package by.pvt.core.Service;

import by.pvt.core.domain.User;

import java.util.List;

public interface IUser
    {
        public void addUSer(User user);
        public List<User> getAllUsers();
        public void delUser(long id);
    }
