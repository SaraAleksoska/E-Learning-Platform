package com.example.elearningplatform.converters;

import com.example.elearningplatform.commands.CourseCommand;
import com.example.elearningplatform.commands.UserCommand;
import com.example.elearningplatform.domain.Course;
import com.example.elearningplatform.domain.User;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserCommandToUser implements Converter<UserCommand, User> {


    private final DepartmentCommandToDepartment departmentConveter;
    private final PositionCommandToPosition positionConverter;

    public UserCommandToUser(DepartmentCommandToDepartment departmentConveter, PositionCommandToPosition positionConverter) {

        this.departmentConveter = departmentConveter;
        this.positionConverter = positionConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public User convert(UserCommand source) {
        if (source == null) {
            return null;
        }

        final User user = new User();
        user.setId(source.getId());
        user.setName(source.getName());
        user.setSurname(source.getSurname());
        user.setEmail(source.getEmail());


        if (source.getDepartments() != null && source.getDepartments().size() > 0){
            source.getDepartments()
                    .forEach(department -> user.getDepartments().add(departmentConveter.convert(department)));
        }

        if (source.getPositions() != null && source.getPositions().size() > 0){
            source.getPositions()
                    .forEach(positions -> user.getPositions().add(positionConverter.convert(positions)));
        }

        return user;
    }
}
