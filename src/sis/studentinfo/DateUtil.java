package sis.studentinfo;

import java.util.*;

public class DateUtil {
   private DateUtil() {}
   public static Date createDate(int year, int month, int date) {
      GregorianCalendar calendar = new GregorianCalendar();
      calendar.clear();
      calendar.set(Calendar.YEAR, year);
      calendar.set(Calendar.MONTH, month - 1);
      calendar.set(Calendar.DAY_OF_MONTH, date);
      return calendar.getTime();
   }
}