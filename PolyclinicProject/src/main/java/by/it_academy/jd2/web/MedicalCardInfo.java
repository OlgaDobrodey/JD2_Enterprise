package by.it_academy.jd2.web;

import by.it_academy.jd2.core.model.*;
import by.it_academy.jd2.core.service.api.IDiagnosisView;
import by.it_academy.jd2.core.service.api.IMedicalCardView;
import by.it_academy.jd2.core.service.api.IPassportView;
import by.it_academy.jd2.core.service.api.IUserView;
import by.it_academy.jd2.core.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MedicalCardInfo {
    private final IUserView userView;
    private final IPassportView passportView;
    private final IMedicalCardView medicalCardView;
    private final IDiagnosisView diagnosisView;

    public MedicalCardInfo(IUserView userView, IPassportView passportView,
                           IMedicalCardView medicalCardView, IDiagnosisView diagnosisView) {
        this.userView = userView;
        this.passportView = passportView;
        this.medicalCardView = medicalCardView;
        this.diagnosisView = diagnosisView;
    }

    @GetMapping(value = "/{login}/newNote")
    public String setNewNote(Model model) {
        model.addAttribute("doctors", this.userView.searchAllDoctors());
        model.addAttribute("patients", this.userView.searchAllPatients());
        return "/views/medcard/newNote.jsp";
    }

    @PostMapping(value = "/{login}/newNote")
    public String saveNewNote(@RequestParam(name = "doctor") String doctor,
                              @RequestParam(name = "patient") String patient,
                              @RequestParam(name = "diagnosis") String diagnosis,
                              @RequestParam(name = "prescription") String prescription,
                              @RequestParam(name = "status") String status,
                              Model model) {

        final MedicalCard cardSave = medicalCardView.saveMedicalCard(this.userView.searchUserLogin(doctor),
                this.userView.searchUserLogin(patient), diagnosis  );
        model.addAttribute("cardSave", cardSave);

        final Diagnosis diagnosisNew = new Diagnosis();
        diagnosisNew.setMedical_card(cardSave);
        diagnosisNew.setPrescription(prescription);
        diagnosisNew.setDate(LocalDate.now());
        diagnosisNew.setStatus(Status.getStatus(status));
        model.addAttribute("diagnosisSave", this.diagnosisView.savaDiagnosis(diagnosisNew));
        model.addAttribute("doctors", this.userView.searchAllDoctors());
        model.addAttribute("patients", this.userView.searchAllPatients());

        return "/views/medcard/newNote.jsp";
    }

    @GetMapping(value = "/{login}/medicalCart/{id}")
    public String getUserDiagnosis(@PathVariable String login, @PathVariable Integer id, Model model) {

        final MedicalCard medicalCardById = medicalCardView.findMedicalCardById(id);
        final List<Diagnosis> allByCard = diagnosisView.getAllByCard(medicalCardById);

        model.addAttribute("medical_card", medicalCardById);
        model.addAttribute("diagnosis", allByCard);
        model.addAttribute("userPatient", userView.searchUserLogin(login));

        return "/views/users/patientDiagnosis.jsp";
    }

    @GetMapping(value = "/{login}/medicalCart")
    public String getMedicalCart(HttpServletRequest req, Model model, @PathVariable String login) {
        HttpSession session = req.getSession();
        if (session.isNew()) {
            return "/views/indexSignIn.jsp";
        }
        final User user = userView.searchUserLogin(login);
        //  User user = (User) session.getAttribute(Constants.USER);
        Map<MedicalCard, Status> historyMap = new HashMap<>();
        List<MedicalCard> medicalCard = new ArrayList<>();
        if (user.getRole() == Role.PATIENT) {
            medicalCard = medicalCardView.findAllDoctorsForPatient(user);
        }
        if (user.getRole() == Role.DOCTOR) {
            medicalCard = medicalCardView.findAllPatientsForDoctor(user);
        }
        for (MedicalCard card : medicalCard) {
            Diagnosis diagnosis = diagnosisView.getStatusDiagnosis(card, Status.NEGATIV);
            if (diagnosis != null) {
                historyMap.put(card, diagnosis.getStatus());
            } else historyMap.put(card, Status.POSITIV);
        }
        model.addAttribute("history", historyMap);
        return Role.pathRoleUser(user);
    }


}
