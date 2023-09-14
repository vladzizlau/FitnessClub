package by.pvt.core.repository;

import by.pvt.core.config.HibernateJavaConfig;
import by.pvt.core.domain.Office;
import by.pvt.core.repository.interfaces.InterfaceDbOfficeRepo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DBOfficeRepoHibernate implements InterfaceDbOfficeRepo {
    private SessionFactory sessionFactory;

    public DBOfficeRepoHibernate() {
        sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

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
        office.setId(null);
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

    public void editCountPeople(long id, int maxCountPeople)
    {
        Session session = sessionFactory.openSession();
        Office office = session.get(Office.class, id);
        session.getTransaction().begin();
        office.setMaxCountPeople(maxCountPeople);
        session.persist(office);
        session.getTransaction().commit();
        session.close();
    }

    public void editCostPerHour(long id, BigDecimal cost)
    {
        Session session = sessionFactory.openSession();
        Office office = session.get(Office.class, id);
        session.getTransaction().begin();
        office.setCost_per_hour(new BigDecimal(String.valueOf(cost)));
        session.persist(office);
        session.getTransaction().commit();
        session.close();
    }

    public List <BigDecimal> getCostForOnePeople(String nameRoom){
        ArrayList<BigDecimal> cost = new ArrayList<>();
        Session session = sessionFactory.openSession();
        Criteria officeCriteria = session.createCriteria(Office.class);
        officeCriteria.add(Restrictions.eq("nameRoom", nameRoom));
        List <Office> offices = officeCriteria.add(Restrictions.like("nameRoom", nameRoom, MatchMode.ANYWHERE)).list();
        for (Office office : offices) {
            BigDecimal costForPoeple = office.getCost_per_hour().divide(BigDecimal.valueOf(office.getMaxCountPeople()));
        cost.add(costForPoeple);
        }
        session.close();
        return cost;
    }
}
