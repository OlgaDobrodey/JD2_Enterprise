package by.it_academy.jd2.core.service.api.medical;

import by.it_academy.jd2.core.model.medical.Diagnosis;
import by.it_academy.jd2.core.model.medical.MedicalCard;
import by.it_academy.jd2.core.model.medical.Status;

import java.util.List;

public interface IDiagnosisView {
    List<Diagnosis> getAllByCard(MedicalCard card);
    Diagnosis getStatusDiagnosis(MedicalCard card, Status status);
    Diagnosis savaDiagnosis(Diagnosis diagnosis);
}
