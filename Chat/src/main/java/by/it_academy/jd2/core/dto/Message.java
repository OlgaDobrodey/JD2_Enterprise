package by.it_academy.jd2.core.dto;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

    private User Sender;
    private User Receiver;
    private String date;
    private String message;

    public Message(User sender, User receiver, String message) {
        this.Sender = sender;
        this.Receiver = receiver;
        this.message = message;
        SimpleDateFormat dateTime = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        this.date = dateTime.format(new Date());
    }

    public String getSender() {
        return Sender.getLogin();
    }

    public String getReceiver() {
        return Receiver.getLogin();
    }

    public String getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return date+ " От: " + Sender.getName() +" Cообщениe: " + message + "\n";
    }
}
