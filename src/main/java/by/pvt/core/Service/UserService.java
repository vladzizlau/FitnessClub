package by.pvt.core.Service;

import by.pvt.core.repository.DBUserRepoJPA;
import by.pvt.core.domain.User;

import java.util.List;

public class UserService implements IUser
    {
        DBUserRepoJPA userRepository = new DBUserRepoJPA();

        @Override
        public void addUSer(User user) {
        userRepository.addUSer(user);
        }

        @Override
        public List<User> getAllUsers() {
            return userRepository.getAllUsers();
        }

        @Override
        public void delUser(long id) {
            userRepository.delUser(id);
        }
    }
