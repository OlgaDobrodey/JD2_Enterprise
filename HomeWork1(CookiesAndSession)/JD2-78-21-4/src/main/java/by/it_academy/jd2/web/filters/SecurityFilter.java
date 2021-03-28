package by.it_academy.jd2.web.filters;

import jakarta.servlet.*;

import java.io.IOException;
import java.util.Locale;
import java.util.logging.LogRecord;

/**
 * A filter is an object that performs filtering tasks on either the request to a resource
 * (a servlet or static content), or on the response from a resource, or both.
 */

public class SecurityFilter implements Filter {
    private boolean active = false;

/**
 * init(FilterConfig filterConfig)
 * Called by the web container to indicate to a filter that it is being placed into service.
 */

    @Override
    public void init(FilterConfig config) throws ServletException {
        String act = config.getInitParameter("active");
        if (act != null) {
            active = (act.toUpperCase().equals("TRUE"));
        }
    }

    /**
     *  The doFilter method of the Filter is called by the container each time a request/response pair is passed
     *  through the chain due to a client request for a resource at the end of the chain.
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (active) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n\n\n\n\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        }
        chain.doFilter(request, response);
    }
}
