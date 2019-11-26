package org.app.cinema.services.validators;

import org.app.cinema.entities.Actor;
import org.app.cinema.entities.Director;
import org.app.cinema.entities.Movie;
import org.app.cinema.entities.Room;

public interface Validator {

    boolean isValid(Actor actor);

    boolean isValid(Director director);

    boolean isValid(Movie movie);

    boolean isValid(Room room);
}
