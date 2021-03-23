package by.it_academy.jd2.web;

import by.it_academy.jd2.core.dto.DataMessage;
import by.it_academy.jd2.core.dto.DataStorageUsers;
import by.it_academy.jd2.core.dto.Message;
import by.it_academy.jd2.core.dto.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet(name = "Message", urlPatterns = "/message")
public class ServletMessage extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<User> set = DataStorageUsers.getAllUsers();
        req.setAttribute("setUsers",set);
        getServletContext().getRequestDispatcher("/indexMessage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User userSender=(User) session.getAttribute("userSender");

        String userReceiverLogin = req.getParameter("userReceiver");
        User userReceiver = DataStorageUsers.searchUserLogin(userReceiverLogin );
        String text = req.getParameter("message");
        Message message = new Message(userSender, userReceiver, text);
        DataMessage.saveMessage(message);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        session.setAttribute("send",true);
        getServletContext().getRequestDispatcher("/indexMessage.jsp").forward(req, resp);




    }
}

