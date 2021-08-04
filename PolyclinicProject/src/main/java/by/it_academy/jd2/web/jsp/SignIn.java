package by.it_academy.jd2.web.jsp;

import by.it_academy.jd2.core.service.api.people.IPassportView;
import by.it_academy.jd2.core.service.api.people.IUserView;
import by.it_academy.jd2.core.utils.Constants;
import by.it_academy.jd2.core.model.people.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.security.Principal;

/**
 * Class Sign In chat
 */
@Controller
public class SignIn {

    private final IUserView userView;
    private final IPassportView passportView;

    public SignIn(IUserView userView, IPassportView passportView) {
        this.userView = userView;
        this.passportView = passportView;
    }

    @GetMapping(value = "/signIn")
    public String doCheckAuthorization(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (!session.isNew()) {
            session.removeAttribute(Constants.USER);
        }
        return "/views/indexSignIn.jsp";
    }

    @Transactional
    @PostMapping(value = "/signIn")
    protected String doGetAuthorization(Model model,
                                        @RequestParam(name = "username") String username,
                                        @RequestParam(name = "password") String password,
                                        HttpServletRequest req) {

        User user = userView.searchUserLoginAndPsw(username, password);

        if (user != null) {
            req.getSession().setAttribute(Constants.PASSPORT, passportView.findPassport(user));
            req.getSession().setAttribute(Constants.USER, user);
            return user.getRole().getPathToProfile();
        } else {

            model.addAttribute("invalidUserLogin", true);      // Дополнительного комментарий "Не верный логин или пароль"                                      // Авторизация не выполнена, попробуйте снова!
            return "/views/indexSignIn.jsp";

        }

    }
//    @GetMapping(value = "/signIn")
//    protected String doGetAuthorization(Principal principal,
//                                        HttpServletRequest req, Model model) {
//        userView.searchUserLogin(principal.getName());
//        User user = userView.searchUserLoginAndPsw(principal.getName(), userView.searchUserLogin(principal.getName()).getPassword());
//        if (user != null) {
//            req.getSession().setAttribute(Constants.PASSPORT, passportView.findPassport(user));
//            req.getSession().setAttribute(Constants.USER, user);
//            return user.getRole().getPathToProfile();
//        } else {
//            model.addAttribute("invalidUserLogin", true);      // Дополнительного комментарий "Не верный логин или пароль"                                      // Авторизация не выполнена, попробуйте снова!
//            return "/views/indexSignIn.jsp";
//        }
//    }


}


