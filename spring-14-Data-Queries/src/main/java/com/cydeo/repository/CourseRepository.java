package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long> {
    //Find all courses by category
    List<Course> findByCategory(String category);
    //Find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    //Check if a course with the supplied name exists. Return true if exists, false isf doesn't exist
    boolean existsByName(String name);

    //Returns the count of courses for the given category
    int countByCategory(String category);

    //Finds all the courses that start with the given name string
    List<Course> findByNameStartingWith(String name);

    //Find all courses by category and returns stream
    Stream<Course> streamAllByCategory(String category);




}
