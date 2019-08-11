package ru.lember.cacheable.entity;

import java.util.List;

public interface UserInterface {

    String getLogin();
    String getGroup();
    List<Market> getMarkets();

}
