package by.pvt.core;

//import by.pvt.core.config.HibernateJavaConfig;


import by.pvt.core.domain.Office;
import by.pvt.core.domain.Visits;
import by.pvt.core.repository.DBOfficeRepoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class Lesson_22 {
@Autowired
    private SessionFactory sessionFactory;

//    public Lesson_22() {
//        sessionFactory = HibernateJavaConfig.getSessionFactory();
//    }


    public void firstMethod(Long Id) {
        Session session = sessionFactory.openSession();
        org.hibernate.query.Query query = session.createQuery("Select o from Office o");
        List office = query.getResultList();

        org.hibernate.query.Query query2 = session.createQuery("Select o from Offer o");
        List offer = query.getResultList();

//        org.hibernate.query.Query query3 = session.createQuery("Select w from Office w where offer_id = :id").setParameter("id", Id);
//        List office1 = query.getResultList();

        Office office1 = session.load(Office.class, Id);
        System.out.println(office1);
        session.close();
    }

    public void secondMethod (Long id){
        Session session = sessionFactory.openSession();
        org.hibernate.query.Query query = session.createQuery("Select o from Office o");
        Office office = session.load(Office.class, id);
        System.out.println(office);
        session.close();

        Session session3 = sessionFactory.openSession();
        Office office1 = session3.load(Office.class, id);
        System.out.println(office1);
        session.close();
    }
}
