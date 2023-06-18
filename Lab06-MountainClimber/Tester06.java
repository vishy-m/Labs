public class Tester06 extends TestGUI.TestData{ 
    public static void main (String[] args) {  
        if (VERSION_NUM < 2.172)
            System.out.println("This test script requires TestGUI version 2.172 or higher.\nPlease download a newer version of TestGUI.java.");
        else
            new TestGUI();   
    }

    public static void runTests() {  //Your test sequence must be within a method called runTests()
        //WRITE ALL YOUR TEST CASES IN HERE       
        setTimeOutSec(1);

        srcButton("TwoDArrayProbs, TwoDRunner, MapIllustrator");
        message("Best possible score is: 17 Green, 0 Yellow, 0 Red");   
        Object o;
        int[][] mat, mat2;

        header("sum");                    
        mat = new int[][]{{1, 2}, {10, 11}};
        o = makeObject("TwoDArrayProbs", new Object[]{mat});     
        testMethod(o, "sum", null, "24");        
        mat = new int[][] {{1, 1, 1}, {10, 10, 10, 10,}, {100}};
        o = makeObject("TwoDArrayProbs", new Object[]{mat});     
        testMethod(o, "sum", null, "143");  

        header("isSquare");
        mat = new int[][] {{2, 3, 1}, {5, 4, 6}};
        o = makeObject("TwoDArrayProbs", new Object[]{mat});  
        testMethod(o, "isSquare", null, "false"); 
        mat = new int[][] {{2, 3}, {5, 4, 6}};
        o = makeObject("TwoDArrayProbs", new Object[]{mat});  
        testMethod(o, "isSquare", null, "false"); 
        mat = new int[][] {{2, 3, 1}, {5, 4, 1}, {0, 0, 0}};
        o = makeObject("TwoDArrayProbs", new Object[]{mat});  
        testMethod(o, "isSquare", null, "true"); 

        header("addMatrix");
        mat = new int[][] {{1,2,3,10}, {3,2,1,100}};
        mat2 = new int[][] {{2,3,1,5}, {3,1,2,5}};
        o = makeObject("TwoDArrayProbs", new Object[]{mat});  
        testMethod(o, "addMatrix", new Object[] {mat2}, "[3, 5, 4, 15]\n[6, 3, 3, 105]");   
        testMethod(o, "addMatrix", new Object[] {mat2}, "[5, 8, 5, 20]\n[9, 4, 5, 110]");

        header("columnSum");
        mat = new int[][] {{1, 2, 3}, {4, 5, 6}, {6}};
        o = makeObject("TwoDArrayProbs", new Object[]{mat});  
        testMethod(o, "columnSum", new Object[] {2}, "9");
        mat = new int[][] {{1}, {1}, {2, 10, 4}, {5, 20, 7}};
        o = makeObject("TwoDArrayProbs", new Object[]{mat});  
        testMethod(o, "columnSum", new Object[] {1}, "30"); 

        header("isColumnMagic");
        mat = new int[][] {{1, 2, 3}, {1}, {2, 2, 1}};
        o = makeObject("TwoDArrayProbs", new Object[]{mat});  
        testMethod(o, "isColumnMagic", null, "true");   
        mat = new int[][] {{1, 2}, {4, 3}, {1, 1, 5}};
        o = makeObject("TwoDArrayProbs", new Object[]{mat});  
        testMethod(o, "isColumnMagic", null, "false");

        header("diagDifference");
        mat = new int[][] {{1, 2, 3}, {3, 2, 1}, {7, 2, 2}};
        o = makeObject("TwoDArrayProbs", new Object[]{mat});  
        testMethod(o, "diagDifference", null, "7");
        mat = new int[][] {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}};
        o = makeObject("TwoDArrayProbs", new Object[]{mat});  
        testMethod(o, "diagDifference", null, "0");   
        mat = new int[][] {{4, 9}, {3, 5}};
        o = makeObject("TwoDArrayProbs", new Object[]{mat});  
        testMethod(o, "diagDifference", null, "3");  

        header("MapTester");
        o = makeObject("MapIllustrator", new Object[]{"Colorado_480x480.txt"}); 
        testMethod("MapTester", "testMinMax", new Object[]{o}, 
            "Min: 1326, max: 4334"
        );
        testMethod("MapTester", "testDrawPath", new Object[]{o}, 
            "Lowest-elevation-change path starting at row 200: 19056"
        );
         testMethod("MapTester", "testBestPath", new Object[]{o}, 
            "Overall best lowest-elevation-change path at row: 457, total change of: 11971"
        );

    }    
}