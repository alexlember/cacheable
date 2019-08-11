package ru.lember.cacheable.webserver.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class ClientRequest extends UserRequest {

}
