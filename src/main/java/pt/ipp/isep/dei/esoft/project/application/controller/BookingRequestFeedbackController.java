package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.Message;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.BookingRequestsFeedbackRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Booking request feedback controller.
 */
public class BookingRequestFeedbackController {

    private BookingRequestsFeedbackRepository bookingRequestsFeedbackRepository = null;
    private AuthenticationRepository authenticationRepository = null;

    /**
     * The Repositories.
     */
    Repositories repositories = Repositories.getInstance();

    /**
     * Instantiates a new Booking request feedback controller.
     */
    public BookingRequestFeedbackController() {
    }

    /**
     * Gets booking requests feedback repository.
     *
     * @return the booking requests feedback repository
     */
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

    /**
     * Gets user email.
     *
     * @return the user email
     */
    public String getUserEmail() {
        AuthenticationRepository authenticationRepository = getAuthenticationRepository();
        return authenticationRepository.getCurrentUserSession().getUserName();
    }

    /**
     * Get user name string.
     *
     * @return the string
     */
    public String getUserName(){
        AuthenticationRepository authenticationRepository = getAuthenticationRepository();
        return authenticationRepository.getCurrentUserSession().getUserName();
    }

    /**
     * Gets request completed list.
     *
     * @param client the client
     * @return the request completed list
     */
    public List<Message> getRequestCompletedList(Client client) {

        return repositories.getMessageRepository().getRequestCompletedList(client);
    }

    /**
     * Gets current client.
     *
     * @return the current client
     */
    public Client getCurrentClient() {
        return this.repositories.getClientRepository().getClientByUserSession(getCurrentSession());
    }

    /**
     * Get current session user session.
     *
     * @return the user session
     */
    public UserSession getCurrentSession(){
        return this.repositories.getAuthenticationRepository().getCurrentUserSession();
    }

    /**
     * Gets replies by client.
     *
     * @param listMessages the list messages
     * @return the replies by client
     */
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

