package sis.studentinfo;

import static org.junit.Assert.*;
import static sis.studentinfo.DateUtil.createDate;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	@Test
	public void canIterateThroughStudents() {
		session.enroll(new Student("a"));
		session.enroll(new Student("b"));
		session.enroll(new Student("c"));

		List<Student> expected = session.getAllStudents();
		List<Student> actual = new ArrayList<Student>();
		for (Student s: session) {
			actual.add(s);
		}
		assertEquals("Iterate through students", expected, actual);
	}

	@Test
	public void validSessionUrl() throws SessionException {
		final String url = "http://course.langrsoft.com/cmsc300";
		session.setUrl(url);
		assertEquals(url, session.getUrl().toString());
	}

	public void invalidSessionUrl() {
		final String url = "httsp://course.langrsoft.com/cmsc300";
		try {
			session.setUrl(url);
			fail("expected exception due to invalid protocol in URL");
		}
		catch (SessionException success) {
			Throwable cause = success.getCause();
			assertEquals(MalformedURLException.class, cause.getClass());
		}
	}

	abstract protected Session createSession(String department, String number, Date startDate);
}
