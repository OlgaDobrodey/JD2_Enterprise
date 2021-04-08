package by.it_academy.jd2.core.tool;

import by.it_academy.jd2.core.storage.AllMessage;
import by.it_academy.jd2.core.view.Message;
import by.it_academy.jd2.core.view.User;

import java.util.ArrayList;
import java.util.List;


/**
 * Class contains method work whith messages
 */
public class DataMessage {


    /**Method save message in application memory
     * @param message String
     */
    public static void saveMessage(Message message) {
        AllMessage.getAllMessage().add(message);
    }


    /**Method search list messages for User with login
     * @param login user String
     * @return list messages
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


    /**Method print list messager for user with login
     * @param userSender User
     * @return text messages String
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
    public static String printMessasgeUserLoginC(User userSender) {
        StringBuilder result = new StringBuilder();
        if (DataMessage.searchMessageUserLogin(userSender.getLogin()).size() != 0) {
            for (Message message : DataMessage.searchMessageUserLogin(userSender.getLogin())) {
                result.append(message.toString());

            }
        } else {
            result.append("У вас пока нет сообщений!!!");
        }
        return result.toString();
    }

}


