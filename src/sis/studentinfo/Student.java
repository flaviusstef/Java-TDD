package sis.studentinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;

public class Student {
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	static final String IN_STATE = "CO";
	public static Logger logger = Logger.getLogger(Student.class.getName());
	private String name;
	private int credits;
	private String state = "";
	private List<Grade> grades = new ArrayList<Grade>();
	private GradingStrategy gradingStrategy = new BasicGradingStrategy();
	private String lastName   = "";
	private String firstName  = "";
	private String middleName = "";
	private List<Integer> charges = new ArrayList<Integer>();
	public static final String TOO_MANY_NAME_PARTS = "Student '%s' has a name with more than 3 parts";

	public enum Grade {
		A(4), B(3), C(2), D(1), F(0);
		private int points;
		Grade(int points) { this.points = points; }
		int getPoints() { return points; }
	};

	public Student(String fullName) {
		credits = 0;
		this.name = fullName;
		StringTokenizer st = new StringTokenizer(fullName, " ");
		switch (st.countTokens()) {
			case 1:  this.lastName = st.nextToken();
 			         break;
			case 2:  this.firstName = st.nextToken();
			         this.lastName = st.nextToken();
			         break;
			case 3:  this.firstName = st.nextToken();
			         this.middleName = st.nextToken();
			         this.lastName = st.nextToken();
			         break;
			default: String message = String.format(Student.TOO_MANY_NAME_PARTS, fullName);
					 Student.logger.info(message);
				     throw new StudentNameFormatException(fullName);
		}
	}

	public String getName() {
		return name;
	}

	boolean isFullTime() {
		return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
	}

	int getCredits() {
		return credits;
	}

	void addCredits(int credits) {
		this.credits += credits;
	}

	boolean isInState() {
		return state.equals(Student.IN_STATE);
	}	

	void setState(String state) {
		this.state = state;
	}

	public double getGpa() {
		if (grades.isEmpty())
			return 0.0;
		double total = 0.0;
		for (Grade grade: grades) {
			total += gradingStrategy.getGradePointsFor(grade);
		}
		return total / grades.size();
	}

	void addGrade(Grade grade) {
		grades.add(grade);
	}

	public void setGradingStrategy(GradingStrategy strategy) {
		this.gradingStrategy  = strategy;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void addCharge(int charge) {
		charges.add(charge);
	}

	public int totalCharges() {
		int result = 0;
		for (int charge: charges) {
			result += charge;
		}
		return result;
	}
}