package com.example.elearningplatform.services;

import com.example.elearningplatform.commands.CourseCommand;
import com.example.elearningplatform.commands.WatchedCommand;
import com.example.elearningplatform.domain.Course;
import com.example.elearningplatform.domain.Watched_courses;

import java.util.Set;

public interface WatchedService {
    Set<Watched_courses> getWatched();
    Watched_courses findById(Long l);
    WatchedCommand findCommandById(Long l);
    WatchedCommand saveWatchedCommand(WatchedCommand watchedCommand);

}
