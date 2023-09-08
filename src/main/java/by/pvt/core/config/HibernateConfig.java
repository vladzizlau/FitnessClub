package by.pvt.core.config;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateConfig {

    public static EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FitnessClub");
        return entityManagerFactory.createEntityManager();
        }

}
