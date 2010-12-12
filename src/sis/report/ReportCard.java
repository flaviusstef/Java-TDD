package sis.report;

import java.util.EnumMap;
import java.util.Map;

import sis.studentinfo.Student.Grade;

public class ReportCard {
	public static final String A_MESSAGE = "A";
	public static final String B_MESSAGE = "B";
	public static final String C_MESSAGE = "C";
	public static final String D_MESSAGE = "D";
	public static final String F_MESSAGE = "F";
	
	private Map<Grade, String> messages = null;

	public String getMessage(Grade g) {
		if (messages == null)
			loadMessages();
		return messages.get(g);
	}

	private void loadMessages() {
		messages = new EnumMap<Grade, String>(Grade.class);
		messages.put(Grade.A, A_MESSAGE);
		messages.put(Grade.B, B_MESSAGE);
		messages.put(Grade.C, C_MESSAGE);
		messages.put(Grade.D, D_MESSAGE);
		messages.put(Grade.F, F_MESSAGE);
	}
}
