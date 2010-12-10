package sis.testing;

public class TestRunner {
   public static void main(String[] args) {
      new junit.swingui.TestRunner().run(TestRunner.class);
   }

   public static junit.framework.Test suite() {
      return new SuiteBuilder().suite();
   }
}