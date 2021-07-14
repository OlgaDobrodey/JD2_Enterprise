package by.it_academy.jd2.core.service;

import by.it_academy.jd2.core.model.MedicalCard;
import by.it_academy.jd2.core.model.User;
import by.it_academy.jd2.core.service.api.IMedicalCardView;
import by.it_academy.jd2.storage.api.IMedicalCardRepository;

import java.util.List;

public class MedicalCardView implements IMedicalCardView {
    private IMedicalCardRepository repository;

    public MedicalCardView(IMedicalCardRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MedicalCard> findAllDoctorsForPatient(User user) {
        return this.repository.findAllByPatient(user);
    }

    @Override
    public List<MedicalCard> findAllPatientsForDoctor(User user) {
        return this.repository.findAllByDoctor(user);
    }

    @Override
    public MedicalCard findMedicalCardById(Integer id) {
        return this.repository.findMedicalCardById(id);
    }
}
