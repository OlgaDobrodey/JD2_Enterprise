package by.it_academy.jd2.web;


import by.it_academy.jd2.core.service.api.IUserView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;

/**
 * Class send on form menu
 */
@Controller
public class MenuNavBar extends HttpServlet {
    private final IUserView userView;

    public MenuNavBar(IUserView userView) {
        this.userView = userView;
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


//    @GetMapping
//    protected String goMenu() {
//        return "/indexMenu.jsp";
//    }
}
