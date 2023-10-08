package by.pvt.core;

import by.pvt.core.config.HibernateJavaConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Lesson_21 {
    private SessionFactory sessionFactory;

    public Lesson_21() {
        sessionFactory = HibernateJavaConfig.getSessionFactory();
    }
    public Double getMoneyWorks(LocalDate start, LocalDate end)
    {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select sum (moneyMonth) from Workers w");
        Long days = end.toEpochDay() - start.toEpochDay();

        Double allMoney = (Double) query.getSingleResult() / 30 * days;
        return allMoney;

    }
    public Double getMyCash(LocalDate start, LocalDate end)
    {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select sum (cost_per_hour) from Office o");
        Long days = end.toEpochDay() - start.toEpochDay();
//12 рабочих часов в день
        Double allMoney =  Double.parseDouble(query.getSingleResult().toString()) * 12 * days;
        return allMoney;

    }

}
