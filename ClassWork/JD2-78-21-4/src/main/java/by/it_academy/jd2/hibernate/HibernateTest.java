package by.it_academy.jd2.hibernate;

import by.it_academy.jd2.core.dto.Person;
import by.it_academy.jd2.dao.HibernateCreator;
import org.hibernate.Session;

public class HibernateTest {
    public static void main(String[] args) {
        Session session = HibernateCreator.getInstance().openSession();
        Person person = new Person();
        person.setAge(33);
        person.setFirstName("Olga");
        person.setLastName("Hurkovskaya");

        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
    }
}
