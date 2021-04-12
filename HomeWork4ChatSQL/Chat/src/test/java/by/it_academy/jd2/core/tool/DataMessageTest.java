package by.it_academy.jd2.core.tool;

import by.it_academy.jd2.core.storage.AllMessage;
import by.it_academy.jd2.core.view.Message;
import by.it_academy.jd2.core.view.User;
import by.it_academy.jd2.data.DaoFactory;
import by.it_academy.jd2.data.DatabaseName;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DataMessageTest {
    private User userSender;
    private User userReceiver;
    private Message message;
    private Connection connection;

    @BeforeAll
    private void createUsers() {
        try {
            connection = DaoFactory.getInstance(DatabaseName.POSTGRES).getConnectionBase();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        final DataStorageUsers users = new DataStorageUsers(connection);
        userSender = new User();
        userSender.setName("Olga");
        userSender.setLogin("Dobrodey");
        userSender.setPassword("123");
        userSender.setBirthday("25.03.2021");
        users.saveUsers(userSender);

        userReceiver = new User();
        userReceiver.setName("Sasha");
        userReceiver.setLogin("Hurkovskii");
        userReceiver.setPassword("456");
        userReceiver.setBirthday("12.04.2011");
        users.saveUsers(userReceiver);

        message = new Message(userSender, userReceiver, "text message");
        (new DataMessage(connection)).saveMessage(message);

    }


    @Test
    void classDefinition() {
        DataMessage dataMessage = new DataMessage(connection);
        Assert.assertTrue(dataMessage instanceof DataMessage);
    }

    @Test
    void saveMessage() {
        Message testMessage = new Message(userReceiver, userSender, "textTest");
        new DataMessage(connection).saveMessage(testMessage);
        AllMessage.getAllMessage(connection).contains(testMessage);
        assertEquals(true, AllMessage.getAllMessage(connection).contains(testMessage));
    }

    @Test
    void searchMessageUserLogin() {
        List<Message> actual = new DataMessage(connection).searchMessageUserLogin(userReceiver.getLogin());
        List<Message> list = new ArrayList<>();
        list.add(message);
        List<Message> expected = list;
        assertEquals(expected, actual);
    }


    @Test
    void printMessasgeUserLoginNullMessage() {
        String expected = "<p><span style='color: black;'> У вас пока нет сообщений!!!</span></p>";
        String actual = new DataMessage(connection).printMessasgeUserLogin(userSender);
        assertEquals(expected, actual);
    }

    @Test
    void printMessasgeUserLogin() {
        String expected = "<p><span style='color: black;'>" + message.toString() + "</span></p>\n";
        String actual = new DataMessage(connection).printMessasgeUserLogin(userReceiver);
        assertEquals(expected, actual);
    }
    @AfterAll
    void closeConnection(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }




}