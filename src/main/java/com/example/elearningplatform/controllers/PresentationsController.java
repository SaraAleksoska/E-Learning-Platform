package com.example.elearningplatform.controllers;

import com.example.elearningplatform.commands.CourseCommand;
import com.example.elearningplatform.commands.PresentationCommand;
import com.example.elearningplatform.services.PresentationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PresentationsController {
    private final PresentationService presentationService;

    public PresentationsController(PresentationService presentationService) {
        this.presentationService = presentationService;
    }

    @GetMapping("/user/presentations")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("presentation", presentationService.findById(Long.valueOf(id)));
        return "user/presentationShow";
    }

   /* @GetMapping("user/new")
    public String newPresentation (Model model){
        model.addAttribute("presentation", new PresentationCommand());

        return "user/presentationForm";
    }

    @GetMapping("course/update")
    public String updatePresentation (@PathVariable String id, Model model){
        model.addAttribute("presentation", presentationService.findCommandById(Long.valueOf(id)));
        return "user/presentationForm";
    }

    @PostMapping("presentations")
    public String saveOrUpdate(@ModelAttribute PresentationCommand command){
        PresentationCommand savedCommand = presentationService.savePresentationCommand(command);

        return "redirect:/user/" + savedCommand.getId() + "/presentationShow";
    }

    @GetMapping("course/delete")
    public String deleteById (@PathVariable String id){
        log.debug("Deleting id: " + id);

        presentationService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }*/
    //Ne znam kako da dodadam add, delete i update na prezentacija dali ke e isto kako za courses???
}
