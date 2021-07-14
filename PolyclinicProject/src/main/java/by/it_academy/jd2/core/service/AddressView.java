package by.it_academy.jd2.core.service;

import by.it_academy.jd2.core.model.Address;
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
}
