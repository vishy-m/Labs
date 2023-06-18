
//Name: Vishruth M
import java.util.*;
public class Tester
{
    public static void main(String[] args)
    {
        System.out.println("Hello again, world!");
        //"This is a comment!".
        int numApples = 50;
        final int PRICE_OF_APPLES = 50;
        System.out.println((numApples * PRICE_OF_APPLES) + " cents");
        if (numApples * PRICE_OF_APPLES >= 2000)
            System.out.println("Thank you valued customer!");
        System.out.println();

        for (int n = 10; n >= 1; n--)
        {
            System.out.print(n + " ");
        }
        System.out.println();
        for (int n = 150; n <= 300; n += 3)
        {
            System.out.print(n + " ");
        }
        System.out.println();
        int sum = 0;
        for (int n = 0; n <= 100; n++)
        {
            sum += n;
        }
        System.out.println(sum);
         System.out.println();
        //I have no clue

        Scanner console = new Scanner(System.in);
        System.out.print("Enter a number to be sqrt >>> ");
        double num = console.nextDouble();
        console.nextLine();
        System.out.println(Math.sqrt(num));

        System.out.println("num^3 = " + Math.pow(num, 3));
        
        System.out.println();
        
        System.out.print("Enter number1 and number2 with a space in between >>> ");
        int num1 = console.nextInt();
        int num2 = console.nextInt();
        console.nextLine();
        if (num1 > num2)
        {
            if (num1 - num2 <= 10)
                System.out.println("Within 10");
            else
                System.out.println("Not within 10");
        }
        else
        {
            if (num2 - num1 <= 10)
                System.out.println("Within 10");
            else
                System.out.println("Not within 10");
        }
        System.out.println();
        double sum2 = 0;
        double count = 0;
        do
        {
            System.out.print("Enter a number (0 to quit) >>> ");
            count = console.nextDouble();
            console.nextLine();
            sum2 += count;
        }
        while (count != 0);
        System.out.println("The sum of all of the numbers is >>> " + sum2);

        double[] areas = new double[20];
        areas[0] = 4.56;
        int length = areas.length;
        boolean[] booleans = {true,true, false, false, true};
        
        System.out.println();
        simpleMethod();
        System.out.println("The sum of num1 and num2 = " + sum(num1, num2));
        System.out.println();
        System.out.print("Enter a num to sumToN to >>> ");
        int sumT = sumToN(console.nextInt());
        console.nextLine();
        System.out.println("The sumToN of num is " + sumT);
        System.out.println();
        
        System.out.print("Enter a num to turn into a triangle >>> ");
        triangle(console.nextInt());
        console.nextLine();
        System.out.println();
        
        System.out.print("Enter some text >>> ");
        System.out.println(": " + altCaps(console.nextLine()));
        System.out.println();
        
        Player p1 = new Player();
        Player p2 = new Player("Timmy", 6);
        System.out.println(p1.playerInfo());
        System.out.println(p2.playerInfo());
    }

    public static void simpleMethod()
    {
        System.out.println("This is a method!");
    }

    public static int sum(int a, int b)
    {
        return a + b;
    }

    public static int sumToN(int n)
    {
        int sum = 0;
        for( int i = 0; i <= n; i++)
        {
            if (i % 3 == 0 || i % 5 == 0)
            {
                sum += i;
            }
        }
        return sum;
    }

    public static void triangle(int n)
    {
        for(int i = 1; i <= n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static String altCaps(String s)
    {
        char[] c = new char[s.length()];
        for( int i = 0; i < c.length; i++)
        {
            c[i] = s.charAt(i);
        }
        String newS = "";
        for(int i = 0, j = 0; i < c.length; i++)
        {
            if (Character.isLetter(c[i]))
            {
                if (j % 2 == 0)
                {
                    String p = "";
                    p += c[i];
                    newS += p.toUpperCase();
                }
                else
                {
                    String p = "";
                    p += c[i];
                    newS += p.toLowerCase();
                }
                j++;
            }
            else
            {
                newS += c[i];
            }
        }
        return newS;
    }
}
