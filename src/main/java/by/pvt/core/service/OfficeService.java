package by.pvt.core.service;

import by.pvt.core.domain.Office;
import by.pvt.core.domain.OfficeSubSelect;
import by.pvt.core.repository.DBOfficeRepoHibernate;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;

public class OfficeService implements IOffice
    {
    private final DBOfficeRepoHibernate officeRepository;

    public OfficeService()
        {
        officeRepository = new DBOfficeRepoHibernate();
        }

    @Override
    public List<OfficeSubSelect> getSmallOffice()
        {
        return officeRepository.getOfficeSubSelect();
        }

    public Double getYield(int countmonth)
        {
        return officeRepository.getYield(countmonth);
        }

        public Integer getCountGuest() {
        return officeRepository.getCountGuest();
        }

        public List<Office> getOfficeMaxCountPeopleAndPrice(BigDecimal one, int two) {
            return officeRepository.getOfficeMaxCountPeopleAndPrice(one, two);
        }
    }
