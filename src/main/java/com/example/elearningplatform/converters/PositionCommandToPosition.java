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
public class PositionCommandToPosition implements Converter<PositionCommand, Position> {

    @Synchronized
    @Nullable
    @Override
    public Position convert(PositionCommand source) {
        if (source == null) {
            return null;
        }

        final Position position = new Position();
        position.setId(source.getId());
        position.setPosition(source.getPosition());
        return position;
    }
}
