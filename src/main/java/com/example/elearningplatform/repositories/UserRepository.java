package com.example.elearningplatform.repositories;

import com.example.elearningplatform.domain.Course;
import com.example.elearningplatform.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
