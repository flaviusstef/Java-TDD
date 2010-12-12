package sis.studentinfo;

public class HonorsGradingStrategy extends BasicGradingStrategy {

	@Override
	public int getGradePointsFor(Student.Grade g) {
		int points = super.getGradePointsFor(g);
		if (points > 0)
			points += 1;
		return points;
	}
}
