package by.it_academy.jd2.web;


import by.it_academy.jd2.core.Constants;
import by.it_academy.jd2.core.tool.DataMessage;
import by.it_academy.jd2.core.view.Message;
import by.it_academy.jd2.core.view.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

/**
 * seng RequestDispatcher on print messages
 */
@WebServlet(name = "Chats", urlPatterns = "/chats")
public class Chats extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            getServletContext().getRequestDispatcher("/indexChats.jsp").forward(req, resp);
        }
}
