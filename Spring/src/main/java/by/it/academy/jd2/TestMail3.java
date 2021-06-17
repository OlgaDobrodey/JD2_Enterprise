package by.it.academy.jd2;

import by.it.academy.jd2.test.A;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMail3 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        A helloBean = context.getBean("hello", A.class);

        System.out.println(helloBean);
    }
}
