//Version 2.0
public class Tester21 extends TestGUI.TestData{ 
   public static void main (String[] args) {  
      if (VERSION_NUM < 2.171)
         System.out.println("This test script requires TestGUI version 2.171 or higher.\nPlease download a newer version of TestGUI.java.");
      else
         new TestGUI();   
   }

   public static void runTests() {  //Your test sequence must be within a method called runTests()
      //WRITE ALL YOUR TEST CASES IN HERE       
      setTimeOutSec(5);
      srcButton("SearchSort");
   
      // Newline Converter: https://onlinestringtools.com/convert-newlines-to-spaces
      // Object testMethod(String cName, String mName, Object[] args, [String expOut], [double allowableError], [String inputScript])
   
      Object o;
   
      header("Searching & Sorting");  
      message("Best possible score is: 28 Green, 2 Yellow, 0 Red");
      header("Constructor tests");
      o = makeObject("SearchSort", new Object[]{new int[]{4, 7, 6, 5}});
      testMethod(o, "toString", null, "[4, 7, 6, 5]");
      o = makeObject("SearchSort", new Object[]{3});        
      testMethod(o, "toString", null, "[%int1_1000%, %int1_1000%, %int1_1000%]");
      o = makeObject("SearchSort", new Object[]{4});
      testMethod(o, "toString", null, "[%int1_1000%, %int1_1000%, %int1_1000%, %int1_1000%]");
   
      int[] teens = {19, 17, 15, 13, 14, 16, 18};
      int[] sorted = {13, 14, 15, 16, 17, 18, 19};
   
      header("Linear Searches");
      o = makeObject("SearchSort", new Object[]{teens.clone()});
      testMethod(o, "toString", null, "[19, 17, 15, 13, 14, 16, 18]");
      testMethod(o, "linearSearch", new Object[]{15}, "2");
      testMethod(o, "linearSearch", new Object[]{19}, "0");
      testMethod(o, "linearSearch", new Object[]{18}, "6");
      testMethod(o, "linearSearch", new Object[]{20}, "-1"); 
   
   
      header("Binary Searches");
      o = makeObject("SearchSort", new Object[]{sorted.clone()});
      testMethod(o, "toString", null, "[13, 14, 15, 16, 17, 18, 19]");
      testMethod(o, "binarySearch", new Object[]{13}, "0");
      testMethod(o, "binarySearch", new Object[]{15}, "2");
      testMethod(o, "binarySearch", new Object[]{19}, "6");
      testMethod(o, "binarySearch", new Object[]{10}, "-1");
      testMethod(o, "binarySearch", new Object[]{20}, "-1");
   
      int[] small = {6, 4, 5, 3};
      int[] rand = {865, 385, 467, 999, 124, 578, 245, 685};
      header("Bubble Sort");
      o = makeObject("SearchSort", new Object[]{small.clone()});
      testMethod(o, "bubbleSort", new Object[]{true}, 
         "[4, 6, 5, 3]\n[4, 5, 6, 3]\n[4, 5, 3, 6]\n[4, 3, 5, 6]\n[3, 4, 5, 6]"
         );
      testMethod(o, "toString", null, "[3, 4, 5, 6]");
      o = makeObject("SearchSort", new Object[]{rand.clone()});
      testMethod(o, "bubbleSort", new Object[]{true}, 
         "[385, 865, 467, 999, 124, 578, 245, 685]\n[385, 467, 865, 999, 124, 578, 245, 685]\n[385, 467, 865, 124, 999, 578, 245, 685]\n[385, 467, 865, 124, 578, 999, 245, 685]\n[385, 467, 865, 124, 578, 245, 999, 685]\n[385, 467, 865, 124, 578, 245, 685, 999]\n[385, 467, 124, 865, 578, 245, 685, 999]\n[385, 467, 124, 578, 865, 245, 685, 999]\n[385, 467, 124, 578, 245, 865, 685, 999]\n[385, 467, 124, 578, 245, 685, 865, 999]\n[385, 124, 467, 578, 245, 685, 865, 999]\n[385, 124, 467, 245, 578, 685, 865, 999]\n[124, 385, 467, 245, 578, 685, 865, 999]\n[124, 385, 245, 467, 578, 685, 865, 999]\n[124, 245, 385, 467, 578, 685, 865, 999]"
         );
      testMethod(o, "toString", null, "[124, 245, 385, 467, 578, 685, 865, 999]");
   
      header("Selection Sort");
      o = makeObject("SearchSort", new Object[]{small.clone()});
      testMethod(o, "selectionSort", new Object[]{true}, 
         "[3, 4, 5, 6]\n[3, 4, 5, 6]\n[3, 4, 5, 6]\n[3, 4, 5, 6]"
         );
      testMethod(o, "toString", null, "[3, 4, 5, 6]");
      o = makeObject("SearchSort", new Object[]{rand.clone()});
      testMethod(o, "selectionSort", new Object[]{true}, 
         "[124, 385, 467, 999, 865, 578, 245, 685]\n[124, 245, 467, 999, 865, 578, 385, 685]\n[124, 245, 385, 999, 865, 578, 467, 685]\n[124, 245, 385, 467, 865, 578, 999, 685]\n[124, 245, 385, 467, 578, 865, 999, 685]\n[124, 245, 385, 467, 578, 685, 999, 865]\n[124, 245, 385, 467, 578, 685, 865, 999]\n[124, 245, 385, 467, 578, 685, 865, 999]"
         );
      testMethod(o, "toString", null, "[124, 245, 385, 467, 578, 685, 865, 999]");
   
      header("Insertion Sort");
      o = makeObject("SearchSort", new Object[]{small.clone()});
      testMethod(o, "insertionSort", new Object[]{true}, 
         "[4, 6, 5, 3]\n[4, 5, 6, 3]\n[3, 4, 5, 6]"
         );
      testMethod(o, "toString", null, "[3, 4, 5, 6]");
      o = makeObject("SearchSort", new Object[]{rand.clone()});
      testMethod(o, "insertionSort", new Object[]{true}, 
         "[385, 865, 467, 999, 124, 578, 245, 685]\n[385, 467, 865, 999, 124, 578, 245, 685]\n[385, 467, 865, 999, 124, 578, 245, 685]\n[124, 385, 467, 865, 999, 578, 245, 685]\n[124, 385, 467, 578, 865, 999, 245, 685]\n[124, 245, 385, 467, 578, 865, 999, 685]\n[124, 245, 385, 467, 578, 685, 865, 999]"
         );
      testMethod(o, "toString", null, "[124, 245, 385, 467, 578, 685, 865, 999]");
   
      header("Merge Sort");
      o = makeObject("SearchSort", new Object[]{small.clone()});
      testMethod(o, "mergeSort", new Object[]{true}, 
         "[4, 6, 5, 3]\n[4, 6, 3, 5]\n[3, 4, 5, 6]"
         );
      testMethod(o, "toString", null, "[3, 4, 5, 6]");
      o = makeObject("SearchSort", new Object[]{rand.clone()});
      testMethod(o, "mergeSort", new Object[]{true}, 
         "[385, 865, 467, 999, 124, 578, 245, 685]\n[385, 865, 467, 999, 124, 578, 245, 685]\n[385, 467, 865, 999, 124, 578, 245, 685]\n[385, 467, 865, 999, 124, 578, 245, 685]\n[385, 467, 865, 999, 124, 578, 245, 685]\n[385, 467, 865, 999, 124, 245, 578, 685]\n[124, 245, 385, 467, 578, 685, 865, 999]"
         );
      testMethod(o, "toString", null, "[124, 245, 385, 467, 578, 685, 865, 999]");
   }
}