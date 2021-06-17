package by.it.academy.jd2.service;

import by.it.academy.jd2.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonService {
    private List<Person> data = new ArrayList<>();
@Autowired
    public PersonService(@Qualifier(value = "personService") Person data) {
        this.data.add(data);
    }

    public void add(Person person){
        this.data.add(person);
    }

    public List<Person> getData() {
        return data;
    }
}
