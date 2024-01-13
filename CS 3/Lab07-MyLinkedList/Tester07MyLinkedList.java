public class Tester07MyLinkedList extends TestGUI.TestData{ 
   public static void main (String[] args) {  
      
      new TestGUI();   
   }

   
   public static void runTests() {  //Your test sequence must be within a method called runTests()
      //WRITE ALL YOUR TEST CASES IN HERE       
      setTimeOutSec(2);
        
      srcButton("MyLinkedList, Runner");
      header("LAB - MyLinkedList");
      
      header("Testing constructors, simple add, and toString");
      Object o =  makeObject("MyLinkedList", new Object[]{20});   
      testMethod(o, "toString", new Object[]{}, "[20]");         
      o = makeObject("MyLinkedList", new Object[]{});
      testMethod(o, "toString", new Object[]{}, "[]");        
      testMethod(o, "add", new Object[]{101});
      testMethod(o, "add", new Object[]{102});
      testMethod(o, "add", new Object[]{103});
      testMethod(o, "add", new Object[]{104});      
      testMethod(o, "toString", new Object[]{}, "[101, 102, 103, 104]");
      
      header("Testing size, indexOf, contains");
      testMethod(o, "size", new Object[]{}, "4");   
      testMethod(o, "add", new Object[]{105});   
      testMethod(o, "size", new Object[]{}, "5"); 
      header("Testing contains");
      testMethod(o, "contains", new Object[]{100}, "false");
      testMethod(o, "contains", new Object[]{101}, "true");
      testMethod(o, "contains", new Object[]{103}, "true");
      testMethod(o, "contains", new Object[]{105}, "true");
      testMethod(o, "contains", new Object[]{106}, "false");
      header("Testing indexOf");
      testMethod(o, "indexOf", new Object[]{100}, "-1");
      testMethod(o, "indexOf", new Object[]{101}, "0");
      testMethod(o, "indexOf", new Object[]{103}, "2");
      testMethod(o, "indexOf", new Object[]{105}, "4");
      testMethod(o, "indexOf", new Object[]{106}, "-1");
      header("Testing get");
      testMethod(o, "get", new Object[]{0}, "101");
      testMethod(o, "get", new Object[]{3}, "104");
      testMethod(o, "get", new Object[]{4}, "105");
      testMethod(o, "get", new Object[]{-1}, "This should throw exception and crash");
      testMethod(o, "get", new Object[]{5}, "This should throw exception and crash");
      header("Testing set");
      testMethod(o, "toString", new Object[]{}, "[101, 102, 103, 104, 105]");
      testMethod(o, "set", new Object[]{201, 0});
      testMethod(o, "set", new Object[]{203, 2});
      testMethod(o, "set", new Object[]{205, 4});
      testMethod(o, "set", new Object[]{999, 6}, "This should throw exception and crash");
      testMethod(o, "toString", new Object[]{}, "[201, 102, 203, 104, 205]");
      
      header("Rebuilding List to [101, 102, 103, 104, 105]");
      o = makeObject("MyLinkedList", new Object[]{});     
      testMethod(o, "add", new Object[]{101});
      testMethod(o, "add", new Object[]{102});
      testMethod(o, "add", new Object[]{103});
      testMethod(o, "add", new Object[]{104});
      testMethod(o, "add", new Object[]{105});
      testMethod(o, "toString", new Object[]{}, "[101, 102, 103, 104, 105]");
      
      header("Testing remove");
      message("Removing an inner node");
      testMethod(o, "remove", new Object[]{2}, "103");
      testMethod(o, "toString", new Object[]{}, "[101, 102, 104, 105]");
      message("Removing the head node");
      testMethod(o, "remove", new Object[]{0}, "101");
      testMethod(o, "toString", new Object[]{}, "[102, 104, 105]");
      message("What if we remove the last node?  Does the tail get messed up?  Let's check by removing the last node and then calling the simple add method (which should be using the tail reference to get O(1) time.");
      testMethod(o, "remove", new Object[]{2}, "105");
      testMethod(o, "toString", new Object[]{}, "[102, 104]");
      testMethod(o, "add", new Object[]{555});
      testMethod(o, "toString", new Object[]{}, "[102, 104, 555]");
      
      header("Building a new list using only the add method that lets us decide where to add things.");
      o = makeObject("MyLinkedList", new Object[]{});     
      testMethod(o, "add", new Object[]{103, 0});
      testMethod(o, "add", new Object[]{102, 0});
      testMethod(o, "add", new Object[]{101, 0});
      testMethod(o, "toString", new Object[]{}, "[101, 102, 103]");
      testMethod(o, "add", new Object[]{888, 1});
      testMethod(o, "toString", new Object[]{}, "[101, 888, 102, 103]");
      testMethod(o, "add", new Object[]{777, 0});
      testMethod(o, "toString", new Object[]{}, "[777, 101, 888, 102, 103]");
      
      message("What if we use the add(val, pos) method to add a node to the end?  Does the tail get messed up?  Let's check.");
      testMethod(o, "add", new Object[]{888, 5});
      testMethod(o, "add", new Object[]{999});   
      testMethod(o, "toString", new Object[]{}, "[777, 101, 888, 102, 103, 888, 999]");
      
      header("Rebuilding List to [101, 102, 103]");
      o = makeObject("MyLinkedList", new Object[]{});     
      testMethod(o, "add", new Object[]{101});
      testMethod(o, "add", new Object[]{102});
      testMethod(o, "add", new Object[]{103});
      testMethod(o, "toString", new Object[]{}, "[101, 102, 103]");
      
      header("Let's remove everything.");
      testMethod(o, "size", new Object[]{}, "3");
      testMethod(o, "remove", new Object[]{0}, "101");
      testMethod(o, "size", new Object[]{}, "2");
      testMethod(o, "remove", new Object[]{0}, "102");
      testMethod(o, "size", new Object[]{}, "1");
      testMethod(o, "remove", new Object[]{0}, "103");
      testMethod(o, "size", new Object[]{}, "0");
      testMethod(o, "toString", new Object[]{}, "[]");
   
   }    
}