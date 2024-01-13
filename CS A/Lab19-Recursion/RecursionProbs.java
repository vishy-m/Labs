
//Name: 
import java.util.*;
public class RecursionProbs
{
    public static void main(String[] args)
    {
        //System.out.println(cheerlead("Go Team! ", 10));
        //System.out.println(countNumA("aaHELLOaaaaaaaa"));
        //printAtoBbyC(10, 30, 5);
        System.out.println(sumDigits(123));
    }
    
    public static int numEars(int bunnies)
    {
        if (bunnies < 1)    return 0;
        
        if (bunnies == 1)   return 2;
        else                return 2 + numEars(bunnies - 1);
    }
    
    public static void countdown(int num)
    {
        if (num == 1)   
            System.out.println(num + ", blastoff!");
        else
        {
            System.out.print(num + ", ");
            countdown(num - 1);
        }
    }
    public static long factorial(long num)
    {
        if (num == 1)
        {
            return 1;
        }
        else
        {
            return num * factorial(num - 1);
        }
    }
    public static String cheerlead(String str, int i)
    {
        if (i == 1) return (str + " ");
        else
        {
            //System.out.println(str);
            return str + " " + cheerlead(str, i - 1);
        }
    }
    public static int pow(int num, int exp)
    {
        if (exp == 1) return num;
        else
        {
            //System.out.println(str);
            return num * pow(num, exp - 1);
        }
    }
    public static int fib(int num)
    {
        if (num == 0) return 0;
        else if (num == 1) return 1;
        else return fib(num - 2) + fib(num - 1);
    }
    public static void printPattern(int num)
    {
        if (num < 0) System.out.print(num);
        else 
        {
            System.out.print(num + ", ");
            printPattern(num - 5);
        }
    }
    public static int countNumA(String str)
    {
        if (str.length() == 0) return 0;
        else
        {
            
            int strL = str.length() - 1;
            char c = str.charAt(strL);
            String s = str.substring(0, strL);
            if (c == 'a')
                return 1 + countNumA(s);
            return countNumA(s);
        }
    }
    public static void printAtoBbyC(int a, int b, int c)
    {
        if (a >= b) System.out.print(b + " ");
        else
        {
            System.out.print(a + " ");
            a += c;
            printAtoBbyC(a, b, c);
        }
    }
    public static int countOdds(int num)
    {
        if (num == 0) return 0;
        else
        {
            int rightNum = num % 10;
            num /= 10;
            if (rightNum % 2 != 0) return 1 + countOdds(num);
            return countOdds(num);
        }
    }
    public static int sumDigits(int num)
    {
        if (num < 10) return num;
        else
        {
            int rightNum = num % 10;
            num /= 10;
            //System.out.println("RightNum: " + rightNum + " num: " + num);
            return rightNum + sumDigits(num);
        }
    }
}
