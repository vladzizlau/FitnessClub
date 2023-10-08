package by.pvt.core.repository.interfaces;

import by.pvt.core.domain.Guest;
import by.pvt.core.domain.PremiumUser;
import by.pvt.core.domain.User;
import by.pvt.core.domain.Visits;

import java.util.List;

public interface InterfaceDbUserRepo {
    void addUSer(User user);

    List<User> getAllUsers();

    User findById(Long userID);

    void delUser(long id);

List <PremiumUser> getUsersPremium();

//Поиск по имени
User getByName(String name);

void addVisit(Visits visit);

    List<User> getUserForAge(int minAge, int maxAge);

    List<Guest> getVisitsByNameAndAge(String name, Integer age);
}
