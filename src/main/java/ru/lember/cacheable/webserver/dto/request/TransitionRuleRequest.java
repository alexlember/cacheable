package ru.lember.cacheable.webserver.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ru.lember.cacheable.entity.Market;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class TransitionRuleRequest extends AbstractRequest {

    private Market market;
    private String name;
    private List<String> dealerGroups;
    private List<String> clientGroups;

}
