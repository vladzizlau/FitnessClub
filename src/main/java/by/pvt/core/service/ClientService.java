package by.pvt.core.service;

import by.pvt.core.domain.Client;
import by.pvt.core.domain.PremiumUser;
import by.pvt.core.domain.Visits;
import by.pvt.core.dto.ClientResponse;
import by.pvt.core.repository.DBClientRepoHibernate;

import by.pvt.core.repository.DbClientRepository;
import by.pvt.core.service.iface.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService implements IClient {
    private DBClientRepoHibernate clientRepository;
    @Autowired
    private DbClientRepository repository;



    @Autowired
    public ClientService(DBClientRepoHibernate userRepository) {
        this.clientRepository = userRepository;

    }

    @Override
    public void addUSer(Client client) {
        clientRepository.addUSer(client);
    }

    @Override
    public List<Client> getAllUsers() {
        return clientRepository.getAllUsers();
    }

    @Override
    public List<PremiumUser> getUserPremium() {
        return clientRepository.getUsersPremium();
    }

    @Override
    public void delUser(long id) {
        clientRepository.delUser(id);
    }

    public Client getByName(String name) {
        return clientRepository.getByName(name);
    }

    @Transactional
    public Client getById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public void addVisit(Visits visit) {
        clientRepository.addVisit(visit);
    }

    @Override
    public List<Client> getUserForAge(int minAge, int maxAge) {
        return clientRepository.getUserForAge(minAge, maxAge);
    }

    public List<Client> getVisitsByNameAndAge(String name, Integer age) {
        return clientRepository.getVisitsByNameAndAge(name, age);
    }

    public void setStatus(Client client, String s) {
       client.setStatus(s);
        repository.save(client);

    }


//    public List<ClientResponse> getAllResponse(){
//         List <ClientResponse> cr = getAllUsers();
//    }

}
