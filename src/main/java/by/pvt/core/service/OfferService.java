package by.pvt.core.service;

import by.pvt.core.domain.Offer;
import by.pvt.core.repository.DBOfferRepoHibernate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class OfferService {
    private final DBOfferRepoHibernate offerRepository;

    public OfferService(DBOfferRepoHibernate dbofferRepository){
        offerRepository = dbofferRepository;
    }

public void addOffer(Offer offer)
    {
    offerRepository.addOffer(offer);

    }


//    public Long getActivity() {
//       return offerRepository.getActivity();
//    }

}
