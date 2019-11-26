package org.app.cinema.services.director;

import org.app.cinema.entities.Director;

import java.util.List;

public interface DirectorService {

    void saveDirector(Director director);

    List<Director> getAllDirectors();
}
