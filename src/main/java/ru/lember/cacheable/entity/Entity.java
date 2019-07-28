package ru.lember.cacheable.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class Entity implements Serializable {

    private String id;

}
