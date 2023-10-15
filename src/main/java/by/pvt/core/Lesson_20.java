package by.pvt.core;

import by.pvt.core.config.HibernateJavaConfig;
import by.pvt.core.domain.*;
import by.pvt.core.service.OfferService;
import by.pvt.core.service.OfficeService;
import by.pvt.core.service.UserService;
import by.pvt.core.service.WorkersService;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;

public class Lesson_20 {
    private final SessionFactory sessionFactory;

    public Lesson_20() {
        sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    public void WorkersCriteria() {
        WorkersService wks = new WorkersService();
        wks.getAllWorkersCriteria();
    }

    public void getActivity() {
        OfferService offerService = new OfferService();
        offerService.getActivity();
    }

    public void getCountGuest() {
        OfficeService officeService = new OfficeService();
        officeService.getCountGuest();
    }

    public List<User> getUserForAge(int minAge, int maxAge) {
        UserService userService = new UserService();
        return userService.getUserForAge(minAge, maxAge);
    }

    public List<Office> getOfficeMaxCountPeopleAndPrice(BigDecimal one, int two) {
        OfficeService officeService = new OfficeService();
        return officeService.getOfficeMaxCountPeopleAndPrice(one, two);
    }

    public List<Guest> getVisitsByNameAndAge(String name, Integer age) {
        UserService userService = new UserService();
        return userService.getVisitsByNameAndAge(name, age);
    }
}
