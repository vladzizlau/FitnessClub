package by.pvt.core.Service;

import by.pvt.core.Repository.DBUserRepository;
import by.pvt.core.domain.Status;
import by.pvt.core.domain.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class UserService implements IUser
    {

    DBUserRepository userRepository;

    public UserService()
        {
        userRepository = new DBUserRepository();
        }

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
    public User searchUserById(long userId)
        {
        return userRepository.seacrhUserById(userId);
        }

    @Override
    public void delUser(long id)
        {
        userRepository.delUser(id);
        }
@Override
    public void editUser(User user, Integer age, BigDecimal amount_sum, String firstName, LocalDate last_date_visit, String phone, Status status, String surname)
        {
        user.setId(user.getId());
            user.setAge(age);
            user.setAmountSum(amount_sum);
            user.setFirstName(firstName);
            user.setLastVisitDate(last_date_visit);
            user.setPhoneNumber(phone);
            user.setStatus(status);
            user.setSurName(surname);
            userRepository.editUser(user);
        }


    }


