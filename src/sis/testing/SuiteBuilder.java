package sis.testing;

import java.util.*;
import junit.runner.*;
import junit.framework.*;
import java.lang.reflect.*;

public class SuiteBuilder {
   public TestSuite suite() {
      TestSuite suite = new TestSuite();
      for (String className: gatherTestClassNames()) {
         Class klass = createClass(className);
         suite.addTestSuite(klass);
      }
      return suite;
   }

   public List<String> gatherTestClassNames() {
      TestCollector collector = new ClassPathTestCollector() {
         public boolean isTestClass(String classFileName) {
            if (!super.isTestClass(classFileName))
               return false;
            String className = classNameFromFile(classFileName);
            Class klass = createClass(className);
            return
               TestCase.class.isAssignableFrom(klass) &&
               isConcrete(klass);
         }
      };
      return Collections.list(collector.collectTests());
   }

   private boolean isConcrete(Class klass) {
      if (klass.isInterface())
         return false;
      int modifiers = klass.getModifiers();
      return !Modifier.isAbstract(modifiers);
   }

   private Class createClass(String name) {
      try {
         return Class.forName(name);
      }
      catch (ClassNotFoundException e) {
         return null;
      }
   }
}