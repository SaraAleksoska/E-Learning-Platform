package com.example.elearningplatform.services;

import com.example.elearningplatform.commands.PresentationCommand;
import com.example.elearningplatform.converters.PresentationCommandToPresentation;
import com.example.elearningplatform.converters.PresentationToPresentationCommand;
import com.example.elearningplatform.domain.Course;
import com.example.elearningplatform.domain.Presentations;
import com.example.elearningplatform.domain.User;
import com.example.elearningplatform.repositories.PresentationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class PresentationServiceImpl implements PresentationService {

    private final PresentationRepository presentationRepository;
    private final PresentationCommandToPresentation presentationCommandToPresentation;
    private final PresentationToPresentationCommand presentationToPresentationCommand;

    public PresentationServiceImpl(PresentationRepository presentationRepository, PresentationCommandToPresentation presentationCommandToPresentation, PresentationToPresentationCommand presentationToPresentationCommand) {
        this.presentationRepository = presentationRepository;
        this.presentationCommandToPresentation = presentationCommandToPresentation;
        this.presentationToPresentationCommand = presentationToPresentationCommand;
    }

    @Override
    public Set<Presentations> getPresentation() {
        Set<Presentations> presentationsSet = new HashSet<>();
        presentationRepository.findAll().iterator().forEachRemaining(presentationsSet::add);
        return presentationsSet;
    }

    @Override
    public Presentations findById(Long l) {
        Optional<Presentations> presentationsOprional = presentationRepository.findById(l);

        if (!presentationsOprional.isPresent()) {
            throw new RuntimeException("Presentation Not Found! For id value: " + l.toString());
        }
        return presentationsOprional.get();
    }

    @Override
    public PresentationCommand findCommandById(Long l) {
        return presentationToPresentationCommand.convert(findById(l));
    }

    @Override
    public PresentationCommand savePresentationCommand(PresentationCommand command) {
        Presentations detachedPresentation = presentationCommandToPresentation.convert(command);

        Presentations savedPresentation = presentationRepository.save(detachedPresentation);
        log.debug("saved Presentation id" + savedPresentation.getId());
        return presentationToPresentationCommand.convert(savedPresentation);
    }

    @Override
    public void deleteById(Long idToDelete) {
        presentationRepository.deleteById(idToDelete);
    }
}
