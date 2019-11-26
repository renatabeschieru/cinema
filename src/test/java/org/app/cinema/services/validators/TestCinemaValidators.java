package org.app.cinema.services.validators;

import org.app.cinema.config.CinemaAppConfig;
import org.app.cinema.entities.Actor;
import org.app.cinema.entities.Director;
import org.app.cinema.entities.Movie;
import org.app.cinema.entities.Room;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CinemaAppConfig.class)
public class TestCinemaValidators {

    @Autowired
    private Validator validator;

    @Test
    public void testActorValidator() {
        Actor actor = new Actor("Popescu", "Ion");
        assert validator.isValid(actor);

        Actor actor1 = new Actor("", "");
        assert !validator.isValid(actor1);
    }

    @Test
    public void testDirectorValidator() {
        Director director = new Director("John", "Snow", "RO");
        assert validator.isValid(director);

        Director director1 = new Director("", "", "RO");
        assert !validator.isValid(director1);
    }

    @Test
    public void testMovieValidator() {
        Movie movie = new Movie("Amintiri din copilarie", "12 Ianuarie 2020");
        assert validator.isValid(movie);

        Movie movie1 = new Movie("", "12 Ianuarie 2020");
        assert !validator.isValid(movie1);
    }

    @Test
    public void testRoomValidator() {
        Room room = new Room("Room#1", 435, 232);
        assert validator.isValid(room);

        Room room1 = new Room("Room#1", 0, 0);
        assert !validator.isValid(room1);
    }
}
