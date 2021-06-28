package by.it_academy.jd2.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServlet;

/**
 * Class send on form menu
 */
@Controller
@RequestMapping(value = "/menu")
public class ServletMenu extends HttpServlet {
    @GetMapping
    protected String goMenu()  {
        return "/indexMenu.jsp";
    }
}
