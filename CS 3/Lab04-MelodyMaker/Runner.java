import java.util.*;
public class Runner
{
   public static void main(String[] args)
   {
      QueueProbs probs = new QueueProbs();
      
      int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
      Queue<Integer> test = makeQueue(nums);
      
      
      System.out.println(probs.evenFirst(test));
      System.out.println(probs.getPrimes(120));
      
   }
   
   public static Queue<Integer> makeQueue(int[] values)
   {
      Queue<Integer> vals = new LinkedList<Integer>();
      for (int i = 0; i < values.length; i++)
      {
         vals.offer(values[i]);
      }
      return vals;
   }
}