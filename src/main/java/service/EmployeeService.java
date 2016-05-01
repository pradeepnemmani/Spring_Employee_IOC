package service;

import model.Employee;
import model.Person;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by deep's on 5/1/2016.
 */
@Component
public class EmployeeService {
    private Random randomEid;

//    static {
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@Inside Static Block@@@@@@@@@@@@@@@@@@@");
//        try {
//            Thread.currentThread().sleep(100000);
//        } catch (InterruptedException ie) {
//            ie.printStackTrace();
//        }
//    }

    public EmployeeService() {
        super();
        randomEid = new Random(10000);
        System.out.println("--------------------------Employee Service Bean Created----------------------------");
    }

    public Employee createEmployee(Person person) {
        Employee employee = null;
        if (person != null) {
            employee = new Employee();
            employee.setFirstName(person.getFirstName());
            employee.setLastName(person.getLastName());
            employee.setAddress(person.getAddress());
            if (employee != null) {
                employee.seteId("EMP-" + randomEid.nextInt());
            }
        }
        return employee;
    }
}
