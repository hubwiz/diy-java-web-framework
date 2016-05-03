package com.demo.web.service;

import java.util.ArrayList;
import java.util.List;

import com.demo.web.entity.Person;
import com.hubwiz.web.annotation.Service;

@Service
public class PersonService {


    public List<Person> getPersons(){
        List<Person> persons = new ArrayList<>();
        Person person = new Person();
        person.setName("Zhang San");
        person.setTelephone("13565654747");
        person.setEmail("zsan@exmaple.com");
        persons.add(person);
        Person person1 = new Person();
        person1.setName("Li Si");
        person1.setTelephone("13589651478");
        person1.setEmail("lsi@exmaple.com");
        persons.add(person1);
        return persons;
    }
    
}
