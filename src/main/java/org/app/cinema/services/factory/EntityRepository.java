package org.app.cinema.services.factory;

import java.util.ArrayList;

import org.app.cinema.entities.Actor;
import org.app.cinema.entities.Director;
import org.app.cinema.entities.Movie;
import org.app.cinema.entities.Room;

public interface EntityRepository {

    void add(Actor actor);

    void add(Room room);

    void add(Director director);

    void add(Movie movie);

    Actor getActor(Long id);

    Room getRoom(Long id);

    Director getDirector(Long id);

    Movie getMovie(Long id);

    ArrayList<Actor> getActors();

    void setActors(ArrayList<Actor> actors);

    ArrayList<Director> getDirectors();

    void setDirectors(ArrayList<Director> directors);

    ArrayList<Movie> getMovies();

    void setMovies(ArrayList<Movie> movies);

    ArrayList<Room> getRooms();

    void setRooms(ArrayList<Room> rooms);
}
