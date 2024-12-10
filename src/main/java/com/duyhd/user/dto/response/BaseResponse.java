package com.duyhd.user.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * The type Base response.
 *
 * @param <T> the type parameter
 */
@Getter
@Setter(AccessLevel.MODULE)
@RequiredArgsConstructor
@Accessors(chain = true)
public class BaseResponse<T> {

    private T data;

    private int code = HttpStatus.OK.value();

    private String message = "Success";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<FieldViolation> errors;

    public static BaseResponse<Void> ok() {
        return new BaseResponse<>();
    }

    public static BaseResponse<Void> fail(int code, String errorCode, String message) {
        BaseResponse<Void> response = new BaseResponse<>();
        response.setMessage(message);
        response.setCode(code);
        response.setErrorCode(errorCode);
        return response;
    }

    public static BaseResponse<Void> fail(int code, String errorCode, List<FieldViolation> errors, String message) {
        BaseResponse<Void> response = new BaseResponse<>();
        response.setMessage(message);
        response.setCode(code);
        response.setErrorCode(errorCode);
        response.setErrors(errors);
        return response;
    }

    public static <T> BaseResponse<T> of(T result) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setData(result);
        return response;
    }

    /**
     * The type Metadata.
     */
    @Getter
    @Setter
    public static class Metadata {

        private String errorCode;
        private String message;
        private List<FieldViolation> errors;
        private String field;
    }

    /**
     * The type Field violation.
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class FieldViolation {

        private String field;
        private String errorCode;

        /**
         * Of field violation.
         *
         * @param field     the field
         * @param errorCode the errorCode
         * @return the field violation
         */
        public static FieldViolation of(final String field, final String errorCode) {
            return new FieldViolation(field, errorCode);
        }
    }
}
