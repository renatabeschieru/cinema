package org.app.cinema.services.movie;

import org.app.cinema.entities.Movie;

import java.util.List;

public interface MovieService {

    void save(Movie movie);

    List<Movie> getAll();
}
