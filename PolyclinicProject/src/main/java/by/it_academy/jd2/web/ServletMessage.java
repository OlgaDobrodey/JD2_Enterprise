package by.it_academy.jd2.web;

import by.it_academy.jd2.core.service.api.IMessageView;
import by.it_academy.jd2.core.service.api.IUserView;
import by.it_academy.jd2.core.utils.Constants;
import by.it_academy.jd2.core.model.Message;
import by.it_academy.jd2.core.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.security.Principal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Class send messages
 */
@Controller
@RequestMapping(value = "/message")
public class ServletMessage extends HttpServlet {
    private final IUserView userView;
    private final IMessageView messageView;

    public ServletMessage(IUserView userView, IMessageView messageView) {
        this.userView = userView;
        this.messageView = messageView;
    }

    @GetMapping
    public String setMessage(Model model) {
        Set<String> set = null;//userView.getUsersLogin();
        model.addAttribute("setUsers", set);             //список логинов всех пользователей
        return "/indexMessage.jsp";
    }

    @PostMapping
    protected String doMessage(Model model, Principal principal,
                               //@RequestParam(name = Constants.USER_SENDER) User userSender,
                               @RequestParam(name = Constants.USER_RECEIVER) String userReceiverLogin,
                               @RequestParam(name = Constants.MESSAGE) String text,
                               HttpServletRequest req) {

        HttpSession session = req.getSession();
        User userSender = (User) session.getAttribute(Constants.USER_SENDER);

        User userReceiver = (User)userView.searchUserLogin(userReceiverLogin);

        Message message = new Message();

        message.setSender(userSender);
        message.setReceiver(userReceiver);
        message.setMessage(text);
        message.setDateTime(Timestamp.valueOf(LocalDateTime.now()));

       // messageView.saveMessage(message);

        Set<String> set = null; //userView.getUsersLogin();   //список логинов всех пользователей
        model.addAttribute("setUsers", set);

        session.setAttribute("send", true);      //aгумент отвечающий за дополнительный коментарий "Cобщение отправлено"
        return "/indexMessage.jsp";
    }


}

