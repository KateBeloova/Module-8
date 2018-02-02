package Homework.Module8.patterns.singleton;

import Homework.Module8.business_objects.User;

public class UserSingleton {

    private static User user;

    private UserSingleton() {
    }

    public static User getUser() {
        if (user == null) {

            user = new User("emqa16@thomsonreuters.com", "Secret123");
        }
        return user;
    }
}
