package by.it_academy.jd2.web;


import by.it_academy.jd2.core.dto.Constants;
import by.it_academy.jd2.core.dto.DataMessage;
import by.it_academy.jd2.core.dto.Message;
import by.it_academy.jd2.core.dto.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Chats", urlPatterns = "/chats")
public class Chats extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  DataMessage.searchMessageUserLogin(userSender.getLogin());
            getServletContext().getRequestDispatcher("/indexChats.jsp").forward(req, resp);
        }
}
