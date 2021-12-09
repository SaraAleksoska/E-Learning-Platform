package com.example.elearningplatform.services;

import com.example.elearningplatform.commands.CourseCommand;
import com.example.elearningplatform.converters.CourseCommandToCourse;
import com.example.elearningplatform.converters.CourseToCourseCommand;
import com.example.elearningplatform.domain.Course;
import com.example.elearningplatform.repositories.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseCommandToCourse courseCommandToCourse;
    private final CourseToCourseCommand courseToCourseCommand;

    public CourseServiceImpl(CourseRepository courseRepository, CourseCommandToCourse courseCommandToCourse, CourseToCourseCommand courseToCourseCommand) {
        this.courseRepository = courseRepository;
        this.courseCommandToCourse = courseCommandToCourse;
        this.courseToCourseCommand = courseToCourseCommand;
    }

    @Override
    public Set<Course> getCourse() {
        Set<Course> courseSet = new HashSet<>();
        courseRepository.findAll().iterator().forEachRemaining(courseSet::add);
        return courseSet;
    }
    @Override
    public Course findById(Long l) {

        Optional<Course> courseOprional = courseRepository.findById(l);

        if (!courseOprional.isPresent()) {
            throw new RuntimeException("Course Not Found! For id value: " + l.toString());
        }
        return courseOprional.get();
    }

    @Transactional
    @Override
    public CourseCommand findCommandById(Long l){
        return courseToCourseCommand.convert(findById(l));
    }

    @Transactional
    @Override
    public CourseCommand saveCourseCommand(CourseCommand command) {
        Course detachedCourse = courseCommandToCourse.convert(command);

        Course savedCourse = courseRepository.save(detachedCourse);
        log.debug("saved Course id" + savedCourse.getId());
        return courseToCourseCommand.convert(savedCourse);
    }

    @Override
    public void deleteById(Long idToDelete){
        courseRepository.deleteById(idToDelete);
    }

}
