package com.example.elearningplatform.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String course;
    private String description;
    private Integer time;
    private String teacher;
    private String skill_level;
    private Integer lectures;
    private Integer progress;

    @Enumerated(value = EnumType.STRING)
    private SourceType sourceType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Set<Source> sources = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Set<Category> categories = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "course_users",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();

}
