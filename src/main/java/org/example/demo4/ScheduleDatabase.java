package org.example.demo4;

import java.time.LocalDateTime;
import java.util.*;

public class ScheduleDatabase {
    public static List<TrainingSession> allSessions = new ArrayList<>();
    private static Map<User, List<TrainingSession>> userSessions = new HashMap<>();

    static {

        allSessions.add(new TrainingSession("Йога", "Ирина", LocalDateTime.now().plusDays(1).withHour(10)));
        allSessions.add(new TrainingSession("Бокс", "Алексей", LocalDateTime.now().plusDays(1).withHour(18)));
        allSessions.add(new TrainingSession("Силовая", "Максим", LocalDateTime.now().plusDays(2).withHour(16)));
    }

    public static List<TrainingSession> getAllSessions() {
        return allSessions;
    }

    public static List<TrainingSession> getSessionsForUser(User user) {
        return userSessions.getOrDefault(user, new ArrayList<>());
    }

    public static boolean isUserSignedUp(User user, TrainingSession session) {
        return getSessionsForUser(user).contains(session);
    }

    public static void signUp(User user, TrainingSession session) {
        userSessions.putIfAbsent(user, new ArrayList<>());
        if (!userSessions.get(user).contains(session)) {
            userSessions.get(user).add(session);
        }
    }

    public static void cancel(User user, TrainingSession session) {
        if (userSessions.containsKey(user)) {
            userSessions.get(user).remove(session);
        }
    }
}
