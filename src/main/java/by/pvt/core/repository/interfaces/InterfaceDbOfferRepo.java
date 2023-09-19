package by.pvt.core.repository.interfaces;

import by.pvt.core.domain.Offer;
import java.util.List;

public interface InterfaceDbOfferRepo {
    void addOffer(Offer offer);

    List<Offer> getListOffer();

    Offer findById(Long offerID);

    void delOffer(long id);
}
