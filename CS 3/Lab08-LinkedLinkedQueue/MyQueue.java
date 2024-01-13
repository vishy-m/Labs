import java.util.*;
public class MyQueue<T> implements QueueADT<T>
{
   
   MyGenericLinkedList<T> queue;
   
   public MyQueue()
   {
      queue = new MyGenericLinkedList<T>();
   }
   
   public MyQueue(T... vals)
   {
      queue = new MyGenericLinkedList<T>(vals);
   }
   
   public boolean isEmpty()
   {
      return queue.isEmpty();
   }
   
   public void offer(T item)
   {
      queue.add(item);
   }
   
   public T poll()
   {
      return queue.remove(0);
   }
   
   public T peek()
   {
      return queue.get(0);
   }
   
   public int size()
   {
      return queue.size();
   }
   
   public void clear()
   {
      while (!isEmpty())
      {
         poll();
      }
   }
   
   public String toString()
   {
      return queue.toString();
   }
}