package com.liao.config;

import com.liao.compent.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = {"com.liao"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})
})
public class MainConfig {

    @Bean
    @Scope(scopeName = "singleton")
    public Person person() {
        return new Person("lqyyy", 18);
    }
}
