package icu.xiii.logger;

import java.util.Random;

public class Logger {

    private static volatile Logger instance;

    private final String id;

    private Logger() {
        Random random = new Random();
        this.id = "logger#" + random.nextInt(100);
    }

    public static Logger getInstance() {
        Logger localInstance = instance;
        if (localInstance == null) {
            synchronized (Logger.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Logger();
                }
            }
        }
        return localInstance;
    }

    public String getId() {
        return this.id;
    }

    public void write(String msg) {
        System.out.println(this.id + ": " + msg);
    }

    public void info(String msg) {
        this.write("[INFO] - " + msg);
    }

    public void debug(String msg) {
        this.write("[DEBUG] - " + msg);
    }

    public void warn(String msg) {
        this.write("[WARN] - " + msg);
    }
}
