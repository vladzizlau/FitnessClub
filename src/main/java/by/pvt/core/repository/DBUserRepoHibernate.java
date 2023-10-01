package by.pvt.core.repository;

import by.pvt.core.config.HibernateJavaConfig;
import by.pvt.core.domain.PremiumUser;
import by.pvt.core.domain.User;
import by.pvt.core.domain.Visits;
import by.pvt.core.repository.interfaces.InterfaceDbUserRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class DBUserRepoHibernate implements InterfaceDbUserRepo
    {

    private final SessionFactory sessionFactory;

    public DBUserRepoHibernate()
        {
        sessionFactory = HibernateJavaConfig.getSessionFactory();
        }

    @Override
    public void addUSer(User user)
        {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
        }

    @Override
    public List<User> getAllUsers()
        {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("select u from User u");
        List<User> allusers = query.getResultList();
        return allusers;
        }

    @Override
    public User findById(Long userID)
        {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, userID);
        return user;
        }

    @Override
    public void delUser(long id)
        {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.getTransaction().begin();
        session.remove(user);
        session.close();
        }

    @Override
    public List<PremiumUser> getUsersPremium()
        {
        Session session = sessionFactory.openSession();
        List<PremiumUser> allusers = session.createQuery("Select p from PremiumUser p").getResultList();
        System.out.println(allusers);
        return allusers;
        }

    @Override
    //Поиск по имени
    public User getByName(String name)
        {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select u from User u where u.firstName = :name");
        query.setParameter("name", name);
        return (User) query.getSingleResult();
        }

    @Override
    public void addVisit(Visits visit)
        {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(visit);
        session.getTransaction().commit();
        session.close();
        }


    }
