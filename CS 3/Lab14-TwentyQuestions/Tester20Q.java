//Version 1.0
import java.io.*;

public class Tester20Q extends TestGUI.TestData{ 
   public static void main (String[] args) {        
      new TestGUI();   
   }

   public static void runTests() {  //Your test sequence must be within a method called runTests()
      //WRITE ALL YOUR TEST CASES IN HERE       
      setTimeOutSec(3);
      srcButton("GameTree");
      
   
      // Newline Converter: https://onlinestringtools.com/convert-newlines-to-spaces
      // Object testMethod(String cName, String mName, Object[] args, [String expOut], [double allowableError], [String inputScript])
         
      header("20 Questions");  
      message("Best possible score: 7 Green, 0 Yellow, 0 Red");
      Object o = makeObject("GameTree", new Object[]{"zelda.txt"});
      testMethod(o, "toString", null, "- - (1)Ocarina of Time\n- (2)Do you turn into a wolf?\n- - (3)Twilight Princess\n(4)Is it 2d?\n- - - (5)Original Legend of Zelda\n- - (6)Is it 16-bit?\n- - - (7)A Link to the Past\n- (8)Does it have side-scrolling action?\n- - (9)Zelda 2: Adventure of Link\n"); 
      testMethod(o, "playerSelected", new Object[]{Choice.Yes}, null);
      testMethod(o, "playerSelected", new Object[]{Choice.No}, null);
      message("After a yes and a no, we are at...");
      testMethod(o, "getCurrent", null, "(6)Is it 16-bit?");
      testMethod(o, "foundAnswer", null, "false");
      message("After another no, we are at...");
      testMethod(o, "playerSelected", new Object[]{Choice.No}, null);
      testMethod(o, "getCurrent", null, "(5)Original Legend of Zelda");
      testMethod(o, "foundAnswer", null, "true");
      message("Adding a question at the current leaf...");
      testMethod(o, "add", new Object[]{"(5a)Was it on the GameBoy?", "(5b)Link's Awakening"}, null);
      testMethod(o, "toString", null, "- - (1)Ocarina of Time\n- (2)Do you turn into a wolf?\n- - (3)Twilight Princess\n(4)Is it 2d?\n- - - - (5)Original Legend of Zelda\n- - - (5a)Was it on the GameBoy?\n- - - - (5b)Link's Awakening\n- - (6)Is it 16-bit?\n- - - (7)A Link to the Past\n- (8)Does it have side-scrolling action?\n- - (9)Zelda 2: Adventure of Link");
      message("Saving...");
      testMethod(o, "saveGame", null);
   
      message("Reloading tree from save file to see if it saved correctly...");
      o = makeObject("GameTree", new Object[]{"zelda.txt"});
      testMethod(o, "toString", null, "- - (1)Ocarina of Time\n- (2)Do you turn into a wolf?\n- - (3)Twilight Princess\n(4)Is it 2d?\n- - - - (5)Original Legend of Zelda\n- - - (5a)Was it on the GameBoy?\n- - - - (5b)Link's Awakening\n- - (6)Is it 16-bit?\n- - - (7)A Link to the Past\n- (8)Does it have side-scrolling action?\n- - (9)Zelda 2: Adventure of Link");
      
      message("Returning zelda.txt to its original state...");
      try {
         System.out.println("\nRestoring original zelda.txt...");
         copyFileUsingStream("zelda-original.txt", "zelda.txt");
         message("Done");
      } catch (Exception e) { message("Could not restore zelda.txt file to original state.\n"+e);}
         
   }      
               
   private static void copyFileUsingStream(String source, String dest) throws IOException {
      InputStream is = null;
      OutputStream os = null;
      try {
         is = new FileInputStream(new File(source));
         os = new FileOutputStream(new File(dest));
         byte[] buffer = new byte[1024];
         int length;
         while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
         }
      } finally {
         is.close();
         os.close();
      }
   }
               
              
}