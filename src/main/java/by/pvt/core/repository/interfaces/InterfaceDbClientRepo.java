package by.pvt.core.repository.interfaces;

import by.pvt.core.domain.Client;
import by.pvt.core.domain.PremiumUser;
import by.pvt.core.domain.Visits;

import java.util.List;

public interface InterfaceDbClientRepo {
    void addUSer(Client client);

    List<Client> getAllUsers();

    Client findById(Long userID);

    void delUser(long id);

List <PremiumUser> getUsersPremium();

//Поиск по имени
Client getByName(String name);

void addVisit(Visits visit);

    List<Client> getUserForAge(int minAge, int maxAge);

    List<Client> getVisitsByNameAndAge(String name, Integer age);
}
