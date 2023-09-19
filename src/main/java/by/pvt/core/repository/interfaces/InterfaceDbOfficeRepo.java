package by.pvt.core.repository.interfaces;

import by.pvt.core.domain.Office;
import java.util.List;

public interface InterfaceDbOfficeRepo {

    void addOffice(Office office);

    void editInvenory(long id, long inventaryNumber);

    List<Office> getListOffice();

    Office findById(Long officeID);

    void delOffice(long id);
}
