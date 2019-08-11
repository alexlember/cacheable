package ru.lember.cacheable.entity;

import java.util.List;

public abstract class User extends Entity implements UserInterface {

    String login;
    String group;
    List<Market> markets;

    User(String login, String group) {
        this.login = login;
        this.group = group;
        this.id = composeId();
    }

    @Override
    protected String composeId() {
        return login;
    }
}
