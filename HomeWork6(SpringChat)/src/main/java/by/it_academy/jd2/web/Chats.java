package by.it_academy.jd2.web;


import by.it_academy.jd2.core.tool.DataMessage;
import by.it_academy.jd2.core.model.User;
import by.it_academy.jd2.core.tool.api.IUserView;
import by.it_academy.jd2.data.DaoFactory;
import by.it_academy.jd2.data.DatabaseName;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * seng RequestDispatcher on print messages
 */
@Controller
@RequestMapping(value = "/chats")
public class Chats extends HttpServlet {

    @GetMapping
    public String chat(Model model, HttpServletRequest req) throws ServletException, IOException {
        try (Connection connection = DaoFactory.getInstance(DatabaseName.POSTGRES).getConnectionBase()) {
            HttpSession session = req.getSession();
            DataMessage dataMessage = new DataMessage(connection);
            User userSender = (User) session.getAttribute("userSender");
            final String s = dataMessage.printMessasgeUserLogin(userSender);
            model.addAttribute("printMSG", s);
            return "/indexChats.jsp";

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "/";
    }

}
