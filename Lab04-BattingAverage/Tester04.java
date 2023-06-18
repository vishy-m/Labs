//Version 1.0
public class Tester04 extends TestGUI.TestData{ 
    public static void main (String[] args) {  
        if (VERSION_NUM < 2.172)
            System.out.println("This test script requires TestGUI version 2.172 or higher.\nPlease download a newer version of TestGUI.java.");
        else
            new TestGUI();   
    }

    public static void runTests() {  //Your test sequence must be within a method called runTests()
        //WRITE ALL YOUR TEST CASES IN HERE       
        setTimeOutSec(5);
        srcButton("Player, Team, Runner");
        message("Best possible score is: 6 Green, 0 Yellow, 0 Red");   

        // Newline Converter: https://onlinestringtools.com/convert-newlines-to-spaces
        // Object testMethod(String cName, String mName, Object[] args, [String expOut], [double allowableError], [String inputScript])

        Object o;
        Class c;
        boolean t;

        header("Testing your Player Class");          
        Object o1 = makeObject("Player", new Object[]{"Fred", 42});
        Object o2 = makeObject("Player", new Object[]{"Bob", 42, 10, 5});
        testMethod(o2, "getBattingAverage", null, "0.5");
        testMethod(o2, "getBattingAverageString", null, "500"); 

        header("Testing your Team Class");    
        Object o3 = makeObject("Team", new Object[]{2});
        testMethod(o3, "setPlayer", new Object[] {o1, 0});
        testMethod(o3, "setPlayer", new Object[] {o2, 1});
        testMethod(o3, "printTeamStats", null, 
        "Fred\t#42\taverage >>> 0\nBob\t#42\taverage >>> 500"
        );

        header("Testing your Runner");
        testMethod("Runner", "main", new Object[]{new String[0]}, 
            "Tom\t#8\taverage >>> 349\nMark\t#4\taverage >>> 530\nFrank\t#23\taverage >>> 483\nRoger\t#45\taverage >>> 203\nAlan\t#12\taverage >>> 438\nHarry\t#11\taverage >>> 569\nRon\t#36\taverage >>> 549\nTim\t#1\taverage >>> 490\nKyle\t#2\taverage >>> 444"
        );               

        header("Testing your ENCAPSULATION");  
        c = getClassFromName("Player");        
        if (c != null) {
            String fields = java.util.Arrays.toString(c.getDeclaredFields());            
            t = c.getDeclaredFields().length == 4 && fields.contains("private"); 
            message("Player class declares exactly 4 PRIVATE Instance Variables: " + t, t);                  
        } else { message("Can't find Player class", false); } 
        c = getClassFromName("Team");        
        if (c != null) {
            String fields = java.util.Arrays.toString(c.getDeclaredFields());            
            t = c.getDeclaredFields().length == 1 && fields.contains("private"); 
            message("Team class declares exactly 1 PRIVATE Instance Variable: " + t, t);                  
        } else { message("Can't find Team class", false); } 

    }    
}