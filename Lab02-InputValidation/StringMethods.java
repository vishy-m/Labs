
//Name: 
import java.util.*;
public class StringMethods
{
    public StringMethods()
    {
        
    }
    
    public void unusualHello(String name)
    {
        System.out.println("Hello " + name + ", you dummy!");
    }
    public String stringRipper(String str)
    {
        String ret = "";
        return ret += str.charAt(0) + "" + str.charAt(str.length()-1);
    }
    public String repeatEnd(String str, int n)
    {
        String ret = "";
        String loop = str.substring(str.length() - n, str.length());
        for (int i = 0; i < n; i++)
        {
            ret += loop;
        }
        return ret;
    }
    public boolean evenFooBar(String s)
    {
        int numFoo = 0;
        int numBar = 0;
        String ret = "";
        for (int i = 0; i + 3 <= s.length(); i++)
        {
            if (s.substring(i, i + 3).equals("foo"))
            {
                ret += s.substring(i, i + 3);
            }
            else if (s.substring(i, i + 3).equals("bar"))
            {
                ret += s.substring(i, i + 3);
            }
        }
        for (int i = 0; i + 3 <= ret.length(); i += 3)
        {
            if (ret.substring(i, i + 3).equals("foo"))
            {
                numFoo++;
            }
            else
            {
                numBar++;
            }
        }
        if (numBar == numFoo)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int sumString(String str)
    {
        Scanner chopper = new Scanner(str);
        int sum = 0;
        while (chopper.hasNext())
        {
            if (chopper.hasNextInt())
            {
                sum += chopper.nextInt(); 
            }
            else
            {
                chopper.next();
            }
        }
        return sum;
    }
    public String decode(String key, String code)
    {
        Scanner chopper = new Scanner(code);
        char[] keyA = new char[key.length()];
        String ret = "";
        
        for (int i = 0; i < key.length(); i++)
        {
           keyA[i] = key.charAt(i); 
        }
        
        while (chopper.hasNext())
        {
            if (chopper.hasNextInt())
            {
                ret += keyA[chopper.nextInt()];
            }
        }
        
        return ret;
    }
}
