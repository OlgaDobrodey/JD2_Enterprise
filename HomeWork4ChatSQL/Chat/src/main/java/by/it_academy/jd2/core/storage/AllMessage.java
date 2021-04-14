package by.it_academy.jd2.core.storage;

import by.it_academy.jd2.core.Constants;
import by.it_academy.jd2.core.view.Message;
import by.it_academy.jd2.core.view.User;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *The class is responsible for receiving all chat messages
 */
public class AllMessage {


    private static String select = "select * from chat.messages";


    private AllMessage() {
    }

    /**
     * Method get all message chat
     * @param connection - connection with Base Data
     * @return list all message
     */


    public static List<Message> getAllMessage(Connection connection) {
        List<Message> AllMessage = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(select)) {
            Set<User> AllUser = AllUsers.getAllUsers(connection);
            while (resultSet.next()) {
                Message message = new Message();
                message.setMessage(resultSet.getString("message"));
                Timestamp date_msg1 = resultSet.getTimestamp("date_msg");
                String format = date_msg1.toLocalDateTime().format(DateTimeFormatter.ofPattern(Constants.FORMAT_DATE));
                message.setDate(format);
//
                String senderLogin = resultSet.getString("sender_login");
                String receiverLogin = resultSet.getString("receiver_login");
                for (User user : AllUser) {
                    if (user.getLogin().equals(senderLogin)){message.setSender(user);break;}
                }
                for (User user : AllUser) {
                    if (user.getLogin().equals(receiverLogin)){message.setReceiver(user);break;}
                }
                AllMessage.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return AllMessage;
    }
}

