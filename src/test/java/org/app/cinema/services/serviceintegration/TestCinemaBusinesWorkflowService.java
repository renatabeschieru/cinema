package org.app.cinema.services.serviceintegration;

import org.app.cinema.config.CinemaAppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CinemaAppConfig.class)
public class TestCinemaBusinesWorkflowService {

    @Autowired
    private CinemaBusinessWorkflowService cinemaBusinessWorkflowService;

    @Test
    public void testCinemaBusinessWorkflowService() {
        cinemaBusinessWorkflowService.startWorkflow();

        assert cinemaBusinessWorkflowService.getNrOfComponents() == 4;
    }
}
