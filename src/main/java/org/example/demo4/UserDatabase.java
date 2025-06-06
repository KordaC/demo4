package org.example.demo4;

import java.util.HashMap;

public class UserDatabase {
    private static HashMap<String, User> users = new HashMap<>();

    public static boolean registerUser(String name, String login, String password) {
        if (users.containsKey(login)) return false;
        users.put(login, new User(name, login, password));
        return true;
    }

    public static User authenticate(String login, String password) {
        User user = users.get(login);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
