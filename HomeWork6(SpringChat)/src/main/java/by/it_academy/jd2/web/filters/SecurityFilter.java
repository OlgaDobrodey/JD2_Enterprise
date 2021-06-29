package by.it_academy.jd2.web.filters;

import by.it_academy.jd2.core.utils.Constants;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


/**
 * Filter for url "/chats","/message","/menu"
 * send Redirect contexPath+"/signIn"
 */
@WebFilter(urlPatterns = {"/chats","/message","/menu"})
public class SecurityFilter
        implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

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

    @Override
    public void destroy() {

    }
}
