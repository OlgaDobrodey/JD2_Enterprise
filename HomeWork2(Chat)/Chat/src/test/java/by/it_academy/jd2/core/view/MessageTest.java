package by.it_academy.jd2.core.view;

import by.it_academy.jd2.core.Constants;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    private User userSender = new User();

    {
        userSender.setName("Olga");
        userSender.setLogin("Dobrodey");
        userSender.setPassword("123");
        userSender.setBirthday("25.03.2021 11:06:45");
    }

    private User userReceiver = new User();

    {
        userReceiver.setName("Sasha");
        userReceiver.setLogin("Hurkovskii");
        userReceiver.setPassword("456");
        userReceiver.setBirthday("12.04.2011 11:06:45");
    }

    private Message message = new Message(userSender, userReceiver, "text message");

    @Test
    void getSender() {
        String actual = message.getSender();
        String expected = "Dobrodey";
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getReceiver() {
        String actual = message.getReceiver();
        String expected = "Hurkovskii";
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getDate() {
        Message message = new Message(userSender,userReceiver,"text");
        SimpleDateFormat dateTime = new SimpleDateFormat(Constants.FORMAT_DATE);
        String date = dateTime.format(new Date());
        String actual = message.getDate();
        String expected = date;
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getMessage() {
        String actual = message.getMessage();
        String expected = "text message";
        Assert.assertEquals(expected, actual);
    }

    @Test
    void testToString() {
        Message message = new Message(userSender,userReceiver,"text");
        SimpleDateFormat dateTime = new SimpleDateFormat(Constants.FORMAT_DATE);
        String date = dateTime.format(new Date());
        String actual = message.toString();
        String expected = message.getDate()+ " От: Olga Cообщениe: text\n";
        Assert.assertEquals(expected, actual);

    }
}