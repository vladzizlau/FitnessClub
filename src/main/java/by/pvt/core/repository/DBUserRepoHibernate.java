package by.pvt.core.repository;

//import by.pvt.core.config.HibernateJavaConfig;
import by.pvt.core.domain.Guest;
import by.pvt.core.domain.PremiumUser;
import by.pvt.core.domain.User;
import by.pvt.core.domain.Visits;
import by.pvt.core.repository.interfaces.InterfaceDbUserRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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
public class DBUserRepoHibernate implements InterfaceDbUserRepo {

    private SessionFactory sessionFactory;



    @Override
    public void addUSer(User user) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("select u from User u");
        List<User> allusers = query.getResultList();
        return allusers;
    }

    @Override
    public User findById(Long userID) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, userID);
        return user;
    }

    @Override
    public void delUser(long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
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
    public User getByName(String name) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select u from User u where u.firstName = :name");
        query.setParameter("name", name);
        return (User) query.getSingleResult();
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
    public List<User> getUserForAge(int minAge, int maxAge) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> user = criteriaQuery.from((User.class));

        criteriaQuery.select(user).where(criteriaBuilder.between(user.get("age"), minAge, maxAge));
        List<User> u = entityManager.createQuery(criteriaQuery).getResultList();
        return u;
    }

    @Override
    public List<Guest> getVisitsByNameAndAge(String name, Integer age) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Guest> cQuery = criteriaBuilder.createQuery(Guest.class);
        Root<Guest> guest = cQuery.from(Guest.class);
        cQuery.select(guest).where(criteriaBuilder.and(criteriaBuilder.equal(guest.get("firstName"), name),
                criteriaBuilder.gt(guest.get("age"), age)));
        List<Guest> guestList = entityManager.createQuery(cQuery).getResultList();
//        guestList.forEach(s -> System.out.println(s.getFirstVisitDate() + " " + s.getLastVisitDate()));
        return guestList;
    }
}
