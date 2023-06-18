//Version 1.0

 

public class Tester17 extends TestGUI.TestData{ 
    public static void main (String[] args) {  
        if (VERSION_NUM < 2.15)
            System.out.println("This test script requires TestGUI version 2.15 or higher.\nPlease download a newer version of TestGUI.java.");
        else
            new TestGUI();   
    }

    public static void runTests() {  //Your test sequence must be within a method called runTests()
        //WRITE ALL YOUR TEST CASES IN HERE       
        setTimeOutSec(3);
        srcButton("Nameable, Monster, MonsterRunner, Cypher, NumericalCypher, CaesarShift, SubstitutionCypher, Translator");

        // Newline Converter: https://onlinestringtools.com/convert-newlines-to-spaces
        // Object testMethod(String cName, String mName, Object[] args, [String expOut], [double allowableError], [String inputScript])

        header("Monster Functionality Tests");  
        Object m1 = makeObject("Monster", new Object[]{"Tim", 1, 1, 1});
        Object m2 = makeObject("Monster", new Object[]{2, 2, 2});
        Object m3 = makeObject("Monster", new Object[]{"Pete", 2, 1, 1});
        Object m4 = makeObject("Monster", new Object[]{});
        Object m5 = makeObject("Monster", new Object[]{"Roger", 2, 2, 1});
        testMethod(m2, "setName", new Object[]{"Fred"});
        testMethod(m2, "toString", null, "Fred"); 
        testMethod(m1, "compareTo", new Object[]{m2}, "-1");
        testMethod(m2, "compareTo", new Object[]{m1}, "1");
        testMethod(m2, "compareTo", new Object[]{m2}, "0");
        testMethod(m2, "compareTo", new Object[]{m3}, "1");
        testMethod(m5, "compareTo", new Object[]{m2}, "-1");
        testMethod(m5, "compareTo", new Object[]{m3}, "1");
        testMethod("MonsterRunner", "main", new Object[]{new String[0]}, "false\ntrue\n-1\n1\n0\n[Unnamed Monster, Unnamed Monster, Gorlock, Bob, Lurr]");

        header("Monster Interface Tests"); 
        message("These tests verify that you followed proper rules of interfaces as guided by the lab instructions.");           
        Class n = getClassFromName("Nameable");
        Class m = getClassFromName("Monster");

        if (n != null) {            
            String fields = java.util.Arrays.toString(n.getDeclaredMethods());            
            boolean t = n.getDeclaredMethods().length == 2; 
            message("Nameable interface includes 2 abstract methods: " + t, t);          
        } else { message("Can't find Nameable interface", false); }         

        if (m != null) {            
            String interfaceList = java.util.Arrays.toString(m.getInterfaces());
            boolean t = interfaceList.indexOf("interface java.lang.Comparable") > -1;
            message("Monster class implements Comparable: " + t, t);               
            t = interfaceList.indexOf("interface Nameable") > -1;
            message("Monster class implements Nameable: " + t, t); 
        } else { message("Can't find Monster class", false); } 

        header("Cypher Functionality Tests"); 
        Object c = makeObject("NumericalCypher", new Object[]{});
        testMethod(c, "encode", new Object[]{"abc. XYZ!"}, "97 98 99 46 32 88 89 90 33 ");
        testMethod(c, "decode", new Object[]{"117 32 68 101 67 111 68 101 100 32 77 101"}, "u DeCoDed Me");
        c = makeObject("CaesarShift", new Object[]{});
        testMethod(c, "encode", new Object[]{"aBcDeFgHiJkLmNoPqRsTuVwXyZ"}, "DEFGHIJKLMNOPQRSTUVWXYZABC");
        testMethod(c, "decode", new Object[]{"DFZA! EGXC"}, "ACWX! BDUZ");
        c = makeObject("SubstitutionCypher", new Object[]{});
        testMethod(c, "encode", new Object[]{"aBcDeFgHiJkLmNoPqRsTuVwXyZ"}, "FmvsLaSlAhyRTKUXiNdQVWurCe");
        testMethod(c, "decode", new Object[]{"tvvUjMADS wU FBB yDUuD BFud UI FnAFwAUD, wkLjL Ad DU uFC F GLL dkUVBM GL FGBL wU IBC. Pwd uADSd FjL wUU dTFBB wU SLw Awd IFw BAwwBL GUMC UII wkL SjUVDM. QkL GLL, UI vUVjdL, IBALd FDCuFC GLvFVdL GLLd MUD'w vFjL ukFw kVTFDd wkADy Ad ATcUddAGBL. JLBBUu, GBFvy. JLBBUu, GBFvy. JLBBUu, GBFvy. JLBBUu, GBFvy."}, "According to all known laws of aviation, there is no way a bee should be able to fly. Its wings are too small to get its fat little body off the ground. The bee, of course, flies anyway because bees don't care what humans think is impossible. Yellow, black. Yellow, black. Yellow, black. Yellow, black.");
        testMethod("Translator", "main", new Object[]{new String[0]}, 
            "0) Quit\n1) Encode \n2) Decode\nChoice >> 1\n\nWhat is the input String? >> salsa\n\nHere are the available cyphers.\n0) NumericalCypher\n1) CaesarShift\n2) SubstitutionCypher\nCypher choice >> 0\n\nOutput String >> 115 97 108 115 97 \nPress enter to continue.\n\n0) Quit\n1) Encode \n2) Decode\nChoice >> 2\n\nWhat is the input String? >> zFBdF\n\nHere are the available cyphers.\n0) NumericalCypher\n1) CaesarShift\n2) SubstitutionCypher\nCypher choice >> 2\n\nOutput String >> Salsa\nPress enter to continue.\n\n0) Quit\n1) Encode \n2) Decode\nChoice >> 1\n\nWhat is the input String? >> x-salsa-X\n\nHere are the available cyphers.\n0) NumericalCypher\n1) CaesarShift\n2) SubstitutionCypher\nCypher choice >> 1\n\nOutput String >> A-VDOVD-A\nPress enter to continue.\n\n0) Quit\n1) Encode \n2) Decode\nChoice >> 0",
            "1\nsalsa\n0\n\n2\nzFBdF\n2\n\n1\nx-salsa-X\n1\n\n0"
        );

        header("Cypher Interface Tests"); 
        message("These tests verify that you followed proper rules of interfaces as guided by the lab instructions.");           
        Class ci = getClassFromName("Cypher");
        Class nc = getClassFromName("NumericalCypher");
        Class cs = getClassFromName("CaesarShift");
        Class sc = getClassFromName("SubstitutionCypher");

        if (ci != null) {            
            String fields = java.util.Arrays.toString(ci.getDeclaredMethods());            
            boolean t = n.getDeclaredMethods().length == 2; 
            message("Cypher interface includes 2 abstract methods: " + t, t);          
        } else { message("Can't find Cypher interface", false); }         

        if (nc != null) {            
            String interfaceList = java.util.Arrays.toString(nc.getInterfaces());
            boolean t = interfaceList.indexOf("interface Cypher") > -1;
            message("NumericalCypher class implements Cypher: " + t, t);               
        } else { message("Can't find NumericalCypher class", false); } 
        
        if (cs != null) {            
            String interfaceList = java.util.Arrays.toString(cs.getInterfaces());
            boolean t = interfaceList.indexOf("interface Cypher") > -1;
            message("CaesarShift class implements Cypher: " + t, t);               
        } else { message("Can't find CaesarShift class", false); } 
        
        if (sc != null) {            
            String interfaceList = java.util.Arrays.toString(sc.getInterfaces());
            boolean t = interfaceList.indexOf("interface Cypher") > -1;
            message("SubstitutionCypher class implements Cypher: " + t, t);               
        } else { message("Can't find SubstitutionCypher class", false); } 

    }    
}