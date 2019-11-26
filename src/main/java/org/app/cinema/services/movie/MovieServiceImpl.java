package org.app.cinema.services.movie;

import java.util.List;

import org.app.cinema.entities.Movie;
import org.app.cinema.services.factory.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private EntityRepository entityRepository;

    @Override
    public void save(Movie movie) {
        entityRepository.add(movie);
    }

    @Override
    public List<Movie> getAll() {
        return entityRepository.getMovies();
    }
}
