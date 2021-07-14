package by.it_academy.jd2.core.service.api;

import by.it_academy.jd2.core.model.MedicalCard;
import by.it_academy.jd2.core.model.Message;
import by.it_academy.jd2.core.model.User;

import java.util.List;

public interface IMessageView {
    void saveMessage(Message message);
    List<Message> findAllMessage();
    List<Message> findAllMessageWithSenderAndReceiver(User sender,User receiver);


}
