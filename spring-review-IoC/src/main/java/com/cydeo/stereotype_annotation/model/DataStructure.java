package com.cydeo.stereotype_annotation.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor

public class DataStructure {

    private ExtraHours extraHours;

    public void getTotalHours(){
        System.out.println("Total hours for DataStructure: " + extraHours.getHours());
    }
}
