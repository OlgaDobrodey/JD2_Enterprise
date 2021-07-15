package by.it_academy.jd2.web;


import by.it_academy.jd2.core.model.Message;
import by.it_academy.jd2.core.model.Role;
import by.it_academy.jd2.core.model.User;
import by.it_academy.jd2.core.service.api.IMessageView;
import by.it_academy.jd2.core.service.api.IUserView;
import by.it_academy.jd2.core.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * seng RequestDispatcher on print messages
 */
@Controller
public class Chats extends HttpServlet {
    private final IMessageView messageView;
    private final IUserView userView;

    public Chats(IMessageView messageView, IUserView userView) {
        this.messageView = messageView;
        this.userView = userView;
    }

    @GetMapping(value = "/chat")
    public String chat(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        if (session.isNew()) {
            return "/views/indexSignIn.jsp";
        }
        User sender = (User) session.getAttribute(Constants.USER);
        if (sender == null) {
            return "/views/indexSignIn.jsp";
        }
        model.addAttribute("doctors", userView.searchAllDoctors());
        if (sender.getRole() == Role.DOCTOR) {
            model.addAttribute("patients", userView.searchAllPatients());
        }
        return "/views/indexChats.jsp";
    }

//    @GetMapping(value = "/chat/{login}")
//    public String getCardDoctor(Model model, @PathVariable String login) {
//        model.addAttribute("doctor", this.userView.searchUserLogin(login));
//        return "/views/indexChats.jsp";
//    }

    @PostMapping(value = "/message")
    protected String doMessage(Model model,
                               @RequestParam(name = Constants.USER_RECEIVER) String userReceiverLogin,
                               @RequestParam(name = Constants.MESSAGE) String text,
                               HttpServletRequest req) {

        HttpSession session = req.getSession();
        User sender = (User) session.getAttribute(Constants.USER);
        User receiver = userView.searchUserLogin(userReceiverLogin);

        Message message = new Message();

        message.setSender(sender);
        message.setReceiver(receiver);
        message.setMessage(text);
        message.setDate_msg(new Date());

        messageView.saveMessage(message);
        model.addAttribute("doctors", this.userView.searchAllDoctors());
        if (sender.getRole().equals("DOCTOR")) {
            model.addAttribute("patients", userView.searchAllPatients());
        }
        model.addAttribute("doctor", receiver);
        model.addAttribute("listMessages", this.messageView.findAllMessageWithSenderAndReceiver(sender, receiver));


//        Set<String> set = userView.getUsersLogin();   //список логинов всех пользователей
//        model.addAttribute("setUsers", set);

//        session.setAttribute("send", true);      //aгумент отвечающий за дополнительный коментарий "Cобщение отправлено"
        return "/views/indexChats.jsp";
    }


//    @GetMapping(value = "/chats")
//    public String chat(Model model, HttpServletRequest req) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        User userSender = (User) session.getAttribute("userSender");
//        final List<String> s = messageView.printMessasgeUserLogin(userSender);
//        model.addAttribute("printMSG", s);
//        return "/indexChats.jsp";
//
//    }

}
