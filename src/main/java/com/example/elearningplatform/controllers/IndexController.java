package com.example.elearningplatform.controllers;

import com.example.elearningplatform.repositories.CourseRepository;
import com.example.elearningplatform.services.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {
    private final CourseService courseService;

    public IndexController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {

        model.addAttribute("courses", courseService.getCourse());

        return "index";
    }

}
