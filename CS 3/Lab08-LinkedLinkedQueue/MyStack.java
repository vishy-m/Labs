import java.util.*; 
public class MyStack implements StackADT {

   private Square[] stack;
   private int size;

   public MyStack() {
      this(10);
   }

   public MyStack(int initCap) {
      stack = new Square[initCap];
      size = 0;
   }

   public boolean isEmpty() { 
      return size == 0; 
   }
   
   public Square peek() {
      if (isEmpty())
         throw new EmptyStackException();
      return stack[size-1];
   }
   
   public Square pop() {         
      if (isEmpty())
         throw new EmptyStackException();
      size--;
      return stack[size];
   }
   
   public void push(Square item) {
      if (size == stack.length)
         doubleCapacity();
      stack[size] = item;
      size++;
   }
   
   private void doubleCapacity() {
      Square[] temp = new Square[stack.length*2];
      for (int i = 0; i < stack.length; i++)
         temp[i] = stack[i];
      stack = temp;
   }
   
   public int size() {
      return size;
   }
   
   public void clear() {
      size = 0;
   }
   
   @Override
   public String toString() {
      if (size == 0) 
         return "{ }";
      String ret = "{";
      for (int i = 0; i < size; i++)
         ret += stack[i] + ", ";
      return ret.substring(0, ret.length()-2) + "}";
   }

}