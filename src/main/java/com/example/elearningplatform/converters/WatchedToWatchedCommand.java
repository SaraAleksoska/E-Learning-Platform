package com.example.elearningplatform.converters;

import com.example.elearningplatform.commands.PresentationCommand;
import com.example.elearningplatform.commands.WatchedCommand;
import com.example.elearningplatform.domain.Presentations;
import com.example.elearningplatform.domain.Watched_courses;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class WatchedToWatchedCommand implements Converter<Watched_courses, WatchedCommand> {

    @Synchronized
    @Nullable
    @Override
    public WatchedCommand convert(Watched_courses source) {
        if (source == null) {
            return null;
        }

        final WatchedCommand watchedCommand = new WatchedCommand();
        watchedCommand.setId(source.getId());

        return watchedCommand;
    }
}
