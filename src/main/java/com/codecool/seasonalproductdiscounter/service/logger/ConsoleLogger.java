package com.codecool.seasonalproductdiscounter.service.logger;

import java.time.LocalDateTime;

public class ConsoleLogger implements Logger{

    @Override
    public void logInfo(String message) {

    }

    @Override
    public void logError(String message) {

    }

    @Override
    public void info(String message) {
        log("INFO", message);
    }

    @Override
    public void error(String message) {
        log("ERROR", message);
    }

    private void log(String level, String message) {
        LocalDateTime timestamp = LocalDateTime.now();
        System.out.println(timestamp + " [" + level + "] " + message);
    }
}