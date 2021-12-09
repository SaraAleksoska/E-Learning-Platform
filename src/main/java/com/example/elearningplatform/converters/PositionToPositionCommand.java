package com.example.elearningplatform.converters;

import com.example.elearningplatform.commands.DepartmentCommand;
import com.example.elearningplatform.commands.PositionCommand;
import com.example.elearningplatform.domain.Department;
import com.example.elearningplatform.domain.Position;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PositionToPositionCommand implements Converter<Position, PositionCommand> {

    @Synchronized
    @Nullable
    @Override
    public PositionCommand convert(Position source) {
        if (source == null) {
            return null;
        }

        final PositionCommand positionCommand = new PositionCommand();

        positionCommand.setId(source.getId());
        positionCommand.setPosition(source.getPosition());

        return positionCommand;
    }
}
