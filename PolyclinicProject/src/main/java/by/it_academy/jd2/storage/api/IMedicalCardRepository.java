package by.it_academy.jd2.storage.api;


import by.it_academy.jd2.core.model.MedicalCard;
import by.it_academy.jd2.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMedicalCardRepository extends JpaRepository<MedicalCard,Integer> {
    List<MedicalCard> findAllByPatient(User user);
    List<MedicalCard> findAllByDoctor(User user);
    MedicalCard findMedicalCardById(Integer id);
}
