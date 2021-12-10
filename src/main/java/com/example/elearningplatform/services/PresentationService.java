package com.example.elearningplatform.services;

import com.example.elearningplatform.commands.CourseCommand;
import com.example.elearningplatform.commands.PresentationCommand;
import com.example.elearningplatform.domain.Course;
import com.example.elearningplatform.domain.Presentations;

import java.util.Set;

public interface PresentationService {
    Set<Presentations> getPresentation();
    static Presentations findById(Long l);
    PresentationCommand findCommandById(Long l);
    PresentationCommand savePresentationCommand(PresentationCommand presentationCommand);
    void deleteById(Long idToDelete);
}
