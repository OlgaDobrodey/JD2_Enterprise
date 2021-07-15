package by.it_academy.jd2.storage.api;

import by.it_academy.jd2.core.model.Diagnosis;
import by.it_academy.jd2.core.model.MedicalCard;
import by.it_academy.jd2.core.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDiagnosisRepository extends JpaRepository<Diagnosis,Integer> {
    List<Diagnosis> findAllByCard(MedicalCard card);
    Diagnosis findFirstByStatusAndCard(Status status,MedicalCard card);

}