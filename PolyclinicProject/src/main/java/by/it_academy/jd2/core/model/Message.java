package by.it_academy.jd2.core.model;


import by.it_academy.jd2.core.utils.Constants;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


/**
 * Class Message
 * chat message
 */
@Entity
@Table(name = "messages", schema = "chat")
public class Message implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_message", nullable = false)
    private Integer id;

    @Column(name = "sender_login", nullable = false)
    private String senderLogin;

    @Column(name = "receiver_login",nullable = false)
    private String receiverLogin;

    @Column(name = "message",nullable = false)
    private String message;

    @CreationTimestamp
    @Column(name = "date_msg",nullable = false)
    private Timestamp dateTime;


//    /**
//     * @param sender   User
//     * @param receiver User
//     * @param message  String
//     */

    public Message() {
    }

    public Message(Integer id, String senderLogin, String receiverLogin, String message, Timestamp dateTime) {
        this.id = id;
        this.senderLogin = senderLogin;
        this.receiverLogin = receiverLogin;
        this.message = message;
        this.dateTime = dateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat(Constants.FORMAT_DATE);

    public String getSender() {
        return senderLogin;
    }

    public void setSender(User sender) {
        this.senderLogin = sender.getLogin();
    }

    public String getReceiver() {
        return receiverLogin;
    }

    public void setReceiver(User receiver) {
        this.receiverLogin = receiver.getLogin();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    /**
     * This method get date write message
     *
     * @return date write message String
     */
    public String getDate() {
        return dateTime.toString();
    }

    //
    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return String.format("От: %s  %s   Cообщениe: %s  ", senderLogin, getDate().substring(0, 19), message);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    //
//    /**
//     * This method get text message
//     *
//     * @return text message String
//     */

//
//

}
