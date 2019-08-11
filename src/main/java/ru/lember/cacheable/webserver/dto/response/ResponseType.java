package ru.lember.cacheable.webserver.dto.response;

import lombok.Getter;

public enum ResponseType {

    SUCCESS(0),
    VALIDATION_ERROR(1),
    BUSINESS_LOGIC_ERROR(2),
    UNEXPECTED_ERROR(3),
    //
    ;

    @Getter
    private int code;

    ResponseType(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.name() + " code: " + code;
    }
}
