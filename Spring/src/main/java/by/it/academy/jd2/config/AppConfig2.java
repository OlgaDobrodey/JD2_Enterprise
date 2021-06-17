package by.it.academy.jd2.config;


import by.it.academy.jd2.service.PersonService;
import by.it.academy.jd2.test.A;
import by.it.academy.jd2.test.B;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {


    @Bean//(name = "personServiceHello")
    //@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public A a() {
        return new A();
    }
    @Bean//(name = "personServiceHello")
    //@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public B b() {
        return new B();
    }
}
