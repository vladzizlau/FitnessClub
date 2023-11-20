package by.pvt.core.repository;

//import by.pvt.core.config.HibernateJavaConfig;
import by.pvt.core.domain.Client;
import by.pvt.core.domain.PremiumUser;
import by.pvt.core.domain.Visits;
import by.pvt.core.repository.interfaces.InterfaceDbClientRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
@Repository
public class DBClientRepoHibernate implements InterfaceDbClientRepo {
    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void addUSer(Client user) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Client> getAllUsers() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("select c from Client c");
        List<Client> allusers = query.getResultList();
        return allusers;
    }

    @Override
    public Client findById(Long userID) {
        Session session = sessionFactory.openSession();
        Client user = session.get(Client.class, userID);
        return user;
    }

    @Override
    public void delUser(long id) {
        Session session = sessionFactory.openSession();
        Client user = session.get(Client.class, id);
        session.getTransaction().begin();
        session.remove(user);
        session.close();
    }

    @Override
    public List<PremiumUser> getUsersPremium() {
        Session session = sessionFactory.openSession();
        List<PremiumUser> allusers = session.createQuery("Select p from PremiumUser p").getResultList();
        System.out.println(allusers);
        return allusers;
    }

    @Override
    //Поиск по имени
    public Client getByName(String name) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select u from Client u where u.firstName = :name");
        query.setParameter("name", name);
        return (Client) query.getSingleResult();
    }

    @Override
    public void addVisit(Visits visit) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(visit);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List <Client> getUserForAge(int minAge, int maxAge) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> user = criteriaQuery.from((Client.class));

        criteriaQuery.select(user).where(criteriaBuilder.between(user.get("age"), minAge, maxAge));
        List<Client> u = entityManager.createQuery(criteriaQuery).getResultList();
        return u;
    }

    @Override
    public List<Client> getVisitsByNameAndAge(String name, Integer age) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> cQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> guest = cQuery.from(Client.class);
        cQuery.select(guest).where(criteriaBuilder.and(criteriaBuilder.equal(guest.get("firstName"), name),
                criteriaBuilder.gt(guest.get("age"), age)));
        List<Client> guestList = entityManager.createQuery(cQuery).getResultList();
//        guestList.forEach(s -> System.out.println(s.getFirstVisitDate() + " " + s.getLastVisitDate()));
        return guestList;
    }
}
