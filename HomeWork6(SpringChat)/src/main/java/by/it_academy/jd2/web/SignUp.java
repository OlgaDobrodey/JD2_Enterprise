package by.it_academy.jd2.web;

import by.it_academy.jd2.core.tool.api.IUserView;
import by.it_academy.jd2.core.utils.Constants;
import by.it_academy.jd2.core.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Class Sign Up chat
 */
@Controller
@RequestMapping(value = "/signUp")
public class SignUp extends HttpServlet {

    public SignUp(IUserView userView) {
        this.userView = userView;
    }

    private final IUserView userView;

    @GetMapping
    public String checkRegistration(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (!session.isNew()) {
            session.removeAttribute(Constants.USER_SENDER);
        }
        return "/indexSignUp.jsp";

    }

    @PostMapping
    protected String getRegistration(Model model,
                                     @RequestParam(name = Constants.LOGIN) String login,
                                     @RequestParam(name = Constants.PASSWORD) String psw,
                                     @RequestParam(name = Constants.NAME) String name,
                                     @RequestParam(name = Constants.BIRTHDAY) String birthday,
                                     HttpServletRequest req){

        User user = new User();
        user.setLogin(login);
        user.setPassword(psw);
        user.setName(name);
        user.setBirthday(birthday);

        User userSearch = userView.searchUserLogin(user.getLogin());

        if (userSearch != null) {
            model.addAttribute("invalidUserLogin", true);
            return "/indexSignUp.jsp";
        }
        userView.saveUsers(user);

        req.getSession().setAttribute(Constants.USER_SENDER, user);
        return "/indexMenu.jsp";
    }
}

