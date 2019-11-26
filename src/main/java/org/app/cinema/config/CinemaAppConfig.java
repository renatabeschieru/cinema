package org.app.cinema.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
@ComponentScan(basePackages = {"org.app.cinema.services"})
public class CinemaAppConfig {

    private static Logger logger = Logger.getLogger(CinemaAppConfig.class.getName());

}
