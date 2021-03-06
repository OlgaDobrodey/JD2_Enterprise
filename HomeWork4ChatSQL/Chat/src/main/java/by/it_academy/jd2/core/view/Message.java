package by.it_academy.jd2.core.view;


import by.it_academy.jd2.core.Constants;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import by.it_academy.jd2.core.view.User;

/**
 * Class Message
 * chat message
 */

public class Message implements Serializable {

    private User sender;
    private User receiver;
    private String message;
    private String date;
    private LocalDateTime dateTime;


    public Message() {
    }

    /**
     * @param sender User
     * @param receiver User
     * @param message String
     */

    public Message(User sender, User receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.FORMAT_DATE);
        this.date = dateTime.format(formatter);

    }

    /**This method get  user sender login
     * @return  user sender login String
     */
    public String getSender() {
        return sender.getLogin();
    }

    /**This method get receiver user login
     * @return  receiver user login String
     */
    public String getReceiver() {
        return receiver.getLogin();
    }
    /**This method get date write message
     * @return  date write message String
     */
    public String getDate() {
        return date;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /**This method get text message
     * @return  text message String
     */
    public String getMessage() {
        return message;
    }


    @Override
    public String toString() {
        return date+ " ????: " + sender.getName() +" C??????????????e: " + message + "\n";
    }
}
