package by.it_academy.jd2.core.service;

import by.it_academy.jd2.core.model.people.Address;
import by.it_academy.jd2.core.service.api.IAddressView;
import by.it_academy.jd2.storage.api.IAddressRepository;

import java.util.List;

public class AddressView implements IAddressView {
    public AddressView(IAddressRepository repository) {
        this.repository = repository;
    }

    private  final IAddressRepository repository;

    @Override
    public List<Address> findAllAddress() {
        return this.repository.findAll();
    }

    @Override
    public Address findAddressWithParameter(String city, String street, String house, String flat) {
        return this.repository.findAddressByCityAndStreetAndHouseAndFlat(city, street, house, flat);
    }

    @Override
    public Address saveAddress(String city, String street, String house, String flat) {
        final Address address = findAddressWithParameter(city, street, house, flat);
        if(address!=null){return address;}
        final Address addressSave = new Address();
        addressSave.setCity(city);
        addressSave.setStreet(street);
        addressSave.setHouse(house);
        addressSave.setFlat(flat);

        return this.repository.save(addressSave);
    }
}
