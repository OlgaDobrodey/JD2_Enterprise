package by.it_academy.jd2.core.service.api;

import by.it_academy.jd2.core.model.people.Address;

import java.util.List;

public interface IAddressView {
    List<Address> findAllAddress();
    Address findAddressWithParameter(String city, String street, String house, String flat);
    Address saveAddress(String city, String street, String house, String flat);
}
