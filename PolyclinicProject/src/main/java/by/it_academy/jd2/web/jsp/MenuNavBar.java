package by.it_academy.jd2.web.jsp;


import by.it_academy.jd2.core.model.menu.Department;
import by.it_academy.jd2.core.service.api.IAddressView;
import by.it_academy.jd2.core.service.api.IDepartementView;
import by.it_academy.jd2.core.service.api.IPassportView;
import by.it_academy.jd2.core.service.api.IUserView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServlet;

/**
 * Class send on form menu
 */
@Controller
public class MenuNavBar extends HttpServlet {
    private final IUserView userView;
private final IPassportView passportView;
    private final IAddressView addressView;
    private final IDepartementView departementView;

    public MenuNavBar(IUserView userView, IPassportView passportView, IAddressView addressView, IDepartementView departementView) {
        this.userView = userView;
        this.passportView = passportView;
        this.addressView = addressView;
        this.departementView = departementView;
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
        return "/views/menu/home.jsp";
    }
    @GetMapping(value = "/Contact")
    public String contact(Model model) {
        return "/views/menu/contact.jsp";
    }
    @GetMapping(value = "/Disease")
    public String disease(Model model) {
        // model.addAttribute("doctors", userView.searchAllDoctors());
        return "/views/menu/disease.jsp";
    }
    @GetMapping(value = "/Departments")
    public String departments(Model model) {
        model.addAttribute("department", this.departementView.findAll());
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

    @GetMapping(value = "/Departments/{idDepartments}")
    public String departments(Model model, @PathVariable String idDepartments) {
        model.addAttribute("department", this.departementView.findAll());
        model.addAttribute("departmentSearch", this.departementView.findDepartamentById(idDepartments));
        return "/views/menu/departments.jsp";
    }




}
