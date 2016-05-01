package TestEmployee;

//import ser.CompanyRepository;
import model.Address;
import model.Company;
import model.Employee;
import model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.*;

import java.util.List;
import java.util.Set;

/**
 * Created by deep's on 5/1/2016.
 */
public class TestEmployee {
    public static void main(String[] args) {
        System.out.println("In main");
        PersonService personService = null;
        AddressService addressService = null;
        CompanyService companyService = null;
        EmployeeService employeeService = null;
        CompanyRepository companyRepository = null;
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aspect.xml");
        Object personServiceObj = applicationContext.getBean("personService");
        Object addressServiceObj = applicationContext.getBean("addressService");
        Object companyRepositoryObj = applicationContext.getBean("companyRepository");
        Object employeeServiceObj = applicationContext.getBean("employeeService");
        Object companyServiceObj = applicationContext.getBean("companyService");
        if (personServiceObj instanceof PersonService) {
            personService = (PersonService) personServiceObj;
        }
        if (addressServiceObj instanceof AddressService) {
            addressService = (AddressService) addressServiceObj;
        }
        if (employeeServiceObj instanceof EmployeeService) {
            employeeService = (EmployeeService) employeeServiceObj;
        }
        if (companyRepositoryObj instanceof CompanyRepository) {
            companyRepository = (CompanyRepository) companyRepositoryObj;
        }
        if (companyServiceObj instanceof CompanyService) {
            companyService = (CompanyService) companyServiceObj;
        }

        if (personService != null && addressService != null && companyService != null && employeeService != null && companyRepository != null) {
            //All services and respected beans have been created.

            //Creating Address Object Using AddressService
            Address ceoAddress = addressService.createAddress("5-11-284", "Madhapur ", "Hyderbad", "Hyderabad", "Telangana", "India");
            Address genAddress = addressService.createAddress("5-435-223484", "Madhapur ", "Hyderbad", "Hyderabad", "Telangana", "India");

            Address pradeepAddress = addressService.createAddress("5-11-284", "Shanti Nagar", "Shanti Nagar", "Nalgonda", "Telangana", "India");
            //creating Person  Object using Person Service.
            Person pradeep = personService.createPerson("Pradeep", "Nemmani", pradeepAddress, "9000128263");
            Person syam = personService.createPerson("Syam", "Akyana", genAddress, "98276522545");
            Person lalitha = personService.createPerson("Lalitha", "Bhargavi", genAddress, "834659823465");
            Person madhav = personService.createPerson("Madhav", "Some Last Name", genAddress, "90735843722");

            Person ceo = personService.createPerson("Nalluri", "Nalluri", ceoAddress, "98634428742");

            //creating Company Object using CompanyService
            Company nalsoft = companyRepository.createCompany("Nalsoft Pvt Ltd", ceo, ceoAddress);
            String nalsoftId = companyRepository.addCompany(nalsoft);


            System.out.println(nalsoftId);


            companyRepository.addEmployee(pradeep, nalsoftId);
            companyRepository.addEmployee(syam, nalsoftId);
            companyRepository.addEmployee(lalitha, nalsoftId);
            companyRepository.addEmployee(madhav, nalsoftId);

            Company nalsoftCmp = companyRepository.getCompany(nalsoftId);
            System.out.println(nalsoftCmp.getName());
            int empSize = nalsoftCmp.getEmployees().size();

            System.out.println(empSize);


            Person iSpaceCeo = personService.createPerson("iSpace Ceo", "Some Last Name", genAddress, "54352q454");
            Company iSpace = companyRepository.createCompany("ISpace", iSpaceCeo, genAddress);
            String iSpaceId = companyRepository.addCompany(iSpace);
            System.out.println(iSpaceId);


            Person a = personService.createPerson("a", "Some", pradeepAddress, "9000128263");
            Person b = personService.createPerson("b", "some", genAddress, "98276522545");
            Person c = personService.createPerson("c", "Some", genAddress, "834659823465");
            Person d = personService.createPerson("d", "Some Last Name", genAddress, "90735843722");

            companyRepository.addEmployee(a, iSpaceId);
            companyRepository.addEmployee(b, iSpaceId);
            companyRepository.addEmployee(c, iSpaceId);
            companyRepository.addEmployee(a, iSpaceId);
            companyRepository.addEmployee(b, iSpaceId);
            companyRepository.addEmployee(c, iSpaceId);

            companyRepository.addEmployee(b, iSpaceId);

            Set<Company> companies = companyRepository.getAllCompanies();
            for (Company company : companies) {
                System.out.println(company.getName());
                System.out.println(company.getCeo().getFirstName());
                System.out.println(company.getcId());
                System.out.println("-------------------------------");
                List<Employee> employeess = company.getEmployees();
                System.out.println("Total Employess=="+employeess.size());
                for(Employee employee :employeess) {
                    System.out.println(employee.getFirstName());
                    System.out.println(employee.geteId());
                }
                System.out.println("****************** End Of Company **************");
            }
        }
    }

}
