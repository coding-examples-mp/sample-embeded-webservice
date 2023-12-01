package org.example.webapp;

import javax.inject.Singleton;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@Singleton
public class Timer {
    Logger logger = Logger.getLogger(getClass().getName());
    //@Schedule(second = "*", minute = "*", hour = "*",  persistent = false)
    public void logTime() {
        logger.warning(String.format("The current time is %s", LocalDateTime.now()));
    }
}
