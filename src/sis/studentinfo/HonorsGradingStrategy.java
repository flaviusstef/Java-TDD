package sis.studentinfo;

public class HonorsGradingStrategy implements GradingStrategy {

	@Override
	public int getGradePointsFor(Student.Grade g) {
		int points = basicGradePointsFor(g);
		if (points > 0)
			points += 1;
		return points;
	}
	int basicGradePointsFor(Student.Grade grade) {
		if (grade == Student.Grade.A) return 4;
		if (grade == Student.Grade.B) return 3;
		if (grade == Student.Grade.C) return 2;
		if (grade == Student.Grade.D) return 1;
		return 0;
	}
}
