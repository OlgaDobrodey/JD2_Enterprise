package by.it_academy.jd2.web.jsp;


import by.it_academy.jd2.core.model.people.*;
import by.it_academy.jd2.core.service.api.medical.IDiagnosisView;
import by.it_academy.jd2.core.service.api.medical.IMedicalCardView;
import by.it_academy.jd2.core.service.api.people.IAddressView;
import by.it_academy.jd2.core.service.api.people.IPassportView;
import by.it_academy.jd2.core.service.api.people.IUserView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

/**
 * Class Sign Up chat
 */
@Controller
public class NewSave {

    private final IUserView userView;
    private final IPassportView passportView;
    private final IMedicalCardView medicalCardView;
    private final IDiagnosisView diagnosisView;
    private final IAddressView addressView;

    public NewSave(IUserView userView, IPassportView passportView, IMedicalCardView medicalCardView, IDiagnosisView diagnosisView, IAddressView addressView) {
        this.userView = userView;
        this.passportView = passportView;
        this.medicalCardView = medicalCardView;
        this.diagnosisView = diagnosisView;
        this.addressView = addressView;
    }

    @GetMapping(value = "/signUp")
    public String checkRegistration(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session.isNew()) {
            return "/views/indexSignIn.jsp";
        }
        return "/views/indexSignUp.jsp";

    }

    @GetMapping(value = "/departament")
    public String setNewDepartamenr(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session.isNew()) {
            return "/views/indexSignIn.jsp";
        }
        return "/views/indexSignUp.jsp";

    }


}

