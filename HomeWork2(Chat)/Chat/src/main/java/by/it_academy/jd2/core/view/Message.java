package by.it_academy.jd2.core.view;


import by.it_academy.jd2.core.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import by.it_academy.jd2.core.view.User;

/**
 *
 *  Home work №2
 *  Chat
 *  @author Olga Dobrodey
 *
 * Message class initializes Message with parameters
 * User sender, User receiver, String date, String message;
 *
  */

public class Message {

    private User sender;
    private User receiver;
    private String message;
    private String date;

    /**
     * Messager constructor initializes Message with parameters
     * @param sender
     * @param receiver
     * @param message
     */
    public Message(User sender, User receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        SimpleDateFormat dateTime = new SimpleDateFormat(Constants.FORMAT_DATE);
        this.date = dateTime.format(new Date());
    }

    /**
     * method getSender()
     * @return sender.getLogin()- String
     */
    public String getSender() {
        return sender.getLogin();
    }
    /**
     * method getReceiver()
     * @return receiver.getLogin()- String
     */
    public String getReceiver() {
        return receiver.getLogin();
    }
    /**
     * method getDate()
     * @return date- String
     */
    public String getDate() {
        return date;
    }
    /**
     * method getMessage()
     * @return  messag- String
     */
    public String getMessage() {
        return message;
    }

    /**
     *  @Override method toStrind
     * @return date+ " От: " + sender.getName() +" Cообщениe: " + message + "\n -String
     */

    @Override
    public String toString() {
        return date+ " От: " + sender.getName() +" Cообщениe: " + message + "\n";
    }
}
