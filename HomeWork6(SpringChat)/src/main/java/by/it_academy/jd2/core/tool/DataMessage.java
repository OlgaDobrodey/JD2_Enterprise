package by.it_academy.jd2.core.tool;

import by.it_academy.jd2.storage.AllMessage;
import by.it_academy.jd2.core.tool.api.DataMessageInt;
import by.it_academy.jd2.core.model.Message;
import by.it_academy.jd2.core.model.User;

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
    private String deleteMessageSender ="DELETE FROM chat.messages WHERE sender_login ='%s'";
    private String deleteMessageReceiver = "DELETE FROM chat.messages WHERE receiver_login ='%s'";

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
            ps.setTimestamp(5,message.getDateTime() );
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
    /**Method print list messager for user with login
     * Method used, when print list message with technology JSTL
     * @param userSender User
     * @return text messages String
     *
     */

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

    /**
     * delete all message with login_sender "
     * @param login - User sender login(String)
     * @return count delete message
     */
    @Override
    public int deleteMessageSender(String login) {
        String select = String.format(deleteMessageSender,login);
        try(PreparedStatement ps = connection.prepareStatement(select)) {

            int result =ps.executeUpdate();
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }

    }
    /**
     * delete all message with login_receiver "
     * @param login - User receiver login(String)
     * @return count delete message
     */

    @Override
    public int deleteMessageReceiver(String login) {
        String select = String.format(deleteMessageReceiver,login);
        try(PreparedStatement ps = connection.prepareStatement(select)) {
            int result =ps.executeUpdate();
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }

    }


}


