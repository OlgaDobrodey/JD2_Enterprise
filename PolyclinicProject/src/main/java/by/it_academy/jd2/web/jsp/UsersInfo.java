package by.it_academy.jd2.web.jsp;

import by.it_academy.jd2.core.model.medical.Diagnosis;
import by.it_academy.jd2.core.model.medical.MedicalCard;
import by.it_academy.jd2.core.model.people.Role;
import by.it_academy.jd2.core.model.people.Sex;
import by.it_academy.jd2.core.model.people.User;
import by.it_academy.jd2.core.service.api.medical.IDiagnosisView;
import by.it_academy.jd2.core.service.api.medical.IMedicalCardView;
import by.it_academy.jd2.core.service.api.people.IAddressView;
import by.it_academy.jd2.core.service.api.people.IPassportView;
import by.it_academy.jd2.core.service.api.people.IUserView;
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
    private final IAddressView addressView;


    public UsersInfo(IUserView userView, IPassportView passportView, IMedicalCardView medicalCardView, IDiagnosisView diagnosisView, IAddressView addressView) {
        this.userView = userView;
        this.passportView = passportView;
        this.medicalCardView = medicalCardView;
        this.diagnosisView = diagnosisView;
        this.addressView = addressView;
    }

    @GetMapping(value = "/{user}")
    public String acountClinet(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession(false);
        if (session.isNew()) {
            return "/views/indexSignIn.jsp";
        }
        User user = (User) session.getAttribute(Constants.USER);
        return user.getRole().getPathToProfile();

    }

    @GetMapping(value = "/doctor/{login}")
    public String getCardDoctor(Model model, @PathVariable String login) {
        model.addAttribute("userCard", this.userView.searchUserLogin(login));
        model.addAttribute("doctor", true);
        return "users/cardUser";
    }

    @GetMapping(value = "/patient/{login}")
    public String getCardPatient(Model model, @PathVariable String login) {
        User user = this.userView.searchUserLogin(login);
        List<MedicalCard> card =this.medicalCardView.findAllDoctorsForPatient(user);
        Map<MedicalCard, List<Diagnosis>> historyMap = new HashMap<>();
        for (MedicalCard medicalCard : card) {
           List< Diagnosis> diagnosis = diagnosisView.getAllByCard(medicalCard);
           historyMap.put(medicalCard,diagnosis);

        }

        model.addAttribute("userCard", user);
        model.addAttribute("passport", this.passportView.findPassport(user));
        model.addAttribute("history",historyMap);

        return "users/cardUser";
    }

    @GetMapping(value = "/passports/{id}")
    public String editPassport(Model model, @PathVariable ("id") Integer id){
        model.addAttribute("passport", this.passportView.findPassportById(id));
        model.addAttribute("userList",this.userView.getAllUsers());
        model.addAttribute("sexList", Sex.values());
        return "edit/editPassport";
    }
    @GetMapping(value = "/address/{id}")
    public String editAddress(Model model, @PathVariable ("id") Integer id){
        model.addAttribute("address", this.addressView.findAddressById(id));
        return "edit/editAddress";
    }

    @GetMapping(value = "/users/{id}")
    public String editUser(Model model, @PathVariable ("id") Integer id){
        model.addAttribute("roleList", Role.values());
        model.addAttribute("user", this.userView.findUserById(id));
        return "edit/editUser";
    }





}
