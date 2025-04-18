package icu.xiii.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public void write(String msg, String lvl) {
        String logMsg = String.format("(%s) [%s] %s - %s%n",
                DateTimeFormatter
                        .ofPattern("dd-MM-yyyy HH:mm:ss")
                        .format(LocalDateTime.now()),
                lvl.toUpperCase(),
                this.id,
                msg
        );

        System.out.print(logMsg);

        try {
            Files.writeString(
                    Paths.get(Constants.LOG_BASE_PATH + "log.txt"),
                    logMsg,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void info(String msg) {
        this.write(msg, "info");
    }

    public void debug(String msg) {
        this.write(msg, "debug");
    }

    public void warn(String msg) {
        this.write(msg, "warn");
    }
}
