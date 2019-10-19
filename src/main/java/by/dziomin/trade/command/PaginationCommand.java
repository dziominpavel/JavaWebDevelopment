package by.dziomin.trade.command;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PaginationCommand {
    private static final String NUMBER_REGEX = "^\\d+$";
    private static final int RECORDS_PER_PAGE = 10;

    protected <T> List<T> executePagination(HttpServletRequest request,
                                            List<T> list) {
        String pageString = request.getParameter("page");
        int page = 1;
        int recordsPerPage = RECORDS_PER_PAGE;
        int noOfRecords = list.size();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        if (pageString != null) {
            Pattern pattern = Pattern.compile(NUMBER_REGEX);
            Matcher matcher = pattern.matcher(pageString);
            if (matcher.matches()) {
                page = Integer.parseInt(pageString);
                if (page > noOfPages) {
                    page = noOfPages;
                }
            } else {
                page = 1;
            }
        }
        request.setAttribute("pagesCount", noOfPages);
        request.setAttribute("page", page);
        return showRecordsOnPage(list, page, recordsPerPage);

    }

    private <T> List<T> showRecordsOnPage(List<T> list, int page,
                                          int recordsPerPage) {
        int listLength = list.size();
        int begin = (page - 1) * recordsPerPage;
        int end = page * recordsPerPage - 1;
        ArrayList<T> resultList = new ArrayList<>();
        for (int i = 0; i < listLength; i++) {
            if (i >= begin && i <= end) {
                resultList.add(list.get(i));
            }
        }
        return resultList;
    }
}
