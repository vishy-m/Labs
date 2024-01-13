import java.util.*;
public class NumberListRunner 
{
   private static NumberList myList = new NumberList(); //the number list object the tests will work with
	
   public static void main(String[] args) 
   {
   	/*
   	 * NumberList objects should function in the same way as an ArrayList that stores Integers
   	 * 
   	 * in other words, NumberList list = new NumberList(); should work the
   	 * same as ArrayList<Integrer> list = new ArrayList<>();
   	 * 
   	 * Uncomment a test you'd like to perform.
       * You must uncomment the method call and the method itself.
   	 */
   	      
      
       test00isEmptyAndSize();
       System.out.println(myList + "\n");
       
      test01outOfBoundsTwoParamAdd();
      System.out.println(myList + "\n");
       
      test02twoParamAdd();
      System.out.println(myList + "\n");
      
      test03twoParamAddOutOfBounds();	
      System.out.println(myList + "\n");
       
      test04oneParamAdd();		
      System.out.println(myList + "\n");
       
      test05get();		
      System.out.println(myList + "\n");
       
      test06getOutOfBounds();
      System.out.println(myList + "\n");
       
      test07set();	
      System.out.println(myList + "\n");
       
      test08setOutOfBounds();
      System.out.println(myList + "\n");
       
      test09remove();
      System.out.println(myList + "\n");
       
      test10removeOutOfBounds();
      System.out.println(myList + "\n");
      
      test11removeAll();
      System.out.println(myList);
   }
	
   //make sure the number list starts empty
   public static void test00isEmptyAndSize() {
      if (myList.isEmpty() && myList.size() == 0)
         System.out.println("Pass: Your isEmpty/size/constructor methods seems to be working!");
      else
         System.out.println("Fail: Your isEmpty and/or size methods may not be working");
   }



	//test cases that will go out of bounds
   public static void test01outOfBoundsTwoParamAdd() {
      try { 
         myList.add(-1, 5); //add element 5 at index -1
      } 
      catch (IndexOutOfBoundsException e) { 
         System.out.println("Pass: Your out of bounds exception handling seems to be working");
         return;
      }
      System.out.println("Fail: Your add method did not catch the out of bounds exception");
   }



	//test two parameter add method, list should begin empty
   public static void test02twoParamAdd() {
   	//adding at 'size' is allowed, per the lab doc
      myList.add(0, 23); 
      myList.add(1, 17); 
      myList.add(0, 44);
   	
      if (myList.size() == 3 && myList.toString().equals("[44, 23, 17]"))
         System.out.println("Pass: Your two-param add method seems to be working!");
      else
         System.out.println("Fail: There was a problem with your two-param add method");
   }



	//test the two-param add with a value that will be out of bounds 
   public static void test03twoParamAddOutOfBounds() {
      try {
         myList.add(4, 100);
      }
      catch (IndexOutOfBoundsException e) {
         System.out.println("Pass: Caught the two-parameter add out of bounds exception!");
         return;
      }
      System.out.println("Fail: There's a problem with your two-parameter add method's exception handling");
   }



	//test the add() method and toString() method
   public static void test04oneParamAdd() {
      myList.add(6); 
      myList.add(8); //may require capacity doubling, depending on the initial size of the backing array
   	
      if (myList.size() == 5 && myList.toString().equals("[44, 23, 17, 6, 8]"))
         System.out.println("Pass: Your single-parameter add method / toString method seems to be working!");
      else
         System.out.println("Fail: Either your single-parameter add method or your toString method is not working correctly");
   }



	//test the get() method
   public static void test05get() {
      int a = myList.get(0);               //44
      int b = myList.get(1);               //23
      int c = myList.get(myList.size() - 1); //8
   	
      if (a == 44 && b == 23 && c == 8)
         System.out.println("Pass: Your get method seems to be working!");
      else
         System.out.println("Fail: There's a problem with the get method");
   }
   
   
    //test the get() method with a request for data that is out of bounds
   public static void test06getOutOfBounds() {
      try {
         System.out.println(myList);
         myList.get(5);
      }
      catch (IndexOutOfBoundsException e) {
         System.out.println("Pass: Caught the get method's out of bounds exception!");
         return;
      }
      System.out.println("Fail: There's a problem with your get method's exception handling");
   }



	//test the set() method
   public static void test07set() {
      myList.set(0, 20);
      myList.set(2, 40);
   	
   	//size shouldn't change with set
      if (myList.size() == 5 && myList.get(0) == 20 && myList.get(2) == 40)
         System.out.println("Pass: Your set method seems to be working!");
      else
         System.out.println("Fail: There's a problem with your set method");
   }
   
   
   //test the set() method with a request that is out of bounds 
   public static void test08setOutOfBounds() {
      try {
         myList.set(5, 300);
      }
      catch (IndexOutOfBoundsException e) {
         System.out.println("Pass: Caught the set method's out of bounds exception!");
         return;
      }
      System.out.println("Fail: There's a problem with your set method's exception handling");
   }

   

	//test the remove() method
   public static void test09remove() {
   	//list = [20, 23, 40, 6, 8]
      int a = myList.remove(0); //remove 20 from the list, list is now [23, 40, 6, 8]
      int b = myList.remove(myList.size() - 2); //remove 6 from list, list is now [23, 40, 8]
   
      if (myList.size() == 3 && a == 20 && b == 6 && myList.toString().equals("[23, 40, 8]"))
         System.out.println("Pass: Your remove method seems to be working!");
      else
         System.out.println("Fail: There's a problem with your remove method");
   }
   
   
    //test the remove() method with a request that is out of bounds 
   public static void test10removeOutOfBounds() {
      try {
         myList.remove(3);  //at this moment, the list only has 3 values in it, in spots zero through two
      }
      catch (IndexOutOfBoundsException e) {
         System.out.println("Pass: Caught the remove method's out of bounds exception!");
         return;
      }
      System.out.println("Fail: There's a problem with your remove method's exception handling");
   }


   //repeatedly remove spot zero until the list is empty
   public static void test11removeAll() {
      while (!myList.isEmpty())
         myList.remove(0);
   	
      if (myList.toString().equals("[]") && myList.size() == 0 && myList.isEmpty())
         System.out.println("Pass: All items removed from list successfully!");
      else
         System.out.println("Fail: There was a problem removing the remainder of the items from the list");
   }
}