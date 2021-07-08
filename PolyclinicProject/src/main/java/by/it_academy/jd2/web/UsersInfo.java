package by.it_academy.jd2.web;

import by.it_academy.jd2.core.model.Role;
import by.it_academy.jd2.core.model.User;
import by.it_academy.jd2.core.service.api.IUserView;
import by.it_academy.jd2.core.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class UsersInfo {

    private final IUserView userView;

    public UsersInfo(IUserView userView) {
        this.userView = userView;
    }

    @GetMapping(value = "/{user}")
    public String acountClinet(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (session.isNew()) {
            return "/views/indexSignIn.jsp";
        }
        return Role.pathRoleUser((User) session.getAttribute(Constants.USER));
    }

    @GetMapping(value = "/{user}/medicalCart")
    public String getMedicalCart(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        if (session.isNew()) {
            return "/views/indexSignIn.jsp";
        }
        User user = (User) session.getAttribute(Constants.USER);
        String medCart = "History disease client";
        model.addAttribute("history", medCart);
        return Role.pathRoleUser(user);
    }

    @GetMapping(value = "/{user}/passport")
    public String getUserPassport(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        if (session.isNew()) {
            return "/views/indexSignIn.jsp";
        }
        User user = (User) session.getAttribute(Constants.USER);
        String passport = "TODO Passport";
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
        model.addAttribute("patient", this.userView.searchUserLogin(login));
        return "/views/users/cardUser.jsp";
    }




}
