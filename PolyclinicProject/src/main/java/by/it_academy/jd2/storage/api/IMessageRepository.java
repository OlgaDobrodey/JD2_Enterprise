package by.it_academy.jd2.storage.api;

import by.it_academy.jd2.core.model.Message;

import by.it_academy.jd2.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMessageRepository extends JpaRepository<Message, Integer> {
   List<Message> findMessageBySenderAndReceiver(User sender,User receiver);


}
