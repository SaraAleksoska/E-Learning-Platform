package com.example.elearningplatform.converters;

import com.example.elearningplatform.commands.CategoryCommand;
import com.example.elearningplatform.commands.DepartmentCommand;
import com.example.elearningplatform.domain.Category;
import com.example.elearningplatform.domain.Department;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class DepartmentToDepartmentCommand implements Converter<Department, DepartmentCommand> {

    @Synchronized
    @Nullable
    @Override
    public DepartmentCommand convert(Department source) {
        if (source == null) {
            return null;
        }

        final DepartmentCommand departmentCommand = new DepartmentCommand();

        departmentCommand.setId(source.getId());
        departmentCommand.setDepartment(source.getDepartment());

        return departmentCommand;
    }
}
