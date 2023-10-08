package by.pvt.core.service;

import by.pvt.core.domain.Offer;
import by.pvt.core.repository.DBOfferRepoHibernate;

public class OfferService {
    private final DBOfferRepoHibernate offerRepository;

    public OfferService(){
        offerRepository = new DBOfferRepoHibernate();
    }

public void addOffer(Offer offer)
    {
    offerRepository.addOffer(offer);

    }


    public Long getActivity() {
       return offerRepository.getActivity();
    }

}
