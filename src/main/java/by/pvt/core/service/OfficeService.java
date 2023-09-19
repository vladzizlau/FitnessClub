package by.pvt.core.service;

import by.pvt.core.domain.OfficeSubSelect;
import by.pvt.core.repository.DBOfficeRepoHibernate;

import java.util.List;

public class OfficeService implements IOffice{
    private final DBOfficeRepoHibernate officeRepository;

    public OfficeService(){
        officeRepository = new DBOfficeRepoHibernate();
    }

@Override
    public List<OfficeSubSelect> getSmallOffice(){
        return officeRepository.getOfficeSubSelect();
    }
}
