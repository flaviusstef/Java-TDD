package sis.studentinfo;

public class AllTests {
   public static junit.framework.TestSuite suite() {
      junit.framework.TestSuite suite =
         new junit.framework.TestSuite();
      suite.addTestSuite(StudentTest.class);
      suite.addTestSuite(CourseSessionTest.class);
//    suite.addTestSuite(RosterReporterTest.class);
      suite.addTestSuite(DateUtilTest.class);
      return suite;
   }
}