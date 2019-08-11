package ru.lember.cacheable.webserver.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ru.lember.cacheable.entity.Market;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class StatusRequest extends AbstractRequest {

    private Market market;
    private String name;

}
