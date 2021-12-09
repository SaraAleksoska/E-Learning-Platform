package com.example.elearningplatform.controllers;

import com.example.elearningplatform.commands.CourseCommand;
import com.example.elearningplatform.commands.UserCommand;
import com.example.elearningplatform.services.CourseService;
import com.example.elearningplatform.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("user", userService.findById(Long.valueOf(id)));
        return "user/show";
    }

    @GetMapping("user/new")
    public String newCourse (Model model){
        model.addAttribute("user", new UserCommand());

        return "user/userform";
    }

    @PostMapping("user")
    public String saveOrUpdate(@ModelAttribute UserCommand command){
        UserCommand savedCommand = userService.saveUserCommand(command);

        return "redirect:/user/" + savedCommand.getId() + "/show";
    }

    @GetMapping("user/{id}/delete")
    public String deleteById (@PathVariable String id){
        log.debug("Deleting id: " + id);

        userService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
}


