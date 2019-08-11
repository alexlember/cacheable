package ru.lember.cacheable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import ru.lember.cacheable.entity.Entity;
import ru.lember.cacheable.repository.Repository;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class InitializationService {

    private Repository<Entity> repository;

    @Autowired
    public InitializationService(Repository<Entity> repository) {
        this.repository = repository;
    }

    @PostConstruct
    private void postConstruct() {
        log.info("initialized");
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("onApplicationEvent");

    }
}
