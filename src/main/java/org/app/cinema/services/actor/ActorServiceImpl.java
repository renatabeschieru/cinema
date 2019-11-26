package org.app.cinema.services.actor;

import java.util.List;

import org.app.cinema.entities.Actor;
import org.app.cinema.services.factory.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private EntityRepository entityRepository;

    @Override
    public void addActor(Actor actor) {
        entityRepository.add(actor);
    }

    @Override
    public List<Actor> getActors() {
        return entityRepository.getActors();
    }
}
