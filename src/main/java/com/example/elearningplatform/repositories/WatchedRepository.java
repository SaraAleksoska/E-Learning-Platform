package com.example.elearningplatform.repositories;

import com.example.elearningplatform.domain.Watched_courses;
import org.springframework.data.repository.CrudRepository;

public interface WatchedRepository extends CrudRepository<Watched_courses, Long> {
}
