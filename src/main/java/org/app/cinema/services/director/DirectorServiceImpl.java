package org.app.cinema.services.director;

import java.util.List;

import org.app.cinema.entities.Director;
import org.app.cinema.services.factory.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private EntityRepository entityRepository;

    @Override
    public void saveDirector(Director director) {
        entityRepository.add(director);
    }

    @Override
    public List<Director> getAllDirectors() {
        return entityRepository.getDirectors();
    }
}
