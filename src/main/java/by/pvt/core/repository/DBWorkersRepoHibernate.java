package by.pvt.core.repository;

import by.pvt.core.config.HibernateJavaConfig;
import by.pvt.core.domain.Offer;
import by.pvt.core.domain.Office;
import by.pvt.core.domain.Workers;
import by.pvt.core.repository.interfaces.InterfaceDbWorkersRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DBWorkersRepoHibernate implements InterfaceDbWorkersRepo
    {
    private final SessionFactory sessionFactory;

    public DBWorkersRepoHibernate()
        {
        sessionFactory = HibernateJavaConfig.getSessionFactory();
        }

    @Override
    public void addGuest(Workers work)
        {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(work);
        session.getTransaction().commit();
        session.close();
        }

    //Самый высокооплачиваемый работник
    public Workers getMostPaid()
        {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select w from Workers w where w.moneyMonth = (select max(w.moneyMonth) from Workers w)");
        return (Workers) query.getSingleResult();
        }

    //Самый низкооплачиваемый работник
    public Workers getMostUnpaid()
        {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select w from Workers w where w.moneyMonth = (select min(w.moneyMonth) from Workers w)");
        return (Workers) query.getSingleResult();
        }

    public List<Workers> getAllWorkersCriteria()
        {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Workers> criteriaQuery = criteriaBuilder.createQuery(Workers.class);
        Root<Workers> root = criteriaQuery.from(Workers.class);
        criteriaQuery.select(root);
        List<Workers> employeeList = entityManager.createQuery(criteriaQuery).getResultList();
        return employeeList;
        }

    public Long getActivity()
        {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        criteriaQuery.select(criteriaBuilder.min(criteriaQuery.from(Offer.class).get("price")));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
        }


    public Integer getCountGuest()
        {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
        criteriaQuery.select(criteriaBuilder.sum(criteriaQuery.from(Office.class).get("maxCountPeople")));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
        }

//    public User getUserForAge(){
//        EntityManager entityManager = sessionFactory.createEntityManager();
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
//        criteriaQuery.select(criteriaBuilder.min(criteriaQuery.from(User.class).get("age"))
//    }

    }
