import java.util.*;

public class RecursionPractice11
{

   public static void printBinary(int digits)
   {
      printBinaryRecursive(digits, "");
      System.out.println();
   }
   
   private static void printBinaryRecursive(int digits, String result)
   {
      if (digits != 0)
      {
         printBinaryRecursive(digits - 1, result + "0");
         printBinaryRecursive(digits - 1, result + "1");
      }
      else
      {
         System.out.print(result + " ");
      }
   }
   
   public static void climbStairs(int steps)
   {
      climbStairsRecursive(steps, "");
   }
   
   private static void climbStairsRecursive(int steps, String result)
   {
      
      if (steps <= 0)
      {
         if (steps == 0)
         {
            System.out.println(result.substring(0, result.length() - 2) + " ");
         }
         return;
      }
      
      climbStairsRecursive(steps - 1, result + "1, ");
      climbStairsRecursive(steps - 2, result + "2, ");
   }
   
   public static void campsite(int x, int y)
   {
      campsiteRecursive(0, 0, x, y, "");
   }
   
   public static void campsiteRecursive(int x, int y, int siteX, int siteY, String result)
   {
      boolean reachedSite = x == siteX && y == siteY;
      boolean outOfBounds = x > siteX || y > siteY;
      if (reachedSite || outOfBounds)
      {
         if (reachedSite)
            System.out.println(result + " ");
         return;
      }
      
      campsiteRecursive(x + 1, y, siteX, siteY, result + "E ");
      campsiteRecursive(x, y + 1, siteX, siteY, result + "N ");
      campsiteRecursive(x + 1, y + 1, siteX, siteY, result + "NE ");
      
   }
   
   public static int getMax(List<Integer> nums, int limit)
   {
      int biggest = 0;
      
      for (int i = 0; i < nums.size(); i++)
      {
         biggest = Math.max(biggest, getMaxRecursive(nums, limit, 0, i));
      }
      
      return biggest;
   }
   
   public static int getMaxRecursive(List<Integer> nums, int limit, int sum, int index)
   {
      int predictedSum = sum + nums.get(index);
      if (index >= nums.size() - 1)
      {
         if (predictedSum <= limit)
            return predictedSum;
         return sum;
      }
      
      if (sum > limit)
         return 0;
      
      int withNum = getMaxRecursive(nums, limit, sum + nums.get(index), index + 1);
      int withoutNum = getMaxRecursive(nums, limit, sum, index + 1);
      
      return Math.max(withNum, withoutNum);
   }
   
   public static int makeChange(int amount)
   {
      return makeChangeRecursive(Arrays.asList(1, 5, 10, 25), amount, 0, 3);
   }
   
   public static int makeChangeRecursive(List<Integer> coins, int amount, int sum, int index)
   {
      if (sum == amount)
      {
         return 1;
      }
      if (sum > amount || index < 0)
      {
         return 0;
      }
      
      
      int sameIndex = makeChangeRecursive(coins, amount, sum + coins.get(index), index);
      int lowerIndex = makeChangeRecursive(coins, amount, sum, index - 1);
      return sameIndex + lowerIndex;
   }
   
   public static void makeChangeAndPrint(int amount)
   {
      makeChangePrintRecursive(amount, 25, 0, 0, 0, 0);
   }
   
   public static void makeChangePrintRecursive(int amount, int largestCoinAllowed, int p, int n, int d, int q)
   {
      if (amount == 0)
      {
         String output = "[" + p + ", " + n + ", " + d + ", " + q + "]";
         System.out.println(output);
      }
      if (amount < 0)
      {
         return;
      }
   
      makeChangePrintRecursive(amount - 1, 1, p + 1, n, d, q);
      
      if (largestCoinAllowed >= 5)
         makeChangePrintRecursive(amount - 5, 5, p, n + 1, d, q);
      
      if (largestCoinAllowed >= 10)
         makeChangePrintRecursive(amount - 10, 10, p, n, d + 1, q);
      
      if (largestCoinAllowed == 25)
         makeChangePrintRecursive(amount - 25, 25, p, n, d, q + 1);
      
   }  
   public static String longestCommonSub(String str, String str2)
   {
      if (str.length() <= 0 || str2.length() <= 0)
      {
         return "";
      }
      
      String newStr = str.substring(1, str.length());
      String newStr2 = str2.substring(1, str2.length());
      
      
      if (str.charAt(0) == str2.charAt(0))
      {
         return str.charAt(0) + longestCommonSub(newStr, newStr2);
      }
      else
      {
         String restOfStr2 = longestCommonSub(str, newStr2);
         String restOfStr = longestCommonSub(newStr, str2);
         
         if (restOfStr2.length() > restOfStr.length())
            return restOfStr2;
         return restOfStr;
      }
      
   } 
   

}