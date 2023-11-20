package by.pvt.core.service.iface;

import by.pvt.core.domain.Workers;

import java.util.List;

public interface IWorkers
    {
    void addWorker(Workers work);

    Workers getMostPaid();

    Workers getMostUnpaid();

        List<Workers> getAllWorkersCriteria();
    }
