package com.example.elearningplatform.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Favorite extends Course{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "favorites")
    private Set<User> users;
}
