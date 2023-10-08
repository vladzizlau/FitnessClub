package by.pvt.core.service;

import by.pvt.core.domain.Guest;
import by.pvt.core.domain.PremiumUser;
import by.pvt.core.domain.User;
import by.pvt.core.domain.Visits;
import by.pvt.core.repository.DBUserRepoHibernate;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserService implements IUser {
    DBUserRepoHibernate userRepository = new DBUserRepoHibernate();

    @Override
    public void addUSer(User user) {
        userRepository.addUSer(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public List<PremiumUser> getUserPremium() {
        return userRepository.getUsersPremium();
    }

    @Override
    public void delUser(long id) {
        userRepository.delUser(id);
    }

    public User getByName(String name) {
        return userRepository.getByName(name);
    }

    @Override
    public void addVisit(Visits visit) {
        userRepository.addVisit(visit);
    }

    @Override
    public List<User> getUserForAge(int minAge, int maxAge) {
        return userRepository.getUserForAge(minAge, maxAge);
    }

    public List<Guest> getVisitsByNameAndAge(String name, Integer age) {
        return userRepository.getVisitsByNameAndAge(name, age);
    }

}
