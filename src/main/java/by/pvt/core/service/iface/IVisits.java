package by.pvt.core.service.iface;

import by.pvt.core.domain.Visits;

import java.util.List;

public interface IVisits {
    void addVisit(Visits visits);

    List<Visits> getAll();

    void update(Visits visits);

    void del(Visits visits);
}
