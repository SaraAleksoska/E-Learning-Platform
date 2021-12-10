package com.example.elearningplatform.converters;

import com.example.elearningplatform.commands.WatchedCommand;
import com.example.elearningplatform.domain.Watched_courses;
import com.sun.istack.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WatchedCommandToWatched implements Converter<WatchedCommand, Watched_courses> {

    @Synchronized
    @Nullable
    @Override
    public Watched_courses convert(WatchedCommand source) {
        if (source == null) {
            return null;
        }

        final Watched_courses watched = new Watched_courses();
        watched.setId(source.getId());

        return watched;
    }
}
