package com.example.elearningplatform.converters;

import com.example.elearningplatform.commands.CategoryCommand;
import com.example.elearningplatform.commands.UserCommand;
import com.example.elearningplatform.domain.Category;
import com.example.elearningplatform.domain.Department;
import com.example.elearningplatform.domain.User;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserToUserCommand implements Converter<User, UserCommand> {

    private final DepartmentToDepartmentCommand departmentConveter;
    private final PositionToPositionCommand positionConverter;

    public UserToUserCommand(DepartmentToDepartmentCommand departmentConveter, PositionToPositionCommand positionConverter) {
        this.departmentConveter = departmentConveter;
        this.positionConverter = positionConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public UserCommand convert(User source) {
        if (source == null) {
            return null;
        }

        final UserCommand userCommand = new UserCommand();

        userCommand.setId(source.getId());
        userCommand.setName(source.getName());
        userCommand.setSurname(source.getSurname());
        userCommand.setEmail(source.getEmail());

        if (source.getDepartments() != null && source.getDepartments().size() > 0){
            source.getDepartments()
                    .forEach((Department department) -> userCommand.getDepartments().add(departmentConveter.convert(department)));
        }

        if (source.getPositions() != null && source.getPositions().size() > 0){
            source.getPositions()
                    .forEach(position -> userCommand.getPositions().add(positionConverter.convert(position)));
        }

        return userCommand;
    }
}
