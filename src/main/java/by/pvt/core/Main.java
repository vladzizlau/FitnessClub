package by.pvt.core;

import by.pvt.core.Repository.DBUserRepository;
import by.pvt.core.Service.UserService;
import by.pvt.core.domain.Status;
import by.pvt.core.domain.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.JUNE;

public class Main
    {
         static UserService userService = new UserService();



        public static void main(String[] args) {
//            addUSer();
//             deluser();
//            getUsers();
//        searchUser();
editUSer();
    }

    public static void addUSer(){
        User user1 = new User();
        user1.setId(1);
        user1.setAge(23);
        user1.setAmountSum(BigDecimal.valueOf(500));
        user1.setFirstName("Антон");
        user1.setSurName("Коржиков");
        user1.setLastVisitDate(LocalDate.of(2019, Month.JUNE, 3));
        user1.setPhoneNumber("+375175682345");
        user1.setStatus(Status.Block);

        User user2 = new User();
        user2.setId(2);
        user2.setAge(17);
        user2.setAmountSum(BigDecimal.valueOf(35));
        user2.setFirstName("Василий");
        user2.setSurName("Антипов");
        user2.setLastVisitDate(LocalDate.of(2023, Month.AUGUST, 23));
        user2.setPhoneNumber("+375175685689");
        user2.setStatus(Status.Active);

        User user3 = new User();
        user3.setId(3);
        user3.setAge(45);
        user3.setAmountSum(BigDecimal.valueOf(1500));
        user3.setFirstName("Сергей");
        user3.setSurName("Смирнов");
        user3.setLastVisitDate(LocalDate.of(2023, Month.SEPTEMBER, 6));
        user3.setPhoneNumber("+375235684589");
        user3.setStatus(Status.Premium);

        User user4 = new User();
        user4.setId(4);
        user4.setAge(17);
        user4.setAmountSum(BigDecimal.valueOf(170));
        user4.setFirstName("Геннадий");
        user4.setSurName("Скакалов");
        user4.setLastVisitDate(LocalDate.of(2021, Month.DECEMBER, 11));
        user4.setPhoneNumber("+375273248534");
        user4.setStatus(Status.Active);

        User user5 = new User();
        user5.setId(5);
        user5.setAge(30);
        user5.setAmountSum(BigDecimal.valueOf(1000));
        user5.setFirstName("Сергей");
        user5.setSurName("Шестаков");
        user5.setLastVisitDate(LocalDate.of(2023, Month.JUNE, 17));
        user5.setPhoneNumber("+3751756767659");
        user5.setStatus(Status.Active);
        userService.addUSer(user1);
        userService.addUSer(user2);
        userService.addUSer(user3);
        userService.addUSer(user4);
        userService.addUSer(user5);
    }
    private static void deluser(){
        userService.delUser(1);
        userService.delUser(2);
        userService.delUser(3);
        userService.delUser(4);
        userService.delUser(5);
    }

    private static void getUsers(){
        System.out.println(userService.getAllUsers());
    }
    private static void searchUser(){

    System.out.println(userService.searchUserById(2));
    }
private static void editUSer(){
        User user = userService.searchUserById(2);
        userService.editUser(user, 18, BigDecimal.valueOf(22), "aleh", LocalDate.of(1901, 03,07), "546646757464", Status.Active, "Pupkins");
}

}
