package by.pvt.core;

import by.pvt.core.domain.*;
import by.pvt.core.repository.DBGuestRepoHibernate;
import by.pvt.core.repository.DBOfficeRepoHibernate;
import by.pvt.core.repository.DBPostRepoHibernate;
import by.pvt.core.repository.DBWorkersRepoHibernate;
import by.pvt.core.service.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Main {
    static UserService userService = new UserService();
    static OfferService offerService = new OfferService();
    static OfficeService officeService = new OfficeService();
    static GuestService guestService = new GuestService();


    public static void main(String[] args) {
//            addUser();
//                 addOffice();
//addWorkers();
//        addGuest();
//             deluser();
//            getUsers();
//            getUserPremium();
//        addVisit();
////           test();
//addPosts();

//Lesson_17_testMethod lesson17TestMethod = new Lesson_17_testMethod();
//lesson17TestMethod.single_table();
//lesson17TestMethod.table_per_class();
//lesson17TestMethod.joined();
//        Lesson_18 lesson18 = new Lesson_18();
//        lesson18.addDb();

//        Lesson_19 lesson19 = new Lesson_19();
//    lesson19.addWorkers();
//    lesson19.getByName();
//    lesson19.getMostPaid();
//lesson19.getMostUnpaid();
//        lesson19.getYield();

//            Lesson_21 lesson21 = new Lesson_21();
//            lesson21.getMoneyWorks();

//
        DBWorkersRepoHibernate workerRepository = new DBWorkersRepoHibernate();
//        System.out.println(workerRepository.getUserForAge(15, 33));
//        System.out.println(workerRepository.getOfficeMaxCountPeopleAndPrice(new BigDecimal(3), 1));
//        System.out.println(workerRepository.getVisitsByNameAndAge("Филипп", 18));
    }

    public static void test() {
//       dbOfficeRepoHibernate.editInvenory(1L, 1234567L);
//       dbOfficeRepoHibernate.editCountPeople(2L, 6);
//       dbOfficeRepoHibernate.editCostPerHour(2L, new BigDecimal(100500));

//       for (BigDecimal bd: dbOfficeRepoHibernate.getCostForOnePeople("Тренажерный зал")) {
//           System.out.println(bd);
//       }
//        OfficeService officeService = new OfficeService();
//        System.out.println(officeService.getSmallOffice());


    }


    public static void addUser() {
        User user1 = new User();
        user1.setAge(23);
        user1.setAmountSum(BigDecimal.valueOf(500));
        user1.setFirstName("Антон");
        user1.setSurName("Коржиков");
//        user1.setLastVisitDate(LocalDate.of(2019, Month.JUNE, 3));
//        user1.setPhoneNumber("+375175682345");
//        user1.setStatus(String.valueOf(StatusUser.Block));
//        user1.setAdress(new Adress("Gomel", "B.hmelnickogo", "15", "256954"));

        User user2 = new User();
        user2.setAge(17);
        user2.setAmountSum(BigDecimal.valueOf(35));
        user2.setFirstName("Василий");
        user2.setSurName("Антипов");
//        user2.setLastVisitDate(LocalDate.of(2023, Month.AUGUST, 23));
//        user2.setPhoneNumber("+375175685689");
//        user2.setStatus(String.valueOf(StatusUser.Active));
//        user2.setAdress(new Adress("Gomel", "B.hmelnickogo", "15", "256954"));

        User user3 = new User();
        user3.setAge(45);
        user3.setAmountSum(BigDecimal.valueOf(1500));
        user3.setFirstName("Сергей");
        user3.setSurName("Смирнов");
//        user3.setLastVisitDate(LocalDate.of(2023, Month.SEPTEMBER, 6));
//        user3.setPhoneNumber("+375235684589");
//        user3.setStatus(String.valueOf(StatusUser.Premium));
//        user3.setAdress(new Adress("Gomel", "B.hmelnickogo", "15", "256954"));

        User user4 = new User();
        user4.setAge(17);
        user4.setAmountSum(BigDecimal.valueOf(170));
        user4.setFirstName("Геннадий");
        user4.setSurName("Скакалов");
//        user4.setLastVisitDate(LocalDate.of(2021, Month.DECEMBER, 11));
//        user4.setPhoneNumber("+375273248534");
//        user4.setStatus(String.valueOf(StatusUser.Active));
//        user4.setAdress(new Adress("Gomel", "B.hmelnickogo", "15", "256954"));

        User user5 = new User();
        user5.setAge(30);
        user5.setAmountSum(BigDecimal.valueOf(1000));
        user5.setFirstName("Сергей");
        user5.setSurName("Шестаков");
//        user5.setLastVisitDate(LocalDate.of(2023, Month.JUNE, 17));
//        user5.setPhoneNumber("+3751756767659");
//        user5.setStatus(String.valueOf(StatusUser.Active));
//        user5.setAdress(new Adress("Gomel", "B.hmelnickogo", "15", "256954"));
        userService.addUSer(user1);
        userService.addUSer(user2);
        userService.addUSer(user3);
        userService.addUSer(user4);
        userService.addUSer(user5);

    }

    private static void addOffice() {
        DBOfficeRepoHibernate dbOfficeRepoHibernate = new DBOfficeRepoHibernate();
        Office office = new Office("Тренажерный зал", 12341L, 20, StatusOffice.Active, new BigDecimal(6));
        Office office2 = new Office("Теннисный корт", 12342L, 10, StatusOffice.Active, new BigDecimal(10));
        Office office3 = new Office("Футбольный стадион", 12343L, 2000, StatusOffice.Active, new BigDecimal(3));
        dbOfficeRepoHibernate.addOffice(office);
        dbOfficeRepoHibernate.addOffice(office2);
        dbOfficeRepoHibernate.addOffice(office3);
    }

    private static void addGuest(){
        DBGuestRepoHibernate dbRepository = new DBGuestRepoHibernate();
        Guest guest = new Guest();
        guest.setFirstName("Алексей");
        guest.setAge(18);
        guest.setFirstVisitDate(LocalDate.of(2023, Month.AUGUST, 23));

        Guest guest2 = new Guest();
        guest2.setFirstName("Филипп");
        guest2.setAge(40);
        guest2.setFirstVisitDate(LocalDate.of(2023, Month.JUNE, 16));

        Guest guest3 = new Guest();
        guest3.setFirstName("Сергей");
        guest3.setAge(34);
        guest3.setFirstVisitDate(LocalDate.of(2023, Month.JANUARY, 4));
        dbRepository.addGuest(guest);
        dbRepository.addGuest(guest2);
        dbRepository.addGuest(guest3);
    }

    private static void deluser() {
        userService.delUser(1);
        userService.delUser(2);
        userService.delUser(3);
        userService.delUser(4);
        userService.delUser(5);
    }

    private static void getUsers() {
        System.out.println(userService.getAllUsers());
    }

    private static void addOffer() {
        Offer offer = new Offer("Теннис", 60);
        Offer offer1 = new Offer("Футбол", 100);
        Offer offer2 = new Offer("Плавание", 10);
        offerService.addOffer(offer);
        offerService.addOffer(offer1);
        offerService.addOffer(offer2);
    }

    private static void getUserPremium() {
        System.out.println(userService.getUserPremium());
    }

    private static void addVisit() {
        Visits visit = new Visits();
        Visits visit1 = new Visits();
        Visits visit2 = new Visits();

        visit.setLastVisit(LocalDate.parse("2023-01-18", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        visit.setAmountSum(56);
        visit.setUserId(1);
        visit.setId_Offer(232134123);

        visit1.setLastVisit(LocalDate.parse("2023-09-18", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        visit1.setAmountSum(500);
        visit1.setUserId(2);
        visit1.setId_Offer(2351);

        visit2.setLastVisit(LocalDate.parse("2023-09-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        visit2.setAmountSum(4000);
        visit2.setUserId(3);
        visit2.setId_Offer(2356151);

        userService.addVisit(visit);
        userService.addVisit(visit1);
        userService.addVisit(visit2);
    }


    public static void addPosts() {
        DBPostRepoHibernate postRepo = new DBPostRepoHibernate();
        Posts post1 = new Posts(1L, 32452L, LocalDate.of(2023, Month.AUGUST, 23), Time.valueOf("10:05:30"));
        Posts post2 = new Posts(1L, 32452L, LocalDate.of(2023, Month.AUGUST, 23), Time.valueOf("11:05:30"));
        Posts post3 = new Posts(2L, 32452L, LocalDate.of(2023, Month.AUGUST, 23), Time.valueOf("12:05:30"));
        Posts post4 = new Posts(2L, 32452L, LocalDate.of(2023, Month.AUGUST, 23), Time.valueOf("13:05:30"));
        Posts post5 = new Posts(3L, 32452L, LocalDate.of(2023, Month.AUGUST, 23), Time.valueOf("14:05:30"));

        postRepo.addPost(post1);
        postRepo.addPost(post2);
        postRepo.addPost(post3);
        postRepo.addPost(post4);
        postRepo.addPost(post5);
    }

    public static void addWorkers() {
        WorkersService workersService = new WorkersService();

        Workers worker = new Workers();
        worker.setStartJob(LocalDate.parse("2023-02-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        worker.setEndJob(LocalDate.parse("2023-09-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        worker.setJob_post("Администратор");
        worker.setMoneyMonth(1200);
        workersService.addWorker(worker);

        Workers worker2 = new Workers();
        worker2.setStartJob(LocalDate.parse("2023-02-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        worker2.setEndJob(LocalDate.parse("2023-09-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        worker2.setJob_post("Бармен");
        worker2.setMoneyMonth(800);
        workersService.addWorker(worker2);

        Workers worker3 = new Workers();
        worker3.setStartJob(LocalDate.parse("2023-02-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        worker3.setEndJob(LocalDate.parse("2023-09-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        worker3.setJob_post("Кассир");
        worker3.setMoneyMonth(1000);
        workersService.addWorker(worker3);


        Workers worker4 = new Workers();
        worker4.setStartJob(LocalDate.parse("2023-02-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        worker4.setEndJob(LocalDate.parse("2023-09-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        worker4.setJob_post("Уборщик");
        worker4.setMoneyMonth(750);
        workersService.addWorker(worker4);

    }

}
