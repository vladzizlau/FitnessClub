package by.pvt.core.repository;

import by.pvt.core.config.HibernateJavaConfig;
import by.pvt.core.domain.Offer;
import by.pvt.core.repository.interfaces.InterfaceDbOfferRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class DBOfferRepoHibernate implements InterfaceDbOfferRepo {
    private SessionFactory sessionFactory;

    public DBOfferRepoHibernate() {
        sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public void addOffer(Offer offer) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(offer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Offer> getListOffer() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("Select * from guest.offer");
        List<Offer> alloffer = query.getResultList();
        return alloffer;
    }

    @Override
    public Offer findById(Long offerID) {
        Session session = sessionFactory.openSession();
        Offer offer = session.get(Offer.class, offerID);
        return offer;
    }

    @Override
    public void delOffer(long id) {
        Session session = sessionFactory.openSession();
        Offer offer = session.get(Offer.class, id);
        session.getTransaction().begin();
        session.remove(offer);
        session.close();
    }
}
