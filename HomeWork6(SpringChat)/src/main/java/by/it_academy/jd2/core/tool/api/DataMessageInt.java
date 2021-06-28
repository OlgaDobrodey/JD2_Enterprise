package by.it_academy.jd2.core.tool.api;

import by.it_academy.jd2.core.model.Message;
import by.it_academy.jd2.core.model.User;

import java.util.List;

public interface DataMessageInt {
    void saveMessage(Message message);

    List<Message> searchMessageUserLogin(String login);

    String printMessasgeUserLogin(User userSender);

    String printMessasgeUserLoginC(User userSender);

    int deleteMessageSender(String login);

    int deleteMessageReceiver(String login);







}
