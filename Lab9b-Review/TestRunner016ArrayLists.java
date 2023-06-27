//v1.0
import java.util.*;
public class TestRunner016ArrayLists extends TestGUI.TestData{ 
    public static void main (String[] args) {        
        new TestGUI();   
    }

    /**
     * Run customized tests of various classes/method and custom build your GUI

     * TO CREATE A HEADER IN THE GUI
     *     void header(String name)
     *   
     *     Example:
     *     header("Histogram");

     * TO CREATE A MESSAGE/NOTE IN THE GUI
     *     void message(String information)
     *     void message(String information, boolean correct)
     *   
     *     Example:
     *     message("This portion of the assignment is optional and for extra credit only."); //default grey color
     *     message("I'm requesting that this method have a green background.", true) //green color
     *     message("I'm requesting that this method have a red background.", false) //red color
     *     

     * TO CREATE A BUTTON FOR LOADING SOURCE CODE / DATA FILES
     *     void srcButton(String sourceFileNamesCommaDelimited)
     *     void srcButton(String[] sourceFileNames)
     *     
     *     Example:
     *     srcButton("PracticeProblems, Data.txt");  //If file has no extension, .java is assumed
     *     srcButton(new String[]{"Car.java", "Truck.java", "DataFile.in"}

     * TO TEST A CONSTRUCTOR AND RECEIVE THE INSTANTIATED OBJECT:
     *     Object makeObject(String className, Object[] args)
     *     Object makeObject(String className, Object[] args, String inputScript)
     *
     *     Parameters:
     *     className - Name of the constructor you are calling
     *     args - arguments you are passing to the constructor.  null can be used if calling a default 
     *            (no parameter) constructor
     *     inputScript - data that will be fed through System.in in the event that the constructor
     *         requests user input
     *      
     *     Returns:
     *     the object constructed from the call
     *      
     *     Example usage:
     *     //Using this...                                              // is similar to using this... 
     *     Object o = makeObject("Person", new Object[]{"Fred", 27});   // Object o = new Person("Fred", 27);
     *     Object o = makeObject("Person", null, "Fred\n27");           // Object o = new Person(); (provides user input)          

     * TO TEST A METHOD  (The testMethod method is very overloaded.  You have several options.)
     *     Object testMethod(Object o,     String mName, Object[] args)
     *     Object testMethod(String cName, String mName, Object[] args)
     *     Object testMethod(Object o,     String mName, Object[] args, String expOut)
     *     Object testMethod(String cName, String mName, Object[] args, String expOut)
     *     Object testMethod(Object o,     String mName, Object[] args, String expOut, String inputScript)
     *     Object testMethod(String cName, String mName, Object[] args, String expOut, String inputScript)
     *   
     *     Parameters:
     *     o - the object invoking the method you want to test (for non-static methods)
     *     cName - name of the class invoking the method you want to test (for static methods)
     *     mName - name of the method being invoked
     *     args - arguments being passing to the method.  null can be used if the method being testing
     *            does not require any parameters.
     *     expOut - the expected output or return value from running the method
     *            If an expOut is provided the GUI will compare this against the actual output/return
     *            value from the test and make a comparison.  Leave this off or pass null if you don't want
     *            to make a red light/green light comparison against the actual output.)
     *     inputScript - data that will be fed through System.in in the event that the method
     *         requests user input
     *   
     *     Returns:
     *     the return value of the method being invoked (as Object)
     *     or null when testing void methods or the student code fails to run/throws exception
     *   
     *     Example usage:
     *     //Using this...                                               // is similar to using this... 
     *     testMethod(myHistogram, "encounter", new Object[]{7});        // myHistogram.encounter(7);
     *     testMethod("Practice", "printXs", new Object[]{4}, "xxxx")    // Practice.printXs(4); 
     *     int s = testMethod(myCar, "getSpeed", null, "55");            // int s = myCar.getSpeed();

     * TO GET A CLASS OBJECT FROM ITS NAME       
     *     Class getClassFromName(String className)
     *     
     *     Example usage:
     *     Class c = getClassFromName("Truck");  
     *     
     *     Note: Why would you want to do this?  This will allow you to collect various information about
     *     how students coded the class, useful for checking how well students understand class design and
     *     inheritance.  You can verify that the Truck class extends the Vehicle class. You can find out 
     *     how many declared fields the student included (vs how many fields were inherited.) Also, this is
     *     your only way to get a version of the Class object that uses the same ClassLoader as the TestGUI
     *     (in the event that you need to try to cast Object o as a student-coded Truck.)  For more info,
     *     read about the Class class here:  https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html 

     * TO SET HOW MANY SECONDS SHOULD BE WAITED BEFORE AN INDIVIDUAL TEST TIMES OUT
     *     setTimeOutSec(int seconds);  //how many seconds to wait before giving up.  (Default 2)
     *   
     */
    public static void runTests() {  //Your test sequence must be within a method called runTests()
        //WRITE ALL YOUR TEST CASES IN HERE       
        setTimeOutSec(3);

        srcButton("Shopping, MadLib, CityPopRunner");
        
       
        header("Shopping");        
        testMethod("Shopping", 
            "main", 
            new Object[]{new String[0]}, 
            "Add item to list (or 0 when done) >>> chips\nAdd item to list (or 0 when done) >>> hot salsa\nAdd item to list (or 0 when done) >>> mild salsa\nAdd item to list (or 0 when done) >>> green salsa\nAdd item to list (or 0 when done) >>> even more salsa\nAdd item to list (or 0 when done) >>> 0\n\nShopping List:\n[chips, even more salsa, green salsa, hot salsa, mild salsa]\n\nThird item: green salsa\n\nCheaper List:\n[chips, ramen noodles, ramen noodles, hot salsa, mild salsa]\n\nramen found at index 1",            
            "chips\nhot salsa\nmild salsa\ngreen salsa\neven more salsa\n0"            
        );  
        testMethod("Shopping", 
            "main", 
            new Object[]{new String[0]}, 
            "Add item to list (or 0 when done) >>> qwertyuiop\nAdd item to list (or 0 when done) >>> apples\nAdd item to list (or 0 when done) >>> 0\n\nShopping List:\n[apples, qwertyuiop]\n\nNo third item\n\nCheaper List:\n[apples, qwertyuiop]\n\nramen not found",            
            "qwertyuiop\napples\n0"            
        );  
        
        header("MadLib");
        message("Due to the randomness of this lab, green/red light tests are not possible. Verification must be done visually.");
        Object o = makeObject("MadLib", null );
        testMethod(o, "getRandomVerb", new Object[]{});
        testMethod(o, "getRandomNoun", new Object[]{});
        testMethod(o, "getRandomAdjective", new Object[]{});
        testMethod(o, "toString", new Object[]{});
        testMethod(o, "toString", new Object[]{});
        testMethod(o, "toString", new Object[]{});
        
        header("CityPop");        
        testMethod("CityPopRunner", 
            "main", 
            new Object[]{new String[0]}, 
            "LIST A:\nHouston (2099451 people)\nDallas (1197816 people)\nAustin (790390 people)\nArlington (365438 people)\nPlano (259841 people)\nLaredo (236091 people)\nIrving (216290 people)\n\nLIST B:\nArlington (365438 people)\nFrisco (116989 people)\nPlano (259841 people)\nGarland (226876 people)\nIrving (216290 people)\nRichardson (99223 people)\n\nDUPLICATES:\nArlington (365438 people)\nPlano (259841 people)\nIrving (216290 people)\n\nLIST B (without duplicates):\nFrisco (116989 people)\nGarland (226876 people)\nRichardson (99223 people)"            
        );        
    }    
}