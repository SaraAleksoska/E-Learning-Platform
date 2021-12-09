package com.example.elearningplatform.converters;

import com.example.elearningplatform.commands.CourseCommand;
import com.example.elearningplatform.domain.Category;
import com.example.elearningplatform.domain.Course;
import com.example.elearningplatform.domain.User;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CourseToCourseCommand implements Converter<Course, CourseCommand>{

    private final CategoryToCategoryCommand categoryConveter;
    private final SourceToSourceCommand sourceConverter;
    private final UserToUserCommand userConverter;


    public CourseToCourseCommand(CategoryToCategoryCommand categoryConveter, SourceToSourceCommand sourceConverter, UserToUserCommand userConverter) {
        this.categoryConveter = categoryConveter;
        this.sourceConverter = sourceConverter;
        this.userConverter = userConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public CourseCommand convert(Course source) {
        if (source == null) {
            return null;
        }

        final CourseCommand command = new CourseCommand();
        command.setId(source.getId());
        command.setCourse(source.getCourse());
        command.setLectures(source.getLectures());
        command.setSkill_level(source.getSkill_level());
        command.setDescription(source.getDescription());
        command.setTeacher(source.getTeacher());
        command.setTime(source.getTime());

        if (source.getUsers() != null && source.getUsers().size() > 0){
            source.getUsers()
                    .forEach((User user) -> command.getUsers().add(userConverter.convert(user)));
        }

        if (source.getCategories() != null && source.getCategories().size() > 0){
            source.getCategories()
                    .forEach((Category category) -> command.getCategories().add(categoryConveter.convert(category)));
        }

        if (source.getSources() != null && source.getSources().size() > 0){
            source.getSources()
                    .forEach(sourcee -> command.getSources().add(sourceConverter.convert(sourcee)));
        }

        return command;
    }
}
