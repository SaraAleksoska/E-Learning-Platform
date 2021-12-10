package com.example.elearningplatform.repositories;

import com.example.elearningplatform.domain.Presentations;
import org.springframework.data.repository.CrudRepository;

public interface PresentationRepository extends CrudRepository<Presentations, Long> {
}
