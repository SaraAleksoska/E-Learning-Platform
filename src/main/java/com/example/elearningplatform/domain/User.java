package com.example.elearningplatform.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Set<Position> positions = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Set<Department> departments = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Presentations> presentations = new HashSet<>();

    @ManyToMany(mappedBy = "users")
    private Set<Course> courses;

    @ManyToMany
    @JoinTable(name = "user_favorite",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "favorite_id"))
    private Set<Favorite> favorites = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "rate",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "watched_id"))
    private Set<Watched_courses> watched_courses = new HashSet<>();
}
