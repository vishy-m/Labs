//Version 1.0
public class Tester16 extends TestGUI.TestData{ 
    public static void main (String[] args) {  
        if (VERSION_NUM < 2.16)
            System.out.println("This test script requires TestGUI version 2.16 or higher.\nPlease download a newer version of TestGUI.java.");
        else
            new TestGUI();   
    }

    public static void runTests() {  //Your test sequence must be within a method called runTests()
        //WRITE ALL YOUR TEST CASES IN HERE       
        setTimeOutSec(30);
        srcButton("Deck, Board, ElevensBoard, ThirteensBoard");

        // Newline Converter: https://onlinestringtools.com/convert-newlines-to-spaces
        // Object testMethod(String cName, String mName, Object[] args, [String expOut], [double allowableError], [String inputScript])

        header("Shuffle Test");  

        String[] ranks = {"10", "jack", "queen", "king"};
        String[] suits = {"hearts", "spades"};
        int[] values   = {10, 11, 12, 13};

        Object d = makeObject("Deck", new Object[]{ranks, suits, values});        
        testMethod(d, "shuffle", new Object[] {}); 
        message("Here's what a mini deck (10 through king, hearts & spaces only) looks like after being created and shuffled.  Since shuffling is random, you have to visually inspect it yourself to see that it is shuffled.  You should have two 10s, two jacks, two queens, and two kings, but in a random order.  (No cards have been dealt.)");        
        testMethod(d, "toString", new Object[] {}); 

        header("Object Design Tests");
        message("These tests verify that you followed proper rules of object design and inheritance as guided by the lab instructions.");   
        Class bClass = getClassFromName("Board");
        Class ebClass = getClassFromName("ElevensBoard");
        Class tbClass = getClassFromName("ThirteensBoard");     

        boolean t;
        if (bClass != null) {
            t = java.lang.reflect.Modifier.isAbstract(bClass.getModifiers());
            message("Board class is abstract: " + t, t); 

            t = java.util.Arrays.toString(bClass.getDeclaredMethods()).contains("public abstract boolean Board.anotherPlayIsPossible(");          
            t = t && java.util.Arrays.toString(bClass.getDeclaredMethods()).contains("public abstract boolean Board.isLegal(");          
            message("Board declares abstract methods for anotherPlayIsPossible and isLegal: " + t, t);                     
        } else { message("Can't find Board class", false); } 

        if (ebClass != null) {
            t = ebClass.getSuperclass().getName().equals("Board");
            message("ElevensBoard extends Board: " + t, t); 

            t = ebClass.getDeclaredMethods().length == 4;          
            message("ElevensBoard has only 4 declared methods (all other methods are inherited from Board): " + t, t);                     
        } else { message("Can't find ElevensBoard class", false); } 

        if (tbClass != null) {
            t = tbClass.getSuperclass().getName().equals("Board");
            message("ThirteensBoard extends Board: " + t, t); 

            t = tbClass.getDeclaredMethods().length == 4;          
            message("ThirteensBoard has only 4 declared methods (all other methods are inherited from Board): " + t, t);                     
        } else { message("Can't find ThirteensBoard class", false); } 

        header("Launching games for playing.");
        Object b = makeObject("ElevensBoard", new Object[]{}); 
        Object game = makeObject("CardGameGUI", new Object[]{b}); 
        boolean success = runAsThread(game, "displayGame", null);
        message("Successfully opened a game of Elevens:", success);

        b = makeObject("ThirteensBoard", new Object[]{}); 
        game = makeObject("CardGameGUI", new Object[]{b}); 
        success = runAsThread(game, "displayGame", null);
        message("Successfully opened a game of Thirteens:", success);

        message("IMPORTANT NOTICE: You won't necessarily get a 100 just because everything turned green.  Mr. McCoy will visually inspect that your cards are shuffled and that both games play correctly.");
    }    
}