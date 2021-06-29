package by.it_academy.jd2.core.tool.api;

import by.it_academy.jd2.core.model.Message;
import by.it_academy.jd2.core.model.User;

import java.util.List;

public interface IMessageView {
    List<Message> getAllMessage();
    void saveMessage(Message message);
    List<Message> searchMessageUserLogin(String login);
    List<String> printMessasgeUserLogin(User userSender);
    int deleteMessageSender(String login);
    int deleteMessageReceiver(String login);
}
