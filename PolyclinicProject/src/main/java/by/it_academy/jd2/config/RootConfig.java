package by.it_academy.jd2.config;


import by.it_academy.jd2.core.service.MessageView;
import by.it_academy.jd2.core.service.PassportView;
import by.it_academy.jd2.core.service.UserView;
import by.it_academy.jd2.core.service.api.IMessageView;
import by.it_academy.jd2.core.service.api.IPassportView;
import by.it_academy.jd2.core.service.api.IUserView;
import by.it_academy.jd2.storage.api.IMessageRepository;
import by.it_academy.jd2.storage.api.IPassportRepository;
import by.it_academy.jd2.storage.api.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("by.it_academy.jd2.config")
public class RootConfig {


    @Bean
    public IUserView userView(IUserRepository repository) {
        return new UserView(repository);
    }

    @Bean
    public IMessageView messageView(IMessageRepository repository) {
        return new MessageView(repository);
    }

    @Bean
    public IPassportView passportView(IPassportRepository repository) {
        return new PassportView(repository);
    }


}
