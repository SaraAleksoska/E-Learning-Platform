package com.example.elearningplatform.converters;

import com.example.elearningplatform.commands.CourseCommand;
import com.example.elearningplatform.domain.Course;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandToCourse implements Converter<CourseCommand, Course> {

    private final CategoryCommandToCategory categoryConveter;
    private final SourceCommandToSource sourceConverter;
    private final UserCommandToUser userConverter;

    public CourseCommandToCourse(CategoryCommandToCategory categoryConveter, SourceCommandToSource sourceConverter, UserCommandToUser userConverter) {
        this.categoryConveter = categoryConveter;
        this.sourceConverter = sourceConverter;
        this.userConverter = userConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Course convert(CourseCommand source) {
        if (source == null) {
            return null;
        }

        final Course course = new Course();
        course.setId(source.getId());
        course.setCourse(source.getCourse());
        course.setLectures(source.getLectures());
        course.setSkill_level(source.getSkill_level());
        course.setDescription(source.getDescription());
        course.setTeacher(source.getTeacher());
        course.setTime(source.getTime());

        if (source.getUsers() != null && source.getUsers().size() > 0){
            source.getUsers()
                    .forEach(users -> course.getUsers().add(userConverter.convert(users)));
        }

        if (source.getCategories() != null && source.getCategories().size() > 0){
            source.getCategories()
                    .forEach(category -> course.getCategories().add(categoryConveter.convert(category)));
        }

        if (source.getSources() != null && source.getSources().size() > 0){
            source.getSources()
                    .forEach(sourcee -> course.getSources().add(sourceConverter.convert(sourcee)));
        }

        return course;
    }
}
