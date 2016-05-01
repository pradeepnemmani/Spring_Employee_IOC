package service;

import annotation.Logging;
import model.Address;
import model.Company;
import model.Person;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by deep's on 5/1/2016.
 */
@Component
public class CompanyService {

//    static {
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@Inside Static Block@@@@@@@@@@@@@@@@@@@");
//        try {
//            Thread.currentThread().sleep(100000);
//        } catch (InterruptedException ie) {
//            ie.printStackTrace();
//        }
//    }

    public CompanyService() {
        super();

        System.out.println("--------------------Company Service Bean Created------------------");
    }
    @Logging
    public Company createCompany(String name, Person ceo, Address address) {
        Company company = new Company();
        company.setName(name);
        company.setAddress(address);
        company.setCeo(ceo);
        return company;
    }
}
