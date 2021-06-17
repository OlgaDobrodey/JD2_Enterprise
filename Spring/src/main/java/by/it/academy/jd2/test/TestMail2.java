package by.it.academy.jd2.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMail2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        A helloBean = context.getBean("hello", A.class);

        System.out.println(helloBean);
    }
}
