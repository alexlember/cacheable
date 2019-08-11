package ru.lember.cacheable.webserver.dto.request;

import ru.lember.cacheable.entity.Market;

import java.util.List;

public abstract class UserRequest extends AbstractRequest {

    protected String login;
    protected String group;
    protected List<Market> markets;

}
