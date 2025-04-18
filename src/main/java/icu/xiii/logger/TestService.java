package icu.xiii.logger;

public class TestService {

    private static final Logger logger = Logger.getInstance();

    public TestService() {
        logger.debug("Running TestService constructor!");
    }

    public void runTest() {
        logger.info("Running TestService::runTest()");
    }
}
