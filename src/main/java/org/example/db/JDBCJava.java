package org.example.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCJava implements JdbcUserInterface {
    private static Connection connection;

    @Override
    public void openConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/greenatom2023", "postgres",
                    "123456654321");
            System.out.println("Подключение выполнено успешно");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void insertInto(User user) {
        try {
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(String.format("insert into users(surename, name, age, city, country, " +
                            "subject)\nvalues\n('%s', '%s', '%d', '%s', '%s', '%s')", user.getSureName(), user.getName(),
                    user.getAge(), user.getCity(), user.getCountry(), user.getSubject()));
            System.out.printf("rows added: %d\n", rows);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void updateUser(UserJdbc user) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("UPDATE users\nSET surename='%s', name='%s', age=%d, city='%s', country='%s'," +
                            " subject='%s'\nWHERE id=%d ", user.getSureName(), user.getName(), user.getAge(),
                    user.getCity(), user.getCountry(),
                    user.getSubject(), user.getId());
            int rows = statement.executeUpdate(query);
            System.out.println("rows added: " + rows);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public  UserJdbc getUserById(Integer id) {
        UserJdbc user = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(String.format("select * from users where id=%d", id));
            while (result.next()) {
                user = new UserJdbc(result.getInt(1), result.getString(2),
                        result.getString(3), result.getInt(4), result.getString(5),
                        result.getString(6), result.getString(7));
                break;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }
    @Override
    public  List<UserJdbc> getAllUsers() {
        List<UserJdbc> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                users.add(new UserJdbc(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4),
                        resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }
    @Override
    public void deleteUser(UserJdbc user){
        try {
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(String.format("DELETE from users where id=%d", user.getId()));
            System.out.println(rows + " rows deleted");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }
}
