import java.io.IOException;
import java.io.File;
import java.util.*;
import static java.lang.System.*;

public class WordLadderRunner {
   public static void main( String args[] ) throws IOException {
      long start = System.currentTimeMillis();
      WordLadder w = new WordLadder();
      Scanner file = new Scanner(new File("input.txt"));
      int counter = 0;
      while (file.hasNext()) {
         w.setWords(file.next(), file.next());
         out.println(w);
           //if (++counter == 2) break;  //force early stop by not reading all cases.  Number indicates how many test cases from file to run
           
      }
      long end = System.currentTimeMillis();
      float sec = (end - start) / 1000F; 
      out.println("Run time = " + sec + " seconds");
   }
}