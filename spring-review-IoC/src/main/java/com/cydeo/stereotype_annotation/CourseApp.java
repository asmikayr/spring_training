package com.cydeo.stereotype_annotation;

import com.cydeo.stereotype_annotation.config.CourseConfig;
import com.cydeo.stereotype_annotation.model.DataStructure;
import com.cydeo.stereotype_annotation.model.Microservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.type.StandardAnnotationMetadata;

public class CourseApp {

    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(CourseConfig.class);
        DataStructure dataStructure = container.getBean(DataStructure.class);
        dataStructure.getTotalHours();
        Microservice microservice = container.getBean(Microservice.class);
        microservice.getTotalHours();
    }
}
