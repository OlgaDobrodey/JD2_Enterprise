package by.it_academy.jd2.web;

import by.it_academy.jd2.core.Constants;
import by.it_academy.jd2.core.tool.DataStorageUsers;
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

/**
 * Class Sign Up chat
 */
@WebServlet(name = "SignUp", urlPatterns = "/signUp")
public class SignUp extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/indexSignUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = DaoFactory.getInstance(DatabaseName.POSTGRES).getConnectionBase()) {
            User user = new User();
            user.setLogin(req.getParameter(Constants.LOGIN));
            user.setPassword(req.getParameter(Constants.PASSWORD));
            user.setName(req.getParameter(Constants.NAME));
            user.setBirthday(req.getParameter(Constants.BIRTHDAY));

            DataStorageUsers dsu = new DataStorageUsers(connection);
            User userSearch = dsu.searchUserLogin(user.getLogin());

            if (userSearch != null) {
                req.setAttribute("invalidUserLogin", true);
                getServletContext().getRequestDispatcher("/indexSignUp.jsp").forward(req, resp);
            }
            dsu.saveUsers(user);
            HttpSession session = req.getSession();
            session.setAttribute(Constants.USER_SENDER, user);
            String path = req.getContextPath() + "/menu";
            resp.sendRedirect(path);

        } catch (
                ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

