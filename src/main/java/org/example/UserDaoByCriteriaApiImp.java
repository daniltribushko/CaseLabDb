package org.example;

import jakarta.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Page;

import java.util.List;
import java.util.Optional;

public class UserDaoByCriteriaApiImp implements UserDao{
    @Override
    public void save(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.persist(user);
        session.close();
    }

    @Override
    public Optional<User> findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> critQuery = builder.createQuery(User.class);
        Root<User> root = critQuery.from(User.class);
        critQuery.select(root)
                .where(builder.equal(root.get("id"), id));
        Optional<User> result = session
                .createQuery(critQuery).uniqueResultOptional();
        session.close();
        return result;
    }

    @Override
    public void update(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaUpdate<User> critQuery = builder.createCriteriaUpdate(User.class);
        System.out.println(user);
        critQuery.set("surename", user.getSureName());
        critQuery.set("name", user.getName());
        critQuery.set("age", user.getAge());
        critQuery.set("city", user.getCity());
        critQuery.set("country", user.getCountry());
        critQuery.set("subject", user.getSubject());
        Transaction transaction = session.getTransaction();
        session.createMutationQuery(critQuery).executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaDelete<User> criteriaDelete = builder.createCriteriaDelete(User.class);
        Root<User> root = criteriaDelete.from(User.class);
        criteriaDelete.where(builder.equal(root.get("id"), user.getId()));
        Transaction transaction = session.getTransaction();
        session.createMutationQuery(criteriaDelete);
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        criteriaQuery.select(criteriaQuery.from(User.class));
        List<User> users = session.createQuery(criteriaQuery).getResultList();
        session.close();

        return users;
    }

    @Override
    public List<User> findAllByPage(Integer page, Integer count) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        criteriaQuery.select(criteriaQuery.from(User.class));
        List<User> users = session.createQuery(criteriaQuery)
                .setPage(Page.page(count, page))
                .getResultList();
        session.close();

        return users;
    }

    @Override
    public List<User> findAllByPageAndAge(Integer page, Integer count, Integer age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(builder.equal(root.get("age"), age));
        List<User> users = session.createQuery(criteriaQuery)
                .setPage(Page.page(count, page))
                .getResultList();
        session.close();

        return users;
    }

    @Override
    public List<User> findAllByPageAndCity(Integer page, Integer count, String city) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(builder.equal(root.get("city"), city));
        List<User> users = session.createQuery(criteriaQuery)
                .setPage(Page.page(count, page))
                .getResultList();
        session.close();

        return users;
    }

    @Override
    public List<User> findAllByPageAndSubject(Integer page, Integer count, String subject) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(builder.equal(root.get("subject"), subject));
        List<User> users = session.createQuery(criteriaQuery)
                .setPage(Page.page(count, page))
                .getResultList();
        session.close();

        return users;
    }

    @Override
    public List<User> findAllByPageAndCountry(Integer page, Integer count, String country) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(builder.equal(root.get("country"), country));
        List<User> users = session.createQuery(criteriaQuery)
                .setPage(Page.page(count, page))
                .getResultList();
        session.close();

        return users;
    }
}
