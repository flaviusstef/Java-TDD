package sis.studentinfo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

public abstract class Session implements Comparable<CourseSession>, Iterable<Student> {
	protected int numberOfCredits;
	protected List<Student> students = new ArrayList<Student>();
	protected String department;
	protected String number;
	protected Date startDate;
	private URL url;

	protected Session(String department, String number, Date startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}

	public Iterator<Student> iterator() {
		return students.iterator();
	}

	void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	public void enroll(Student student) {
		student.addCredits(numberOfCredits);
		students.add(student);
	}


	public String getDepartment() {
		return department;
	}

	public String getNumber() {
		return number;
	}

	int getNumberOfStudents() {
		return students.size();
	}


	Student get(int index) {
		return students.get(index);
	}

	protected Date getStartDate() {
		return startDate;
	}

	public List<Student> getAllStudents() {
		return students;
	}

	public Date getEndDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(getStartDate());
		final int daysInWeek = 7;
		final int daysFromFridayToMonday = 3;
		int numberOfDays =
			getSessionLength() * daysInWeek - daysFromFridayToMonday;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		return calendar.getTime();
	}

	@Override
	public int compareTo(CourseSession o) {
		return (getDepartment()+getNumber()).compareTo(o.getDepartment()+o.getNumber());
	}

	protected abstract int getSessionLength();

	public void setUrl(String urlString) throws SessionException  {
		try {
			this.url = new URL(urlString);
		} catch (MalformedURLException e) {
			log(e);
			throw new SessionException(e);
		}
	}

	private void log(Exception e) {

	}

	public URL getUrl() {
		return url;
	}
}
