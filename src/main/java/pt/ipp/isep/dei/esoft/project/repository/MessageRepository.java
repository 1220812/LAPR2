package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Message;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MessageRepository {
    static List<Message> MessageList;
    static List<Message> MessageCompleteList;

    Message message=null;

    public MessageRepository(){
        MessageList = new ArrayList<>();
        MessageCompleteList = new ArrayList<>();
    }



    public static Message checkIfValid(LocalDate date, String schedule) {
        Message message = new Message(date, schedule);
        add(message);
        return message;
    }




    public static boolean add(Message message){
        if (message == null) throw new IllegalArgumentException("Impossible message");
        if (MessageList.contains(message)) throw new IllegalArgumentException("Visit already exist");
        return MessageList.add(message);
    }

    public static boolean addComplete(Message message){
        if (message == null) throw new IllegalArgumentException("Impossible message");
        if (MessageList.contains(message)) throw new IllegalArgumentException("Visit already exist");
        return MessageList.add(message);
    }


    public static List<Message> getMessageList(){
        return MessageList;
    }


    public static Message addMessage(LocalDate date, String schedule, String name, int phone) {
        Message message = new Message(date, schedule,name, phone);
        addComplete(message);
        return message;

    }
}
