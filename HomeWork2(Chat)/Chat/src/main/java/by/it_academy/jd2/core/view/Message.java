package by.it_academy.jd2.core.view;


import by.it_academy.jd2.core.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import by.it_academy.jd2.core.view.User;

/**
 * Class Message
 * chat message
 */

public class Message {

    private User sender;
    private User receiver;
    private String message;
    private String date;


    /**
     * @param sender User
     * @param receiver User
     * @param message String
     */
    public Message(User sender, User receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        SimpleDateFormat dateTime = new SimpleDateFormat(Constants.FORMAT_DATE);
        this.date = dateTime.format(new Date());
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
    /**This method get text message
     * @return  text message String
     */
    public String getMessage() {
        return message;
    }



    @Override
    public String toString() {
        return date+ " От: " + sender.getName() +" Cообщениe: " + message + "\n";
    }
}
