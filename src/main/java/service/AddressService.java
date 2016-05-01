package service;

import model.Address;
import org.springframework.stereotype.Component;

/**
 * Created by deep's on 5/1/2016.
 */
@Component
public class AddressService {
    public AddressService() {
        super();
        System.out.println("----------------------Address Service Bean Created--------------");
    }

    public Address createAddress(String hNo, String area, String street, String city, String state, String country) {
        Address address = new Address();
        address.sethNo(hNo);
        address.setArea(area);
        address.setCity(city);
        address.setCountry(country);
        address.setState(state);
        address.setStreet(street);
        return address;
    }
}
