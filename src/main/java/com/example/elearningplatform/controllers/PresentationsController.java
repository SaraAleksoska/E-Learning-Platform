package com.example.elearningplatform.controllers;

import com.example.elearningplatform.commands.CourseCommand;
import com.example.elearningplatform.commands.PresentationCommand;
import com.example.elearningplatform.services.PresentationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class PresentationsController {
    private final PresentationService presentationService;

    public PresentationsController(PresentationService presentationService) {
        this.presentationService = presentationService;
    }

    @GetMapping("/user/{id}/presentations")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("presentation", PresentationService.findById(Long.valueOf(id)));
        return "user/presentationShow";
    }

    @GetMapping("user/new")
    public String newPresentation (Model model){
        model.addAttribute("presentation", new PresentationCommand());

        return "user/presentationForm";
    }

    @GetMapping("course/{id}/update")
    public String updatePresentation (@PathVariable String id, Model model){
        model.addAttribute("presentation", presentationService.findCommandById(Long.valueOf(id)));
        return "user/presentationForm";
    }

    @PostMapping("presentations")
    public String saveOrUpdate(@ModelAttribute PresentationCommand command){
        PresentationCommand savedCommand = presentationService.savePresentationCommand(command);

        return "redirect:/user/" + savedCommand.getId() + "/presentationShow";
    }

    @GetMapping("course/{id}/delete")
    public String deleteById (@PathVariable String id){
        log.debug("Deleting id: " + id);

        presentationService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
}
