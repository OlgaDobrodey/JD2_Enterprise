package by.it_academy.jd2.storage.api.chat;

import by.it_academy.jd2.core.model.chat.Message;

import by.it_academy.jd2.core.model.people.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMessageRepository extends JpaRepository<Message, Integer> {
   List<Message> findMessageBySenderAndReceiver(User sender,User receiver);


}
