package org.example;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void save(User user);
    Optional<User> findById(Long id);
    void update(User user);
    void delete(User user);
    List<User> findAll();
    List<User> findAllByPage(Integer page, Integer count);
    List<User> findAllByPageAndAge(Integer page, Integer count, Integer age);
    List<User> findAllByPageAndCity(Integer page, Integer count, String city);
    List<User> findAllByPageAndSubject(Integer page, Integer count, String subject);
    List<User> findAllByPageAndCountry(Integer page, Integer count, String country);

}
