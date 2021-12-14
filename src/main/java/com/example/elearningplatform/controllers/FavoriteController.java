package com.example.elearningplatform.controllers;

import com.example.elearningplatform.commands.CourseCommand;
import com.example.elearningplatform.commands.FavoriteCommand;
import com.example.elearningplatform.services.FavoriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FavoriteController {
    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping("/favorite")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("favorite", favoriteService.findById(Long.valueOf(id)));
        return "user/favorite";
    }

    /*@GetMapping("favorite/add")
    public String newCourse (Model model){
        model.addAttribute("favorite", new FavoriteCommand());
        return "user/favorite";
    }

    @GetMapping("favorite/remove")
    public String deleteById (@PathVariable String id){
        log.debug("Deleting id: " + id);

        favoriteService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }*/
}
