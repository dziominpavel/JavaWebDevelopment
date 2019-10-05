package by.dziomin.trade.controller;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/locale")
public class LocaleFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String lang = request.getParameter("lang");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.getSession().setAttribute("locale", lang);
        chain.doFilter(request, response);
    }
}
