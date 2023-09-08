package by.pvt.core.Repository;

import by.pvt.core.config.HibernateConfig;
import by.pvt.core.domain.User;

import javax.persistence.EntityManager;
import java.util.List;

public class DBUserRepository
    {

    private final String GET_ALL_USERS = "Select * from guest.user";

    public void addUSer(User user)
        {
        EntityManager entityManager = HibernateConfig.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        }

    public List<User> getAllUsers()
        {
        EntityManager entityManager = HibernateConfig.getEntityManager();
        List<User> users = entityManager.createNativeQuery(GET_ALL_USERS).getResultList();
        entityManager.close();
        return users;
        }

    public User seacrhUserById(long userId)
        {
        EntityManager entityManager = HibernateConfig.getEntityManager();
        User user = entityManager.find(User.class, userId);
        entityManager.getTransaction().begin();
        //entityManager.getTransaction().commit();
        entityManager.close();
        return user;
        }

    public void delUser(long id)
        {
        EntityManager entityManager = HibernateConfig.getEntityManager();
        User user = entityManager.find(User.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        }

    public void editUser(User user)
        {
        EntityManager entityManager = HibernateConfig.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        }


    }
