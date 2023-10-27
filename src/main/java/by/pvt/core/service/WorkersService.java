package by.pvt.core.service;

import by.pvt.core.domain.Workers;
import by.pvt.core.repository.DBWorkersRepoHibernate;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkersService implements IWorkers {

    private final DBWorkersRepoHibernate workersRepo;

    public WorkersService(DBWorkersRepoHibernate dbWorkersRepoHibernate) {
       this.workersRepo = dbWorkersRepoHibernate;
    }

    @Override
    public void addWorker(Workers work) {
        workersRepo.addGuest(work);
    }

    @Override
    public Workers getMostPaid() {
        return workersRepo.getMostPaid();
    }

    @Override
    public Workers getMostUnpaid() {
        return workersRepo.getMostUnpaid();
    }

    @Override
    public List<Workers> getAllWorkersCriteria() {
        return workersRepo.getAllWorkersCriteria();
    }
}
