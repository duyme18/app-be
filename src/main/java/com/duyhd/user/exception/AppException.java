package com.duyhd.user.exception;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException {
    private final transient String code;

    private final transient String field;

    public AppException(String code, String field) {
        super("AppException");
        this.field = field;
        this.code = code;
    }
}
