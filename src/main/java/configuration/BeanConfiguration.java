package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import service.repository.CompanyRepository;
import service.AddressService;
import service.CompanyService;
import service.EmployeeService;
import service.PersonService;

/**
 * Created by deep's on 5/1/2016.
 */
@Configuration
@ComponentScan(basePackages = {"service"})
@EnableAspectJAutoProxy
public class BeanConfiguration {

    public BeanConfiguration() {
        System.out.println("----------Bean Configuration Instance created----------------");
    }


//    @Bean
//    public PersonService personService() {
//        System.out.println("*******Person Service Bean initialised**********");
//        return new PersonService();
//    }
//
//    @Bean
//    public AddressService addressService() {
//        System.out.println("*******Address Service Service Bean initialised**********");
//        return new AddressService();
//    }
//
//    @Bean
//    public EmployeeService employeeService() {
//        System.out.println("*******Employee Service Bean initialised**********");
//        return new EmployeeService();
//    }
//
//    @Bean
//    public CompanyService companyService() {
//        System.out.println("*******Company Service Bean initialised**********");
//        return new CompanyService();
//    }


}
