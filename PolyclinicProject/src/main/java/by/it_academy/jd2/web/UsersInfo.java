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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
public class UsersInfo {

    private final IUserView userView;
    private final IPassportView passportView;
    private final IMedicalCardView medicalCardView;
    private final IDiagnosisView diagnosisView;

    public UsersInfo(IUserView userView, IPassportView passportView, IMedicalCardView medicalCardView, IDiagnosisView diagnosisView) {
        this.userView = userView;
        this.passportView = passportView;
        this.medicalCardView = medicalCardView;
        this.diagnosisView = diagnosisView;
    }

    @GetMapping(value = "/{user}")
    public String acountClinet(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        if (session.isNew()) {
            return "/views/indexSignIn.jsp";
        }
        User user = (User) session.getAttribute(Constants.USER);
        return Role.pathRoleUser((User) session.getAttribute(Constants.USER));
    }


    @GetMapping(value = "/{user}/passport")
    public String getUserPassport(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        if (session.isNew()) {
            return "/views/indexSignIn.jsp";
        }
        User user = (User) session.getAttribute(Constants.USER);
        Passport passport = passportView.findPassport(user);
        // String passport = "PASSPORT";
        model.addAttribute("passport", passport);
        return Role.pathRoleUser(user);
    }

    @GetMapping(value = "/doctor/{login}")
    public String getCardDoctor(Model model, @PathVariable String login) {
        model.addAttribute("doctor", this.userView.searchUserLogin(login));
        return "/views/users/cardUser.jsp";
    }

    @GetMapping(value = "/patient/{login}")
    public String getCardPatient(Model model, @PathVariable String login) {
        User user = this.userView.searchUserLogin(login);
        List<MedicalCard> card =this.medicalCardView.findAllDoctorsForPatient(user);
        Map<MedicalCard, List< Diagnosis>> historyMap = new HashMap<>();
        for (MedicalCard medicalCard : card) {
           List< Diagnosis> diagnosis = diagnosisView.getAllByCard(medicalCard);
           historyMap.put(medicalCard,diagnosis);

        }

        model.addAttribute("userCard", user);
        model.addAttribute("passport", this.passportView.findPassport(user));
        model.addAttribute("history",historyMap);

        return "/views/users/cardUser.jsp";
    }



}
