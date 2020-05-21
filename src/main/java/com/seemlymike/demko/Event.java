package com.seemlymike.demko;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
final class Event {
    @Id
    private final String id;
    private final String title;

    @JsonCreator
    private Event(String id, String title) {
        this.id = id;
        this.title = title;
    }

    @JsonIgnore
    public static Event create(String id, String title) {
        return new Event(id, title);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) &&
                Objects.equals(title, event.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
