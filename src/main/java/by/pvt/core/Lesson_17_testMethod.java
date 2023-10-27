//package by.pvt.core;
//
//import by.pvt.core.Main;
//import by.pvt.core.domain.Adress;
//import by.pvt.core.domain.Guest;
//import by.pvt.core.domain.User;
//import by.pvt.core.domain.Workers;
//import by.pvt.core.service.GuestService;
//import by.pvt.core.service.UserService;
//import by.pvt.core.service.WorkersService;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.time.Month;
//import java.time.format.DateTimeFormatter;
//
//public class Lesson_17_testMethod
//    {
//    UserService userService = new UserService();
//    GuestService guestService = new GuestService();
//    WorkersService workersService = new WorkersService();
//    public void single_table(){
//    User user1 = new User();
//        user1.setAge(23);
//        user1.setFirstName("Антон");
//        user1.setSurName("Коржиков");
////        user1.setAdress(new Adress("Gomel", "B.hmelnickogo", "15", "256954"));
//    userService.addUSer(user1);
//
//    Guest guest1 = new Guest();
//    guest1.setAmountSum(new BigDecimal(500));
//    guest1.setPhoneNumber("5565665454");
//    guest1.setFirstVisitDate(LocalDate.parse("2023-01-18", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//    guest1.setLastVisitDate(LocalDate.of(2023, Month.MAY, 6));
//    guest1.setStatus("Просрочен");
//    guestService.addGuest(guest1);
//
//    Workers worker = new Workers();
//    worker.setStartJob(LocalDate.parse("2023-02-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//    worker.setEndJob(LocalDate.parse("2023-09-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//    worker.setJob_post("Администратор");
//    worker.setMoneyMonth(1200);
//    workersService.addWorker(worker);
//
//    }
//
//    public void table_per_class() {
//    Guest guest1 = new Guest();
//    guest1.setAmountSum(new BigDecimal(500));
//    guest1.setPhoneNumber("5565665454");
//    String date = "2023-01-18";
//    LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//    guest1.setFirstVisitDate(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//    guest1.setLastVisitDate(LocalDate.of(2023, Month.MAY, 6));
//    guest1.setStatus("Просрочен");
//    guestService.addGuest(guest1);
//
//    Workers worker = new Workers();
//    String date2 = "2023-02-10";
//    String date3 = "2023-09-10";
//    worker.setStartJob(LocalDate.parse(date2, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//    worker.setEndJob(LocalDate.parse(date3, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//    worker.setJob_post("Администратор");
//    worker.setMoneyMonth(1200);
//    workersService.addWorker(worker);
//    }
//
//    public void joined(){
//    User user1 = new User();
//    user1.setAge(23);
//    user1.setFirstName("Антон");
//    user1.setSurName("Коржиков");
////    user1.setAdress(new Adress("Gomel", "B.hmelnickogo", "15", "256954"));
//    userService.addUSer(user1);
//
//    Guest guest1 = new Guest();
//    guest1.setAmountSum(new BigDecimal(500));
//    guest1.setPhoneNumber("5565665454");
//    guest1.setFirstVisitDate(LocalDate.parse("2023-01-18", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//    guest1.setLastVisitDate(LocalDate.of(2023, Month.MAY, 6));
//    guest1.setStatus("Просрочен");
//    guestService.addGuest(guest1);
//
//    Workers worker = new Workers();
//    worker.setStartJob(LocalDate.parse("2023-02-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//    worker.setEndJob(LocalDate.parse("2023-09-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//    worker.setJob_post("Администратор");
//    worker.setMoneyMonth(1200);
//    workersService.addWorker(worker);
////select * from guest.workers w join guest.user g on g.id = w.pk_workers_id
//    }
//    }
