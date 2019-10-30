package by.dziomin.trade.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Command interface
 *
 * @author - Pavel Dziomin
 */
public interface Command {
    /**
     * Executing request
     *
     * @param request request for executing
     * @return url after executing request.
     */
    String execute(HttpServletRequest request);
}
