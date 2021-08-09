package by.it_academy.jd2.web.jsp;


import by.it_academy.jd2.core.model.chat.Message;
import by.it_academy.jd2.core.model.people.Role;
import by.it_academy.jd2.core.model.people.User;
import by.it_academy.jd2.core.service.api.chat.IMessageView;
import by.it_academy.jd2.core.service.api.people.IUserView;
import by.it_academy.jd2.core.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

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
        HttpSession session = req.getSession(false);
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
        return "indexChats";
    }

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
        if (sender.getRole().equals(Role.DOCTOR)) {
            model.addAttribute("patients", userView.searchAllPatients());
        }
        model.addAttribute("doctor", receiver);
        model.addAttribute("listMessages", this.messageView.findAllMessageWithSenderAndReceiver(sender, receiver));
        return "indexChats";
    }

}
