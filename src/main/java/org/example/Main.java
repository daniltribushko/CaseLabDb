package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        UserDao userDao = new UserDaoImp();
        var r = random.ints(100L, 0, 55).toArray();
        for (int i = 0; i < 100; i++) {
            var d = r[i];
            User user = new User(
                    String.valueOf(i),
                    String.valueOf(i),
                    d,
                    String.valueOf(d),
                    String.valueOf(d),
                    String.valueOf(d)
            );
            userDao.save(user);
        }
    }
}