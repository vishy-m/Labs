//Version 1.0
public class Tester02 extends TestGUI.TestData{ 
    public static void main (String[] args) {  
        if (VERSION_NUM < 2.171)
            System.out.println("This test script requires TestGUI version 2.171 or higher.\nPlease download a newer version of TestGUI.java.");
        else
            new TestGUI();   
    }

    public static void runTests() {  //Your test sequence must be within a method called runTests()
        //WRITE ALL YOUR TEST CASES IN HERE       
        setTimeOutSec(5);
        srcButton("StringMethods, Runner, ValidateForm");

        // Newline Converter: https://onlinestringtools.com/convert-newlines-to-spaces
        // Object testMethod(String cName, String mName, Object[] args, [String expOut], [double allowableError], [String inputScript])        

        header("Input Validation Lab");         
        message("Best possible score is: 48 Green, 0 Yellow, 0 Red");        

        header("StringMethods Tests");
        Object o = makeObject("StringMethods", new Object[]{});

        testMethod(o, "unusualHello", new Object[]{"Bob"}, "Hello Bob, you dummy!");
        testMethod(o, "unusualHello", new Object[]{"Tracy"}, "Hello Tracy, you dummy!");

        testMethod(o, "stringRipper", new Object[]{"something"}, "sg");
        testMethod(o, "stringRipper", new Object[]{"abcde"}, "ae");

        testMethod(o, "repeatEnd", new Object[]{"Hello", 2}, "lolo");
        testMethod(o, "repeatEnd", new Object[]{"Salsa", 3}, "lsalsalsa");
        testMethod(o, "repeatEnd", new Object[]{"anothertest", 4}, "testtesttesttest");

        testMethod(o, "evenFooBar", new Object[]{"barfoobar"}, "false");
        testMethod(o, "evenFooBar", new Object[]{"barfoofoobar"}, "true");
        testMethod(o, "evenFooBar", new Object[]{"foobarbarbarsalsafoofoo"}, "true");

        testMethod(o, "sumString", new Object[]{"Hi 5 there are 2 or 3 numbers in this String"}, "10");
        testMethod(o, "sumString", new Object[]{"a 1 b 2 c 3 d 4 e 5"}, "15");
        testMethod(o, "sumString", new Object[]{"abc 1 1 1 def -3"}, "0");

        testMethod(o, "decode", new Object[]{"hello world", "6 4 0 5 3 7 2"}, "woh lol");
        testMethod(o, "decode", new Object[]{"Paulie's dog", "7 1 3 7 1 8 4 7 8 11 10 10 9"}, "salsa is good");
        testMethod(o, "decode", new Object[]{"six perfect quality black jewels amazed the governor", "35 10 10 33 9 24 3 17 41 8 3 20 51 16 38 44 47 32 33 10 19 38 35 28 49"}, "attack the bridge at dawn");

        header("Testing your methods in ValidateForm");
        o = makeObject("ValidateForm", new Object[]{});

        testMethod(o, "isAllAlpha", new Object[]{"aBcDeFg"}, "true");
        testMethod(o, "isAllAlpha", new Object[]{"aBc DeFg"}, "false");
        testMethod(o, "isAllAlpha", new Object[]{"aBc!DeFg"}, "false");
        testMethod(o, "isAllAlpha", new Object[]{"aBc5DeFg"}, "false");

        testMethod(o, "isNumeric", new Object[]{"123456789"}, "true");
        testMethod(o, "isNumeric", new Object[]{"1234 56789"}, "false");
        testMethod(o, "isNumeric", new Object[]{"1234!56789"}, "false");
        testMethod(o, "isNumeric", new Object[]{"1234M56789"}, "false");

        testMethod(o, "checkName", new Object[]{"FredJones"}, "");
        testMethod(o, "checkName", new Object[]{"Fred Jones"}, "Invalid name!\n");
        testMethod(o, "checkName", new Object[]{"Fred1234"}, "Invalid name!\n");
        testMethod(o, "checkName", new Object[]{"a"}, "Invalid name!\n");

        testMethod(o, "checkPW", new Object[]{"abcd1"}, "Invalid password!\n");
        testMethod(o, "checkPW", new Object[]{"ABCD1"}, "Invalid password!\n");
        testMethod(o, "checkPW", new Object[]{"aBcDeF"}, "Invalid password!\n");
        testMethod(o, "checkPW", new Object[]{"a3A"}, "Invalid password!\n");
        testMethod(o, "checkPW", new Object[]{"a3AA"}, "");

        testMethod(o, "checkEmail", new Object[]{"mccoykr@friscoisd.org"}, "");
        testMethod(o, "checkEmail", new Object[]{"@friscoisd.org"}, "Invalid email!\n");
        testMethod(o, "checkEmail", new Object[]{"mccoykr@friscoisd.o"}, "Invalid email!\n");
        testMethod(o, "checkEmail", new Object[]{"mccoykr.friscoisd@org"}, "Invalid email!\n");
        
        testMethod(o, "checkZip", new Object[]{"75033"}, "");
        testMethod(o, "checkZip", new Object[]{"75M33"}, "Invalid zip!\n");
        testMethod(o, "checkZip", new Object[]{"75"}, "Invalid zip!\n");
        testMethod(o, "checkZip", new Object[]{"750333"}, "Invalid zip!\n");
        
        testMethod(o, "checkBirth", new Object[]{"2000"}, "");
        testMethod(o, "checkBirth", new Object[]{"1820"}, "Invalid birth year!\n");
        testMethod(o, "checkBirth", new Object[]{"2060"}, "Invalid birth year!\n");
        testMethod(o, "checkBirth", new Object[]{"20XX"}, "Invalid birth year!\n");
        
        testMethod(o, "checkPhone", new Object[]{"555-123-4567"}, "");
        testMethod(o, "checkPhone", new Object[]{"555-123-45 7"}, "Invalid phone number!\n");
        testMethod(o, "checkPhone", new Object[]{"555-aaa-4567"}, "Invalid phone number!\n");

    }
}