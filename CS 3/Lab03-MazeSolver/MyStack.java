import java.util.*;
public class MyStack implements StackADT
{
   private Square[] stack;
   private int size;
   
   public MyStack(int initCap)
   {
      stack = new Square[initCap];
   }
   
   public MyStack()
   {
      this(10);
   }
   
   public boolean isEmpty()
   {
      return size == 0;
   }
   
   public Square peek()
   {
      if (isEmpty()) throw new EmptyStackException();
      return stack[size - 1];
   }
   
   public Square pop()
   {
      if (isEmpty()) throw new EmptyStackException();
      
      Square sq = stack[size - 1];
      stack[size - 1] = null;
      size--;
      return sq;
      
   }
   
   public void push(Square item)
   {
      if (size + 1 >= stack.length)
      {
         doubleCapacity();
      }
      
      stack[size] = item;
      size++;
      
   }
   
   public int size()
   {
      return size;
   }
   
   private void doubleCapacity()
   {
      Square[] temp = new Square[stack.length * 2];
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
   public void clear()
   {
      for (int i = 0; i < size; i++)
      {
         stack[i] = null;
      }
      size = 0;
   }
   
}