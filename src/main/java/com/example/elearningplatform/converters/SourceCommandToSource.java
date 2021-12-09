package com.example.elearningplatform.converters;

import com.example.elearningplatform.commands.SourceCommand;
import com.example.elearningplatform.domain.Source;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SourceCommandToSource implements Converter<SourceCommand, Source>{

    @Synchronized
    @Nullable
    @Override
    public Source convert(SourceCommand source) {
        if (source == null) {
            return null;
        }

        final Source sourcee = new Source();
        sourcee.setId(source.getId());
        sourcee.setSource(source.getSource());
        sourcee.setUrl(source.getUrl());
        return sourcee;
    }
}
