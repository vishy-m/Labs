import java.util.*;

public class StackProbs
{
   public Stack<Integer> doubleUp(Stack<Integer> nums)
   {
      Stack<Integer> temp = new Stack<Integer>();
      
      while (!nums.isEmpty())
      {
         temp.push(nums.pop());
      }
      
      while (!temp.isEmpty())
      {
         nums.push(temp.peek());
         nums.push(temp.pop());
      }
      
      return nums;
   }
   
   public Stack<Integer> posAndNeg(Stack<Integer> nums)
   {
      Stack<Integer> pos = new Stack<Integer>();
      Stack<Integer> neg = new Stack<Integer>();
      
      while (!nums.isEmpty())
      {
         if (nums.peek() < 0) neg.push(nums.pop());
         else pos.push(nums.pop());
      }
      
      while (!neg.isEmpty())
      {
         nums.push(neg.pop());
      }
      
      while (!pos.isEmpty())
      {
         nums.push(pos.pop());
      }
      
      return nums;
      
   }
   
   public Stack<Integer> shiftByN(Stack<Integer> nums, int n)
   {
      Stack<Integer> temp = new Stack<Integer>();
   
      int size = nums.size();
      for (int i = size; i > n; i--)
      {
         temp.push(nums.pop());
      }
      
      Stack<Integer> reversedNums = new Stack<Integer>();
      while (!nums.isEmpty())
         reversedNums.push(nums.pop());
      
      while (!temp.isEmpty())
         nums.push(temp.pop());
      
      while (!reversedNums.isEmpty())
         nums.push(reversedNums.pop());
      
      return nums;
      
   }
   
   public String reverseVowels(String str)
   {
      Stack<Character> vowels = new Stack<Character>();
      String finalStr = "";
      
      
      for (char c : str.toCharArray())
      {
         if (isVowel(c))
            vowels.push(c);
      }
      
      for (char c : str.toCharArray())
      {
         if (isVowel(c))
            finalStr += vowels.pop(); 
              
         else finalStr += c;
      }
      
      
      return finalStr;
   }
   
   private Boolean isVowel(char c)
   {
      String vowels = "aeiou";
      
      if (vowels.indexOf(c) == -1) 
         return false;
      return true;
   }
   
   public boolean bracketBalance(String s)
   {
   
      Stack<Character> stack = new Stack<Character>();
      HashMap<Character, Character> pairs = new HashMap<Character, Character>();
      pairs.put('(', ')');
      pairs.put('[', ']');
      
      char[] chars = s.toCharArray();
      
      for (int i = 0; i < chars.length; i++)
      {
         if (stack.isEmpty())
         {
            stack.push(chars[i]);
            continue;
         }
         
         if (chars[i] == pairs.get(stack.peek()))
            stack.pop();
         else stack.push(chars[i]);
      }
   
      if (stack.size() != 0)
         return false;
      return true;
   }
   
}