package by.pvt.core.repository;

//import by.pvt.core.config.HibernateJavaConfig;
import by.pvt.core.domain.Offer;
import by.pvt.core.repository.interfaces.InterfaceDbOfferRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public class DBOfferRepoHibernate implements InterfaceDbOfferRepo {

    @Autowired
    private SessionFactory sessionFactory;



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
//@Override
//    public Long getActivity() {
//        EntityManager entityManager = sessionFactory.createEntityManager();
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
//        criteriaQuery.select(criteriaBuilder.min(criteriaQuery.from(Offer.class).get("price")));
//        return entityManager.createQuery(criteriaQuery).getSingleResult();
//    }
}
