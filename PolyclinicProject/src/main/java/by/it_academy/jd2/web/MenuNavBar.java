package by.it_academy.jd2.web;


import by.it_academy.jd2.core.service.api.IAddressView;
import by.it_academy.jd2.core.service.api.IPassportView;
import by.it_academy.jd2.core.service.api.IUserView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServlet;

/**
 * Class send on form menu
 */
@Controller
public class MenuNavBar extends HttpServlet {
    private final IUserView userView;
private final IPassportView passportView;
    private final IAddressView addressView;

    public MenuNavBar(IUserView userView, IPassportView passportView, IAddressView addressView) {
        this.userView = userView;
        this.passportView = passportView;
        this.addressView = addressView;
    }

    @GetMapping(value = "/AboutUs")
    public String aboutUs(Model model) {
        model.addAttribute("doctors", userView.searchAllDoctors());
        return "/views/menu/aboutUs.jsp";
    }
    @GetMapping(value = "/allPatients")
    public String getAllPatients(Model model) {
        model.addAttribute("patients", userView.searchAllPatients());
        return "/views/menu/allPatients.jsp";
    }
    @GetMapping(value = "/Home")
    public String home(Model model) {
       // model.addAttribute("doctors", userView.searchAllDoctors());
        return "/views/menu/home.jsp";
    }
    @GetMapping(value = "/Contact")
    public String contact(Model model) {
        // model.addAttribute("doctors", userView.searchAllDoctors());
        return "/views/menu/contact.jsp";
    }
    @GetMapping(value = "/Disease")
    public String disease(Model model) {
        // model.addAttribute("doctors", userView.searchAllDoctors());
        return "/views/menu/disease.jsp";
    }
    @GetMapping(value = "/Departments")
    public String departments(Model model) {
        // model.addAttribute("doctors", userView.searchAllDoctors());
        return "/views/menu/departments.jsp";
    }

    @GetMapping(value = "/allPassports")
    public String getAllPassports(Model model) {
        model.addAttribute("passports", passportView.findAllPassport());
        return "/views/menu/allPassports.jsp";
    }

    @GetMapping(value = "/allAddress")
    public String getAllAddress(Model model) {
        model.addAttribute("address", addressView.findAllAddress());
        return "/views/menu/allAddress.jsp";
    }



}
