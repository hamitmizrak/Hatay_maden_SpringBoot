package com.hamitmizrak.runner;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// LOMBOK
@Log4j2

@Configuration
public class _2_ProjectDataSet {

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Project Data set -2 ");
            log.info("Project Data set -2 ");
        };
    } // end Bean

} // _2_ProjectDataSet
