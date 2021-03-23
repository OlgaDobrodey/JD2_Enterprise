package by.it_academy.jd2.web.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Locale;
import java.util.logging.LogRecord;

@WebFilter(urlPatterns = {"/chats","/message"})
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req =(HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contexPath = req.getContextPath();
        HttpSession session = req.getSession();
        if((session!=null)&&(session.getAttribute("user")!=null)){
            chain.doFilter(request, response);
        }
        else{
            chain.doFilter(request, response);
            res.sendRedirect(contexPath+"/signIn");
        }
   }
}
