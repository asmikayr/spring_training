package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping
    public List<CourseDTO> getAllCourses(){
        return courseService.getCourses();
    }
    @GetMapping("{id}")
    public CourseDTO getCourseById(@PathVariable("id") long courseId){
        return courseService.getCourseById(courseId);
    }

    @GetMapping("category/{categoryName}")
    public List<CourseDTO> getCourseById(@PathVariable("categoryName") String categoryName){
        return courseService.getCoursesByCategory(categoryName);
    }

    @PostMapping
    public  CourseDTO createCourse(@RequestBody CourseDTO course){
        return courseService.createCourse(course);
    }



}