package ru.lember.cacheable.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@ToString(callSuper = true)
public class Transition extends Entity implements HasMarket {

    @Getter
    private Market market;

    @Getter
    private String beginStatusId;

    @Getter
    private String endStatusId;

    @Getter
    private String transitionRuleId;

    private Transition(Market market, String beginStatusId, String endStatusId, String transitionRuleId) {
        this.market = market;
        this.beginStatusId = beginStatusId;
        this.endStatusId = endStatusId;
        this.transitionRuleId = transitionRuleId;
        this.id = composeId();
    }

    public static Transition of(@NonNull Market market,
                                @NonNull String beginStatusId,
                                @NonNull String endStatusId,
                                @NonNull String transitionRuleId) {

        return new Transition(market, beginStatusId, endStatusId, transitionRuleId);

    }

    public Transition andMarket(@NonNull Market market) {
        this.market = market;
        return this;
    }

    public Transition andBeginStatusId(@NonNull String beginStatusId) {
        this.beginStatusId = beginStatusId;
        return this;
    }

    public Transition andEndStatusId(@NonNull String endStatusId) {
        this.endStatusId = endStatusId;
        return this;
    }

    public Transition andTransitionRuleId(@NonNull String endStatusId) {
        this.endStatusId = endStatusId;
        return this;
    }

    @Override
    protected String composeId() {
        return beginStatusId + "-" + transitionRuleId + "-" + endStatusId + "-" + market;
    }
}
