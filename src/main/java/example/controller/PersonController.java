package example.controller;


import example.domain.Person;
import example.repository.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import example.repository.Personrepository;

import java.util.ArrayList;

@Controller
public class PersonController {

    @Autowired
    private PersonJpaRepository personJpaRepository;

    @Autowired
    private Personrepository personRepository;

    @RequestMapping("/")
    @ResponseBody

    public String test2() {
        Person person = new Person();
        person.setFirstName("First");
        person.setLastName("Test");

        //person.setActorId(actorId)
        //person.setActorId(2l);
       // person.getActorId();
        personRepository.save(person);
        return "OK";
    }
    @RequestMapping(value="/searchbyid{id}")
    @ResponseBody
    public ArrayList<Person> findall(@PathVariable long id) {
        ArrayList<Person> sortedList = new ArrayList<Person>();
        sortedList = personJpaRepository.findById(id);
        sortedList.forEach(System.out::println);
        return sortedList;
    }

    @RequestMapping(value="/searchbynamelike={name}")
    @ResponseBody
    public ArrayList<Person> findall(@PathVariable String name) {
        ArrayList<Person> sortedList = new ArrayList<Person>();
        sortedList = personJpaRepository.findByName(name);
        sortedList.forEach(System.out::println);
        return sortedList;
    }

}
