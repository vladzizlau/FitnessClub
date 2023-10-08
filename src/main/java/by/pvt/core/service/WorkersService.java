package by.pvt.core.service;

import by.pvt.core.domain.Workers;
import by.pvt.core.repository.DBWorkersRepoHibernate;

import java.util.List;

public class WorkersService implements IWorkers {
    DBWorkersRepoHibernate workersRepo;

    public WorkersService() {
        workersRepo = new DBWorkersRepoHibernate();
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
