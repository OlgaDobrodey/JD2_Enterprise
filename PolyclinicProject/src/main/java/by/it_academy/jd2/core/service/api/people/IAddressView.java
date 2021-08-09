package by.it_academy.jd2.core.service.api.people;

import by.it_academy.jd2.core.model.people.Address;

import java.util.List;

public interface IAddressView {
    List<Address> findAllAddress();

    Address saveAddress(Address address);
    Address findAddressById(Integer id);
    void deleteAddress(Integer id);
    Address updateAddress(Address address, Integer id);
}
