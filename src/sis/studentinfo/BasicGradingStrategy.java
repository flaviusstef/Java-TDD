package sis.studentinfo;

public class BasicGradingStrategy implements GradingStrategy {
	
	public int getGradePointsFor(Student.Grade g) {
		return g.getPoints();
	}
}