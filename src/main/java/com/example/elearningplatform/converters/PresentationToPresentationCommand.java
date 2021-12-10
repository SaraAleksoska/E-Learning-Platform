package com.example.elearningplatform.converters;

import com.example.elearningplatform.commands.FavoriteCommand;
import com.example.elearningplatform.commands.PresentationCommand;
import com.example.elearningplatform.domain.Favorite;
import com.example.elearningplatform.domain.Presentations;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PresentationToPresentationCommand implements Converter<Presentations, PresentationCommand> {

    @Synchronized
    @Nullable
    @Override
    public PresentationCommand convert(Presentations source) {
        if (source == null) {
            return null;
        }

        final PresentationCommand presentationCommand = new PresentationCommand();
        presentationCommand.setId(source.getId());

        return presentationCommand;
    }
}
