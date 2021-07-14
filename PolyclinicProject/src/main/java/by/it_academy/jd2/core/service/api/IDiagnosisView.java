package by.it_academy.jd2.core.service.api;

import by.it_academy.jd2.core.model.Diagnosis;
import by.it_academy.jd2.core.model.MedicalCard;
import by.it_academy.jd2.core.model.Status;

import java.util.List;

public interface IDiagnosisView {
    List<Diagnosis> getAllByCard(MedicalCard card);
    Diagnosis getStatusDiagnosis(MedicalCard card, Status status);
}
