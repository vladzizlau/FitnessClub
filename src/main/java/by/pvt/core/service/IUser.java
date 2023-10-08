package by.pvt.core.service;

import by.pvt.core.domain.PremiumUser;
import by.pvt.core.domain.User;
import by.pvt.core.domain.Visits;

import java.util.List;

public interface IUser
    {
        public void addUSer(User user);
        public List<User> getAllUsers();

    List<PremiumUser> getUserPremium();

    public void delUser(long id);

    void addVisit(Visits visit);

        List<User> getUserForAge(int minAge, int maxAge);
    }
