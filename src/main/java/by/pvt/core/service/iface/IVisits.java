package by.pvt.core.service.iface;

import by.pvt.core.domain.Visits;
import by.pvt.core.dto.VisitCreateRequest;

import java.util.List;

public interface IVisits
    {
    Visits addVisit(VisitCreateRequest visits);

    List<Visits> getAll();

    Visits update(VisitCreateRequest visits);

    void del(Visits visits);
    }
