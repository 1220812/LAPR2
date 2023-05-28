package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.OfferRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class PublishOfferController {

    private OfferRepository offerRepository;

    public OfferRepository getOfferRepository() {
        if (offerRepository == null) {
            Repositories repositories = Repositories.getInstance();
//            offerRepository = repositories.getOfferRepository();
        }
        return offerRepository;
    }

    /**
     * new methods for publishing offers for different types of property
     *
     * @return offer
     */
}
