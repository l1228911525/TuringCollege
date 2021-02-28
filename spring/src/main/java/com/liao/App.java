package com.liao;

import com.liao.compent.Person;
import com.liao.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);

        Person person = ctx.getBean("person", Person.class);

        Person person1 = ctx.getBean("person", Person.class);

        System.out.println(person == person1);

//        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
//
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }

    }
}
