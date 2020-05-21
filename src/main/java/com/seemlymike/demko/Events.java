package com.seemlymike.demko;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collections;
import java.util.List;

final class Events {
    private final List<Event> events;

    @JsonCreator
    private Events(List<Event> events) {
        this.events = Collections.unmodifiableList(events);
    }

    @JsonIgnore
    public static Events create(List<Event> events) {
        return new Events(events);
    }

    public List<Event> getEvents() {
        return events;
    }
}
