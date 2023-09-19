package by.pvt.core.service;

import by.pvt.core.domain.Workers;
import by.pvt.core.repository.DBWorkersRepoHibernate;

public class WorkersService implements IWorkers
    {
    DBWorkersRepoHibernate workersRepo;

    public WorkersService()
        {
        workersRepo = new DBWorkersRepoHibernate();
        }

    @Override
    public void addWorker(Workers work)
        {
        workersRepo.addGuest(work);
        }
    }
