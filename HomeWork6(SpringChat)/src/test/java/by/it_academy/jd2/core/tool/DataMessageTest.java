package by.it_academy.jd2.core.tool;

import by.it_academy.jd2.storage.AllMessage;
import by.it_academy.jd2.core.model.Message;
import by.it_academy.jd2.core.model.User;
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
    private DataStorageUsers users;
    private DataMessage dataMessage;

    @BeforeAll
    private void createUsers() {
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

    }


    @Test
    void classDefinition() {
        DataMessage dataMessageClass = new DataMessage(connection);
        Assert.assertTrue(dataMessageClass instanceof DataMessage);
    }

    @Test
    void saveMessage() {
        Message testMessage = new Message(userReceiver, userSender, "textTest");
        dataMessage.saveMessage(testMessage);
        String actual = "";
        for (Message search : AllMessage.getAllMessage(connection)) {
            if (search.toString().equals(testMessage.toString())) {
                actual = search.toString();
            }
        }
        assertEquals(testMessage.toString(), actual);

        //assertEquals(true, AllMessage.getAllMessage(connection).contains(testMessage));
    }

    @Test
    void searchMessageUserLogin() {
        List<Message> actual = dataMessage.searchMessageUserLogin(userReceiver.getLogin());
        List<Message> list = new ArrayList<>();
        list.add(message);
        List<Message> expected = list;
        assertEquals(expected.toString(), actual.toString());
    }


    @Test
    void printMessasgeUserLoginNullMessage() {
        String expected = "<p><span style='color: black;'> У вас пока нет сообщений!!!</span></p>";
        String actual = dataMessage.printMessasgeUserLogin(userSender);
        assertEquals(expected, actual);
    }

    @Test
    void printMessasgeUserLogin() {
        String expected = "<p><span style='color: black;'>" + message.toString() + "</span></p>\n";
        String actual = dataMessage.printMessasgeUserLogin(userReceiver);
        assertEquals(expected, actual);
    }

    @Test
    void deleteMessageSender(){
        User newUser = new User();
        newUser.setName("Test");
        newUser.setLogin("User");
        newUser.setPassword("456");
        newUser.setBirthday("2021-03-25");
        users.saveUsers(newUser);
        dataMessage.saveMessage(new Message(newUser,userSender,"textdelete"));
       int actual = dataMessage.deleteMessageSender("User");
       int expected = 1;
        assertEquals(expected, actual);
        users.deleteUser("User");
    }

    @Test
    void  deleteMessageReceiver(){
        User newUser = new User();
        newUser.setName("Test");
        newUser.setLogin("User");
        newUser.setPassword("456");
        newUser.setBirthday("2021-03-25");
        users.saveUsers(newUser);
        dataMessage.saveMessage(new Message(userSender,newUser,"textdelete"));
        int actual = dataMessage.deleteMessageReceiver("User");
        int expected = 1;
        assertEquals(expected, actual);
        users.deleteUser("User");
    }
    @Test
    void printMessasgeUserLoginC(){
        String expected = message.toString();
        String actual = dataMessage.printMessasgeUserLoginC(userReceiver);
        assertEquals(expected, actual);
    }
    @Test
    void printMessasgeUserLoginCNullMessage() {
        String expected = "У вас пока нет сообщений!!!";
        String actual = dataMessage.printMessasgeUserLoginC(userSender);
        assertEquals(expected, actual);
    }



    @AfterAll
    void closeConnection() {
       dataMessage.deleteMessageSender("Dobrodey");
        dataMessage.deleteMessageReceiver("Dobrodey");
        users.deleteUser("Dobrodey");
        users.deleteUser("Hurkovskii");


        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}