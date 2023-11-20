package by.pvt.core.repository;

import by.pvt.core.domain.Office;
import by.pvt.core.domain.OfficeSubSelect;
import by.pvt.core.repository.interfaces.InterfaceDbOfficeRepo;
//import net.sf.ehcache.search.expression.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Repository
public class DBOfficeRepoHibernate implements InterfaceDbOfficeRepo {
    @Autowired
    private SessionFactory sessionFactory;

//    public DBOfficeRepoHibernate() {
//        sessionFactory = HibernateJavaConfig.getSessionFactory();
//    }

    @Override
    public void addOffice(Office office) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(office);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void editInvenory(long id, long inventaryNumber) {
        Session session = sessionFactory.openSession();
        Office office = session.get(Office.class, id);
        session.detach(office);
        session.getTransaction().begin();
        office.setRoomID(inventaryNumber);
        session.persist(office);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Office> getListOffice() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("Select * from guest.office");
        List<Office> alloffice = query.getResultList();
        return alloffice;
    }

    @Override
    public Office findById(Long officeID) {
        Session session = sessionFactory.openSession();
        Office office = session.get(Office.class, officeID);
        return office;
    }

    @Override
    public void delOffice(long id) {
        Session session = sessionFactory.openSession();
        Office office = session.get(Office.class, id);
        session.getTransaction().begin();
        session.remove(office);
        session.close();
    }

    public void editCountPeople(long id, int maxCountPeople) {
        Session session = sessionFactory.openSession();
        Office office = session.get(Office.class, id);
        session.getTransaction().begin();
        office.setMaxCountPeople(maxCountPeople);
        session.persist(office);
        session.getTransaction().commit();
        session.close();
    }

    public void editCostPerHour(long id, BigDecimal cost) {
        Session session = sessionFactory.openSession();
        Office office = session.get(Office.class, id);
        session.getTransaction().begin();
        office.setCost_per_hour(new BigDecimal(String.valueOf(cost)));
        session.persist(office);
        session.getTransaction().commit();
        session.close();
    }

//    public List<BigDecimal> getCostForOnePeople(String nameRoom) {
//        ArrayList<BigDecimal> cost = new ArrayList<>();
//        Session session = sessionFactory.openSession();
//        Criteria officeCriteria = session.createCriteria(Office.class);
//        officeCriteria.add(Restrictions.eq("nameRoom", nameRoom));
//        List<Office> offices = officeCriteria.add(Restrictions.like("nameRoom", nameRoom, MatchMode.ANYWHERE)).list();
//        for (Office office : offices) {
//            BigDecimal costForPoeple = office.getCost_per_hour().divide(BigDecimal.valueOf(office.getMaxCountPeople()));
//            cost.add(costForPoeple);
//        }
//        session.close();
//        return cost;
//    }

    public List<OfficeSubSelect> getOfficeSubSelect() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("Select os from OfficeSubSelect os");
        return (List<OfficeSubSelect>) query.getResultList();
    }


    //Выручка со всех помещений за N месяцев
    public double getYield(int countmonth) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select sum (cost_per_hour) from Office o");
        BigDecimal yield = (BigDecimal) query.getSingleResult();
        return Double.valueOf(String.valueOf(yield)) * countmonth;
    }


    public Integer getCountGuest() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
        criteriaQuery.select(criteriaBuilder.sum(criteriaQuery.from(Office.class).get("maxCountPeople")));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public List<Office> getOfficeMaxCountPeopleAndPrice(BigDecimal one, int two) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Office> cQuery = criteriaBuilder.createQuery(Office.class);
        Root<Office> office = cQuery.from(Office.class);
        cQuery.select(office).where(criteriaBuilder.and(criteriaBuilder.gt(office.get("cost_per_hour"), one),
                criteriaBuilder.gt(office.get("maxCountPeople"), two))).orderBy(criteriaBuilder.asc(office.get("maxCountPeople")));
        List<Office> officeList = entityManager.createQuery(cQuery).getResultList();
        return officeList;
    }

}
