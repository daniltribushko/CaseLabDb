package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Page;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class UserDaoImp implements UserDao {
    @Override
    public void save(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(user);
        session.close();
    }

    @Override
    public Optional<User> findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User result = session.get(User.class, id);
        session.close();
        return Optional.ofNullable(result);
    }

    @Override
    public void update(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        session.merge(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        session.remove(user);
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("FROM User ", User.class)
                .getResultList();
        session.close();

        return users;
    }

    @Override
    public List<User> findAllByPage(Integer page, Integer count) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery("from User ", User.class);
        query.setPage(Page.page(count, page));
        List<User> users = query.getResultList();
        session.close();

        return users;
    }

    @Override
    public List<User> findAllByPageAndAge(Integer page, Integer count, Integer age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery(
                "from User u where u.age=" + age,
                User.class);
        query.setPage(Page.page(count, page));
        List<User> users = query.getResultList();
        session.close();

        return users;
    }

    @Override
    public List<User> findAllByPageAndCity(Integer page, Integer count, String city) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery(
                String.format("from User u where u.city='%s'", city),
                User.class);
        query.setPage(Page.page(count, page));
        List<User> users = query.getResultList();
        session.close();

        return users;
    }

    @Override
    public List<User> findAllByPageAndSubject(Integer page, Integer count, String subject) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery(
                String.format("from User u where u.subject='%s'", subject),
                User.class);
        query.setPage(Page.page(count, page));
        List<User> users = query.getResultList();
        session.close();

        return users;
    }

    @Override
    public List<User> findAllByPageAndCountry(Integer page, Integer count, String country) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery(
                String.format("from User u where u.country='%s'", country),
                User.class);
        query.setPage(Page.page(count, page));
        List<User> users = query.getResultList();
        session.close();

        return users;
    }
}
