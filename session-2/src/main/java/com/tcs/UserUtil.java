package com.tcs;

public class UserUtil {

    public static User getUserById(Integer id) {
        return new User(id, "User_" + id);
    }
    public static User capitalizeUsername(User user) {
        user.setUserName(user.getUserName().toUpperCase());
        return user;
    }
}
