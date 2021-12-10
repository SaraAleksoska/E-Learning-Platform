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
public class PresentationCommandToPresentation implements Converter<PresentationCommand, Presentations> {

    @Synchronized
    @Nullable
    @Override
    public Presentations convert(PresentationCommand source) {
        if (source == null) {
            return null;
        }

        final Presentations presentations = new Presentations();
        presentations.setId(source.getId());

        return presentations;
    }
}
