package by.it_academy.jd2.web;


import by.it_academy.jd2.core.service.api.IUserView;
import by.it_academy.jd2.core.utils.Constants;
import by.it_academy.jd2.core.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Class Sign Up chat
 */
@Controller
public class SignUp{

    public SignUp(IUserView userView) {
        this.userView = userView;
    }

    private final IUserView userView;

    @GetMapping(value ="/signUp" )
    public String checkRegistration(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (!session.isNew()) {
            session.removeAttribute(Constants.USER);
        }
        return "/views/indexSignUp.jsp";

    }

    @PostMapping(value = "/signUp")
    protected String getRegistration(Model model,
                                     @RequestParam(name = Constants.LOGIN) String login,
                                     @RequestParam(name = Constants.PASSWORD) String psw,
                                     @RequestParam(name = Constants.NAME) String name,
                                     @RequestParam(name = Constants.PHONE) String phone,
                                     HttpServletRequest req){

        User user = new User();
        user.setLogin(login);
        user.setPassword(psw);
        user.setSurname(name);
      //  user.setGiven_name();
        user.setPhone(phone);

        User userSearch = userView.searchUserLogin(user.getLogin());

        if (userSearch != null) {
            model.addAttribute("invalidUserLogin", true);
            return "/indexSignUp.jsp";
        }
        //userView.saveUsers(user);

        req.getSession().setAttribute(Constants.USER, user);
        return "/indexMenu.jsp";
    }
}

