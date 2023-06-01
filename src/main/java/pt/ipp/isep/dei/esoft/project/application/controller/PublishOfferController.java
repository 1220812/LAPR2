package pt.ipp.isep.dei.esoft.project.application.controller;

import java.util.List;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Offer;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.OfferRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class PublishOfferController {

    OfferRepository offerRepository = Repositories.getInstance().getOfferRepository();
    AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();

    public void registerOffer(Offer offer) {
        OfferRepository repository = Repositories.getInstance().getOfferRepository();
        //get the email
        repository.add(offer);
    }

    public List<Announcement> getAnnouncements() {

        return announcementRepository.getAnnouncements();
    }

    public boolean validateOffer(Offer offer) {
        return Repositories.getInstance().getOfferRepository().validateOffer(offer);
    }

    /**
     * need a method for checking if there is any pending offer on the same announcement
     */



    /**
     * new methods for publishing offers for different types of property
     *
     * @return offer
     */
}
