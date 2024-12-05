package org.unsam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main( String[] args ) {
        SpringApplication.run(Main.class);
        LOGGER.info("The application is now running......");
    }
}