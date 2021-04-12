package by.it_academy.jd2.core.tool;

import by.it_academy.jd2.core.storage.AllMessage;
import by.it_academy.jd2.core.storage.AllUsers;
import by.it_academy.jd2.core.tool.api.DataMessageInt;
import by.it_academy.jd2.core.view.Message;
import by.it_academy.jd2.core.view.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Class contains method work whith messages
 */
public class DataMessage implements DataMessageInt {
    private Connection connection;

    private String  insert = "INSERT INTO chat.messages" +
            "(id_message, sender_login, receiver_login, message, date_msg)" +
            " VALUES (?, ?, ?, ?, ?)";
    public DataMessage(Connection connection) {
        this.connection = connection;
    }

    /**Method save message in application memory
     * @param message String
     */
    public void saveMessage(Message message) {
        try(PreparedStatement ps = connection.prepareStatement(insert)){
            int count = AllMessage.getAllMessage(connection).size() + 1;
            String sender = message.getSender();
            String receiver = message.getReceiver();
            ps.setInt(1, count);
            ps.setString(2,sender);
            ps.setString(3, receiver);
            ps.setString(4, message.getMessage());
            ps.setTimestamp(5,Timestamp.valueOf(message.getDateTime()) );
            int affected = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**Method search list messages for User with login
     * @param login user String
     * @return list messages
     */
    public List<Message> searchMessageUserLogin(String login) {
        List<Message> messagesUser = new ArrayList<>();
        List<Message> AllMSG= AllMessage.getAllMessage(connection);

        for (Message message : AllMSG) {
            String receiverLogin = message.getReceiver();
            if (receiverLogin.equals(login)) {
                messagesUser.add(message);
            }
        }
        return messagesUser;
    }


    /**Method print list messager for user with login
     * @param userSender User
     * @return text messages String
     */
    public  String printMessasgeUserLogin(User userSender) {
        StringBuilder result = new StringBuilder();
        String senderLogin = userSender.getLogin();
        List<Message> messagesUser = searchMessageUserLogin(senderLogin);
        if (messagesUser.size() != 0) {
            for (Message message : messagesUser) {
                result.append("<p><span style='color: black;'>" + message.toString() + "</span></p>\n");

            }
        } else {
            result.append("<p><span style='color: black;'> У вас пока нет сообщений!!!</span></p>");
        }
        return result.toString();
    }

    public String printMessasgeUserLoginC(User userSender) {
        StringBuilder result = new StringBuilder();
        String senderLogin = userSender.getLogin();
        List<Message> messagesUser = searchMessageUserLogin(senderLogin);
        if (messagesUser.size() != 0) {
            for (Message message : messagesUser) {
                result.append(message.toString());

            }
        } else {
            result.append("У вас пока нет сообщений!!!");
        }
        return result.toString();
    }

}


