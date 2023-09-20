package com.codecool.seasonalproductdiscounter.service.logger;

public interface Logger {
    public void logInfo(String message);

    public void logError(String message);

    void info(String s);

    void error(String message);
}
