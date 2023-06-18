package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.domain.SortingMethods.BubbleSort;
import pt.ipp.isep.dei.esoft.project.domain.SortingMethods.MergeSort;

import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * The MessageRepository class is responsible for storing and managing messages.
 */
public class MessageRepository implements Serializable {
    private static final long serialVersionUID = -2164261031341973438L;
    /**
     * The Message list.
     */
    static List<Message> MessageList;
    /**
     * The Message complete list.
     */
    static List<Message> MessageCompleteList;

    /**
     * Constructs a new instance of MessageRepository.
     * Initializes the message lists.
     */
    public MessageRepository() {
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
    public static boolean add(Message message) {
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
    public static boolean addComplete(Message message) {
        return MessageCompleteList.add(message);
    }

    /**
     * Retrieves the list of messages.
     *
     * @return the list of messages.
     */
    public static List<Message> getMessageList() {
        return MessageList;
    }

    /**
     * Add message message.
     *
     * @param client            the client
     * @param announcement      the announcement
     * @param newVisitStartTime the new visit start time
     * @param newVisitEndTime   the new visit end time
     * @return the message
     */
    public static Message addMessage(Client client, Announcement announcement, LocalDateTime newVisitStartTime, LocalDateTime newVisitEndTime) {
        Message message = new Message(client, announcement, newVisitStartTime, newVisitEndTime);
        addComplete(message);
        return message;
    }

    /**
     * Gets request assigned list.
     *
     * @param agent the agent
     * @return the request assigned list
     */
    public List<Message> getRequestAssignedList(Agent agent) {
        List<Message> assignedList = new ArrayList<>();
        for (Message message : this.MessageList) {
            if (message.getAgent().getEmailAddress().equalsIgnoreCase(agent.getEmailAddress())) {
                assignedList.add(message);
            }
        }
        return assignedList;
    }

    /**
     * Gets client.
     *
     * @param message the message
     * @return the client
     */
    public Client getClient(Message message) {
        return message.getClient();
    }

    /**
     * Gets announcement.
     *
     * @param message the message
     * @return the announcement
     */
    public Announcement getAnnouncement(Message message) {
        return message.getAnnouncement();
    }

    /**
     * Remove message message.
     *
     * @param message the message
     * @return the message
     */
    public static Message removeMessage(Message message) {
        getMessageList().remove(message);
        return message;
    }

    /**
     * The Final list.
     */
    List<Message> finalList = new ArrayList<>();


    /**
     * Gets message sorted.
     *
     * @param messageList the message list
     * @return the message sorted
     * @throws IOException the io exception
     */
    public List<Message> getMessageSorted(List<Message> messageList) throws IOException {
        Properties properties = System.getProperties();
        properties.load(new FileReader("src/main/resources/sortingMethods.properties"));
        String algorithm = properties.getProperty("sorting.algorithm");

        switch (algorithm.toUpperCase()) {
            case "MERGESORT":
                MergeSort merge = new MergeSort();
                //finalList = merge.merge(requestList);


                break;
            case "SORTINGBUBBLES":
                BubbleSort bubbleSort = new BubbleSort();
                finalList = bubbleSort.sortByDate(messageList);
                break;
            default:
                System.out.println("Warning: invalid");
//                finalList = merge.merge(requestList);
        }
        return finalList;
    }

    public List<Message> getRequestCompletedList(Client client) {
        List<Message> assignedCompletedList = new ArrayList<>();
        for (Message message : this.MessageCompleteList) {
            if (message.getClient().getEmailAddress().equalsIgnoreCase(client.getEmailAddress())) {
                assignedCompletedList.add(message);
            }
        }
        return assignedCompletedList;
    }

    public List<Message> getMessageCompleteList() {
        return MessageCompleteList;
    }
}