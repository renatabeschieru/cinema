package org.app.cinema.services.validators;

import org.app.cinema.entities.Actor;
import org.app.cinema.entities.Director;
import org.app.cinema.entities.Movie;
import org.app.cinema.entities.Room;
import org.springframework.stereotype.Service;

@Service
public class ValidatorImpl implements Validator {

    @Override
    public boolean isValid(Actor actor) {
        return !actor.getFirstName().isEmpty() && !actor.getLastName().isEmpty();
    }

    @Override
    public boolean isValid(Director director) {
        return !director.getFirstName().isEmpty() &&
             !director.getLastName().isEmpty();
    }

    @Override
    public boolean isValid(Movie movie) {
        return !movie.getName().isEmpty();
    }

    @Override
    public boolean isValid(Room room) {
        return !room.getName().isEmpty()
            && room.getNrOfRows() > 0
            && room.getNrOfSeats() > 0;
    }
}
