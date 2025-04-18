package icu.xiii;

import icu.xiii.logger.Logger;
import icu.xiii.service.TestService;

public class Main {

    public static void main(String[] args) {
        Logger.getInstance()
                .debug("Singleton test #1");

        Logger.getInstance()
                .info("Singleton test #2");

        loggerTest3();

        new TestService().runTest();
    }

    private static void loggerTest3() {
        Logger.getInstance()
                .warn("Singleton test #3");
    }
}
