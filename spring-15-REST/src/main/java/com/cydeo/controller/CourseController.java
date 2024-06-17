package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @GetMapping
    public List<CourseDTO> getAllCourses(){

    }



}
