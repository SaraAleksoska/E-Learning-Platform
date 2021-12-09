package com.example.elearningplatform.repositories;

import com.example.elearningplatform.domain.Category;
import com.example.elearningplatform.domain.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
