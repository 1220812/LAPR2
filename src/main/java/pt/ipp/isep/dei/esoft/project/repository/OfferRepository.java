package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.lang.Object;

public class OfferRepository {

    List<Offer> offersList = new ArrayList<>();

    public List <Offer> addOffer (Offer offer){
        offersList.add(offer);
        Optional<Offer> newOffer = Optional.empty();
        boolean operationSuccess = false;
        if(validateOffer(offer)){
            newOffer = Optional.of(offer.clone());
            operationSuccess = offersList.add(newOffer.get());
        }
        if(!operationSuccess){
            newOffer = Optional.empty();
        }
        return offersList;
    }

    public boolean validateOffer(Offer offer) {
        boolean isValid = !offersList.contains(offer);
        return isValid;
    }
}
