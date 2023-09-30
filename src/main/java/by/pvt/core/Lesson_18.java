package by.pvt.core;
import by.pvt.core.config.HibernateJavaConfig;
import by.pvt.core.domain.Office;
import by.pvt.core.domain.Posts;
import by.pvt.core.domain.StatusOffice;
import by.pvt.core.repository.DBOfficeRepoHibernate;
import by.pvt.core.repository.DBPostRepoHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.time.Month;

public class Lesson_18 {
    DBOfficeRepoHibernate officeRepo  = new DBOfficeRepoHibernate();
    private SessionFactory sessionFactory;

    public Lesson_18() {
        sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

// Работа с сущностями Posts и Office
    public void addDb() {
        DBOfficeRepoHibernate dbOfficeRepoHibernate = new DBOfficeRepoHibernate();
        Office office = new Office("Тренажерный зал", 12341L, 20, StatusOffice.Active, new BigDecimal(6));
        Office office2 = new Office("Теннисный корт", 12342L, 10, StatusOffice.Active, new BigDecimal(10));
        Office office3 = new Office("Футбольный стадион", 12343L, 2000, StatusOffice.Active, new BigDecimal(3));
        dbOfficeRepoHibernate.addOffice(office);
        dbOfficeRepoHibernate.addOffice(office2);
        dbOfficeRepoHibernate.addOffice(office3);


        DBPostRepoHibernate postRepo = new DBPostRepoHibernate();
        Posts post1 = new Posts(1L, 32452L, LocalDate.of(2023, Month.AUGUST, 23), Time.valueOf("10:05:30"));
        Posts post2 = new Posts(1L, 32452L, LocalDate.of(2023, Month.AUGUST, 23), Time.valueOf("11:05:30"));
        Posts post3 = new Posts(2L, 32452L, LocalDate.of(2023, Month.AUGUST, 23), Time.valueOf("12:05:30"));
        Posts post4 = new Posts(2L, 32452L, LocalDate.of(2023, Month.AUGUST, 23), Time.valueOf("13:05:30"));
        Posts post5 = new Posts(3L, 32452L, LocalDate.of(2023, Month.AUGUST, 23), Time.valueOf("14:05:30"));
        post1.setOffice(office);
        post2.setOffice(office2);
        post3.setOffice(office);
        post4.setOffice(office3);
        post5.setOffice(office3);
        postRepo.addPost(post1);
        postRepo.addPost(post2);
        postRepo.addPost(post3);
        postRepo.addPost(post4);
        postRepo.addPost(post5);

        deleteOffice(office2.getId());
    }
    //При удалении офиса удаляется пост
    private void deleteOffice(long officeId){
        Session session = sessionFactory.openSession();
        Office office = session.get(Office.class, officeId);
        session.getTransaction().begin();
        session.detach(office);
        session.remove(office);
        session.getTransaction().commit();
        session.close();
    }

}
