package by.it_academy.jd2.web;


import by.it_academy.jd2.core.Constants;
import by.it_academy.jd2.core.tool.DataMessage;
import by.it_academy.jd2.core.view.Message;
import by.it_academy.jd2.core.view.User;
import by.it_academy.jd2.data.DaoFactory;
import by.it_academy.jd2.data.DatabaseName;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * seng RequestDispatcher on print messages
 */
@WebServlet(name = "Chats", urlPatterns = "/chats")
public class Chats extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = DaoFactory.getInstance(DatabaseName.POSTGRES).getConnectionBase()){
            HttpSession session = req.getSession();
            DataMessage dataMessage = new DataMessage(connection);
            User userSender = (User) session.getAttribute("userSender");
            final String s = dataMessage.printMessasgeUserLogin(userSender);
            req.setAttribute("printMSG",s);
            getServletContext().getRequestDispatcher("/indexChats.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
