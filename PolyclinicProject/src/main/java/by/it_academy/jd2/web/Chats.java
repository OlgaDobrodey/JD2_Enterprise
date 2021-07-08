package by.it_academy.jd2.web;


import by.it_academy.jd2.core.model.User;
import by.it_academy.jd2.core.service.api.IMessageView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * seng RequestDispatcher on print messages
 */
@Controller
@RequestMapping(value = "/chats")
public class Chats extends HttpServlet {
    private final IMessageView messageView;

    public Chats(IMessageView messageView) {
        this.messageView = messageView;
    }

    @GetMapping
    public String chat(Model model, HttpServletRequest req) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User userSender = (User) session.getAttribute("userSender");
        final List<String> s = null; //messageView.printMessasgeUserLogin(userSender);
        model.addAttribute("printMSG", s);
        return "/indexChats.jsp";

    }

}
