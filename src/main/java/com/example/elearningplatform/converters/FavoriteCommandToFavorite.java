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
public class FavoriteCommandToFavorite implements Converter<FavoriteCommand, Favorite> {

    @Synchronized
    @Nullable
    @Override
    public Favorite convert(FavoriteCommand source) {
        if (source == null) {
            return null;
        }

        final Favorite favorite = new Favorite();
        favorite.setId(source.getId());

        return favorite;
    }
}
