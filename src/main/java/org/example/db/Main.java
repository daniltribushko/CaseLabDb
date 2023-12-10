package org.example.db;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        JDBCJava java = new JDBCJava();
        java.openConnection();
        java.insertInto(new User("ff", "ff", 20, "sf", "ssh", "dhdh"));
        java.getAllUsers().forEach(System.out::println);
        UserJdbc users =  java.getUserById(1);
        users.setName("Боб");
        java.updateUser(users);
        java.getAllUsers().forEach(System.out::println);
        java.deleteUser(users);
        java.getAllUsers().forEach(System.out::println);
        java.closeConnection();
    }
}
