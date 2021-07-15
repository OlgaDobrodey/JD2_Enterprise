package by.it_academy.jd2.web;


import by.it_academy.jd2.core.model.*;
import by.it_academy.jd2.core.service.api.*;
import by.it_academy.jd2.core.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

/**
 * Class Sign Up chat
 */
@Controller
public class SignUp {

    private final IUserView userView;
    private final IPassportView passportView;
    private final IMedicalCardView medicalCardView;
    private final IDiagnosisView diagnosisView;
    private final IAddressView addressView;

    public SignUp(IUserView userView, IPassportView passportView, IMedicalCardView medicalCardView, IDiagnosisView diagnosisView, IAddressView addressView) {
        this.userView = userView;
        this.passportView = passportView;
        this.medicalCardView = medicalCardView;
        this.diagnosisView = diagnosisView;
        this.addressView = addressView;
    }

    @GetMapping(value = "/signUp")
    public String checkRegistration(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (session.isNew()) {
            return "/views/indexSignIn.jsp";
        }
        return "/views/indexSignUp.jsp";

    }

//    @PostMapping(value = "/signUp")
//    protected String getRegistration(Model model,
//                                     @RequestParam(name = Constants.LOGIN) String login,
//                                     @RequestParam(name = Constants.PASSWORD) String psw,
//                                     @RequestParam(name = Constants.NAME) String name,
//                                     @RequestParam(name = Constants.PHONE) String phone,
//                                     HttpServletRequest req){
//
//        User user = new User();
//        user.setLogin(login);
//        user.setPassword(psw);
//        user.setSurname(name);
//      //  user.setGiven_name();
//        user.setPhone(phone);
//
//        User userSearch = userView.searchUserLogin(user.getLogin());
//
//        if (userSearch != null) {
//            model.addAttribute("invalidUserLogin", true);
//            return "/indexSignUp.jsp";
//        }
//        //userView.saveUsers(user);
//
//        req.getSession().setAttribute(Constants.USER, user);
//        return "/indexSignUp.jsp";
//    }

    @GetMapping(value = "/newUser")
    public String setNewNote(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (session.isNew()) {
            return "/views/indexSignIn.jsp";
        }
        model.addAttribute("roleList", Role.values());
        model.addAttribute("sexList", Sex.values());
        return "/views/users/newUser.jsp";
    }

    @PostMapping(value = "/newUser")
    public String saveNewNote(@RequestParam(name = "login") String login,
                              @RequestParam(name = "password") String password,
                              @RequestParam(name = "surname") String surname,
                              @RequestParam(name = "given_name") String given_name,
                              @RequestParam(name = "role") String role,
                              @RequestParam(name = "position") String position,
                              @RequestParam(name = "phone") String phone,
                              @RequestParam(name = "email") String email,
                              @RequestParam(name = "city") String city,
                              @RequestParam(name = "street") String street,
                              @RequestParam(name = "house") String house,
                              @RequestParam(name = "flat") String flat,
                              @RequestParam(name = "id_passport") String id_passport,
                              @RequestParam(name = "identification") String identification,
                              @RequestParam(name = "code_state") String code_state,
                              @RequestParam(name = "nationality") String nationality,
                              @RequestParam(name = "date_birthday") String date_birthday_string,
                              @RequestParam(name = "place_birth") String place_birth,
                              @RequestParam(name = "data_issue") String data_issue_string,
                              @RequestParam(name = "data_expiry") String data_expiry_string,
                              @RequestParam(name = "sex") String sex_string,
                              @RequestParam(name = "info") String info,
                              Model model) {
        if (this.userView.searchUserLoginAndPsw(login, password) != null) {
            model.addAttribute("errorLogin", "error");
            model.addAttribute("roleList", Role.values());
            model.addAttribute("sexList", Sex.values());
            return "/views/users/newUser.jsp";
        }
        if (this.passportView.findPassportByIdOrIdentification(id_passport, identification)) {
            model.addAttribute("errorPassport", "error");
            model.addAttribute("roleList", Role.values());
            model.addAttribute("sexList", Sex.values());
            return "/views/users/newUser.jsp";
        }
        Address addressSave = this.addressView.saveAddress(
                city.isBlank() ? null : city,
                street.isBlank() ? null : street,
                house.isBlank() ? null : house,
                flat.isBlank() ? null : flat);

        final Role valueOf = Role.valueOf(role);
        User user = this.userView.saveUser(login, password, valueOf, surname, given_name,
                email.isBlank() ? null : email, phone, info.isBlank() ? null : info, position.isBlank() ? null : position, addressSave);

        Sex sex = Sex.valueOf(sex_string);
        LocalDate date_birthday = LocalDate.parse(date_birthday_string);
        LocalDate data_expiry = LocalDate.parse(data_expiry_string);
        LocalDate data_issue = LocalDate.parse(data_issue_string);

        Passport passportSave = this.passportView.savePassport(id_passport, identification, code_state, nationality, date_birthday, sex, data_issue, data_expiry, place_birth, user);

        model.addAttribute("userCard", user);
        model.addAttribute("passport", passportSave);

        return "/views/users/cardUser.jsp";
    }


}

