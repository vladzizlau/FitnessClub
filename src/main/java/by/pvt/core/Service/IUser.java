package by.pvt.core.Service;

import by.pvt.core.domain.Status;
import by.pvt.core.domain.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IUser
    {
        public void addUSer(User user);
        public List<User> getAllUsers();

    User searchUserById(long userId);

    public void delUser(long id);

    void editUser(User user, Integer age, BigDecimal amount_sum, String firstName, LocalDate last_date_visit, String phone, Status status, String surname);
    }
