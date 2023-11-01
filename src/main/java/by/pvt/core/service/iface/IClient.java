package by.pvt.core.service.iface;

import by.pvt.core.domain.Client;
import by.pvt.core.domain.PremiumUser;
import by.pvt.core.domain.Visits;

import java.util.List;

public interface IClient
    {
        public void addUSer(Client client);
        public List<Client> getAllUsers();

    List<PremiumUser> getUserPremium();

    public void delUser(long id);

    void addVisit(Visits visit);

        List<Client> getUserForAge(int minAge, int maxAge);
    }
