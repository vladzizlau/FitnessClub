package by.pvt.core.repository;

import by.pvt.core.config.HibernateJavaConfig;
import by.pvt.core.domain.Guest;
import by.pvt.core.repository.interfaces.InterfaceDbGuestRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DBGuestRepoHibernate implements InterfaceDbGuestRepo
    {
    private final SessionFactory sessionFactory;
    public DBGuestRepoHibernate()
        {
        sessionFactory = HibernateJavaConfig.getSessionFactory();
        }

    @Override
    public void addGuest(Guest guest) {
    Session session = sessionFactory.openSession();
    session.getTransaction().begin();
    session.persist(guest);
    session.getTransaction().commit();
    session.close();
    }
    }
