import java.util.*;

public class WelcomeBack
{
   public String getMiddle(String s)
   {
      int middle = s.length() / 2;
      return (s.length() % 2 == 0) ? "" + s.charAt(middle - 1) + s.charAt(middle) : "" + s.charAt(middle);
   }
   
   public int[] sumNumbers(int n)
   {
      int[] nums = new int[n + 1];
      int sum = 0;
      for (int i = 0; i < nums.length; i++)
      {
         sum += i;
         nums[i] = sum;
      }
      
      return nums;
   }
   
   public int sumDigits(int nums)
   {
      int sum = 0;
      while (nums > 0)
      {
         sum += nums % 10;
         nums /= 10;
      }
      return sum;
   }
   
   public int keepSummingDigits(int num)
   {
      int sum = sumDigits(num);
      while (sum >= 10)
      {
         num = sum;
         sum = (sumDigits(num));
      }
      return sum;
   }
   
   public String getIntersection(int[] a, int[] b)
   {
      String intersection = "";
      for (int i = 0; i < a.length; i++)
      {
         for (int j = 0; j < b.length; j++)
         {
            if (a[i] != b[j]) 
               continue;
            //System.out.println("a: " + a[i] + " || b: " + b[j] + " || found in intersection? " + intersection.indexOf(a[i]) + " || Intersection: " + intersection + "\n");
            if (intersection.indexOf("" + a[i]) == -1)
            {
               intersection += "" + a[i];
            }
            
         }
      }
      return intersection;
   }
   
   public HashMap<Integer, Integer> mapLengths(String[] words)
   {
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int i = 0; i < words.length; i++)
      {
         int wordLength = words[i].length();
         
         if (!map.containsKey(wordLength))
            map.put(wordLength, 1);
         else
            map.put(wordLength, map.get(wordLength) + 1);
      }
      return map;
   }
   
   public int sumWithoutCarry(int a, int b)
   {
      int sum = 0;
      ArrayList<Integer> aList = getNumArray(a);
      ArrayList<Integer> bList = getNumArray(b);
      
      int largestSize = (aList.size() > bList.size())? aList.size() : bList.size();
      
      for (int i = 0; i < largestSize; i++)
      {
         int temp = 0;
         
         if (i < aList.size()) temp += aList.get(i);
         if (i < bList.size()) temp += bList.get(i);
         
         if (temp > 10)
         {
            temp %= 10;
         }
         
         if (i != 0) sum += temp * Math.pow(10, i);
         else sum += temp;
      }
      
      return sum;
      
   }
   
   public int getRightNum(int num)
   {
      if (num >= 10) return num % 10;
      return num;
   }
   
   public ArrayList<Integer> getNumArray(int num)
   {
      ArrayList<Integer> list = new ArrayList<Integer>();
     
      while (num > 0)
      {
         list.add(num % 10);
         num /= 10;
      }
      
      return list;
   }
   
}