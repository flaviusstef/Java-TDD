package sis.studentinfo;

import static org.junit.Assert.*;
import static sis.studentinfo.DateUtil.createDate;

import java.util.Date;

import org.junit.*;

public abstract class SessionTest {
	protected Session session;
	protected Date startDate;
	protected static final int CREDITS = 3;

	@Before
	public void setUp() {
		startDate = createDate(2003, 1, 6);
		session = createSession("ENGL", "101", startDate);
		session.setNumberOfCredits(CREDITS);
	}

	@Test
	public void testCreate() {
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
		assertEquals(startDate, session.getStartDate());
	}

	@Test
	public void testEnrollStudents() {
		Student student1 = new Student("Cain DiVoe");
		session.enroll(student1);
		assertEquals(CREDITS, student1.getCredits());
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));

		Student student2 = new Student("Coralee DeVaughn");
		session.enroll(student2);
		assertEquals(CREDITS, student2.getCredits());
		assertEquals(2, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		assertEquals(student2, session.get(1));
	}

	abstract protected Session createSession(String department, String number, Date startDate);
}
