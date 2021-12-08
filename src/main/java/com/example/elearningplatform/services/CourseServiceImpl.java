package com.example.elearningplatform.services;

import com.example.elearningplatform.domain.Course;
import com.example.elearningplatform.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Set<Course> getCourse() {
        Set<Course> courseSet = new HashSet<>();
        courseRepository.findAll().iterator().forEachRemaining(courseSet::add);
        return courseSet;
    }

}
