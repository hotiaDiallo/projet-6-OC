package com.ib.library.soap;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Utils {

  /*
   * Converts XMLGregorianCalendar to java.util.Date in Java
   */
  public static Date toDate(XMLGregorianCalendar calendar){
    if(calendar == null) {
      return null;
    }
    return calendar.toGregorianCalendar().getTime();
  }

  public static XMLGregorianCalendar toXMLGregorianCalendar(Date date){
    GregorianCalendar gCalendar = new GregorianCalendar();
    gCalendar.setTime(date);
    XMLGregorianCalendar xmlCalendar = null;
    try {
      xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
    } catch (DatatypeConfigurationException ex) {
    }
    return xmlCalendar;
  }


  public static final String NAMESPACE_URI = "http://library/soap/web-services";
  public static final String PORT_NAME = "libraryPortName";

}
