import java.util.*;
import java.io.*;
public class Maze
{
   private Square[][] maze;
   
   private Square startSquare, exitSquare;
   
   public Maze()
   {
      
   }
   
   public boolean loadMaze (String fileName)
   {
      File file = new File(fileName);
      Scanner input = null;
      
      try { input = new Scanner(file); }
      catch (IOException e) 
      {
         System.out.println(e); 
         return false;
      }
      int i = 0;
     
      while (input.hasNextLine())
      {
         Scanner chopper = new Scanner(input.nextLine());
         if (i == 0)
         {
            int row = chopper.nextInt();
            int col = chopper.nextInt();
            maze = new Square[row][col];
         }
         else
         {
            int colCount = 0;
            while (colCount < maze[0].length)
            {  
               int squareType = chopper.nextInt();
               //System.out.println(squareType);
               maze[i - 1][colCount] = new Square(i - 1, colCount, squareType);
               if (squareType == 2)
               {
                  startSquare = maze[i - 1][colCount];
               }
               if (squareType == 3)
               {
                  exitSquare = maze[i - 1][colCount];
               }
               colCount++;
            }
         }
         i++;
      }
      return true;
   }
   
   public List<Square> getNeighbors(Square s)
   {
      ArrayList<Square> neighborSquares = new ArrayList<Square>();
          
      for (int r = 0; r < maze.length; r++)
      {
         for (int c = 0; c < maze[r].length; c++)
         {
            if (maze[r][c].equals(s))
            {
               if (r + 1 < maze.length)  neighborSquares.add(maze[r + 1][c]);
               if (r - 1 >= 0) neighborSquares.add(maze[r - 1][c]);
               if (c + 1 < maze[r].length) neighborSquares.add(maze[r][c + 1]);
               if (c - 1 < 0) neighborSquares.add(maze[r][c - 1]);
               return neighborSquares;
            }
         }
      }
      
      return neighborSquares;
   }
   
   public Square getStart()
   {
      return startSquare;
   }
   
   public Square getExit()
   {
      return exitSquare;
   }
   
   public void reset()
   {
      for (int r = 0; r < maze.length; r++)
      {
         for (int c = 0; c < maze[r].length; c++)
         {
            maze[r][c].reset();
         }
      }
   }
   
   public String toString()
   {
      String map = "";
      for (int r = 0; r < maze.length; r++)
      {
         for (int c= 0; c < maze[r].length; c++)
         {
            map += maze[r][c] + " ";
         }
         map += "\n";
      }
      return map;
   }
   
}