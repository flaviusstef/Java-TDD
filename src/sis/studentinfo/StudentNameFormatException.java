package sis.studentinfo;

@SuppressWarnings("serial")
public class StudentNameFormatException extends IllegalArgumentException {
	private String student;
	
	public StudentNameFormatException(String student) {
		this.student = student;
	}

	@Override
	public String getMessage() {
		return "Student '" + student + "' has a name with more than 3 parts";
	}
}
