package com.products.exceptions;

public enum ErrorType {

    UNEXPECTED_ERROR("TKT0001", "Unexpected error"),
    SABRE_SESSION_ERROR("TKT0002", "Sabre Session error");

    private final String code;
    private final String description;

    ErrorType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
