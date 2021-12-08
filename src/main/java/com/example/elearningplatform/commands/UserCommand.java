package com.example.elearningplatform.commands;

import com.example.elearningplatform.domain.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class UserCommand {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private CourseCommand course;
    private Set<DepartmentCommand> departments = new HashSet<>();
    private Set<PositionCommand> positions = new HashSet<>();
}
