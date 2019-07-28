package ru.lember.cacheable.entity;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class TransitionRule implements HasMarket {

    @Getter
    private Market market;

    @Getter
    private String name;

    private List<String> dealerGroups;

    private List<String> clientGroups;

    private TransitionRule(Market market, String name) {
        this.market = market;
        this.name = name;
        this.dealerGroups = new ArrayList<>();
        this.clientGroups = new ArrayList<>();
    }

    public List<String> getDealerGroups() {
        return new ArrayList<>(dealerGroups);
    }

    public List<String> getClientGroups() {
        return new ArrayList<>(clientGroups);
    }

    public static TransitionRule of(@NonNull Market market, @NonNull String name) {
        return new TransitionRule(market, name);
    }

    public boolean addDealerGroup(@NonNull String dealerGroup) {
        return dealerGroups.add(dealerGroup);
    }

    public boolean addClientGroup(@NonNull String clientGroup) {
        return clientGroups.add(clientGroup);
    }

    public boolean removeDealerGroup(@NonNull String dealerGroup) {
        return dealerGroups.remove(dealerGroup);
    }

    public boolean removeClientGroup(@NonNull String clientGroup) {
        return clientGroups.remove(clientGroup);
    }

    public boolean andDealerGroups(@NonNull List<String> dealerGroups) {
        return this.dealerGroups.addAll(dealerGroups);
    }

    public boolean andClientGroups(@NonNull List<String> clientGroups) {
        return this.clientGroups.addAll(clientGroups);
    }

    public void cleanClientGroups() {
        this.clientGroups.clear();
    }

    public void cleanDealerGroups() {
        this.dealerGroups.clear();
    }
}
