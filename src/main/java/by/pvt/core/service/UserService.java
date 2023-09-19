package by.pvt.core.service;

import by.pvt.core.domain.PremiumUser;
import by.pvt.core.domain.User;
import by.pvt.core.domain.Visits;
import by.pvt.core.repository.DBUserRepoHibernate;

import java.util.List;

public class UserService implements IUser
    {
    DBUserRepoHibernate userRepository = new DBUserRepoHibernate();

    @Override
    public void addUSer(User user)
        {
        userRepository.addUSer(user);
        }

    @Override
    public List<User> getAllUsers()
        {
        return userRepository.getAllUsers();
        }

    @Override
    public List<PremiumUser> getUserPremium()
        {
        return userRepository.getUsersPremium();
        }

    @Override
    public void delUser(long id)
        {
        userRepository.delUser(id);
        }

    @Override
    public void addVisit(Visits visit)
        {
        userRepository.addVisit(visit);
        }
    }
