import java.util.*;
import java.io.*;

public class Maze {
   private Square[][] maze;
   private Square start, exit;

   public Maze() {      
   }

   public boolean loadMaze(String fileName) {
      Scanner fileReader = null;
      try {
         fileReader = new Scanner(new File(fileName));                  
      } catch (Exception e) {
         return false;
      }
      
      maze = new Square[fileReader.nextInt()][fileReader.nextInt()];
      for (int r = 0; r < maze.length; r++)
         for (int c = 0; c < maze[r].length; c++) {          
            maze[r][c] = new Square(r, c, fileReader.nextInt());
            if (maze[r][c].getType() == Square.START)
               start = maze[r][c];
            if (maze[r][c].getType() == Square.EXIT)
               exit = maze[r][c];
         }
     
      return true;
   }
   
   public List<Square> getNeighbors(Square s) {
      List<Square> n = new ArrayList<Square>();
      int r = s.getRow();
      int c = s.getCol();
      if (r-1 >= 0) 
         n.add(maze[r-1][c]);
      if (c-1 >= 0) 
         n.add(maze[r][c-1]);
      if (r+1 < maze.length) 
         n.add(maze[r+1][c]);
      if (c+1 < maze[r].length) 
         n.add(maze[r][c+1]);
      return n;
   }
   
   public Square getStart() {
      return start;
   }
   
   public Square getExit() {
      return exit;
   }
   
   public void reset() {
      for (int r = 0; r < maze.length; r++) 
         for (int c = 0; c < maze[r].length; c++)   
            maze[r][c].reset();
   }
   
   public String toString() {
      String ret = "";
      for (int r = 0; r < maze.length; r++) {
         for (int c = 0; c < maze[r].length; c++)   
            ret += maze[r][c] + " ";
         ret += "\n";
      }
      return ret;
   }

}