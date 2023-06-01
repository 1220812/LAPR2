package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Message;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Message repository.
 */
public class MessageRepository {
    /**
     * The Message list.
     */
    static List<Message> MessageList;
    /**
     * The Message complete list.
     */
    static List<Message> MessageCompleteList;

    /**
     * The Message.
     */
    Message message=null;

    /**
     * Instantiates a new Message repository.
     */
    public MessageRepository(){
        MessageList = new ArrayList<>();
        MessageCompleteList = new ArrayList<>();
    }


    /**
     * Check if valid message.
     *
     * @param date     the date
     * @param schedule the schedule
     * @return the message
     */
    public static Message checkIfValid(LocalDate date, String schedule) {
        Message message = new Message(date, schedule);
        add(message);
        return message;
    }


    /**
     * Add boolean.
     *
     * @param message the message
     * @return the boolean
     */
    public static boolean add(Message message){
        if (message == null) throw new IllegalArgumentException("Impossible message");
        if (MessageList.contains(message)) throw new IllegalArgumentException("Visit already exist");
        return MessageList.add(message);
    }

    /**
     * Add complete boolean.
     *
     * @param message the message
     * @return the boolean
     */
    public static boolean addComplete(Message message){
        return MessageCompleteList.add(message);
    }


    /**
     * Get message list list.
     *
     * @return the list
     */
    public static List<Message> getMessageList(){
        return MessageList;
    }


    /**
     * Add message message.
     *
     * @param date     the date
     * @param schedule the schedule
     * @param name     the name
     * @param phone    the phone
     * @return the message
     */
    public static Message addMessage(LocalDate date, String schedule, String name, int phone, int inputAnnou) {
        Message message = new Message(date, schedule,name, phone, inputAnnou);
        addComplete(message);
        return message;

    }
}
