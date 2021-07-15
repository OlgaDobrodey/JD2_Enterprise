package by.it_academy.jd2.storage.api;

import by.it_academy.jd2.core.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address,Integer> {
    Address findAddressByCityAndStreetAndHouseAndFlat(String city, String street, String house, String flat);
}
