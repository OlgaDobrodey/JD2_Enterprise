package by.it_academy.jd2.core.model.chat;



import by.it_academy.jd2.core.model.people.User;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Class Message
 * chat message
 */
@Entity
@Table(name = "messages", schema = "polyclinic")
public class Message implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_message;

    @OneToOne
    @JoinColumn(name = "sender", nullable = false)
    private User sender;


    @OneToOne
    @JoinColumn(name = "receiver", nullable = false)
    private User receiver;
    @NotNull
    private String message;
    @NotNull
    @CreationTimestamp
    private Date date_msg;

    public Message() {
    }


    public Message(Integer id_message, User sender, User receiver, String message, Date date_msg) {
        this.id_message = id_message;
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.date_msg = date_msg;
    }

    public Integer getId_message() {
        return id_message;
    }

    public void setId_message(Integer id_message) {
        this.id_message = id_message;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate_msg() {
        return date_msg;
    }

    public void setDate_msg(Date date_msg) {
        this.date_msg = date_msg;
    }


}
