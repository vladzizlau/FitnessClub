package by.pvt.core.service;

import by.pvt.core.config.HibernateConfig;
import by.pvt.core.domain.Client;
import by.pvt.core.domain.Visits;
import by.pvt.core.repository.VisitsRepository;
import by.pvt.core.service.iface.IVisits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
@Service
public class VisitService implements IVisits {

    private final VisitsRepository repository;

    @Autowired
    public VisitService(VisitsRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public void addVisit(Visits visits) {
        repository.save(visits);
    }


    @Override
    public List<Visits> getAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public void update(Visits visit) {
        Visits v = new Visits();
        v.setLastVisit(visit.getLastVisit());
        v.setAmountSum(visit.getAmountSum());
        v.setId_Offer(visit.getId_Offer());
        repository.save(v);
    }

    @Transactional
    @Override
    public void del(Visits visits) {
        repository.delete(visits);
    }

    @Transactional
    public void transactional(long clientid){
        ApplicationContext ac = new AnnotationConfigApplicationContext(HibernateConfig.class);
        ClientService clientService = ac.getBean(ClientService.class);
        Client client1 = clientService.getById(clientid);


        int countVisit = 0;
        List<Visits> getList = getAll();
        for (Visits visits : getList) {
            if (visits.getClient().getId() == clientid)
            {
                countVisit++;
            }
        }
        addVisit(new Visits(1, LocalDate.of(2023,02,23), 100, 1, client1));
        System.out.println(countVisit);
        if (countVisit > 10){
            clientService.setStatus(client1,"Good");
        }
        else{
            throw new RuntimeException();
        }
    }

}
