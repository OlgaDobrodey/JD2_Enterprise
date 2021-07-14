package by.it_academy.jd2.web;

import by.it_academy.jd2.core.model.Role;
import by.it_academy.jd2.core.service.api.IPassportView;
import by.it_academy.jd2.core.service.api.IUserView;
import by.it_academy.jd2.core.utils.Constants;
import by.it_academy.jd2.core.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Class Sign In chat
 */
@Controller
public class SignIn {

    private final IUserView userView;
    private final IPassportView passportView;

    public SignIn(IUserView userView,IPassportView passportView) {
        this.userView = userView;
        this.passportView = passportView;
    }

    @GetMapping(value = "/signIn")
    public String doCheckAuthorization(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (!session.isNew()) {
            session.removeAttribute(Constants.USER);
        }
        return "/views/indexSignIn.jsp";
    }

    @PostMapping(value = "/signIn")
    protected String doGetAuthorization(Model model,
                                        @RequestParam(name = Constants.LOGIN) String login,
                                        @RequestParam(name = Constants.PASSWORD) String psw,
                                        HttpServletRequest req) {

        User user = userView.searchUserLoginAndPsw(login, psw);

        if (user != null) {
            req.getSession().setAttribute(Constants.PASSPORT,passportView.findPassport(user));
            req.getSession().setAttribute(Constants.USER, user);
            return Role.pathRoleUser(user);
        } else {

            model.addAttribute("invalidUserLogin", true);      // Дополнительного комментарий "Не верный логин или пароль"                                      // Авторизация не выполнена, попробуйте снова!
            return "/views/indexSignIn.jsp";

        }
    }

}


