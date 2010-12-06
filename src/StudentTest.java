import static org.junit.Assert.*;

import org.junit.Test;


public class StudentTest {
	@Test
	public void testCreate() {
		Student jane = new Student("Jane Doe");
		assertEquals("Jane Doe", jane.getName());
		
		Student john = new Student("John Doe");
		assertEquals("John Doe", john.getName());
	}
}
