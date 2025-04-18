package icu.xiii.logger;

import icu.xiii.Constants;

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
    private final DateTimeFormatter dateTimeFormatter;

    private Logger() {
        this.id = "logger#" + new Random()
                .nextInt(100);

        this.dateTimeFormatter = DateTimeFormatter
                .ofPattern("dd-MM-yyyy HH:mm:ss");
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
                dateTimeFormatter
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
            System.out.println("Error writing to log file: " + e.getMessage());
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
