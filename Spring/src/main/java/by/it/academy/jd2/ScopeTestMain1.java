package by.it.academy.jd2;

import by.it.academy.jd2.dto.Person;
import by.it.academy.jd2.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTestMain1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ScopeTest.xml");
        PersonService personService = context.getBean("personService", PersonService.class);
        personService.add(new Person("Jkmuf",32));
        System.out.println(personService.getData());
        testSinglton(context);
    }

    public static void testSinglton(ApplicationContext context) {
        PersonService personService = context.getBean("personService", PersonService.class);
        System.out.println(personService.getData());
    }
}
