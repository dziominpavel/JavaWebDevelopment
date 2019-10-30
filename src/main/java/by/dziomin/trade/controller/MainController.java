package by.dziomin.trade.controller;

import by.dziomin.trade.command.Command;
import by.dziomin.trade.command.CommandFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.dziomin.trade.command.AppUrls.ERROR_PAGE;
import static by.dziomin.trade.util.ErrorMessages.SERVER_ERROR;

/**
 * Main app controller
 *
 * @author - Pavel Dziomin
 */
@WebServlet(name = "MainController", urlPatterns = {"/app"})
public class MainController extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (ServletException | IOException e) {
            logger.error(SERVER_ERROR, e);
        }
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (ServletException | IOException e) {
            logger.error(SERVER_ERROR, e);
        }
    }

    private void processRequest(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String commandName = req.getParameter("command");
        logger.debug("Command " + commandName);
        try {
            Command command =
                    CommandFactory.getInstance().defineCommand(commandName);
            String page = command.execute(req);
            req.getRequestDispatcher(page).forward(req, resp);
        } catch (Exception e) {
            logger.error("Command " + commandName, e);
            req.getRequestDispatcher(ERROR_PAGE).forward(req, resp);
        }
    }
}
