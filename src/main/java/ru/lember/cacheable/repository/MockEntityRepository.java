package ru.lember.cacheable.repository;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.lember.cacheable.entity.Entity;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Реализация для тестов, для доступа к сущности Entity.
 */
@Service
@Slf4j
public class MockEntityRepository implements Repository<Entity> {

	private Map<Class<? extends Entity>, Map<String, ? extends Entity>> cache =
			new ConcurrentHashMap<>();

	@PostConstruct
	private void postConstruct() {
		log.info("initialized");
	}

	@Override
	public <S extends Entity> S findById(Object id, Class<S> clazz) {

		Map<String, ?> collection = cache.get(clazz);
		if (collection == null) {
			return null;
		}

		return (S) collection.get(id.toString());
	}

	@Override
	public <S extends Entity> List<S> findAll(Class<S> clazz) {
		Map<String, ?> collection = cache.get(clazz);

		if (collection == null) {
			return Collections.emptyList();
		}

		return new ArrayList<>((Collection<? extends S>) collection.values());//.stream().collect(Collectors.toList());
	}

	@Override
	public <S extends Entity> void remove(S entity) {
		final Class<? extends Entity> collectionClass = entity.getClass();

		Map<String, ?> collection = cache.get(collectionClass);

		if (collection != null) {
			collection.remove(entity.getId());
			if (collection.isEmpty()) {
				cache.remove(collectionClass);
			}
		}
	}

	@Override
	public <S extends Entity> void removeById(Object id, Class<S> clazz) {
		Map<String, ?> collection = cache.get(clazz);

		if (collection != null) {
			collection.remove(id);
			if (collection.isEmpty()) {
				cache.remove(clazz);
			}
		}
	}

	@Override
	public <S extends Entity> void save(S entity) {

		final Class<? extends Entity> collectionClass = entity.getClass();

		Map<String, S> collection = (Map<String, S>) cache.get(collectionClass);

		if (collection == null) {
			collection = new ConcurrentHashMap<>();
			cache.put(collectionClass, collection);
		}

		collection.put(entity.getId(), entity);
	}
}
