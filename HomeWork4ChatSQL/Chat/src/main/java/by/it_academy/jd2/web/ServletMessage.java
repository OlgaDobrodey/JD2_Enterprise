package by.it_academy.jd2.web;

import by.it_academy.jd2.core.Constants;
import by.it_academy.jd2.core.tool.DataMessage;
import by.it_academy.jd2.core.tool.DataStorageUsers;
import by.it_academy.jd2.core.view.Message;
import by.it_academy.jd2.core.view.User;
import by.it_academy.jd2.data.DaoFactory;
import by.it_academy.jd2.data.DatabaseName;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

/**
 * Class send messages
 */
@WebServlet(name = "Message", urlPatterns = "/message")
public class ServletMessage extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = DaoFactory.getInstance(DatabaseName.POSTGRES).getConnectionBase()) {
            DataStorageUsers dsu = new DataStorageUsers(connection);
            Set<String> set = dsu.getUsersLogin();
            req.setAttribute("setUsers", set);             //список логинов всех пользователей
            getServletContext().getRequestDispatcher("/indexMessage.jsp").forward(req, resp);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = DaoFactory.getInstance(DatabaseName.POSTGRES).getConnectionBase()) {
            HttpSession session = req.getSession();
            User userSender = (User) session.getAttribute(Constants.USER_SENDER);
            String userReceiverLogin = req.getParameter(Constants.USER_RECEIVER);

            DataStorageUsers dsu = new DataStorageUsers(connection);
            User userReceiver = dsu.searchUserLogin(userReceiverLogin);
            String text = req.getParameter(Constants.MESSAGE);

            Message message = new Message(userSender, userReceiver, text);
            DataMessage dm = new DataMessage(connection);
            dm.saveMessage(message);

            Set<String> set = dsu.getUsersLogin();   //список логинов всех пользователей
            req.setAttribute("setUsers", set);
            session.setAttribute("send", true);      //aгумент отвечающий за дополнительный коментарий "Cобщение отправлено"
            getServletContext().getRequestDispatcher("/indexMessage.jsp").forward(req, resp);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}

