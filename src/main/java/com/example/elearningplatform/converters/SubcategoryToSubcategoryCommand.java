package com.example.elearningplatform.converters;

import com.example.elearningplatform.commands.SourceCommand;
import com.example.elearningplatform.commands.SubcategoryCommand;
import com.example.elearningplatform.domain.Source;
import com.example.elearningplatform.domain.Subcategory;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SubcategoryToSubcategoryCommand implements Converter<Subcategory, SubcategoryCommand> {

    @Synchronized
    @Nullable
    @Override
    public SubcategoryCommand convert(Subcategory source) {
        if (source == null) {
            return null;
        }

        final SubcategoryCommand subcategoryCommand = new SubcategoryCommand();
        subcategoryCommand.setId(source.getId());
        subcategoryCommand.setName_subcategory(source.getName_subcategory());
        return subcategoryCommand;
    }
}
