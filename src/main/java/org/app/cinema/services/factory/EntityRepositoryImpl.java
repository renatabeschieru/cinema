package org.app.cinema.services.factory;

import java.util.ArrayList;

import org.app.cinema.entities.Actor;
import org.app.cinema.entities.Director;
import org.app.cinema.entities.Movie;
import org.app.cinema.entities.Room;
import org.springframework.stereotype.Service;

@Service
public class EntityRepositoryImpl implements EntityRepository {

    private ArrayList<Actor> actors;

    private ArrayList<Director> directors;

    private ArrayList<Movie> movies;

    private ArrayList<Room> rooms;

    public EntityRepositoryImpl() {
        actors = new ArrayList<>();
        directors = new ArrayList<>();
        movies = new ArrayList<>();
        rooms = new ArrayList<>();
    }

    @Override
    public void add(Actor actor) {
        actors.add(actor);
    }

    @Override
    public void add(Room room) {
        rooms.add(room);
    }

    @Override
    public void add(Director director) {
        directors.add(director);
    }

    @Override
    public void add(Movie movie) {
        movies.add(movie);
    }

    @Override
    public Actor getActor(Long id) {
        return actors.stream().filter(actor -> actor.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Room getRoom(Long id) {
        return rooms.stream().filter(room -> room.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Director getDirector(Long id) {
        return directors.stream().filter(director -> director.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Movie getMovie(Long id) {
        return movies.stream().filter(movie -> movie.getId().equals(id)).findFirst().orElse(null);
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public ArrayList<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(ArrayList<Director> directors) {
        this.directors = directors;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
}
