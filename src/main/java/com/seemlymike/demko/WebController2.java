package com.seemlymike.demko;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Profile("profile2")
@RestController
@RequestMapping("/events")
final class WebController2 {

    private final EventsRepo repo;

    WebController2(EventsRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    ResponseEntity<Events> getAllEvents2() {
        return ResponseEntity.ok(Events.create(List.of(Event.create("magicUUID", "title"))));
    }
}
