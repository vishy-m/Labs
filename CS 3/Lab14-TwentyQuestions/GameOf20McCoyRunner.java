import java.io.*;
public class GameOf20McCoyRunner {

   public static void main(String[] arg) {
      try{
      
         GameTree game = new GameTree("zelda.txt");
         System.out.println(game);
         game.playerSelected(Choice.Yes);
         game.playerSelected(Choice.No);
         System.out.println("After a yes and a no we are at: " + game.getCurrent());
         game.playerSelected(Choice.No);
         System.out.println("After another no are we at a leaf/answer node: " + game.foundAnswer() + " " + game.getCurrent());
      
         game.add("(5a)Was it on the GameBoy?", "(5b)Link's Awakening");
         System.out.println("\nAdding a question/answer about GameBoy (5a & 5b)\n" + game);
      
         System.out.println("\nSaving...");
         game.saveGame();
      
         System.out.println("\nReloading from save file...");
         game = new GameTree("zelda.txt");
         System.out.println(game);  
      } catch (Exception e) { System.out.println(e); }
      
      //return the file Zelda.txt to its original state
      try {
         System.out.println("\nRestoring original zelda.txt...");
         copyFileUsingStream("zelda-original.txt", "zelda.txt");
      } catch (Exception e) { System.out.println("Could not restore zelda.txt file to original state.\n"+e);
      
      
      }
          
   }
   
   /*  EXPECTED RESULTS
   
 - - (1)Ocarina of Time
 - (2)Do you turn into a wolf?
 - - (3)Twilight Princess
 (4)Is it 2d?
 - - - (5)Original Legend of Zelda
 - - (6)Is it 16-bit?
 - - - (7)A Link to the Past
 - (8)Does it have side-scrolling action?
 - - (9)Zelda 2: Adventure of Link
 
 After a yes and a no we are at: (6)Is it 16-bit?
 After another no are we at a leaf/answer node: true (5)Original Legend of Zelda
 
 Adding a question/answer about GameBoy
 - - (1)Ocarina of Time
 - (2)Do you turn into a wolf?
 - - (3)Twilight Princess
 (4)Is it 2d?
 - - - - (5)Original Legend of Zelda
 - - - (5a)Was it on the GameBoy?
 - - - - (5b)Link's Awakening
 - - (6)Is it 16-bit?
 - - - (7)A Link to the Past
 - (8)Does it have side-scrolling action?
 - - (9)Zelda 2: Adventure of Link    
 
 Saving...
 
 Reloading from save file...
 - - (1)Ocarina of Time
 - (2)Do you turn into a wolf?
 - - (3)Twilight Princess
 (4)Is it 2d?
 - - - - (5)Original Legend of Zelda
 - - - (5a)Was it on the GameBoy?
 - - - - (5b)Link's Awakening
 - - (6)Is it 16-bit?
 - - - (7)A Link to the Past
 - (8)Does it have side-scrolling action?
 - - (9)Zelda 2: Adventure of LinkW
   
   */
   
   
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