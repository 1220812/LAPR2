package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.Message;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.BookingRequestsFeedbackRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.ArrayList;
import java.util.List;

public class BookingRequestFeedbackController {

    private BookingRequestsFeedbackRepository bookingRequestsFeedbackRepository = null;
    private AuthenticationRepository authenticationRepository = null;

    Repositories repositories = Repositories.getInstance();

    public BookingRequestFeedbackController() {
    }

    public BookingRequestsFeedbackRepository getBookingRequestsFeedbackRepository() {
        if (bookingRequestsFeedbackRepository == null) {
            Repositories repositories = Repositories.getInstance();
            bookingRequestsFeedbackRepository = repositories.getBookingRequestsFeedbackRepository();
        }
        return bookingRequestsFeedbackRepository;
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

    public List<Message> getRequestCompletedList(Client client) {

        return repositories.getMessageRepository().getRequestCompletedList(client);
    }

    public Client getCurrentClient() {
        return this.repositories.getClientRepository().getClientByUserSession(getCurrentSession());
    }

    public UserSession getCurrentSession(){
        return this.repositories.getAuthenticationRepository().getCurrentUserSession();
    }

    public List<String> getRepliesByClient(List<Message> listMessages) {
        List<String> listReplies = new ArrayList<>();
        for (Message message : repositories.getMessageRepository().getMessageCompleteList()){
            for (Message message1 : listMessages){
                if (message.equals(message1)){
                    int i = repositories.getMessageRepository().getMessageCompleteList().indexOf(message);
                    listReplies.add(repositories.getReplyRepository().getReplyList().get(i));
                }
            }
        }
        return listReplies;
    }
}

