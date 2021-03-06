package by.it_academy.jd2.web.jsp;


import by.it_academy.jd2.core.model.people.Role;
import by.it_academy.jd2.core.model.people.Sex;
import by.it_academy.jd2.core.model.people.User;
import by.it_academy.jd2.core.service.api.people.IAddressView;
import by.it_academy.jd2.core.service.api.medical.IDepartementView;
import by.it_academy.jd2.core.service.api.people.IPassportView;
import by.it_academy.jd2.core.service.api.people.IUserView;
import by.it_academy.jd2.core.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @GetMapping(value = "/about_us")
    public String aboutUs(Model model) {
        model.addAttribute("doctors", userView.searchAllDoctors());
        return "menu/aboutUs";
    }

    @GetMapping(value = "/users")
    public String getAllPatients(HttpServletRequest req, Model model) {
        User user = (User) req.getSession().getAttribute(Constants.USER);

        model.addAttribute("roleList", Role.values());
        model.addAttribute("users", this.userView.getAllUsers());
        return "menu/allUsers";
    }

    @GetMapping(value = "/home")
    public String home() {
        return "menu/home";
    }

    @GetMapping(value = "/contact")
    public String contact() {
        return "menu/contact";
    }

    @GetMapping(value = "/disease")
    public String disease() {
        return "menu/disease";
    }

    @GetMapping(value = "/departments")
    public String departments(Model model) {
        model.addAttribute("department", this.departementView.findAll());
        return "menu/departments";
    }


    @GetMapping(value = "/passports")
    public String getAllPassports(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session.isNew()) {
            return "/views/indexSignIn.jsp";
        }
        User user = (User) session.getAttribute(Constants.USER);

        model.addAttribute("userList", this.userView.getAllUsers());
        model.addAttribute("sexList", Sex.values());

        model.addAttribute("passports", passportView.findAllPassport());
        return "menu/allPassports";
    }

    @GetMapping(value = "/address")
    public String getAllAddress(Model model) {
        model.addAttribute("userList", userView.getAllUsers());
        model.addAttribute("address", addressView.findAllAddress());
        return "menu/allAddress";
    }

    @GetMapping(value = "/departments/{idDepartments}")
    public String departments(Model model, @PathVariable String idDepartments) {
        model.addAttribute("department", this.departementView.findAll());
        model.addAttribute("departmentSearch", this.departementView.findDepartamentById(idDepartments));
        return "menu/departments";
    }


}
