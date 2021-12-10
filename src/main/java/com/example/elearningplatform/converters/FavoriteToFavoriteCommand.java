package com.example.elearningplatform.converters;

import com.example.elearningplatform.commands.CategoryCommand;
import com.example.elearningplatform.commands.FavoriteCommand;
import com.example.elearningplatform.domain.Category;
import com.example.elearningplatform.domain.Favorite;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class FavoriteToFavoriteCommand implements Converter<Favorite, FavoriteCommand> {

    @Synchronized
    @Nullable
    @Override
    public FavoriteCommand convert(Favorite source) {
        if (source == null) {
            return null;
        }

        final FavoriteCommand favoriteCommand = new FavoriteCommand();
        favoriteCommand.setId(source.getId());

        return favoriteCommand;
    }
}
