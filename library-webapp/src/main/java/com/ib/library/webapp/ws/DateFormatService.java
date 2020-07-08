package com.ib.library.webapp.ws;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatService {

    public static Date convertDateToXMLGregorianCalender(XMLGregorianCalendar calendar  ){
        return calendar.toGregorianCalendar().getTime();

    }

    public static String dateFormat(XMLGregorianCalendar xmlDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = convertDateToXMLGregorianCalender(xmlDate);
        return dateFormat.format(date);
    }
}
