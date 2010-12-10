package sis.testing;

import junit.framework.*;
import java.util.*;

public class SuiteBuilderTest extends TestCase {
   public void testGatherTestClassNames() {
      SuiteBuilder builder = new SuiteBuilder();
      List<String> classes = builder.gatherTestClassNames();
      assertTrue(classes.contains("sis.testing.SuiteBuilderTest"));
      assertFalse(classes.contains("sis.testing.testclasses.NotATestClass"));
      assertFalse(classes.contains("sis.testing.testclasses.AbstractTestClass"));
   }

   public void testCreateSuite() {
      SuiteBuilder builder = new SuiteBuilder() {
         public List<String> gatherTestClassNames() {
            List<String> classNames = new ArrayList<String>();
            classNames.add("sis.testing.SuiteBuilderTest");
            return classNames;
         }
      };

      TestSuite suite = builder.suite();
      assertEquals(1, suite.testCount());
      assertTrue(contains(suite, sis.testing.SuiteBuilderTest.class));
   }

   public boolean contains(TestSuite suite, Class testClass) {
      List testClasses = Collections.list(suite.tests());
      for (Object object: testClasses) {
         if (object.getClass() == TestSuite.class)
            if (contains((TestSuite)object, testClass))
               return true;
         if (object.getClass() == testClass)
            return true;
      }
      return false;
   }
}