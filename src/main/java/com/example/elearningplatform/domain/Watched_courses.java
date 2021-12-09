package com.example.elearningplatform.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Watched_courses extends Course{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "watched_courses")
    private Set<User> users;
}
