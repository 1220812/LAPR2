package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.BookingRequestsFeedbackRepository;
import pt.ipp.isep.dei.esoft.project.repository.BookingRequestsRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class BookingRequestFeedbackController {

    private BookingRequestsRepository bookingRequestsRepository = null;
    private BookingRequestsFeedbackRepository bookingRequestsFeedbackRepository = null;
    private AuthenticationRepository authenticationRepository = null;

    public BookingRequestFeedbackController() {
    }

    public BookingRequestsFeedbackRepository getBookingRequestsFeedbackRepository() {
        if (bookingRequestsFeedbackRepository == null) {
            Repositories repositories = Repositories.getInstance();
            bookingRequestsFeedbackRepository = repositories.getBookingRequestsFeedbackRepository();
        }
        return bookingRequestsFeedbackRepository;
    }

    public BookingRequestsRepository getBookingRequestsRepository() {
        if (bookingRequestsRepository == null) {
            Repositories repositories = Repositories.getInstance();
            bookingRequestsRepository = repositories.getBookingRequestsRepository();
        }
        return bookingRequestsRepository;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();

            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    public String getUserEmail() {
        AuthenticationRepository authenticationRepository = getAuthenticationRepository();
        return authenticationRepository.getCurrentUserSession().getUserName();
    }

    public String getUserName(){
        AuthenticationRepository authenticationRepository = getAuthenticationRepository();
        return authenticationRepository.getCurrentUserSession().getUserName();
    }

}

