@SuppressWarnings("unused")
public class Tester00 extends TestGUI.TestData {
   public static void main (String[] args) throws Exception {  
      if (VERSION_NUM < 2.2)
         System.out.println("This test script requires TestGUI version 2.3 or higher.\nPlease download a newer version of TestGUI.java.");
      else
         new TestGUI();   
   }

   public static void runTests() {  //Your test sequence must be within a method called runTests()
      setTimeOutSec(5);
      message("Best possible score:  25 green, 0 yellow, 0 red");
      srcButton("WelcomeBack,NumberList");
      
      header("Welcome Back Problems");
      Object o = makeObject("WelcomeBack");
      testMethod(o,"getMiddle",new Object[] {"abcde"},"c");
      testMethod(o,"getMiddle",new Object[] {"wxyz"},"xy");
      testMethod(o,"sumNumbers", new Object[] {3},"[0, 1, 3, 6]");
      testMethod(o,"sumNumbers", new Object[] {12},"[0, 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78]");
      testMethod(o,"sumDigits", new Object[] {311}, "5");
      testMethod(o,"sumDigits", new Object[] {234}, "9");
      testMethod(o,"keepSummingDigits", new Object[] {29}, "2");
      testMethod(o,"keepSummingDigits", new Object[] {99984}, "3");
      testMethod(o,"getIntersection", new Object[] {new int[] {1,2,3,4,1}, new int[] {9,0,4,3,4,1}}, "134");
      testMethod(o,"getIntersection", new Object[] {new int[] {5,4,4,4}, new int[] {9,0,4,3,4,1}}, "4");
      testMethod(o,"mapLengths", new Object[] {new String[] {"a", "b", "hello", "hi", "yo", "I"}}, "{1=3, 2=2, 5=1}");
      testMethod(o,"mapLengths", new Object[] {new String[] {"dog", "salsa", "hello", "cat", "spicy"}}, "{3=2, 5=3}");
      testMethod(o,"sumWithoutCarry", new Object[] {863, 551}, "314");
      testMethod(o,"sumWithoutCarry", new Object[] {9999, 8765}, "7654");
      
      header("NumberList ADT");
      o = makeObject("NumberList");
      testMethod(o, "size", null, "0");
      testMethod(o, "isEmpty", null, "true");
      testMethod(o, "toString", null, "[]");
      testMethod(o, "add", new Object[] {0, 100});
      testMethod(o, "add", new Object[] {1, 200});
      testMethod(o, "add", new Object[] {0, 5});
      testMethod(o, "toString", null, "[5, 100, 200]");
      testMethod(o, "size", null, "3");
      testMethod(o, "add", new Object[] {300});
      testMethod(o, "add", new Object[] {400});
      testMethod(o, "add", new Object[] {500});
      testMethod(o, "add", new Object[] {600});
      testMethod(o, "toString", null, "[5, 100, 200, 300, 400, 500, 600]");
      testMethod(o, "size", null, "7");
      testMethod(o, "get", new Object[] {4}, "400");
      testMethod(o, "set", new Object[] {4, 410}, "400");
      testMethod(o, "toString", null, "[5, 100, 200, 300, 410, 500, 600]");
      testMethod(o, "remove", new Object[] {5});
      testMethod(o, "remove", new Object[] {0});
      testMethod(o, "toString", null, "[100, 200, 300, 410, 600]");

      
      //header("Advanced Problems");
      //If you did any of the advanced practice problems, you can uncomment the appropriate test(s)
   
      //testMethod(o,"buySell1", new Object[] {new int[] {3, 4, 3, 2, 1, 5}}, "4");
      //testMethod(o,"buySell1", new Object[] {new int[] {5, 4, 3, 2, 1, 1}}, "0");
      //testMethod(o,"buySell2", new Object[] {new int[] {1, 2, 7, 4, 11}}, "13");
      //testMethod(o,"buySell2", new Object[] {new int[] {2, 6, 8, 7, 8, 7, 9, 4, 1, 2, 4, 5, 8}}, "16");
      //testMethod(o,"buySell3", new Object[] {new int[] {1, 4, 7, 2, 11}}, "15");
      //testMethod(o,"buySell3", new Object[] {new int[] {1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9}}, "17");
      //testMethod(o,"buySell4", new Object[] {4, new int[] {1, 2, 4, 2, 5, 7, 2, 4, 9, 0}}, "15");
      //testMethod(o,"buySell4", new Object[] {2, new int[] {1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9}}, "17");//*/
        
   }
}
