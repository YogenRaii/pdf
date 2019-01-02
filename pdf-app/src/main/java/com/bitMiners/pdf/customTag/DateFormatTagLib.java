package com.bitMiners.pdf.customTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Date;

public class DateFormatTagLib extends TagSupport {

    /**
     * Serial Version ID
     */
    private static final long serialVersionUID = 1L;
    private Date date;

    @Override
    public int doStartTag() throws JspException {

        try {
            // Get the writer object for output.
            JspWriter out = pageContext.getOut();

            // Perform substr operation on string.
            out.println(getNiceDate(date));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    static String getNiceDate(Date date) {
        Date now = new Date();
        long diff = Math.abs(now.getTime() - date.getTime());
        final long second = 1000;
        final long minute = second * 60;
        final long hour = minute * 60;
        final long day = hour * 24;
        final long year = day * 365;
        String niceTime = "";
        long calc = 0;

        calc = (long) Math.floor(diff / year);
        if (calc != 0) {
            niceTime += calc + " year" + (calc > 1 ? "s " : " ");
            diff %= year;
        }

        calc = (long) Math.floor(diff / day);
        if (calc != 0) {
            niceTime += calc + " day" + (calc > 1 ? "s " : " ");
            diff %= day;
        }
        calc = (long) Math.floor(diff / hour);
        if (calc != 0) {
            niceTime += calc + " hour" + (calc > 1 ? "s " : " ");
            diff %= hour;
        }
        calc = (long) Math.floor(diff / minute);
        if (calc != 0) {
            niceTime += calc + " minute" + (calc > 1 ? "s " : " ");
            diff %= minute;
        }
        if (niceTime.isEmpty()) {
            niceTime = "Right now";
        } else {
            niceTime += (date.getTime() > now.getTime()) ? "from now" : "ago";
        }
        return niceTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
