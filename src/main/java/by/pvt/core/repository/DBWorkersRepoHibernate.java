package by.pvt.core.repository;


import by.pvt.core.config.HibernateConfig;
import by.pvt.core.domain.*;
import by.pvt.core.repository.interfaces.InterfaceDbWorkersRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
@Repository
public class DBWorkersRepoHibernate implements InterfaceDbWorkersRepo {

   private SessionFactory sessionFactory;

    @Override
    public void addGuest(Workers work) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(work);
        session.getTransaction().commit();
        session.close();
    }

    //Самый высокооплачиваемый работник
    public Workers getMostPaid() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select w from Workers w where w.moneyMonth = (select max(w.moneyMonth) from Workers w)");
        return (Workers) query.getSingleResult();
    }

    //Самый низкооплачиваемый работник
    public Workers getMostUnpaid() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select w from Workers w where w.moneyMonth = (select min(w.moneyMonth) from Workers w)");
        return (Workers) query.getSingleResult();
    }

    public List<Workers> getAllWorkersCriteria() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Workers> criteriaQuery = criteriaBuilder.createQuery(Workers.class);
        Root<Workers> root = criteriaQuery.from(Workers.class);
        criteriaQuery.select(root);
        List<Workers> workerList = entityManager.createQuery(criteriaQuery).getResultList();
        return workerList;
    }


}
