package com.example.elearningplatform.services;

import com.example.elearningplatform.commands.CourseCommand;
import com.example.elearningplatform.commands.UserCommand;
import com.example.elearningplatform.converters.UserCommandToUser;
import com.example.elearningplatform.converters.UserToUserCommand;
import com.example.elearningplatform.domain.Course;
import com.example.elearningplatform.domain.User;
import com.example.elearningplatform.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserToUserCommand userToUserCommand;
    private final UserCommandToUser userCommandToUser;

    public UserServiceImpl(UserRepository userRepository, UserToUserCommand userToUserCommand, UserCommandToUser userCommandToUser) {
        this.userRepository = userRepository;
        this.userToUserCommand = userToUserCommand;
        this.userCommandToUser = userCommandToUser;
    }

    @Override
    public Set<User> getUsers() {
        Set<User> userSet = new HashSet<>();
        userRepository.findAll().iterator().forEachRemaining(userSet::add);
        return userSet;
    }

    @Override
    public User findById(Long l) {

        Optional<User> userOprional = userRepository.findById(l);

        if (!userOprional.isPresent()) {
            throw new RuntimeException("User Not Found! For id value: " + l.toString());
        }
        return userOprional.get();
    }


    @Transactional
    @Override
    public UserCommand findCommandById(Long l){
        return userToUserCommand.convert(findById(l));
    }


    @Transactional
    @Override
    public UserCommand saveUserCommand(UserCommand command) {
        User detachedUser = userCommandToUser.convert(command);

        User savedUser = userRepository.save(detachedUser);
        log.debug("saved User id" + savedUser.getId());
        return userToUserCommand.convert(savedUser);
    }

    @Override
    public void deleteById(Long idToDelete){
        userRepository.deleteById(idToDelete);
    }

}
