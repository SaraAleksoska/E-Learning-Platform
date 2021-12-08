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
public class SubcategoryCommandToSubcategory implements Converter<SubcategoryCommand, Subcategory> {

    @Synchronized
    @Nullable
    @Override
    public Subcategory convert(SubcategoryCommand source) {
        if (source == null) {
            return null;
        }

        final Subcategory subcategory = new Subcategory();
        subcategory.setId(source.getId());
        subcategory.setName_subcategory(source.getName_subcategory());
        return subcategory;
    }
}
