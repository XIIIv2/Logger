package icu.xiii;

import icu.xiii.logger.Logger;
import icu.xiii.service.TestService;
import icu.xiii.service.Test2Service;

public class Main {

    public static void main(String[] args) {
        Logger.getInstance()
                .debug("Singleton test #1");

        Logger.getInstance()
                .info("Singleton test #2");

        loggerTest3();

        new TestService()
                .runTest();

        new Test2Service()
                .runTest();

        new Test2Service(Logger.getInstance())
                .runTest();
    }

    private static void loggerTest3() {
        Logger.getInstance()
                .warn("Singleton test #3");
    }
}
