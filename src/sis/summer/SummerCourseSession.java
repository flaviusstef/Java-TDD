package sis.summer;

import java.util.Date;
import sis.studentinfo.Session;

public class SummerCourseSession extends Session {
	
	public static Session create(String department, String number, Date startDate) {
		return new SummerCourseSession(department, number, startDate);
	}

	private SummerCourseSession(String department, String number, Date startDate) {
		super(department, number, startDate);
	}
	
	@Override
	protected int getSessionLength() {
		return 8;
	}
}
