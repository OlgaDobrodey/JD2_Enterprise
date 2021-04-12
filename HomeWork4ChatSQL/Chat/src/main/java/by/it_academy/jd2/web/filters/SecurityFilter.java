package by.it_academy.jd2.web.filters;

import by.it_academy.jd2.core.Constants;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


/**
 * Filter for url "/chats","/message","/menu"
 * send Redirect contexPath+"/signIn"
 */
@WebFilter(urlPatterns = {"/chats","/message","/menu"})
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req =(HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contexPath = req.getContextPath();
        HttpSession session = req.getSession();
        if((session!=null)&&(session.getAttribute(Constants.USER_SENDER)!=null)){
            chain.doFilter(request, response);
        }
        else{
           res.sendRedirect(contexPath+"/signIn");
        }
   }
}
