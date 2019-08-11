package ru.lember.cacheable.webserver.dto.response;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
public class AbstractResponse implements Serializable {

    protected String result;
    protected Integer code;
    protected String details;

    AbstractResponse(@NonNull String result, int code) {
        this.result = result;
        this.code = code;
    }

}
