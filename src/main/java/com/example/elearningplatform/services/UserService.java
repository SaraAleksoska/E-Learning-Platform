package com.example.elearningplatform.services;

import com.example.elearningplatform.commands.CourseCommand;
import com.example.elearningplatform.commands.UserCommand;
import com.example.elearningplatform.domain.Course;
import com.example.elearningplatform.domain.User;

import java.util.Set;

public interface UserService {
    Set<User> getUsers();
    UserCommand saveUserCommand(UserCommand userCommand);
    void deleteById(Long idToDelete);
}
