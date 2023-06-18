//Version 1.0
public class Tester14 extends TestGUI.TestData{ 
    public static void main (String[] args) {  
        if (VERSION_NUM < 2.13)
            System.out.println("This test script requires TestGUI version 2.11 or higher.\nPlease download a newer version of TestGUI.java.");
        else
            new TestGUI();   
    }

    public static void runTests() {  //Your test sequence must be within a method called runTests()
        //WRITE ALL YOUR TEST CASES IN HERE       
        setTimeOutSec(3);
        srcButton("Point, Path, GreedyPath");

        // Newline Converter: https://onlinestringtools.com/convert-newlines-to-spaces
        // Object testMethod(String cName, String mName, Object[] args, [String expOut], [double allowableError], [String inputScript])

        header("Functionality Tests");  
        Object point1 = makeObject("Point", new Object[]{0, 0});
        Object point2 = makeObject("Point", new Object[]{3, 4});
        testMethod(point2, "toString", null, "(3.0, 4.0)"); 
        testMethod(point1, "getDistance", new Object[]{point2}, "5.0"); 
        Object p = makeObject("Path", new Object[]{"points10.txt"});
        testMethod(p, "getMaxX", null, "2.5"); 
        testMethod(p, "getNumPoints", null, "10");
        testMethod(p, "getDistance", null, "27.47724086052482", 0.0001);
        testMethod(p, "toString", null, "(0.0, 0.0)\n(1.3, 1.9)\n(-2.0, 1.0)\n(2.5, 2.8)\n(-0.5, -2.3)\n(1.0, -1.3)\n(2.0, -1.0)\n(0.7, 1.6)\n(-1.8, -0.5)\n(-0.1, 0.5)\nTotal Distance: 27.47724086052482", 0.0001); 
        p = makeObject("GreedyPath", new Object[]{"points10.txt"});
        testMethod(p, "getDistance", null, "14.454064189612776",0.0001);
        testMethod(p, "toString", null, "(0.0, 0.0)\n(-0.1, 0.5)\n(0.7, 1.6)\n(1.3, 1.9)\n(2.5, 2.8)\n(2.0, -1.0)\n(1.0, -1.3)\n(-0.5, -2.3)\n(-1.8, -0.5)\n(-2.0, 1.0)\nTotal Distance: 14.454064189612776", 0.0001);         
        
        header("Object Design & Inheritance Tests"); 
        message("These tests verify that you followed proper rules of object design and inheritance as guided by the lab instructions.");   
        Class greedyPath = getClassFromName("GreedyPath");
        Class path = getClassFromName("Path");
        Class point = getClassFromName("Point");     

        if (point != null) {
            //Confirm that Point only has 3 PIVs
            String fields = java.util.Arrays.toString(point.getDeclaredFields());            
            boolean t = point.getDeclaredFields().length == 3 && ! fields.contains("public"); 
            message("Point class declares 3 PIVs (nothing public): " + t, t);          
        } else { message("Can't find Point class", false); } 

        if (path != null) {
            //Confirm that Path only has 3 PIVs
            String fields = java.util.Arrays.toString(path.getDeclaredFields());            
            boolean t = path.getDeclaredFields().length == 5 && ! fields.contains("public"); 
            message("Path class declares 5 PIVs (nothing public): " + t, t);                                            
        } else { message("Can't find Path class", false); } 

        if (greedyPath != null) {
            boolean t = greedyPath.getSuperclass().getName().equals("Path");
            message("GreedyPath class extends Path: " + t, t);

            //Confirm that GreedyPath only has 1 PIV
            String fields = java.util.Arrays.toString(greedyPath.getDeclaredFields());            
            t = greedyPath.getDeclaredFields().length == 1 && ! fields.contains("public"); 
            message("GreedyPath class declares 1 PIV (all other fields were inherited): " + t, t);                                  
        } else { message("Can't find GreedyPath class", false); } 

        Object path2 = makeObject("GreedyPath", new Object[]{"points5.txt"});
        testMethod("DrawPath", "draw", new Object[]{path2}); 
    }    
}