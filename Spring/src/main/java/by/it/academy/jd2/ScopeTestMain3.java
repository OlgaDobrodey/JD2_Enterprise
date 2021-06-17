package by.it.academy.jd2;

import by.it.academy.jd2.config.AppConfig;
import by.it.academy.jd2.config.AppConfig2;
import by.it.academy.jd2.dto.Person;
import by.it.academy.jd2.service.PersonService;
import by.it.academy.jd2.test.A;
import by.it.academy.jd2.test.B;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ScopeTestMain3 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);
        A helloBean1 = context.getBean("a", A.class);
        B helloBean2 = context.getBean("b", B.class);

        System.out.println(helloBean1.toString());

//        PersonService personService = context.getBean("personService", PersonService.class);
//        personService.add(new Person("Jkmuf",32));
//        System.out.println(personService.getData());
       // testSinglton(context);
    }

//    public static void testSinglton(ApplicationContext context) {
//        PersonService personService = context.getBean("personService", PersonService.class);
//        System.out.println(personService.getData());
//    }
}
