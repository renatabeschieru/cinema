package org.app.cinema.services.factory;

import java.util.logging.Logger;

import org.app.cinema.entities.Actor;
import org.app.cinema.entities.Director;
import org.app.cinema.entities.Movie;
import org.app.cinema.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class EntityFactoryImpl implements EntityFactory {

    @Autowired
    private EntityRepository entityRepository;

    private static Logger logger = Logger.getLogger(EntityFactoryImpl.class.getName());

    public EntityFactoryImpl() {
        logger.info("EntityFactoryImpl - bean instantiated");
    }

    @Override
    public Actor buildActor(String firstName, String lastName) {
        logger.info(">>> Service: EntityFactoryImpl :: build Actor");
        Actor actor = new Actor(firstName, lastName);
        return actor;
    }

    @Override
    public Director buildDirector(String firstName, String lastName, String nationality) {
        logger.info(">>> Service: EntityFactoryImpl :: build Director");
        return new Director(firstName, lastName, nationality);
    }

    @Override
    public Movie buildMovie(String name, String releaseDate) {
        logger.info(">>> Service: EntityFactoryImpl :: build Movie");
        return new Movie(name, releaseDate);
    }

    @Override
    public Room buildRoom(String name, int nrOfSeats, int nrOfRows) {
        logger.info(">>> Service: EntityFactoryImpl :: build Room");
        return new Room(name, nrOfSeats, nrOfRows);
    }

    @Override
    public void initDomainServiceEntities() {
        Actor actor = buildActor("Popescu", "Ion");
        Movie movie = buildMovie("Film #1", "12 Martie 2002");
        Director director = buildDirector("John", "Snow", "Roman");
        Room room = buildRoom("Room #1", 122, 10);
        actor.addMovie(movie);
        movie.addActor(actor);
        movie.addDirector(director);
        entityRepository.add(room);
        entityRepository.add(actor);
        entityRepository.add(director);
        entityRepository.add(movie);
    }
}
