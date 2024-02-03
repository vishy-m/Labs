//Version 1.2
@SuppressWarnings({"unchecked", "deprecation"}) 
public class TesterMinHeap extends TestGUI.TestData{ 
   public static void main (String[] args) {  
      double requiredVersion = 2.2;
      if (VERSION_NUM < requiredVersion)
         System.out.println("This test script requires TestGUI version " + requiredVersion + " or higher.\nPlease download a newer version of TestGUI.java.");
      else
         new TestGUI();   
   }

   public static void runTests() {  //Your test sequence must be within a method called runTests()
      //WRITE ALL YOUR TEST CASES IN HERE       
      setTimeOutSec(30);
      srcButton("MinHeap, MinHeapGeneric");
   
      // Newline Converter: https://onlinestringtools.com/convert-newlines-to-spaces
      // Object testMethod(String cName, String mName, Object[] args, [String expOut], [double allowableError], [String inputScript])
   
      header("MinHeap Tests");  
   
      Object o = makeObject("MinHeap", new Object[]{5});        
      
      int[] nums = {8, 42, 35, 4, -1, 99, 76, 20};   	
      for (int i = 0; i < nums.length; i++) 
         testMethod(o, "insert", new Object[] {nums[i]});
         
      testMethod(o, "toString", new Object[] {},
         "-1, 4, 35, 20, 8, 99, 76, 42"
         ); 
   
      testMethod(o, "insert", new Object[] {36});
      testMethod(o, "toString", new Object[] {},
         "-1, 4, 35, 20, 8, 99, 76, 42, 36"
         );
         
      testMethod(o, "insert", new Object[] {3});
      testMethod(o, "toString", new Object[] {},
         "-1, 3, 35, 20, 4, 99, 76, 42, 36, 8"
         );
   
   
      testMethod(o, "popMinimum", new Object[] {},
         "-1"
         );
         
      testMethod(o, "toString", new Object[] {},
         "3, 4, 35, 20, 8, 99, 76, 42, 36"
         );
         
      testMethod(o, "peekMinimum", new Object[] {},
         "3"
         );
         
      testMethod(o, "toString", new Object[] {},
         "3, 4, 35, 20, 8, 99, 76, 42, 36"
         );
         
      testMethod(o, "popMinimum", new Object[] {},
         "3"
         );
         
      testMethod(o, "popMinimum", new Object[] {},
         "4"
         );
         
      testMethod(o, "popMinimum", new Object[] {},
         "8"
         );
         
      testMethod(o, "popMinimum", new Object[] {},
         "20"
         );
         
      testMethod(o, "popMinimum", new Object[] {},
         "35"
         );
         
      testMethod(o, "popMinimum", new Object[] {},
         "36"
         );
         
      testMethod(o, "popMinimum", new Object[] {},
         "42"
         );
         
      testMethod(o, "popMinimum", new Object[] {},
         "76"
         );
         
      testMethod(o, "popMinimum", new Object[] {},
         "99"
         );
         
      testMethod(o, "toString", new Object[] {},
         ""
         );         
         
      message("Testing the varArgs constructor, which should use your buildHeap method.");   
      o = makeObject("MinHeap",  Integer.class, new Object[]{8, 6, -1, 7, 9, 5, 3, 0});  
          
      testMethod(o, "popMinimum", new Object[] {},
         "-1"
         );
   
      testMethod(o, "popMinimum", new Object[] {},
         "0"
         );
                  
      testMethod(o, "popMinimum", new Object[] {},
         "3"
         );
         
      testMethod(o, "popMinimum", new Object[] {},
         "5"
         );
         
      testMethod(o, "popMinimum", new Object[] {},
         "6"
         );
         
      testMethod(o, "popMinimum", new Object[] {},
         "7"
         );
         
      testMethod(o, "popMinimum", new Object[] {},
         "8"
         );
         
      testMethod(o, "popMinimum", new Object[] {},
         "9"
         );
   
      message("Testing MinHeapGeneric with Doubles");
      o = makeObject("MinHeapGeneric", new Object[]{});  
      testMethod(o, "insert", new Object[] {"5.5"});
      testMethod(o, "insert", new Object[] {"8.8"});
      testMethod(o, "insert", new Object[] {"2.2"});
      testMethod(o, "popMinimum", new Object[] {},
         "2.2"
         );
   
      message("Testing MinHeapGeneric with Strings");
      o = makeObject("MinHeapGeneric", new Object[]{});  
      testMethod(o, "insert", new Object[] {"hi"});
      testMethod(o, "insert", new Object[] {"bye"});
      testMethod(o, "insert", new Object[] {"foo"});
      testMethod(o, "popMinimum", new Object[] {},
         "bye"
         );
         
      message("Testing the varArgs constructor of your MinHeapGeneric.");
      o = makeObject("MinHeapGeneric", String.class, new Object[]{"salsa", "tastes", "so", "very", "good"});  
      testMethod(o, "popMinimum", new Object[] {},
         "good"
         );
   }    
}