//Version 1.0
public class Tester20 extends TestGUI.TestData{ 
    public static void main (String[] args) {  
        if (VERSION_NUM < 2.13)
            System.out.println("This test script requires TestGUI version 2.13 or higher.\nPlease download a newer version of TestGUI.java.");
        else
            new TestGUI();   
    }

    public static void runTests() {  //Your test sequence must be within a method called runTests()
        //WRITE ALL YOUR TEST CASES IN HERE       
        setTimeOutSec(15);
        srcButton("RecursionProbs2");

        // Newline Converter: https://onlinestringtools.com/convert-newlines-to-spaces
        // Object testMethod(String cName, String mName, Object[] args, [String expOut], [double allowableError], [String inputScript])

        header("RecursionProbs Test");  
        message("In addition to passing these tests, Mr. McCoy will spot check your labs to ensure that you didn't use any loops. LOOPS ARE OFF LIMITS in RecursionProbs.");

        testMethod("RecursionProbs2", "pal", new Object[]{"racecar"}, "true"); 
        testMethod("RecursionProbs2", "pal", new Object[]{"abccba"}, "true"); 
        testMethod("RecursionProbs2", "pal", new Object[]{"abcdba"}, "false"); 
        testMethod("RecursionProbs2", "isPrime", new Object[]{37, 2}, "true"); 
        testMethod("RecursionProbs2", "isPrime", new Object[]{38, 2}, "false"); 
        testMethod("RecursionProbs2", "isPrime", new Object[]{977, 2}, "true"); 
        testMethod("RecursionProbs2", "isPrime", new Object[]{361, 2}, "false"); 
        testMethod("RecursionProbs2", "timesTwo", new Object[]{80}, "2 * 2 * 2 * 2 * 5"); 
        testMethod("RecursionProbs2", "timesTwo", new Object[]{68}, "2 * 2 * 17"); 
        testMethod("RecursionProbs2", "timesTwo", new Object[]{71}, "71"); 
        testMethod("RecursionProbs2", "timesTwo", new Object[]{4}, "2 * 2 * 1"); 
        testMethod("RecursionProbs2", "timesTwo", new Object[]{-12}, "2 * 2 * -3"); 
        testMethod("RecursionProbs2", "tri", new Object[]{2}, "3"); 
        testMethod("RecursionProbs2", "tri", new Object[]{4}, "10"); 
        testMethod("RecursionProbs2", "tri", new Object[]{10}, "55"); 
        testMethod("RecursionProbs2", "tri", new Object[]{-1}, "0"); 
        testMethod("RecursionProbs2", "penta", new Object[]{2}, "5"); 
        testMethod("RecursionProbs2", "penta", new Object[]{4}, "22"); 
        testMethod("RecursionProbs2", "penta", new Object[]{10}, "145"); 
        testMethod("RecursionProbs2", "penta", new Object[]{-1}, "0"); 
        testMethod("RecursionProbs2", "addEm", new Object[]{new int[]{1, 2, 3, 4, 5}, 0}, "15"); 
        testMethod("RecursionProbs2", "addEm", new Object[]{new int[]{7, 8, 9}, 0}, "24"); 
        testMethod("RecursionProbs2", "reverseString", new Object[]{"I love salsa!"}, "!aslas evol I"); 
        testMethod("RecursionProbs2", "reverseString", new Object[]{"Salsa is great!"}, "!taerg si aslaS"); 
        testMethod("RecursionProbs2", "printReverse", new Object[]{"Is my String backwards?"}, "?sdrawkcab gnirtS ym sI"); 
        testMethod("RecursionProbs2", "printReverse", new Object[]{"Yes, I believe it is."}, ".si ti eveileb I ,seY"); 
        testMethod("RecursionProbs2", "isPowerOfN", new Object[]{64, 4}, "true"); 
        testMethod("RecursionProbs2", "isPowerOfN", new Object[]{66, 2}, "false"); 
        testMethod("RecursionProbs2", "isPowerOfN", new Object[]{8, 1}, "false"); 
        testMethod("RecursionProbs2", "isPowerOfN", new Object[]{1, 100}, "true"); 
        testMethod("RecursionProbs2", "curlyBracket", new Object[]{"remove remove {salsa} remove"}, "{salsa}"); 
        testMethod("RecursionProbs2", "curlyBracket", new Object[]{"no brackets!"}, ""); 
        testMethod("RecursionProbs2", "curlyBracket", new Object[]{"} do you even bracket, bro? {"}, ""); 
        testMethod("RecursionProbs2", "printPattern2", new Object[]{16}, "16 11 6 1 -4 1 6 11 16 "); 
        testMethod("RecursionProbs2", "printPattern2", new Object[]{33}, "33 28 23 18 13 8 3 -2 3 8 13 18 23 28 33"); 
        testMethod("RecursionProbs2", "printSquares", new Object[]{5}, "25, 9, 1, 4, 16"); 
        testMethod("RecursionProbs2", "printSquares", new Object[]{8}, "49, 25, 9, 1, 4, 16, 36, 64"); 
        testMethod("RecursionProbs2", "wordWrap", new Object[]{"hello, how are you doing today?", 13}, "hello, how\nare you doing\ntoday?"); 
        testMethod("RecursionProbs2", "wordWrap", new Object[]{"Have you tried eating salsa with breakfast?", 10}, "Have you\ntried\neating\nsalsa with\nbreakfast?"); 

        header("Happy Numbers");
        testMethod("RecursionProbs2", "isHappy", new Object[]{19}, "true"); 
        testMethod("RecursionProbs2", "isHappy", new Object[]{230}, "true"); 
        testMethod("RecursionProbs2", "isHappy", new Object[]{231}, "false"); 
        testMethod("RecursionProbs2", "isHappy", new Object[]{42}, "false"); 
        testMethod("RecursionProbs2", "isHappy", new Object[]{81}, "false"); 
        testMethod("RecursionProbs2", "isHappy", new Object[]{82}, "true");       
        
    }
}