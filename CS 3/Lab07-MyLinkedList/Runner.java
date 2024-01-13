public class Runner
{
   public static void main(String[] args)
   {
      MyLinkedList a = new MyLinkedList();
      MyLinkedList b = new MyLinkedList(20);
      
      //UNCOMMENT THINGS AS YOU GO TO RUN TESTS
   	
      System.out.println(a); //test no-parameter constructor and toString() method, should be []
      System.out.println(b); //test parameterized constructor and toString() method, should be [20]
   	
      MyLinkedList list = new MyLinkedList();
      list.add(4); list.add(5); list.add(6);  //test add method      
      
      System.out.println(list); //test one parameter add() method, toString() method, should be [4, 5, 6]
      System.out.println(list.contains(5) + " " + list.contains(3) + " " + list.contains(6)); //test contains
      
      System.out.println("Size >>> " + list.size()); //test size() method, should be 3
      //
      System.out.println("Size (recursive) >>> " + list.sizeRecursive()); //test sizeRecursive() method, should be 3
      System.out.println("Index of value 6 >>> " + list.indexOf(6)); //test indexOf() method, should be 2
      System.out.println("Index of value 100 >>> " + list.indexOf(100)); //test indexOf() method, should be -1
   	
      list.add(10);
      System.out.println(list);
      System.out.println("Last value >>> " + list.get(list.size() - 1)); //test get() method, by getting last element in the list, should be 10      
   	
      list.add(7); list.add(8); list.add(9);               
      list.set(100, 4);  //test set() method
      System.out.println(list); //did set work?
      System.out.println("Size >>> " + list.size()); //is size still working? should be 7
   	
      list.remove(3); //test remove() method, removes at index 3  
      System.out.println(list);  //should have removed the value 100, which was at spot 3
      list.remove(5); //test removing the last item
      System.out.println(list);  //should have removed the value 9, which was at spot 5 (the end)
      list.add(111, 2); //test two parameter add() method 
      System.out.println(list);
   	
      list = new MyLinkedList(); //empty out the list for rebuilding
      list.add(200, 0); //adding several values to an empty list using 2 parameter add
      list.add(300, 1);
      list.add(100, 0);
      System.out.println(list); 
      
      //after you add the tail property, removing the last node can cause problems if you aren't careful.
      list.remove(2);
      list.add(999); //testing single parameter add after removing last node
      System.out.println(list); 
      	
      while (!list.isEmpty()) { //test isEmpty() and remove() methods
         System.out.print(list.remove(0) + " "); //should print list in order
      }
   	
      System.out.println("\n" + list.size()); //test size() method, should be back to 0
      
      /* EXPECTED OUTPUT 
         []
         [20]
         [4, 5, 6]
         true false true
         Size >>> 3
         Size (recursive) >>> 3
         Index of value 6 >>> 2
         Index of value 100 >>> -1
         [4, 5, 6, 10]
         Last value >>> 10
         [4, 5, 6, 10, 100, 8, 9]
         Size >>> 7
         [4, 5, 6, 100, 8, 9]
         [4, 5, 6, 100, 8]
         [4, 5, 111, 6, 100, 8]
         [100, 200, 300]
         [100, 200, 999]
         100 200 999 
         0
      */
      
      
   }
}
