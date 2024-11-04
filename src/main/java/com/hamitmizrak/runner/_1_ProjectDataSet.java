package com.hamitmizrak.runner;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// LOMBOK
@Log4j2

// DATA SET
@Component
public class _1_ProjectDataSet implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Project Data set -1 ");
        log.info("Project Data set -1 ");
    }
}
