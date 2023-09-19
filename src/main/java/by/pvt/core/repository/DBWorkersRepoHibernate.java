package by.pvt.core.repository;

import by.pvt.core.config.HibernateJavaConfig;
import by.pvt.core.domain.Guest;
import by.pvt.core.domain.Workers;
import by.pvt.core.repository.interfaces.InterfaceDbGuestRepo;
import by.pvt.core.repository.interfaces.InterfaceDbWorkersRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DBWorkersRepoHibernate implements InterfaceDbWorkersRepo
    {
    private final SessionFactory sessionFactory;
    public DBWorkersRepoHibernate()
        {
        sessionFactory = HibernateJavaConfig.getSessionFactory();
        }

    @Override
    public void addGuest(Workers work) {
    Session session = sessionFactory.openSession();
    session.getTransaction().begin();
    session.persist(work);
    session.getTransaction().commit();
    session.close();
    }
    }
