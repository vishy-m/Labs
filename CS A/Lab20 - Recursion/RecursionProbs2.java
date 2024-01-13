
//Name: 

public class RecursionProbs2
{

    public static void main(String[] args)
    {
        System.out.println(pal("racecar"));
        System.out.println(isPrime(29, 2));
        timesTwo(68);
        System.out.println(tri(4));
        System.out.println(penta(4));
        int[] ints = {1, 2, 3};
        System.out.println(addEm(ints, 0));
        System.out.println(reverseString("Hello"));
        printReverse("Hello");
        System.out.println(0 / 5);
        System.out.println(isPowerOfN(66, 2));
        System.out.println(curlyBracket("Hello {salsa} nnininin"));
        printSquares(8);
        System.out.println();
        System.out.println(wordWrap("hello\n ur are a good man", 8));
    }

    public static boolean pal(String s)
    {
        if (s.length() == 0 || s.length() == 1) return true;
        if (s.charAt(0) == s.charAt(s.length() - 1))    return pal(s.substring(1, s.length() - 1));
        return false;
    }

    public static boolean isPrime(int num, int i)
    {
        if (i == num - 1) return true;
        if (num % i != 0) return isPrime(num, i + 1);
        return false;
    }

    public static void timesTwo(int n)
    {
        if (n % 2 == 0) 
        {
            System.out.print("2 * ");
            timesTwo(n / 2);
        }
        else System.out.println(n);
    }

    public static int tri(int n)
    {
        if (n <= 0) return 0;

        return n + tri(n - 1);
    }

    public static int penta(int n)
    {
        if (n <= 0) return 0;
        return 3 * n * (n - 1) / 2 + n;
    }

    public static int addEm(int[] ints, int index)
    {
        if (index == ints.length - 1)   return ints[index];

        return ints[index] + addEm(ints, index + 1);
    }

    public static String reverseString(String str)
    {
        if (str.length() == 0) return "";
        return str.charAt(str.length() -1) + reverseString(str.substring(0, str.length() - 1));
    }

    public static void printReverse(String str)
    {
        if (str.length() == 0) System.out.println("\n");
        System.out.print(str.charAt(str.length() -1) + reverseString(str.substring(0, str.length() - 1)));
    }

    public static boolean isPowerOfN(int num, int base)
    {
        double n = (double)num / (double)base;
        if (n == (double)base || num == 1)    return true;
        if (base <= 1) return false;
        if (n > base) return isPowerOfN((int)Math.round(n), base);
        return false;
    }

    public static String curlyBracket(String str)
    {
        if (str.length() == 0) return str;
        if (str.charAt(0) == '{')
        {
            if (str.charAt(str.length() - 1) == '}') return str;
            else return curlyBracket(str.substring(0, str.length() - 1));
        }
        else return curlyBracket(str.substring(1, str.length()));
    }

    public static void printPattern2(int n)
    {
        if (n >= 0)
        {
            System.out.print(n + " ");
            printPattern2(n - 5);
        }
        System.out.print(n + " ");
    }

    public static void printSquares(int n)
    {
        int numSq = n * n;
        if (n > 0)
        {
            if (n % 2 != 0)
            {
                System.out.print(numSq + ", ");
                printSquares(n - 1);
            }
            else if (n == 1) System.out.print("1 ");
            if (n % 2 == 0)
            {
                printSquares(n - 1);
                System.out.print(numSq + ", ");
            }
        }
    }

    public static String wordWrap(String line, int width)
    {
        if (line.length() == 0) return "";
        
        String[] words = line.split(" ");
        String word = words[0];
        int len = word.length();
        
        if (len + 1 < 13)
        {
            String newLine = line.substring(len - 1, line.length());
            return word + wordWrap(newLine, width - len);
        }
        else
        {
            //return "\n" + wordWrap()
        }
        return "";
    }
}

