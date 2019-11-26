package org.app.cinema.services.serviceintegration;

import java.util.logging.Logger;

import org.app.cinema.services.factory.EntityFactory;
import org.app.cinema.services.factory.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaBusinessWorkflowServiceImpl implements CinemaBusinessWorkflowService {

    private static Logger logger = Logger.getLogger(CinemaBusinessWorkflowServiceImpl.class.getName());

    @Autowired
    private EntityFactory entityFactory;

    @Autowired
    private EntityRepository entityRepository;


    @Override
    public void startWorkflow() {
        entityFactory.initDomainServiceEntities();
    }

    @Override
    public int getNrOfComponents() {
        return entityRepository.getActors().size() + entityRepository.getDirectors().size() +
            entityRepository.getMovies().size() + entityRepository.getRooms().size();
    }
}
