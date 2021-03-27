package by.it_academy.jd2.core.tool;

import by.it_academy.jd2.core.storage.AllMessage;
import by.it_academy.jd2.core.view.Message;
import by.it_academy.jd2.core.view.User;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DataMessageTest {
    private User userSender;
    private User userReceiver;
    private Message message;

    @BeforeAll
    private void createUsers() {
        userSender = new User();
        userSender.setName("Olga");
        userSender.setLogin("Dobrodey");
        userSender.setPassword("123");
        userSender.setBirthday("25.03.2021");
        DataStorageUsers.saveUsers(userSender);

        userReceiver = new User();
        userReceiver.setName("Sasha");
        userReceiver.setLogin("Hurkovskii");
        userReceiver.setPassword("456");
        userReceiver.setBirthday("12.04.2011");
        DataStorageUsers.saveUsers(userReceiver);

        message = new Message(userSender, userReceiver, "text message");
        DataMessage.saveMessage(message);

    }


    @Test
    void classDefinition() {
        DataMessage dataMessage = new DataMessage();
        Assert.assertTrue(dataMessage instanceof DataMessage);
    }

    @Test
    void saveMessage() {
        Message testMessage = new Message(userReceiver,userSender,"textTest");
        DataMessage.saveMessage(testMessage);
        AllMessage.getAllMessage().contains(testMessage);
        assertEquals(true, AllMessage.getAllMessage().contains(testMessage));
    }

    @Test
    void searchMessageUserLogin() {
        List<Message> actual = DataMessage.searchMessageUserLogin(userReceiver.getLogin());
        List<Message> list = new ArrayList<>();
        list.add(message);
        List<Message> expected = list;
        assertEquals(expected, actual);
    }



    @Test
    void printMessasgeUserLoginNullMessage() {
        String expected = "<p><span style='color: black;'> У вас пока нет сообщений!!!</span></p>";
        String actual= DataMessage.printMessasgeUserLogin(userSender);
        assertEquals(expected, actual);
    }

    @Test
    void printMessasgeUserLogin() {
        String expected = "<p><span style='color: black;'>" + message.toString() + "</span></p>\n";
        String actual= DataMessage.printMessasgeUserLogin(userReceiver);
        assertEquals(expected, actual);
    }


}