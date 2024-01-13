import java.util.*;
public class MyStack
{
   private int[] stack;
   private int size;
   
   public MyStack(int initCap)
   {
      stack = new int[initCap];
   }
   
   public MyStack()
   {
      this(10);
   }
   
   public boolean isEmpty()
   {
      return size == 0;
   }
   
   public int peek()
   {
      if (isEmpty()) throw new EmptyStackException();
      return stack[size - 1];
   }
   
   public int pop()
   {
      if (isEmpty()) throw new EmptyStackException();
      
      int num = stack[size - 1];
      stack[size - 1] = 0;
      size--;
      return num;
      
   }
   
   public void push(int item)
   {
      if (size + 1 >= stack.length)
      {
         doubleCapacity();
      }
      
      stack[size] = item;
      size++;
      
   }
   
   private void doubleCapacity()
   {
      int[] temp = new int[stack.length * 2];
      for (int i = 0; i < stack.length; i++)
         temp[i] = stack[i];
      stack = temp;
   }
   
   public String toString()
   {
      String str = "[";    
      for (int i = 0; i < size; i++)
      {
         if (i == 0) str += stack[i];
         else str += ", " + stack[i];
      }
      str += "]";
      return str;
      
   }
   
}