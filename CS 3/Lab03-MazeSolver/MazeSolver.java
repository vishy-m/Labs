import java.util.*;

public abstract class MazeSolver
{
   public Maze maze;
   
   private static final String SOLVED = "solved";
   private static final String UNSOLVABLE = "unsolvable";
   private static final String NYS = "not yet solved";
   
   private String status;
   
   public MazeSolver(Maze m)
   {
      maze = m;
      makeEmpty();
      add(m.getStart());
      status = NYS;
   }
   
   public abstract void makeEmpty();
   public abstract boolean isEmpty();
   public abstract void add(Square s);
   public abstract Square next();
   
   public String getPath()
   {
      return status;
   }
   
   public boolean isSolved()
   {
      if (isEmpty()) 
         return true;
      if (status.equals(SOLVED)) 
         return true;
      return false;
   }
   
   public void step()
   {
      if (isEmpty())
      {
         status = UNSOLVABLE;
         return;
      }
      
      Square nextSquare = next();
      if (nextSquare.equals(maze.getExit()))
      {
         status = SOLVED;
         return;
      }
      status = NYS;
      
      List<Square> neighbors = maze.getNeighbors(nextSquare);
      for (int i = 0; i < neighbors.size(); i++)
      {
         Square currentNeighbor = neighbors.get(i);
         if (currentNeighbor.getType() != Square.WALL && currentNeighbor.getStatus() == Square.UNKNOWN)
         {
            currentNeighbor.setStatus(Square.WORKING);
            add(currentNeighbor);
         }
      }
      
      nextSquare.setStatus(Square.EXPLORED);
      
   }
   
   public void solve()
   {
      while(getPath().equals(NYS))
      {
         step();
      }  
   }
}