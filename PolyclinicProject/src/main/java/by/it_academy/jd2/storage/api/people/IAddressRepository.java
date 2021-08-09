package by.it_academy.jd2.storage.api.people;

import by.it_academy.jd2.core.model.people.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address,Integer> {
   Address findAddressById(Integer id);

}
