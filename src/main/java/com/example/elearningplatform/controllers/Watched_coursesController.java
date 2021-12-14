package com.example.elearningplatform.controllers;

import com.example.elearningplatform.services.WatchedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Watched_coursesController {

    private final WatchedService watchedService;

    public Watched_coursesController(WatchedService watchedService) {
        this.watchedService = watchedService;
    }

    @GetMapping("/watched/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("watched", watchedService.findById(Long.valueOf(id)));
        return "user/watchedCourses";
    }
    //ne znam dali treba add
}
