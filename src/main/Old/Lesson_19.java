//package by.pvt.core;
//
//import by.pvt.core.config.HibernateJavaConfig;
//import by.pvt.core.domain.Workers;
//import by.pvt.core.service.OfficeService;
//import by.pvt.core.service.UserService;
//import by.pvt.core.service.WorkersService;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//public class Lesson_19
//    {
//    private SessionFactory sessionFactory;
//    private final UserService userService;
//    private final WorkersService workersService;
//    private final OfficeService officeService;
//
//    public Lesson_19()
//        {
//        sessionFactory = HibernateJavaConfig.getSessionFactory();
//        userService = new UserService();
//        workersService = new WorkersService();
//        officeService = new OfficeService();
//        }
//
//
//
//    //Поиск по имени
//    public void getByName()
//        {
//        System.out.println(userService.getByName("Антон"));
//        }
//
//    //Самый высокооплачиваемый работник
//    public void getMostPaid()
//        {
//        System.out.println(workersService.getMostPaid());
//        }
//
//    //Самый низкооплачиваемый работник
//    public void getMostUnpaid()
//        {
//        System.out.println(workersService.getMostUnpaid());
//        }
//
//    //Выручка со всех помещений за месяц
//    public void getYield()
//        {
//        System.out.println(officeService.getYield(3));
//        }
//
//
//    }
