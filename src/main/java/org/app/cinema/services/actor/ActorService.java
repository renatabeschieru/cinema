package org.app.cinema.services.actor;

import org.app.cinema.entities.Actor;

import java.util.List;

public interface ActorService {

    void addActor(Actor actor);

    List<Actor> getActors();
}
