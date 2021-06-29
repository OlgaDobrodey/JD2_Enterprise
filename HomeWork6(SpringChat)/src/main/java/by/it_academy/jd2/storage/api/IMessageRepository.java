package by.it_academy.jd2.storage.api;

import by.it_academy.jd2.core.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMessageRepository extends JpaRepository<Message,Integer> {
    List<Message> findAllByReceiverLogin (String receiver);
}
