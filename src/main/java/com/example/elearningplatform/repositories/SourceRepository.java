package com.example.elearningplatform.repositories;

import com.example.elearningplatform.domain.Category;
import com.example.elearningplatform.domain.Source;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SourceRepository extends CrudRepository<Source, Long> {
    Optional<Source> findBySource(String source);
}
