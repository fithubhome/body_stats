package ro.fithubhome.bodystats.service;


import java.time.LocalDateTime;

public class Logger {
    public static void logInfo(String info) {
        System.out.println(LocalDateTime.now() + " - " + info);
    }
    public static void logError(String error) {
        System.out.println(LocalDateTime.now() + " - " + error);
    }
}
