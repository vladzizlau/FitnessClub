package by.pvt.core.service;

import by.pvt.core.domain.Client;
import by.pvt.core.domain.PremiumUser;
import by.pvt.core.domain.Visits;
import by.pvt.core.dto.ClientResponse;
import by.pvt.core.mapper.ClientMap;
import by.pvt.core.repository.DBClientRepoHibernate;
import by.pvt.core.repository.DbClientRepository;
import by.pvt.core.service.iface.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService implements IClient {

    private DBClientRepoHibernate clientRepository;

    private DbClientRepository repository;


    private ClientMap clientMap;

    @Autowired
    public ClientService(DBClientRepoHibernate clientRepository, DbClientRepository repository, ClientMap clientMap) {
        this.clientRepository = clientRepository;
        this.repository = repository;
        this.clientMap = clientMap;
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

    public List<Client> getAll() {
        return repository.findAll();
    }

    public Client getClientByUserName(String userame){
       return repository.getCleintByUser(userame);
    }


    public List<ClientResponse> getAllResponse() {
//        List<Client> all = getAllUsers();
//        List<Client> cr = getAll();
//        List<ClientResponse>clientResponses = cr.stream().map(client -> clientMap.toResponse(client)).collect(Collectors.toList());
//        return clientResponses;
        return clientMap.toResponseList(getAll());
    }

}
