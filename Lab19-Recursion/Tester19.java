//Version 1.0
public class Tester19 extends TestGUI.TestData{ 
    public static void main (String[] args) {  
        if (VERSION_NUM < 2.13)
            System.out.println("This test script requires TestGUI version 2.11 or higher.\nPlease download a newer version of TestGUI.java.");
        else
            new TestGUI();   
    }

    public static void runTests() {  //Your test sequence must be within a method called runTests()
        //WRITE ALL YOUR TEST CASES IN HERE       
        setTimeOutSec(15);
        srcButton("RecursionProbs, Numbrix");

        // Newline Converter: https://onlinestringtools.com/convert-newlines-to-spaces
        // Object testMethod(String cName, String mName, Object[] args, [String expOut], [double allowableError], [String inputScript])

        header("RecursionProbs Test");  
        message("In addition to passing these tests, Mr. McCoy will spot check your labs to ensure that you didn't use any loops. LOOPS ARE OFF LIMITS in RecursionProbs.");

        testMethod("RecursionProbs", "numEars", new Object[]{10}, "20"); 
        testMethod("RecursionProbs", "numEars", new Object[]{24}, "48"); 
        testMethod("RecursionProbs", "countdown", new Object[]{5}, "5, 4, 3, 2, 1, blastoff!"); 
        testMethod("RecursionProbs", "countdown", new Object[]{8}, "8, 7, 6, 5, 4, 3, 2, 1, blastoff!"); 
        testMethod("RecursionProbs", "factorial", new Object[]{5}, "120"); 
        testMethod("RecursionProbs", "factorial", new Object[]{17}, "355687428096000"); 
        testMethod("RecursionProbs", "cheerlead", new Object[]{"Go team!", 3}, "Go team! Go team! Go team! "); 
        testMethod("RecursionProbs", "cheerlead", new Object[]{"salsa", 7}, "salsa salsa salsa salsa salsa salsa salsa"); 
        testMethod("RecursionProbs", "pow", new Object[]{3, 4}, "81"); 
        testMethod("RecursionProbs", "pow", new Object[]{2, 8}, "256"); 
        testMethod("RecursionProbs", "fib", new Object[]{7}, "13"); 
        testMethod("RecursionProbs", "fib", new Object[]{12}, "144"); 
        testMethod("RecursionProbs", "printPattern", new Object[]{16}, "16, 11, 6, 1, -4"); 
        testMethod("RecursionProbs", "printPattern", new Object[]{10}, "10, 5, 0, -5"); 
        testMethod("RecursionProbs", "countNumA", new Object[]{"aaHELLOa"}, "3"); 
        testMethod("RecursionProbs", "countNumA", new Object[]{"bob"}, "0"); 
        testMethod("RecursionProbs", "countNumA", new Object[]{""}, "0"); 
        testMethod("RecursionProbs", "countNumA", new Object[]{"Salsa is great. Easily my favorite."}, "5"); 
        testMethod("RecursionProbs", "printAtoBbyC", new Object[]{10, 30, 5}, "10 15 20 25 30"); 
        testMethod("RecursionProbs", "printAtoBbyC", new Object[]{0, 60, 12}, "0 12 24 36 48 60"); 
        testMethod("RecursionProbs", "countOdds", new Object[]{123456}, "3"); 
        testMethod("RecursionProbs", "countOdds", new Object[]{1233325555}, "8"); 
        testMethod("RecursionProbs", "sumDigits", new Object[]{123456}, "21"); 
        testMethod("RecursionProbs", "sumDigits", new Object[]{1233325555}, "34"); 

        header("Numbrix Puzzle");
        Object o = makeObject("Numbrix", new Object[]{"puzzle1.txt"});
        testMethod(o, "toString", null, "49	-	51	-	63	-	69	-	71	\n-	-	-	-	-	-	-	-	-	\n47	-	-	-	-	-	-	-	77	\n-	-	-	-	-	-	-	-	-	\n45	-	-	-	-	-	-	-	81	\n-	-	-	-	-	-	-	-	-	\n43	-	-	-	-	-	-	-	19	\n-	-	-	-	-	-	-	-	-	\n41	-	37	-	9	-	13	-	15	\n");
        testMethod(o, "solve", null, "49	50	51	62	63	68	69	70	71	\n48	53	52	61	64	67	74	73	72	\n47	54	59	60	65	66	75	76	77	\n46	55	58	27	26	25	24	79	78	\n45	56	57	28	5	4	23	80	81	\n44	31	30	29	6	3	22	21	20	\n43	32	33	34	7	2	1	18	19	\n42	39	38	35	8	11	12	17	16	\n41	40	37	36	9	10	13	14	15	\n");
        o = makeObject("Numbrix", new Object[]{"puzzle2.txt"});
        testMethod(o, "toString", null, "10	-	-	13	24	-	\n-	-	3	-	21	22	\n-	5	2	15	-	19	\n7	6	-	-	17	18	");
        testMethod(o, "solve", null, "10	11	12	13	24	23	\n9	4	3	14	21	22	\n8	5	2	15	20	19	\n7	6	1	16	17	18	");
    }
}