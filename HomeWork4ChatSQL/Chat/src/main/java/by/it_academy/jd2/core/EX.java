package by.it_academy.jd2.core;

import by.it_academy.jd2.core.storage.AllMessage;
import by.it_academy.jd2.core.storage.AllUsers;
import by.it_academy.jd2.core.tool.DataMessage;
import by.it_academy.jd2.core.tool.DataStorageUsers;
import by.it_academy.jd2.core.view.Message;
import by.it_academy.jd2.core.view.User;
import by.it_academy.jd2.data.DaoFactory;
import by.it_academy.jd2.data.DatabaseName;

import javax.sound.midi.Soundbank;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EX {
    private static User userSender;
    private static User userReceiver;
    private static Message message;
    private static Connection connection;
    private static DataStorageUsers users;
    private static DataMessage dataMessage;
    public static void main(String[] args) {
        try {
            connection = DaoFactory.getInstance(DatabaseName.POSTGRES).getConnectionBase();
            users = new DataStorageUsers(connection);
            dataMessage = new DataMessage(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        userSender = new User();
        userSender.setName("Olga");
        userSender.setLogin("Dobrodey");
        userSender.setPassword("123");
        userSender.setBirthday("2021-03-25");
        users.saveUsers(userSender);

        userReceiver = new User();
        userReceiver.setName("Sasha");
        userReceiver.setLogin("Hurkovskii");
        userReceiver.setPassword("456");
        userReceiver.setBirthday("2011-12-04");
        users.saveUsers(userReceiver);

        message = new Message(userSender, userReceiver, "text message");
        (dataMessage).saveMessage(message);
        System.out.println("message"+message);
        System.out.println("AllMe"+AllMessage.getAllMessage(connection));
        for (Message message1 : AllMessage.getAllMessage(connection)) {
            if((message1.toString()).equals(message.toString())){
                System.out.println("!!!"+message1);
            }

        }

        System.out.println(AllMessage.getAllMessage(connection).contains(message.toString().trim()));
        System.out.println( dataMessage.deleteMessageSender("Dobrodey"));

users.deleteUser("Dobrodey");
users.deleteUser("Hurkovskii");
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    }
