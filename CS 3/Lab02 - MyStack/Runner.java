import java.util.*;

public class Runner
{
   
   
   public static void main(String[] args)
   {
   
      StackProbs test = new StackProbs();
   
      int[] nums = {7, 23, -7, 0, 22, -8, 4, 5};
      Stack<Integer> stack = makeStack(nums);
      
      System.out.println(stack);
      
      //System.out.println(test.doubleUp(stack));
      //System.out.println(test.posAndNeg(stack));
      //System.out.println(test.shiftByN(stack, 3));
      //System.out.println(test.reverseVowels("Hello how are you"));
      System.out.println(test.bracketBalance("([()[]()])()"));
      
   }
   
   
   public static Stack<Integer> makeStack(int[] nums)
   {
      Stack<Integer> stack = new Stack<>();
      for (int num : nums)
         stack.push(num);
      return stack;
   }
   
}