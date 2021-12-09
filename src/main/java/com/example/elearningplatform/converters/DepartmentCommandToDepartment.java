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
public class DepartmentCommandToDepartment implements Converter<DepartmentCommand, Department> {

    @Synchronized
    @Nullable
    @Override
    public Department convert(DepartmentCommand source) {
        if (source == null) {
            return null;
        }

        final Department department = new Department();
        department.setId(source.getId());
        department.setDepartment(source.getDepartment());
        return department;
    }
}
