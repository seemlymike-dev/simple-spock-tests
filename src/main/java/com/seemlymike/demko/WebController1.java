package com.seemlymike.demko;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("profile1")
@RestController
@RequestMapping("/events")
final class WebController1 {

    private final EventsRepo repo;

    WebController1(EventsRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    ResponseEntity<Events> getAllEvents1() {
        return ResponseEntity.ok(Events.create(repo.findAll()));
    }

}
