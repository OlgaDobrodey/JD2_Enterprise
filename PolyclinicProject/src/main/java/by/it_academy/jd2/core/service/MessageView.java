package by.it_academy.jd2.core.service;

import by.it_academy.jd2.core.model.chat.Message;
import by.it_academy.jd2.core.model.people.User;

import by.it_academy.jd2.core.service.api.IMessageView;
import by.it_academy.jd2.storage.api.IMessageRepository;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

public class MessageView implements IMessageView {
    private final IMessageRepository repository;

    public MessageView(IMessageRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void saveMessage(Message message) {
        this.repository.save(message);
    }

    @Override
    public List<Message> findAllMessage() {
        return this.repository.findAll();
    }

    @Override
    public List<Message> findAllMessageWithSenderAndReceiver(User sender, User receiver) {
        final List<Message> messageBySenderAndReceiver = this.repository.findMessageBySenderAndReceiver(sender, receiver);
        final List<Message> messageByReceiverAndSender = this.repository.findMessageBySenderAndReceiver(receiver, sender);
        messageBySenderAndReceiver.addAll(messageByReceiverAndSender);
        messageBySenderAndReceiver.sort(Comparator.comparing(Message::getDate_msg));
        return messageBySenderAndReceiver ;
    }


}
