import java.util.*;
public class Runner11 {

// SCROLL TO THE BOTTOM FOR EXPECTED OUTPUT

   public static void main(String[] args) {
      System.out.print("printBinary(2) >>> ");
      RecursionPractice11.printBinary(2);
      System.out.print("printBinary(3) >>> ");         
      RecursionPractice11.printBinary(3);
      System.out.print("printBinary(4) >>> ");
      RecursionPractice11.printBinary(4);
      
      System.out.println("\nclimbStairs(3) ");
      RecursionPractice11.climbStairs(3);
      System.out.println("\nclimbStairs(5) ");
      RecursionPractice11.climbStairs(5);
      
      System.out.println("\ncampsite(0, 4) ");
      RecursionPractice11.campsite(0, 4);
      
      System.out.println("\ncampsite(1, 1) ");
      RecursionPractice11.campsite(1, 1);
      
      System.out.println("\ncampsite(2, 1) ");
      RecursionPractice11.campsite(2, 1);
      
      System.out.print("\ngetMax([7, 30, 8, 22, 6, 1, 14],  16) >>> ");  
      System.out.println(RecursionPractice11.getMax(Arrays.asList(7, 30, 8, 22, 6, 1, 14), 16));
      
      System.out.print("getMax([10, 25, 9, 1, 5],  32) >>> ");  
      System.out.println(RecursionPractice11.getMax(Arrays.asList(10, 25, 9, 1, 5), 32));
      
      System.out.print("\nmakeChange(11) >>> ");      
      System.out.println(RecursionPractice11.makeChange(11));
      System.out.print("makeChange(25) >>> ");      
      System.out.println(RecursionPractice11.makeChange(25));
      System.out.print("makeChange(100) >>> ");      
      System.out.println(RecursionPractice11.makeChange(100));
      
      System.out.println("\nmakeChangeAndPrint(11) ");  
      RecursionPractice11.makeChangeAndPrint(11);
      System.out.println("\nmakeChangeAndPrint(25) "); 
      RecursionPractice11.makeChangeAndPrint(25);
      
      System.out.print("\nlongestCommonSub(\"ABCDEFG\", \"BGCEHAF\" >>> "); 
      System.out.println(RecursionPractice11.longestCommonSub("ABCDEFG", "BGCEHAF"));
      System.out.print("longestCommonSub(\"12345\", \"54321 21 54321\" >>> "); 
      System.out.println(RecursionPractice11.longestCommonSub("12345", "54321 21 54321"));
   
   /*
   
   EXPECTED OUTPUT (The order of your "paths" in each problem may be different that mine, but every value
   should be in there somewhere.)
   
   printBinary(2) >>> 00 01 10 11 
   printBinary(3) >>> 000 001 010 011 100 101 110 111 
   printBinary(4) >>> 0000 0001 0010 0011 0100 0101 0110 0111 1000 1001 1010 1011 1100 1101 1110 1111 
   
   climbStairs(3) 
   1, 1, 1
   1, 2
   2, 1
   
   climbStairs(5) 
   1, 1, 1, 1, 1
   1, 1, 1, 2
   1, 1, 2, 1
   1, 2, 1, 1
   1, 2, 2
   2, 1, 1, 1
   2, 1, 2
   2, 2, 1
   
   campsite(0, 4) 
   N N N N 
   
   campsite(1, 1) 
   E N 
   N E 
   NE 
   
   campsite(2, 1) 
   E E N 
   E N E 
   E NE 
   N E E 
   NE E 
   
   getMax([7, 30, 8, 22, 6, 1, 14],  16) >>> 16
   getMax([10, 25, 9, 1, 5],  32) >>> 31
   
   makeChange(11) >>> 4
   makeChange(25) >>> 13
   makeChange(100) >>> 242
   
   makeChangeAndPrint(11) 
   P  N  D  Q
   -----------
   [11, 0, 0, 0]
   [6, 1, 0, 0]
   [1, 0, 1, 0]
   [1, 2, 0, 0]
   
   makeChangeAndPrint(25) 
   P  N  D  Q
   -----------
   [5, 2, 1, 0]
   [15, 2, 0, 0]
   [0, 0, 0, 1]
   [0, 1, 2, 0]
   [15, 0, 1, 0]
   [0, 5, 0, 0]
   [10, 1, 1, 0]
   [20, 1, 0, 0]
   [0, 3, 1, 0]
   [25, 0, 0, 0]
   [5, 4, 0, 0]
   [5, 0, 2, 0]
   [10, 3, 0, 0]
   
   longestCommonSub("ABCDEFG", "BGCEHAF" >>> BCEF
   longestCommonSub("12345", "54321 21 54321" >>> 123
   
   */
            
   }
}