package by.it_academy.jd2.core.service.api.chat;

import by.it_academy.jd2.core.model.chat.Message;
import by.it_academy.jd2.core.model.people.User;

import java.util.List;

public interface IMessageView {
    void saveMessage(Message message);
    List<Message> findAllMessageWithSenderAndReceiver(User sender,User receiver);


}
