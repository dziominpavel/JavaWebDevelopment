package by.dziomin.trade.controller;

import by.dziomin.trade.dto.user.SessionUserDTO;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.dziomin.trade.command.AppUrls.ACCESS_DENIED_PAGE;
import static by.dziomin.trade.command.AppUrls.HOME_PAGE;
import static by.dziomin.trade.command.AppUrls.SIGNIN_PAGE;

/**
 * Filter to manage security acces to pages
 *
 * @author - Pavel Dziomin
 */
@WebFilter("/*")
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String servletPath = request.getServletPath();

        //login available for everyone
        if (SecurityConfig.isFreeAccess(servletPath)) {
            chain.doFilter(request, response);
            return;
        }

        Object userObject = request.getSession().getAttribute("currentUser");
        //check access
        if (SecurityConfig.authorizedAccess.contains(servletPath)) {
            if (userObject == null) {
                req.getRequestDispatcher(SIGNIN_PAGE).forward(request, response);
                return;
            } else {
                req.getRequestDispatcher(HOME_PAGE).forward(request, response);
                return;
            }
        }


        if (userObject == null) {
            req.getRequestDispatcher(SIGNIN_PAGE).forward(request, response);
            return;
        }
        String role = ((SessionUserDTO) userObject).getRole();

        // Check if the user has a valid role
        boolean hasPermission = SecurityConfig.checkAccess(role, servletPath);
        if (!hasPermission) {
            req.getRequestDispatcher(ACCESS_DENIED_PAGE).forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }

}