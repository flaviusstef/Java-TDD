package sis.studentinfo;

import java.util.*;

import org.junit.Test;

import static org.junit.Assert.*;
import static sis.studentinfo.DateUtil.createDate;

public class CourseSessionTest extends SessionTest {
	
	@Test
	public void testCourseDates() {
		Date sixteenWeeksOut = createDate(2003, 4, 25);
		assertEquals(sixteenWeeksOut, session.getEndDate());
	}

	@Test
	public void testCount() {
		CourseSession.resetCount();
		createSession("", "", new Date());
		assertEquals(1, CourseSession.getCount());
		createSession("", "", new Date());
		assertEquals(2, CourseSession.getCount());
	}
	

	protected CourseSession createSession(String department, String number, Date startDate) {
		CourseSession session =
			CourseSession.create("ENGL", "101", startDate);
		session.setNumberOfCredits(SessionTest.CREDITS);
		return session;
	}
}