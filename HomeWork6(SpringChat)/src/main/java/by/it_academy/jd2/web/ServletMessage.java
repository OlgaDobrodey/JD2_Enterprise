package by.it_academy.jd2.web;

import by.it_academy.jd2.core.tool.api.IUserView;
import by.it_academy.jd2.core.utils.Constants;
import by.it_academy.jd2.core.tool.DataMessage;
import by.it_academy.jd2.core.tool.DataStorageUsers;
import by.it_academy.jd2.core.model.Message;
import by.it_academy.jd2.core.model.User;
import by.it_academy.jd2.data.DaoFactory;
import by.it_academy.jd2.data.DatabaseName;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.security.Principal;
import java.sql.Connection;
import java.sql.SQLException;
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

    public ServletMessage(IUserView userView) {
        this.userView = userView;
    }

    @GetMapping
    public String setMessage(Model model){
        Set<String> set = userView.getUsersLogin();
            model.addAttribute("setUsers", set);             //список логинов всех пользователей
            return "/indexMessage.jsp";
           }

    @PostMapping
    protected String doMessage(Model model, Principal principal,
                               //@RequestParam(name = Constants.USER_SENDER) User userSender,
                               @RequestParam(name = Constants.USER_RECEIVER) String userReceiverLogin,
                               @RequestParam(name = Constants.MESSAGE) String text,
                               HttpServletRequest req) {
        try (Connection connection = DaoFactory.getInstance(DatabaseName.POSTGRES).getConnectionBase()) {

            HttpSession session = req.getSession();
            User userSender = (User) session.getAttribute(Constants.USER_SENDER);

            User userReceiver = userView.searchUserLogin(userReceiverLogin);

            Message message = new Message(userSender, userReceiver, text);
            DataMessage dm = new DataMessage(connection);
            dm.saveMessage(message);

            Set<String> set = userView.getUsersLogin();   //список логинов всех пользователей
            model.addAttribute("setUsers", set);
            session.setAttribute("send", true);      //aгумент отвечающий за дополнительный коментарий "Cобщение отправлено"
            return "/indexMessage.jsp";


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "/";
    }


}

