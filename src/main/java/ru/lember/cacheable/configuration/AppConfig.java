package ru.lember.cacheable.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ru.lember.cacheable.entity.Status;
import ru.lember.cacheable.entity.Transition;
import ru.lember.cacheable.entity.TransitionRule;

import java.util.List;

@Data
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("app")
public class AppConfig {

    private List<Status> statuses;
    private List<TransitionRule> transitionRules;
    private List<Transition> transitions;


}
