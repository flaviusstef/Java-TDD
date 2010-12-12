package sis.studentinfo;

import static org.junit.Assert.*;

import org.junit.Test;

public class BasicGradingStrategyTest {
	@Test
	public void testGetGradePoints() {
		BasicGradingStrategy strategy = new BasicGradingStrategy();
		assertEquals(4, strategy.getGradePointsFor(Student.Grade.A));
		assertEquals(3, strategy.getGradePointsFor(Student.Grade.B));
		assertEquals(2, strategy.getGradePointsFor(Student.Grade.C));
		assertEquals(1, strategy.getGradePointsFor(Student.Grade.D));
		assertEquals(0, strategy.getGradePointsFor(Student.Grade.F));
	}
}
