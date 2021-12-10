package com.example.elearningplatform.commands;

import com.example.elearningplatform.domain.SourceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class CourseCommand {
    private Long id;
    private String course;
    private String description;
    private Integer time;
    private String teacher;
    private String skill_level;
    private Integer lectures;
    private Integer progress;
    private SourceType sourceType;
    private Set<CategoryCommand> categories = new HashSet<>();
    private Set<SourceCommand> sources = new HashSet<>();
    private Set<UserCommand> users = new HashSet<>();

}
