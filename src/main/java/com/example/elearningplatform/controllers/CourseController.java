package com.example.elearningplatform.controllers;

import com.example.elearningplatform.commands.CourseCommand;
import com.example.elearningplatform.converters.CourseCommandToCourse;
import com.example.elearningplatform.services.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/course/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("course", courseService.findById(Long.valueOf(id)));
        return "course/show";
    }

    @GetMapping("course/new")
    public String newCourse (Model model){
        model.addAttribute("course", new CourseCommand());

        return "course/courseform";
    }

    @GetMapping("course/update")
    public String updateCourse (@PathVariable String id, Model model){
        model.addAttribute("course", courseService.findCommandById(Long.valueOf(id)));
        return "course/courseform";
    }

    @PostMapping("course")
    public String saveOrUpdate(@ModelAttribute CourseCommand command){
        CourseCommand savedCommand = courseService.saveCourseCommand(command);

        return "redirect:/course/" + savedCommand.getId() + "/show";
    }

    @GetMapping("course/delete")
    public String deleteById (@PathVariable String id){
         log.debug("Deleting id: " + id);

        courseService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
}
