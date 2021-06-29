package by.it_academy.jd2.web.filters;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String encoding = "utf-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String encodingParam = filterConfig.getInitParameter("encoding");
        if (encodingParam != null) {
            encoding = encodingParam;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        //                response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding(encoding);
        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
