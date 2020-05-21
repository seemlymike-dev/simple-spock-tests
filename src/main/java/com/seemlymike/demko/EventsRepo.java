package com.seemlymike.demko;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventsRepo extends MongoRepository<Event, String> {
}
