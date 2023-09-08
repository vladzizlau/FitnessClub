package by.pvt.core.Repository;

import by.pvt.core.config.HibernateConfig;
import by.pvt.core.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DBUserRepository {
    public void addUSer(User user) {
        EntityManager entityManager = HibernateConfig.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<User> getAllUsers() {
        EntityManager entityManager = HibernateConfig.getEntityManager();
        List<User> users = entityManager.createNativeQuery("Select * from guest.user").getResultList();
        entityManager.close();
        return users;
    }

    public void delUser(long id) {
        EntityManager entityManager = HibernateConfig.getEntityManager();
        User user = entityManager.find(User.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
