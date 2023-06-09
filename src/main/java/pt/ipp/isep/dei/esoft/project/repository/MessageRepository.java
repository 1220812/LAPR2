package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Message;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * The MessageRepository class is responsible for storing and managing messages.
 */
public class MessageRepository {
    static List<Message> MessageList;
    static List<Message> MessageCompleteList;

    /**
     * Constructs a new instance of MessageRepository.
     * Initializes the message lists.
     */
    public MessageRepository(){
        MessageList = new ArrayList<>();
        MessageCompleteList = new ArrayList<>();
    }

    /**
     * Adds a message to the MessageList.
     *
     * @param message the message to add.
     * @return true if the message is added successfully, false otherwise.
     * @throws IllegalArgumentException if the message is null or already exists in the list.
     */
    public static boolean add(Message message){
        if (message == null) throw new IllegalArgumentException("Impossible message");
        if (MessageList.contains(message)) throw new IllegalArgumentException("Visit already exists");
        return MessageList.add(message);
    }

    /**
     * Adds a message to the MessageCompleteList.
     *
     * @param message the message to add.
     * @return true if the message is added successfully, false otherwise.
     */
    public static boolean addComplete(Message message){
        return MessageCompleteList.add(message);
    }

    /**
     * Retrieves the list of messages.
     *
     * @return the list of messages.
     */
    public static List<Message> getMessageList(){
        return MessageList;
    }

    /**
     * Adds a new message to the repository.
     *
     * @param name               the name of the message sender.
     * @param phone              the phone number of the message sender.
     * @param inputAnnou         the input announcement for the visit.
     * @param newVisitStartTime  the start time of the visit.
     * @param newVisitEndTime    the end time of the visit.
     * @return the created Message object.
     */
    public static Message addMessage(String name, int phone, int inputAnnou, LocalDateTime newVisitStartTime, LocalDateTime newVisitEndTime) {
        Message message = new Message(name, phone, inputAnnou, newVisitStartTime, newVisitEndTime);
        addComplete(message);
        return message;
    }
}