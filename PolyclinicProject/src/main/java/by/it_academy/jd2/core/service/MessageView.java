package by.it_academy.jd2.core.service;

import by.it_academy.jd2.core.model.User;
import by.it_academy.jd2.core.service.api.IMessageView;
import by.it_academy.jd2.storage.api.IMessageRepository;

public class MessageView implements IMessageView {
   private final IMessageRepository repository;

    public MessageView(IMessageRepository repository) {
        this.repository = repository;
    }
//
//    @Override
//    public List<Message> getAllMessage() {
//        return repository.findAll();
//    }
//
//    @Override
//    public void saveMessage(Message message) {
//        this.repository.save(message);
//    }
//
//    @Override
//    public List<Message> searchMessageUserLogin(String login) {
//        return this.repository.findAllByReceiverLogin(login);
//
//    }
//
//    @Override
//    public List<String> printMessasgeUserLogin(User userSender) {
//        List<String> messageToString = new ArrayList<>();
//        List<Message> list = searchMessageUserLogin(userSender.getLogin());
//        for (Message message : list) {
//            messageToString.add(message.toString());
//        }
//        return messageToString;
//    }
//
//    @Override
//    public int deleteMessageSender(String login) {
//
//        return 0;
//    }
//
//    @Override
//    public int deleteMessageReceiver(String login) {
//        return 0;
//    }/


}
