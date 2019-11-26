package org.app.cinema.services.factory;

import org.app.cinema.entities.Actor;
import org.app.cinema.entities.Director;
import org.app.cinema.entities.Movie;
import org.app.cinema.entities.Room;

public interface EntityFactory {

    Actor buildActor(String firstName, String lastName);

    Director buildDirector(String firstName, String lastName, String nationality);

    Movie buildMovie(String name, String releaseDate);

    Room buildRoom(String name, int nrOfSeats, int nrOfRows);

    void initDomainServiceEntities();
}
