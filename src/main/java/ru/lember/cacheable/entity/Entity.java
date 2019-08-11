package ru.lember.cacheable.entity;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@ToString
public abstract class Entity implements Serializable {

    @Getter
    protected String id;

    protected abstract String composeId();

}
