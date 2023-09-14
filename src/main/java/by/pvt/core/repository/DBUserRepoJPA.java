package by.pvt.core.repository;

import by.pvt.core.config.HibernateJPAConfig;
import by.pvt.core.domain.User;
import by.pvt.core.repository.interfaces.InterfaceDbUserRepo;

import javax.persistence.EntityManager;
import java.util.List;

public class DBUserRepoJPA implements InterfaceDbUserRepo {
   @Override
    public void addUSer(User user) {
        EntityManager entityManager = HibernateJPAConfig.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = HibernateJPAConfig.getEntityManager();
        List<User> users = entityManager.createNativeQuery("Select * from guest.user").getResultList();
        entityManager.close();
        return users;
    }

    @Override
    public User findById(Long userID) {
        EntityManager entityManager = HibernateJPAConfig.getEntityManager();
        User user = entityManager.find(User.class, userID);
        entityManager.getTransaction().begin();
        entityManager.close();
        return user;
    }

    @Override
    public void delUser(long id) {
        EntityManager entityManager = HibernateJPAConfig.getEntityManager();
        User user = entityManager.find(User.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
