import static java.lang.System.*;
import java.util.*;

public class RecursionPractice {

   public static double sumReciprocals(int n)  {
      double num = (double)1 / (double)n;
      if (num == 1.0)
      {
         return 1.0;
      }
      else
      {
         return num + sumReciprocals(n - 1);
      }
   }
   
   public static int productOfEvens(int n) 
   {
      if (n == 0) 
         return 1;
      return n*2 * productOfEvens(n-1);
   }
   
   
   
   public static void doubleUp(Stack<Integer> nums)
   {
      int num = nums.pop();
      if (!nums.isEmpty())
      {
         doubleUp(nums);
      }
      nums.push(num);
      nums.push(num);
   }
   
   public static void countToBy(int n, int m)
   {
      int num = n - m;
      if (num > m)
      {
         countToBy(num, m);
      }
      else
      {
         System.out.print(num + "");
      }
      System.out.print(", " + n);
   }
   
   public static int matchingDigits(int a, int b)
   {
      int aRightD = a % 10;
      int bRightD = b % 10;
      
      int newA = a / 10;
      int newB = b / 10;
      
      boolean sameNum = aRightD == bRightD;
      
      if (newB == 0)
      {
         if (sameNum)
         {
            return 1;
         }
         return 0;
      }
      
      if (sameNum)
      {
         return 1 + matchingDigits(newA, newB);
      }
      return matchingDigits(newA, newB);
   }
   
   public static void printThis(int n)
   {
      if (n == 1)
      {
         System.out.print("*");
      }
      else if (n == 2)
      {
         System.out.print("**");
      }
      else
      {
         System.out.print("<");
         printThis(n - 2);
         System.out.print(">");
      }
   }
   
   public static void printNums2(int n)
   {
      
      if (n == 1)
      {
         System.out.print("1 ");
      }
      else if (n == 2)
      {
         System.out.print("1 1 ");
      }
      else
      {  
         int num = n / 2;
         if (n % 2 != 0)
         {
            num++;
         }
         System.out.print(num + " ");
         printNums2(n - 2);
         System.out.print(num + " ");
      }
   }
   
/**
*  Use this main method for running tests.
*/
   public static void main(String[] args) {
      System.out.println(sumReciprocals(10)); //Should print 2.9289682539682538
      System.out.println(productOfEvens(4));
      
      Stack<Integer> stack = new Stack<Integer>();
      stack.push(3);
      stack.push(7);
      stack.push(12);
      stack.push(9);
      doubleUp(stack);
      
      System.out.println(stack);
      
      countToBy(34, 5);
      System.out.println();
      countToBy(25, 4);
      System.out.println();
      
      System.out.println(matchingDigits(1000, 0));
      printThis(8);
      System.out.println();
      
      for (int i = 1; i <= 10; i++)
      {
         printNums2(i);
         System.out.println();
      }
   }


}