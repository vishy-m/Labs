
//Name: 

public class Runner
{
    public static void main(String[] args)
    {
        StringMethods test = new StringMethods();
        
        test.unusualHello("Bob");
        System.out.println(test.stringRipper("something"));
        System.out.println(test.repeatEnd("Hello", 1));
        System.out.println(test.evenFooBar("foobarfoobbarffoobar"));
        System.out.println(test.sumString("Oh, hello there 5 This string has 2 or 3 numbers in it."));
        System.out.println(test.decode("six perfect quality black jewels amazed the governor", "35 10 10 33 9 24 3 17 41 8 3 20 51 16 38 44 47 32 33 10 19 38 35 28 49"));
    }
}
