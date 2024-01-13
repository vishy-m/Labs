import java.util.*;
public class QueueProbs
{
   public static void main(String[] args)
   {
      
   }
   
   public Queue<Integer> evenFirst(Queue<Integer> nums)
   {
      Queue<Integer> temp = new LinkedList<Integer>();
      Queue<Integer> evens = new LinkedList<Integer>();
      while (!nums.isEmpty())
      {
         if (nums.peek() % 2 == 0)
         {
            evens.offer(nums.poll());
            continue;
         }
         temp.offer(nums.poll());
      }
      while (!temp.isEmpty())
      {
         evens.offer(temp.poll());
      }
      return evens;
   }
   
   public Stack<Integer> getPrimes(int n)
   {
      Queue<Integer> nums = new LinkedList<Integer>();
      Stack<Integer> primes = new Stack<Integer>();
      
      for (int i = 2; i <= n; i++)
      {
         nums.offer(i);
      } 
      
      for (int i = 0; !nums.isEmpty(); i++)
      {
         primes.push(nums.poll());
         int size = nums.size();
         for (int r = 0; r < size; r++)
         {
            if (nums.peek() % primes.peek() == 0) nums.poll();
            else nums.offer(nums.poll());
         }
      }
      
      return primes;
   }
   
}