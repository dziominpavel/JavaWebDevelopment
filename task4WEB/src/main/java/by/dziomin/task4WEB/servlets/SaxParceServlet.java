package by.dziomin.task4WEB.servlets;

import by.dziomin.task4WEB.service.TariffsSaxBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/sax")
public class SaxParceServlet extends HttpServlet {
//    Logger logger = Logger.getLogger(SaxParceServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TariffsSaxBuilder saxBuilder = new TariffsSaxBuilder();
        saxBuilder.buildSetTariffs("D:/data/tariffs.xml");
//        logger.debug(saxBuilder.getTarifSet());
        PrintWriter writer = resp.getWriter();
        writer.println(saxBuilder.getTarifSet());
    }


}
