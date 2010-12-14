package sis.studentinfo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScorerTest {

	@Test
	public void goodScore() {
		Scorer s = new Scorer();
		assertEquals(75, s.score("75"));
	}

	@Test
	public void badScore() {
		Scorer s = new Scorer();
		try {
			s.score("non_numbers_are_bad");
			fail("should have failed");
		} catch (NumberFormatException success) {
			
		}
	}
	
	@Test
	public void testValidity() {
		Scorer s = new Scorer();
		assertTrue(s.isValid("75"));
		assertFalse(s.isValid("not_a_number"));
	}
}
