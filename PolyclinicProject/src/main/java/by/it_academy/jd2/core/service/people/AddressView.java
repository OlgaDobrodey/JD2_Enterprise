package by.it_academy.jd2.core.service.people;

import by.it_academy.jd2.core.model.people.Address;
import by.it_academy.jd2.core.model.people.User;
import by.it_academy.jd2.core.service.api.people.IAddressView;
import by.it_academy.jd2.storage.api.people.IAddressRepository;
import by.it_academy.jd2.storage.api.people.IUserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class AddressView implements IAddressView {
    public AddressView(IAddressRepository repository, IUserRepository userRepository) {
        this.userRepository = userRepository;
        this.repository = repository;
    }

    private final IAddressRepository repository;
    private final IUserRepository userRepository;

    @Override
    public List<Address> findAllAddress() {
        return this.repository.findAll(Sort.by(Sort.Direction.ASC, "city"));

    }

    @Override
    public Address saveAddress(Address address) {
        return this.repository.save(address);

    }

    @Override
    public Address findAddressById(Integer id) {
        return this.repository.findAddressById(id);
    }

    @Transactional
    @Override
    public void deleteAddress(Integer id) {
        final Address address = this.repository.findAddressById(id);
        final List<User> allByAddresses = this.userRepository.findAllByAddresses(address);
        allByAddresses.forEach(user -> user.setAddresses(null));
        this.repository.delete(address);
    }

    @Override
    public Address updateAddress(Address address, Integer id) {
        Address addressfind = this.repository.findAddressById(id);
        addressfind.setStreet(address.getStreet());
        addressfind.setCity(address.getCity());
        addressfind.setHouse(address.getHouse());
        addressfind.setFlat(address.getFlat());
        repository.save(addressfind);
        return addressfind;
    }
}
