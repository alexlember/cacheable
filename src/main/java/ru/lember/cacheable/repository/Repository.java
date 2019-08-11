package ru.lember.cacheable.repository;

import ru.lember.cacheable.entity.Entity;

import java.util.List;

/**
 * Интерфейс для получения определенной сущности.
 * @param <T> класс сущности, к которому необходимо получить доступ.
 */
public interface Repository<T> {

	<S extends T> S findById(Object id, Class<S> clazz);

	<S extends T> List<S> findAll(Class<S> clazz);

	<S extends T> void remove(S entity);

	<S extends Entity> void removeById(Object id, Class<S> clazz);

	<S extends T> void save(S entity);

}
