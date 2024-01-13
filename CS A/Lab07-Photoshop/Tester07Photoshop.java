public class Tester07Photoshop extends TestGUI.TestData{ 
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
        setTimeOutSec(1);

        srcButton("Picture");
        header("Unaltered Beach Pic Data");        
        Object pic = makeObject("Picture", new Object[]{"beach.jpg"});    
        testMethod(pic, "getPixel", new Object[]{100, 100}, 
            "{Red: 160, Green: 204, Blue: 231}"
        );       
        testMethod(pic, "getPixel", new Object[]{200, 200}, 
            "{Red: 112, Green: 122, Blue: 87}"
        );

        header("zeroBlue");        
        testMethod(pic, "zeroBlue", null); 
        testMethod(pic, "getPixel", new Object[]{100, 100}, 
            "{Red: 160, Green: 204, Blue: 0}"
        );       
        testMethod(pic, "getPixel", new Object[]{200, 200}, 
            "{Red: 112, Green: 122, Blue: 0}"
        );

        header("keepOnlyBlue");        
        pic = makeObject("Picture", new Object[]{"beach.jpg"});       
        testMethod(pic, "keepOnlyBlue", null); 
        testMethod(pic, "getPixel", new Object[]{100, 100}, 
            "{Red: 0, Green: 0, Blue: 231}"
        );       
        testMethod(pic, "getPixel", new Object[]{200, 200}, 
            "{Red: 0, Green: 0, Blue: 87}"
        );

        header("negate");        
        pic = makeObject("Picture", new Object[]{"beach.jpg"});       
        testMethod(pic, "negate", null); 
        testMethod(pic, "getPixel", new Object[]{100, 100}, 
            "{Red: 95, Green: 51, Blue: 24}"
        );       
        testMethod(pic, "getPixel", new Object[]{200, 200}, 
            "{Red: 143, Green: 133, Blue: 168}"
        );

        header("solarize");        
        pic = makeObject("Picture", new Object[]{"beach.jpg"});       
        testMethod(pic, "solarize", new Object[]{115}); 
        testMethod(pic, "getPixel", new Object[]{100, 100}, 
            "{Red: 160, Green: 204, Blue: 231}"
        );       
        testMethod(pic, "getPixel", new Object[]{200, 200}, 
            "{Red: 143, Green: 122, Blue: 168}"
        );

        header("grayscale");        
        pic = makeObject("Picture", new Object[]{"beach.jpg"});       
        testMethod(pic, "grayscale", new Object[]{}); 
        testMethod(pic, "getPixel", new Object[]{100, 100}, 
            "{Red: 198, Green: 198, Blue: 198}"
        );       
        testMethod(pic, "getPixel", new Object[]{200, 200}, 
            "{Red: 107, Green: 107, Blue: 107}"
        );

        header("tint");        
        pic = makeObject("Picture", new Object[]{"beach.jpg"});       
        testMethod(pic, "tint", new Object[]{.5,1,3}); 
        testMethod(pic, "getPixel", new Object[]{100, 100}, 
            "{Red: 80, Green: 255, Blue: 231}"
        );       
        testMethod(pic, "getPixel", new Object[]{200, 200}, 
            "{Red: 56, Green: 255, Blue: 87}"
        );

        header("posterize");        
        pic = makeObject("Picture", new Object[]{"beach.jpg"});       
        testMethod(pic, "posterize", new Object[]{90}); 
        testMethod(pic, "getPixel", new Object[]{100, 100}, 
            "{Red: 90, Green: 180, Blue: 180}"
        );       
        testMethod(pic, "getPixel", new Object[]{200, 200}, 
            "{Red: 90, Green: 90, Blue: 0}"
        );

        header("mirrorRightToLeft");        
        pic = makeObject("Picture", new Object[]{"beach.jpg"});       
        testMethod(pic, "mirrorRightToLeft", new Object[]{}); 
        testMethod(pic, "getPixel", new Object[]{100, 100}, 
            "{Red: 168, Green: 185, Blue: 213}"
        );       
        testMethod(pic, "getPixel", new Object[]{200, 200}, 
            "{Red: 119, Green: 135, Blue: 151}"
        );

        header("mirrorHorizontal");        
        pic = makeObject("Picture", new Object[]{"beach.jpg"});       
        testMethod(pic, "mirrorHorizontal", new Object[]{}); 
        testMethod(pic, "getPixel", new Object[]{100, 100}, 
            "{Red: 160, Green: 204, Blue: 231}"
        );       
        testMethod(pic, "getPixel", new Object[]{400, 400}, 
            "{Red: 159, Green: 200, Blue: 222}"
        );

        header("verticalFlip");        
        pic = makeObject("Picture", new Object[]{"beach.jpg"});       
        testMethod(pic, "verticalFlip", new Object[]{}); 
        testMethod(pic, "getPixel", new Object[]{100, 100}, 
            "{Red: 40, Green: 39, Blue: 35}"
        );       
        testMethod(pic, "getPixel", new Object[]{400, 400}, 
            "{Red: 159, Green: 200, Blue: 222}"
        );

        header("fixRoof");
        message("HINT.  If your fixRoof algorithm fails this test: make sure you are mirroring ONLY the top portion of the photograph and using the middle column as your axis of symmetry.");
        pic = makeObject("Picture", new Object[]{"temple.jpg"});       
        testMethod(pic, "fixRoof", new Object[]{}); 
        testMethod(pic, "getPixel", new Object[]{400, 70}, 
            "{Red: 57, Green: 36, Blue: 17}"
        );       
        testMethod(pic, "getPixel", new Object[]{400, 300}, 
            "{Red: 45, Green: 61, Blue: 22}"
        );

        header("edgeDetection"); 
        message("HINT.  If your edgeDetection algorithm fails this test: A pixel is considered an edge (should turn black) if EITHER its right neighor or bottom neighbor is color distant.");
        pic = makeObject("Picture", new Object[]{"swan.jpg"});       
        testMethod(pic, "edgeDetection", new Object[]{25}); 
        testMethod(pic, "getPixel", new Object[]{264, 170}, 
            "{Red: 255, Green: 255, Blue: 255}"
        );       
        testMethod(pic, "getPixel", new Object[]{264, 185}, 
            "{Red: 0, Green: 0, Blue: 0}"
        );

        header("chromakey");        
        Object mark = makeObject("Picture", new Object[]{"blue-mark.jpg"});       
        Object moon = makeObject("Picture", new Object[]{"moon-surface.jpg"});            
        testMethod(mark, "chromakey", new Object[]{moon, new java.awt.Color(10, 40, 75), 60}); 
        testMethod(mark, "getPixel", new Object[]{93, 156}, 
            "{Red: 203, Green: 202, Blue: 208}"
        );       
        testMethod(mark, "getPixel", new Object[]{327, 209}, 
            "{Red: 171, Green: 107, Blue: 82}"
        );

        header("encode / decode");        
        pic = makeObject("Picture", new Object[]{"beach.jpg"});       
        Object msg = makeObject("Picture", new Object[]{"msg.jpg"});            
        testMethod(pic, "encode", new Object[]{msg}); 
        testMethod(pic, "getPixel", new Object[]{75, 212}, 
            "{Red: 74, Green: 93, Blue: 51}"
        );       
        testMethod(pic, "getPixel", new Object[]{222, 229}, 
            "{Red: 125, Green: 140, Blue: 153}"
        );
        Object msgDec = testMethod(pic, "decode", new Object[]{}); 
        testMethod(msgDec, "getPixel", new Object[]{75, 212}, 
            "{Red: 255, Green: 255, Blue: 255}"
        );       
        testMethod(msgDec, "getPixel", new Object[]{222, 229}, 
            "{Red: 0, Green: 0, Blue: 0} "
        );

        header("simpleBlur");  
        message("HINT.  If your simpleBlur algorithm fails this test: You should be building a new picture and returning it.  The original (unblurred) picture shouldn't change.  This is because you don't want the change you made to a previously visited pixel to alter the average of the current pixel.");
        pic = makeObject("Picture", new Object[]{"beach.jpg"});       
        pic = testMethod(pic, "simpleBlur", new Object[]{}); 
        testMethod(pic, "getPixel", new Object[]{100, 100}, 
            "{Red: 160, Green: 204, Blue: 231}"
        );       
        testMethod(pic, "getPixel", new Object[]{400, 400}, 
            "{Red: 94, Green: 78, Blue: 62}"
        );

        header("blur");        
        message("HINT.  If your blur algorithm fails this test: You should be building a new picture and returning it.  The original (unblurred) picture shouldn't change.  This is because you don't want the change you made to a previously visited pixel to alter the average of the current pixel.");
        pic = makeObject("Picture", new Object[]{"beach.jpg"});       
        pic = testMethod(pic, "blur", new Object[]{10}); 
        testMethod(pic, "getPixel", new Object[]{100, 100}, 
            "{Red: 161, Green: 203, Blue: 232}"
        );       
        testMethod(pic, "getPixel", new Object[]{400, 400}, 
            "{Red: 141, Green: 125, Blue: 96}"
        );

        header("glassFilter");        
        message("Due to the random number generation involved in the glassFilter algorithm, pixel data will be different each time this filter is applied.  Solution can only be verified visually.  Does your picture look glass filtered?");
        pic = makeObject("Picture", new Object[]{"beach.jpg"});       
        pic = testMethod(pic, "glassFilter", new Object[]{3}); 
        testMethod(pic, "view", new Object[]{}); 
    }    
}