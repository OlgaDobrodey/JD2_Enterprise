package by.it_academy.jd2.core.service.medical;

import by.it_academy.jd2.core.model.medical.Diagnosis;
import by.it_academy.jd2.core.model.medical.MedicalCard;
import by.it_academy.jd2.core.model.medical.Status;
import by.it_academy.jd2.core.service.api.medical.IDiagnosisView;
import by.it_academy.jd2.storage.api.medicalCard.IDiagnosisRepository;

import java.util.List;

public class DiagnosisView implements IDiagnosisView {
    private IDiagnosisRepository repository;

    public DiagnosisView(IDiagnosisRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Diagnosis> getAllByCard(MedicalCard card) {
        return this.repository.findAllByCard(card);
    }

    @Override
    public Diagnosis getStatusDiagnosis(MedicalCard card, Status status) {
        return this.repository.findFirstByStatusAndCard(status,card);
    }

    @Override
    public Diagnosis savaDiagnosis(Diagnosis diagnosis) {
        return this.repository.save(diagnosis);
    }
}
