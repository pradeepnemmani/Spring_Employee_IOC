package service;

import annotation.Transactional;
import model.Address;
import model.Company;
import model.Employee;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by deep's on 5/1/2016.
 */

@Component
public class CompanyRepository {
    @Autowired
    public EmployeeService employeeService;
    @Autowired
    private CompanyService companyService;

    private Set<Company> companies;
    private Random randomCid;

    public CompanyRepository() throws InterruptedException {
        super();
//        Thread.currentThread().sleep(1000);

        companies = new HashSet<Company>();

        randomCid = new Random(1000);
        System.out.println("----------------------------Company Repository Bean created-------------------------------------------");
    }

    public Company createCompany(String name, Person ceo, Address address) {
        Company company = companyService.createCompany(name, ceo, address);
        return company;
    }

    @Transactional
    public String addCompany(Company company) {
        String cId = null;
        if (company != null) {
            int comId = randomCid.nextInt();
            cId = "CMP-" + comId;
            company.setcId(cId);
            companies.add(company);
        }
        return cId;
    }

    @Transactional
    public String addEmployee(Person person, String companyId) {
        Company company = null;
        String eId = null;
        if (person != null && companyId != null) {
            if (companies != null) {
                for (Company cmp : companies) {
                    if (cmp.getcId().equals(companyId)) {
                        company = cmp;
                        break;
                    }
                }
            }
        }
        if (company != null) {
            Employee employee = employeeService.createEmployee(person);
            if (employee != null) {
                company.getEmployees().add(employee);
                eId = employee.geteId();
            }
        }
        return eId;
    }

    public Company getCompany(String cId) {
        Company company = null;
        if (companies != null) {
            for (Company cmp : companies) {
                if (cmp.getcId().equals(cId)) {
                    company = cmp;
                }
            }
        }
        return company;
    }

    public String removeCompany(String cId) {
        Company company = null;
        String message = null;
        if (companies != null) {
            for (Company cmp : companies) {
                if (cmp.getcId().equals(cId)) {
                    company = cmp;
                    break;
                }
            }
        }
        if (company != null) {
            companies.remove(company);
            message = "COMPANY REMOVED";
        } else {
            message = "COMPANY NOT FOUND";
        }
        return message;

    }

    public Set<Company> getAllCompanies() {
        return companies;
    }
}
