package by.it_academy.jd2.core.storage;

import by.it_academy.jd2.core.view.Message;
import by.it_academy.jd2.core.view.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * application memory containing messages
 */
public class AllMessage {
    //private static List<Message> AllMessage;
    private static String select = "select * from chat.messages";

    private AllMessage() {
    }


    public static List<Message> getAllMessage(Connection connection) {
        List<Message> AllMessage = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(select)) {
            Set<User> AllUser = AllUsers.getAllUsers(connection);
            while (resultSet.next()) {
                Message message = new Message();
                message.setMessage(resultSet.getString("message"));
                message.setDate(resultSet.getString("date_msg"));
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

