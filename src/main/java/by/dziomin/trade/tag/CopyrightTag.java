package by.dziomin.trade.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.GregorianCalendar;

//@SuppressWarnings("serial")
public class CopyrightTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        GregorianCalendar gc = new GregorianCalendar();
        String time = " © " + gc.toZonedDateTime().getYear() + " Copyright :";
        try {
            JspWriter out = pageContext.getOut();
            out.write(time);
//            out.write(time + locale);
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
