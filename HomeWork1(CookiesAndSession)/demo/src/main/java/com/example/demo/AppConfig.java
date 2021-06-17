package com.example.demo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@ComponentScan(value = "it.academy", includeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION, classes = TestAnnotation.class))
public class AppConfig {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(AppConfig.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        Person person=context.getBean("person", Person.class);
        System.out.println(person);

        context.close();
    }
}
