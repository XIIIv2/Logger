package icu.xiii.service;

import icu.xiii.logger.Logger;

public class Test2Service {

    private final Logger logger;


    public Test2Service() {
        this(Logger.getInstance());
    }

    public Test2Service(Logger logger) {
        this.logger = logger;

        logger.debug("Running Test2Service constructor!");
    }

    public Test2Service runTest() {
        logger.info("Running Test2Service::runTest()");

        return this;
    }
}
