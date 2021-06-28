package by.it_academy.jd2.config;


import by.it_academy.jd2.core.tool.UserView;
import by.it_academy.jd2.core.tool.api.IUserView;
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
//
//    @Bean
//    public IFlyingsView flyingsView(FlyingsRepository repository) {
//        return new FlyingsView(repository);
//    }

}
