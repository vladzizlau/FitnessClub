package by.pvt.core.service;

import by.pvt.core.domain.Office;
import by.pvt.core.domain.OfficeSubSelect;
import by.pvt.core.repository.DBOfficeRepoHibernate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;
@Service
public class OfficeService implements IOffice
    {
    private final DBOfficeRepoHibernate officeRepository;

    public OfficeService(DBOfficeRepoHibernate dbOfficeRepoHibernate)
        {
        officeRepository = dbOfficeRepoHibernate;
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
