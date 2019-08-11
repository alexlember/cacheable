package ru.lember.cacheable.entity;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends User {

    private Dealer(@NonNull String login, @NonNull String group) {
        super(login, group);
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getGroup() {
        return group;
    }

    @Override
    public List<Market> getMarkets() {
        return new ArrayList<>(markets);
    }

}
