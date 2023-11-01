package by.pvt.core.service;

import by.pvt.core.domain.Guest;
import by.pvt.core.domain.PremiumUser;
import by.pvt.core.domain.User;
import by.pvt.core.domain.Visits;
import by.pvt.core.repository.DBUserRepoHibernate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

@Service
public class UserService implements IUser {
    private DBUserRepoHibernate userRepository;

    public UserService(DBUserRepoHibernate userRepository) {
        this.userRepository = userRepository;
    }

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
