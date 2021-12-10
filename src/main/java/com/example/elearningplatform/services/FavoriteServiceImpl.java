package com.example.elearningplatform.services;

import com.example.elearningplatform.commands.FavoriteCommand;
import com.example.elearningplatform.commands.UserCommand;
import com.example.elearningplatform.converters.FavoriteCommandToFavorite;
import com.example.elearningplatform.converters.FavoriteToFavoriteCommand;
import com.example.elearningplatform.domain.Course;
import com.example.elearningplatform.domain.Favorite;
import com.example.elearningplatform.domain.User;
import com.example.elearningplatform.repositories.FavoriteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final FavoriteCommandToFavorite favoriteCommandToFavorite;
    private final FavoriteToFavoriteCommand favoriteToFavoriteCommand;

    public FavoriteServiceImpl(FavoriteRepository favoriteRepository, FavoriteCommandToFavorite favoriteCommandToFavorite, FavoriteToFavoriteCommand favoriteToFavoriteCommand) {
        this.favoriteRepository = favoriteRepository;
        this.favoriteCommandToFavorite = favoriteCommandToFavorite;
        this.favoriteToFavoriteCommand = favoriteToFavoriteCommand;
    }

    @Override
    public Set<Favorite> getFavorite() {
        Set<Favorite> favoritesSet = new HashSet<>();
        favoriteRepository.findAll().iterator().forEachRemaining(favoritesSet::add);
        return favoritesSet;
    }

    @Override
    public Favorite findById(Long l) {
        Optional<Favorite> favoriteOprional = favoriteRepository.findById(l);

        if (!favoriteOprional.isPresent()) {
            throw new RuntimeException("Favorite courese Not Found! For id value: " + l.toString());
        }
        return favoriteOprional.get();
    }

    @Override
    public FavoriteCommand findCommandById(Long l) {
        return favoriteToFavoriteCommand.convert(findById(l));
    }


    @Transactional
    @Override
    public FavoriteCommand saveFavoriteCommand(FavoriteCommand command) {
        Favorite detachedFavorite = favoriteCommandToFavorite.convert(command);

        Favorite savedFavorite = favoriteRepository.save(detachedFavorite);
        log.debug("saved Favorite course id" + savedFavorite.getId());
        return favoriteToFavoriteCommand.convert(savedFavorite);
    }

    @Override
    public void deleteById(Long idToDelete){
        favoriteRepository.deleteById(idToDelete);
    }
}
