package by.it_academy.jd2;

import by.it_academy.jd2.core.dto.DataMessage;
import by.it_academy.jd2.core.dto.Message;
import by.it_academy.jd2.core.dto.User;

public class ex {


    public static void main(String[] args) {

        User userOlga = new User();
        userOlga.setName("Olga");
        userOlga.setLogin("Olga1");
        userOlga.setPassword("123");
        userOlga.setBirthday("11.12.2011");
        User userSasha = new User();
        userSasha.setName("Sasha");
        userSasha.setLogin("Sasha1");
        userSasha.setPassword("123");
        userSasha.setBirthday("11.12.2011");
         Message message = new Message(userOlga, userSasha, "asddff");
        Message message2= new Message(userSasha,userOlga,"dfngkdj");

        DataMessage.saveMessage(message);DataMessage.saveMessage(message2);


        if (DataMessage.searchMessageUserLogin(userSasha.getLogin()).size()!=0) {
            for (Message message1 : DataMessage.searchMessageUserLogin(userSasha.getLogin())) {
                System.out.println(message1.toString());
            }
        } else
            System.out.println(" У вас пока нет сообщений!!!");
        String a = "true";

        boolean b =Boolean.parseBoolean(a);
        System.out.println(b);
    }

}

