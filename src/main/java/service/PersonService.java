package service;

import model.Address;
import model.Person;
import org.springframework.stereotype.Component;

/**
 * Created by deep's on 5/1/2016.
 */
@Component
public class PersonService {
    public PersonService() {
        super();
        System.out.println("-----------------------------------Person Service Bean created------------------------------");
    }

    public Person createPerson(String fName, String lName, Address address, String phNo) {
        Person person = new Person();
        person.setAddress(address);
        person.setFirstName(fName);
        person.setLastName(lName);
        person.setPhNo(phNo);
        return person;
    }
}

