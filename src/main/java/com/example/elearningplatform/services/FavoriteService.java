package com.example.elearningplatform.services;

import com.example.elearningplatform.commands.CourseCommand;
import com.example.elearningplatform.commands.FavoriteCommand;
import com.example.elearningplatform.domain.Course;
import com.example.elearningplatform.domain.Favorite;
import com.example.elearningplatform.domain.User;

import java.util.Set;

public interface FavoriteService {
    Set<Favorite> getFavorite();
    Favorite findById(Long l);
    FavoriteCommand findCommandById(Long l);
    FavoriteCommand saveFavoriteCommand(FavoriteCommand favoriteCommand);
    void removeById(Long idToDelete);
}
