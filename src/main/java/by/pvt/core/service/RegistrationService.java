package by.pvt.core.service;


import by.pvt.core.domain.Registration;
import by.pvt.core.repository.DBRegistrationSpringData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Service
@EnableTransactionManagement
public class RegistrationService {
@Autowired (required = false)
    private DBRegistrationSpringData springData;
    public void add(Registration registration)
    {
        springData.save(registration);
    }

    public List<Registration> getAll(){
        return springData.findAll();
    }

    public void delete(Registration registration)
    {
        springData.delete(registration);
    }
}
