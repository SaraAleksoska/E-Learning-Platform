package com.example.elearningplatform.services;

import com.example.elearningplatform.commands.WatchedCommand;
import com.example.elearningplatform.converters.WatchedCommandToWatched;
import com.example.elearningplatform.converters.WatchedToWatchedCommand;
import com.example.elearningplatform.domain.Course;
import com.example.elearningplatform.domain.Watched_courses;
import com.example.elearningplatform.repositories.WatchedRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class WatchedServiceImpl implements WatchedService {

    private final WatchedRepository watchedRepository;
    private final WatchedCommandToWatched watchedCommandToWatched;
    private final WatchedToWatchedCommand watchedToWatchedCommand;

    public WatchedServiceImpl(WatchedRepository watchedRepository, WatchedCommandToWatched watchedCommandToWatched, WatchedToWatchedCommand watchedToWatchedCommand) {
        this.watchedRepository = watchedRepository;
        this.watchedCommandToWatched = watchedCommandToWatched;
        this.watchedToWatchedCommand = watchedToWatchedCommand;
    }

    @Override
    public Set<Watched_courses> getWatched() {
        Set<Watched_courses> watchedSet = new HashSet<>();
        watchedRepository.findAll().iterator().forEachRemaining(watchedSet::add);
        return watchedSet;
    }

    @Override
    public Watched_courses findById(Long l) {
        Optional<Watched_courses> watchedOprional = watchedRepository.findById(l);

        if (!watchedOprional.isPresent()) {
            throw new RuntimeException("Watched course Not Found! For id value: " + l.toString());
        }
        return watchedOprional.get();
    }

    @Override
    public WatchedCommand findCommandById(Long l) {
        return watchedToWatchedCommand.convert(findById(l));
    }

    @Override
    public WatchedCommand saveWatchedCommand(WatchedCommand command) {
        Watched_courses detachedWatched = watchedCommandToWatched.convert(command);
        Watched_courses savedWatched = null;
        if(savedWatched.getTime() == savedWatched.getProgress()){
            savedWatched = watchedRepository.save(detachedWatched);
        }
        log.debug("saved Course id" + savedWatched.getId());
        return watchedToWatchedCommand.convert(savedWatched);
    }
}
