package ru.lember.cacheable.entity;

import lombok.Getter;
import lombok.NonNull;

public class Status extends Entity implements HasMarket {

    @Getter
    private Market market;

    @Getter
    private String name;

    private Status(@NonNull Market market, @NonNull String name) {
        this.market = market;
        this.name = name;
        this.id = composeId();
    }

    public static Status of(@NonNull Market market, @NonNull String name) {
        return new Status(market, name);
    }

    public Status andName(@NonNull String name) {
        this.name = name;
        return this;
    }

    public Status andMarket(@NonNull Market market) {
        this.market = market;
        return this;
    }

    @Override
    protected String composeId() {
        return name + "-" + market;
    }
}
