package by.it_academy.jd2.core.service.api;

import by.it_academy.jd2.core.model.MedicalCard;
import by.it_academy.jd2.core.model.User;

import java.util.List;

public interface IMedicalCardView {
    List<MedicalCard>  findAllDoctorsForPatient(User user);
    List<MedicalCard> findAllPatientsForDoctor(User user);
    MedicalCard findMedicalCardById(Integer id);
}
