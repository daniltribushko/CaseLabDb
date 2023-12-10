package org.example.db;

import java.sql.SQLException;
import java.util.List;

public interface JdbcUserInterface {
    void openConnection();
    void insertInto(User user);
    void updateUser(UserJdbc user);
    UserJdbc getUserById(Integer id);
    List<UserJdbc> getAllUsers();
    void deleteUser(UserJdbc user);
    void closeConnection() throws SQLException;
}
