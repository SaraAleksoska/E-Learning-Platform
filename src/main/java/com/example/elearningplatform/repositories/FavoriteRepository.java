package com.example.elearningplatform.repositories;

import com.example.elearningplatform.domain.Favorite;
import org.springframework.data.repository.CrudRepository;

public interface FavoriteRepository extends CrudRepository<Favorite, Long> {
}
