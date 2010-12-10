package sis.studentinfo;

import java.util.*;
import junit.framework.*;

public class DateUtilTest extends TestCase {
   public void testCreateDate() {
      Date date = DateUtil.createDate(2000, 1, 1);
      Calendar calendar = new GregorianCalendar();
      calendar.setTime(date);
      assertEquals(2000, calendar.get(Calendar.YEAR));
      assertEquals(Calendar.JANUARY, calendar.get(Calendar.MONTH));
      assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
   }
}