package com.duyhd.user.exception;

import com.duyhd.user.constant.ErrorCodeReference;
import com.duyhd.user.dto.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

import static com.duyhd.user.constant.ErrorCodeReference.*;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    BaseResponse<Void> handleException(final MethodArgumentNotValidException exception) {
        val errors = exception.getFieldErrors();
        val errorResponse = errors.stream()
                .map(error -> BaseResponse.FieldViolation.of(error.getField(),
                        error.getDefaultMessage()))
                .toList();
        log.error(exception.getMessage(), exception);
        return BaseResponse.fail(HttpStatus.BAD_REQUEST.value(), VALIDATOR_EXCEPTION, errorResponse, "Validate request fail");
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    BaseResponse<Void> handleException(final MethodArgumentTypeMismatchException exception) {
        List<BaseResponse.FieldViolation> errorResponse = new ArrayList<>();
        errorResponse.add(BaseResponse.FieldViolation.of(exception.getPropertyName(), ErrorCodeReference.FIELD_INVALID_DATA_TYPE));
        log.error(exception.getMessage(), exception);
        return BaseResponse.fail(HttpStatus.BAD_REQUEST.value(), VALIDATOR_EXCEPTION, errorResponse, "Validate request fail");
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = AppException.class)
    BaseResponse<Void> handleOpenPlaceException(final AppException exception) {
        log.error(exception.getMessage(), exception);
        return BaseResponse.fail(HttpStatus.BAD_REQUEST.value(), exception.getCode(), exception.getMessage());
    }
}
