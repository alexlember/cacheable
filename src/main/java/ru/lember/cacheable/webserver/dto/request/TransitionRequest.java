package ru.lember.cacheable.webserver.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ru.lember.cacheable.entity.Market;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class TransitionRequest extends AbstractRequest {

    private String beginStatusId;
    private String endStatusId;
    private String transitionRuleId;
    private Market market;

}
