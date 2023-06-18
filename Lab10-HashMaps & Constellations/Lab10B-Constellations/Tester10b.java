    //Version 1.0
public class Tester10b extends TestGUI.TestData{ 
    public static void main (String[] args) {  
        if (VERSION_NUM < 2.16)
            System.out.println("This test script requires TestGUI version 2.16 or higher.\nPlease download a newer version of TestGUI.java.");
        else
            new TestGUI();   
    }

    public static void runTests() {  //Your test sequence must be within a method called runTests()
        //WRITE ALL YOUR TEST CASES IN HERE       
        setTimeOutSec(30);
        srcButton("Star, StarChart");

        //IMPORTANT: This tester requires that students use the version of StdDraw that 
        //   does NOT shut down on close.

        // Newline Converter: https://onlinestringtools.com/convert-newlines-to-spaces
        // Object testMethod(String cName, String mName, Object[] args, [String expOut], [double allowableError], [String inputScript])

        header("Testing entire program via Runner.java");  
        testMethod("Runner", "main", new Object[] {new String[0]});
        message("Mr. McCoy will visually verify that your image is accurate.  All stars should show up, some with larger radius.  All 8 constellations should draw correctly.  Mr. McCoy will also inspect your code to ensure that you properly used a hashmap to locate your Star objects when drawing the constellations.");
    }    
}