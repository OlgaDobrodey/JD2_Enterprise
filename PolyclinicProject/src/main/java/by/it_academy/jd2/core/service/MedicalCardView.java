package by.it_academy.jd2.core.service;

import by.it_academy.jd2.core.model.medical.Diagnosis;
import by.it_academy.jd2.core.model.medical.MedicalCard;
import by.it_academy.jd2.core.model.medical.Status;
import by.it_academy.jd2.core.model.people.User;
import by.it_academy.jd2.core.service.api.IMedicalCardView;
import by.it_academy.jd2.storage.api.IDiagnosisRepository;
import by.it_academy.jd2.storage.api.IMedicalCardRepository;

import java.util.Collections;
import java.util.List;

public class MedicalCardView implements IMedicalCardView {
    private IMedicalCardRepository repository;
    private IDiagnosisRepository diagnosisRepository;

    public MedicalCardView(IMedicalCardRepository repository, IDiagnosisRepository diagnosisRepository) {
        this.repository = repository;
        this.diagnosisRepository = diagnosisRepository;
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

    @Override
    public List<MedicalCard> findMedicalCardForCard(User doctor, User patient, String diagnosis) {
        return this.repository.findMedicalCardByDoctorAndPatientAndDiagnosis(doctor,
                patient, diagnosis);
    }

    @Override
    public MedicalCard saveMedicalCard(User doctor, User patient, String diagnosis) {
        final List<MedicalCard> medicalCards = findMedicalCardForCard(doctor,
                patient, diagnosis);

        if (medicalCards.size() != 0) {
            for (MedicalCard medicalCard : medicalCards) {
                final List<Diagnosis> allByCard = this.diagnosisRepository.findAllByCard(medicalCard);
                 Diagnosis max = Collections.max(allByCard);
                 if(max.getStatus() == Status.POSITIV){return medicalCard;}

            }
        }
        MedicalCard card = new MedicalCard();
        card.setDoctor(doctor);
        card.setPatient(patient);
        card.setDiagnosis(diagnosis);
        return this.repository.save(card);
    }


}
