package ru.lember.cacheable.webserver.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class ResponseImpl<T> extends AbstractResponse {

    private T body;

    public ResponseImpl(@NonNull ResponseType responseType) {
        super(responseType.name(), responseType.getCode());
    }

    @JsonIgnore
    public ResponseImpl andDetails(String details) {
        this.details = details;
        return this;
    }

    @JsonIgnore
    public ResponseImpl andBody(T body) {
        this.body = body;
        return this;
    }
}
