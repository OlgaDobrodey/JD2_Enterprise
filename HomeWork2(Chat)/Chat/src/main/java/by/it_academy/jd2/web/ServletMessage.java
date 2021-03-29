package by.it_academy.jd2.web;

import by.it_academy.jd2.core.Constants;
import by.it_academy.jd2.core.tool.DataMessage;
import by.it_academy.jd2.core.tool.DataStorageUsers;
import by.it_academy.jd2.core.view.Message;
import by.it_academy.jd2.core.view.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Set;

/**
 * Class send messages
 */
@WebServlet(name = "Message", urlPatterns = "/message")
public class ServletMessage extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<String> set = DataStorageUsers.getUsersLogin();
        req.setAttribute("setUsers",set);             //список логинов всех пользователей
        getServletContext().getRequestDispatcher("/indexMessage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User userSender=(User) session.getAttribute(Constants.USER_SENDER);

        String userReceiverLogin = req.getParameter(Constants.USER_RECEIVER);
        User userReceiver = DataStorageUsers.searchUserLogin(userReceiverLogin );
        String text = req.getParameter(Constants.MESSAGE);
        Message message = new Message(userSender, userReceiver, text);
        DataMessage.saveMessage(message);
        Set<String> set = DataStorageUsers.getUsersLogin();   //список логинов всех пользователей
        req.setAttribute("setUsers",set);
        session.setAttribute("send",true);      //aгумент отвечающий за дополнительный коментарий "Cобщение отправлено"
        getServletContext().getRequestDispatcher("/indexMessage.jsp").forward(req, resp);
    }
}

