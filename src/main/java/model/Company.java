package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by deep's on 5/1/2016.
 */
public class Company {
    private String name;
    private String cId;
    private Person ceo;
    private Address address;
    private List<Employee> employees;

    public Company() {
        employees = new ArrayList<Employee>();
    }

    public Company(Person ceo, String cId) {
        this.ceo = ceo;
        this.cId = cId;
        employees = new ArrayList<Employee>();
    }

    public Company(Address address, String cId, Person ceo) {
        this.address = address;
        this.cId = cId;
        this.ceo = ceo;
        employees = new ArrayList<Employee>();
    }

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public Person getCeo() {
        return ceo;
    }

    public void setCeo(Person ceo) {
        this.ceo = ceo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
