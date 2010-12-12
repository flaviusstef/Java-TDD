package sis.summer;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import sis.studentinfo.*;

public class SummerCourseSessionTest extends sis.studentinfo.SessionTest {
	@Test
	public void testEndDate() {
		Date startDate = DateUtil.createDate(2003, 6, 9);
		Session session =
			SummerCourseSession.create("ENGL", "200", startDate);
		Date eightWeeksOut = DateUtil.createDate(2003, 8, 1);
		assertEquals(eightWeeksOut, session.getEndDate());
	}

	protected Session createSession(String department, String number, Date date) {
		return SummerCourseSession.create(department, number, startDate);
	}
}
