package sis.report;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sis.studentinfo.CourseSession;

public class CourseReport {

	private List<CourseSession> courseSessions = new ArrayList<CourseSession>();

	public void add(CourseSession cs) {
		courseSessions.add(cs);
	}

	public String text() {
		Collections.sort(courseSessions);
		StringBuilder result = new StringBuilder();
		for (CourseSession cs: courseSessions) {
			result.append(cs.getDepartment());
			result.append(" ");
			result.append(cs.getNumber());
			result.append(ReportConstant.NEWLINE);
		}
		return result.toString();
	}

}
