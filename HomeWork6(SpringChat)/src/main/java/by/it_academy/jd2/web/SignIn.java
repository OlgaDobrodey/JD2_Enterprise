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


import java.io.IOException;

/**
 * Class Sign In chat
 */
@Controller
@RequestMapping(value = "/signIn")
public class SignIn extends HttpServlet {

    private final IUserView userView;

    public SignIn(IUserView userView) {
        this.userView = userView;
    }

    @GetMapping
    public String doCheckAuthorization(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (!session.isNew()) {
            session.removeAttribute(Constants.USER_SENDER);
        }
        return "/indexSignIn.jsp";
    }

    @PostMapping
    protected String doGetAuthorization(Model model,
                                        @RequestParam(name = Constants.LOGIN) String login,
                                        @RequestParam(name = Constants.PASSWORD) String psw,
                                        HttpServletRequest req) {

        User user = userView.searchUserLoginAndPsw(login, psw);

        if (user != null) {
            req.getSession().setAttribute(Constants.USER_SENDER, user);
            return "/indexMenu.jsp";
        } else {
            model.addAttribute("invalidUserLogin", true);      // Дополнительного комментарий "Не верный логин или пароль"                                      // Авторизация не выполнена, попробуйте снова!
            return "/indexSignIn.jsp";

        }

    }
}

