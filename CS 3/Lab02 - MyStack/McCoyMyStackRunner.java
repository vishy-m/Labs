import java.util.*;
public class McCoyMyStackRunner 
{

/** DESIRED OUTPUT

 true
 Attempting to pop an empty stack threw appropriate exception!
 
 In the stack:
 {4, 6, 3, 7}
 
 7 3 3 6 false 6 4 true
 
 {12, 23, 34, 45, 56, 67, 78, 89, 90}
 90 89 78 67 56 45 34 23 12 EMPTY   

*/      


   public static void main(String[] args)
   {
      MyStack m = new MyStack();
   	
      System.out.println(m.isEmpty()); //test with empty stack
   	
      try { m.pop(); } 
      catch (EmptyStackException e) { System.out.println("Attempting to pop an empty stack threw appropriate exception!"); }
   	
      m.push(4); m.push(6); m.push(3); m.push(7); //test push() method
   	
      System.out.println("\nIn the stack:\n" + m); //test toString() method
   			
      System.out.print("\n" + m.pop() + " "); //test peek() and pop()
      System.out.print(m.peek() + " "); 
      System.out.print(m.pop() + " ");
      System.out.print(m.peek() + " ");
      System.out.print( m.isEmpty() + " ");
      System.out.print(m.pop() + " ");
      System.out.print(m.pop() + " ");
      System.out.println(m.isEmpty());
      System.out.println();
      
      //testing doubleCapacity method by creating a stack that can only hold 3 numbers, but pushing 9 numbers to it.
      m = new MyStack(3);         
      m.push(12); m.push(23); m.push(34);  m.push(45);    			
      m.push(56); m.push(67); m.push(78);  m.push(89);  m.push(90);     	
      System.out.println(m); 
      
      //pop until empty
      while (! m.isEmpty()) {
         System.out.print( m.pop() + " " );
      }
      System.out.println("EMPTY");
   }
}