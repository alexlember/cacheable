package ru.lember.cacheable.webserver;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import ru.lember.cacheable.entity.Entity;
import ru.lember.cacheable.entity.Transition;
import ru.lember.cacheable.repository.Repository;
import ru.lember.cacheable.webserver.dto.request.*;
import ru.lember.cacheable.webserver.dto.response.AbstractResponse;
import ru.lember.cacheable.webserver.dto.response.ResponseImpl;
import ru.lember.cacheable.webserver.dto.response.ResponseType;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@RestController
public class EntitiesController {

    private Repository<Entity> repository;

    @Autowired
    public EntitiesController(Repository<Entity> repository) {
        this.repository = repository;
    }

    @PostConstruct
    private void postConstruct() {
        log.info("initialized");
    }

    @GetMapping("/transitions")
    public ResponseImpl getTransitions() {
        log.info("get transitions request");
        return logAndReturn(
                new ResponseImpl<List<Transition>>(ResponseType.SUCCESS)
                .andBody(repository.findAll(Transition.class)));
    }

    @GetMapping("/transitions/{id}")
    public ResponseImpl getTransition(@PathVariable String id) {
        log.info("get transitions/{id} request");

        return logAndReturn(
                new ResponseImpl<Transition>(ResponseType.SUCCESS)
                .andBody(repository.findById(id, Transition.class)));
    }

    @DeleteMapping("/transitions/{id}")
    public ResponseImpl deleteTransition(@PathVariable String id) {
        log.info("delete transitions/{id} request");

        Transition transition = repository.findById(id, Transition.class);

        if (transition == null) {
            return new ResponseImpl<>(ResponseType.BUSINESS_LOGIC_ERROR)
                    .andDetails(String.format("Transition with id: %s doesn't exist", id));
        }

        repository.removeById(id, Transition.class);

        return logAndReturn(
                new ResponseImpl<Transition>(ResponseType.SUCCESS)
                        .andBody(transition)
                        .andDetails("Transition was successfully removed"));
    }

    @PostMapping("/transitions")
    public ResponseImpl addOrUpdateTransition(@RequestBody @NonNull TransitionRequest tx) {
        log.info("post transitions request: {}", tx);

        if (StringUtils.isEmpty(tx.getBeginStatusId())
                || StringUtils.isEmpty(tx.getTransitionRuleId())
                || StringUtils.isEmpty(tx.getEndStatusId())
                || tx.getMarket() == null) {
            return new ResponseImpl<>(ResponseType.VALIDATION_ERROR)
                    .andDetails(String.format("One of mandatory fields: %s is empty",
                           "beginStatusId/endStatusId/transitionRuleId/market"));
        }

        Transition transition = Transition.of(
                tx.getMarket(),
                tx.getBeginStatusId(),
                tx.getEndStatusId(),
                tx.getTransitionRuleId());

        repository.save(transition);

        return logAndReturn(new ResponseImpl<>(ResponseType.SUCCESS)
            .andBody(transition)
            .andDetails("Transition was successfully added"));
    }

//    @PostMapping("/txRules")
//    public AbstractResponse txRule(@RequestBody @NonNull TransitionRuleRequest txRule) {
//        log.info("txRule request: {}", txRule);
//        repository.save(txRule);
//    }
//
//    @PostMapping("/statuses")
//    public AbstractResponse status(@RequestBody @NonNull StatusRequest status) {
//        log.info("status request: {}", status);
//        repository.save(Status.of());
//    }
//
//    @PostMapping("/dealers")
//    public AbstractResponse dealer(@RequestBody @NonNull DealerRequest dealer) {
//        log.info("dealer request: {}", dealer);
//        repository.save(dealer);
//    }
//
//    @PostMapping("/clients")
//    public AbstractResponse client(@RequestBody @NonNull ClientRequest client) {
//        log.info("client request: {}", client);
//        repository.save(Client);
//    }

    private <T> T logAndReturn(T response) {
        log.info("response: {}", response);
        return response;
    }
}