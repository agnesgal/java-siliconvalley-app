package com.valley.app.config;

import com.valley.app.service.ProductAndCompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Profile("dev")
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    ProductAndCompanyService dbDataService;

    private static final Logger logger = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

    @Override
    public void run(String...args) throws Exception {
        dbDataService.createDatabase();
        logger.info("Application started with command-line arguments: {} . \n To kill this application click on the stop button.", Arrays.toString(args));
    }

}
