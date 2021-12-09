package com.example.elearningplatform.services;

import com.example.elearningplatform.commands.CourseCommand;
import com.example.elearningplatform.domain.Course;

import java.util.Set;

public interface CourseService{
    Set<Course> getCourse();
    Course findById(Long l);

    CourseCommand findCommandById(Long l);
    CourseCommand saveCourseCommand(CourseCommand courseCommand);
    void deleteById(Long idToDelete);
}
