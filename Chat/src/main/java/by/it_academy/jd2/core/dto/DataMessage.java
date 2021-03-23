package by.it_academy.jd2.core.dto;

import java.util.ArrayList;
import java.util.List;


public class DataMessage {
    private static List<Message> AllMessage = new ArrayList<>();

    public static void saveMessage(Message message) {
        AllMessage.add(message);
    }

    public static List<Message> searchMessageUserLoginAndPsw(String login) {
        List<Message> messagesUser = new ArrayList<>();
        for (Message message : AllMessage) {
            if(message.getReceiver().equals(login)){
                messagesUser.add(message);
            }
        }
        return messagesUser;}


    }


