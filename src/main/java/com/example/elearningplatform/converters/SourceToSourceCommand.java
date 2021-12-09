package com.example.elearningplatform.converters;

import com.example.elearningplatform.commands.SourceCommand;
import com.example.elearningplatform.domain.Source;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SourceToSourceCommand implements Converter<Source, SourceCommand> {

    @Synchronized
    @Nullable
    @Override
    public SourceCommand convert(Source source) {
        if (source == null) {
            return null;
        }

        final SourceCommand sourceCommand = new SourceCommand();
        sourceCommand.setId(source.getId());
        sourceCommand.setSource(source.getSource());
        sourceCommand.setUrl(source.getUrl());
        return sourceCommand;
    }
}
