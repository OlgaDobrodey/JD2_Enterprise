package by.it_academy.jd2.core.tool;

import by.it_academy.jd2.core.storage.AllMessage;
import by.it_academy.jd2.core.view.Message;
import by.it_academy.jd2.core.view.User;

import java.util.ArrayList;
import java.util.List;

/**
 *Class DataMessage contains methods for work Messages
 */

public class DataMessage {
    /**
     * method saveMessage
     * save Messager List<Message> AllMessage
     * @param message -String
     */


    public static void saveMessage(Message message) {
        AllMessage.getAllMessage().add(message);
    }

    /**
     * method  searchMessageUserLogin
     * finds messages for a user
     * @param login -string
     * @return
     */
    public static List<Message> searchMessageUserLogin(String login) {
        List<Message> messagesUser = new ArrayList<>();
        for (Message message : AllMessage.getAllMessage()) {
            if (message.getReceiver().equals(login)) {
                messagesUser.add(message);
            }
        }
        return messagesUser;
    }

    /**
     * method  printMessasgeUserLogin
     * print Messarges for a user
     * @param userSender
     * @return result -String (list messages or "У вас пока нет сообщений!!!")
     */

    public static String printMessasgeUserLogin(User userSender) {
        StringBuilder result = new StringBuilder();
        if (DataMessage.searchMessageUserLogin(userSender.getLogin()).size() != 0) {
            for (Message message : DataMessage.searchMessageUserLogin(userSender.getLogin())) {
                result.append("<p><span style='color: black;'>" + message.toString() + "</span></p>\n");

            }
        } else {
            result.append("<p><span style='color: black;'> У вас пока нет сообщений!!!</span></p>");
        }
        return result.toString();
    }

}


