package sis.studentinfo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PerformanceTest {
   private static final double tolerance = 0.005;
   
   @Test
   public void testAverage() {
      Performance performance = new Performance();
      performance.setNumberOfTests(4);
      performance.set(0, 98);
      performance.set(1, 92);
      performance.set(2, 81);
      performance.set(3, 72);

      assertEquals(92, performance.get(1));

      assertEquals(85.75, performance.average(), tolerance);
   }
   
   @Test
   public void testInitialization() {
	   Performance p = new Performance();
	   p.setScores(80,80,90,90);
	   
	   assertEquals(85, p.average(), tolerance);
   }
}
