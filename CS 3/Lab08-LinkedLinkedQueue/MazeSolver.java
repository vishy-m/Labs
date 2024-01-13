import java.util.*;
public abstract class MazeSolver {

   private Maze maze;
   private String solutionStatus = "not yet solved";   

   public MazeSolver(Maze maze) { 
      this.maze = maze;         
   }

   public abstract void makeEmpty();

   public abstract boolean isEmpty();

   public abstract void add(Square s);

   public abstract Square next();

   public boolean isSolved() {
      return solutionStatus.equals("solved");
   }

   public void step() {
   //1
      if (isEmpty()) { 
         solutionStatus = "unsolvable";
         return;         
      }
         //2
      Square next = next();
      if (next.equals(maze.getExit())) {
         solutionStatus = "solved";
         return;
      }
      
      for (Square option : maze.getNeighbors(next)) 
         if (option.getType() != Square.WALL && option.getStatus() == '_') {
            option.setStatus('o');
            add(option);
            if (option.getPrevious() == null)
               option.setPrevious(next);
         }
      next.setStatus('.');              
   }

   public String getPath() {
      if (solutionStatus.equalsIgnoreCase("unsolvable"))
         return solutionStatus;
      
      if (solutionStatus.equalsIgnoreCase("solved"))
      {
         Square current = this.maze.getExit();
         
         
         Stack<String> stack = new Stack<String>();
         while (current != null && !current.equals(this.maze.getStart()))
         {
            String cords = "[" + current.getRow() + ", " + current.getCol() + "]";
            stack.push(cords);
            current = current.getPrevious(); 
         }
         
         
         
         String fullPath = "";
         fullPath += "Start: " + "[" + this.maze.getStart().getRow() + ", " + this.maze.getStart().getCol() + "] -> ";
         while (!stack.isEmpty())
         {
            fullPath += stack.pop();
            if (!stack.isEmpty())
               fullPath += " -> ";
         }
         fullPath += " : END";
         
         return fullPath;
      }
      
      return solutionStatus;
     
   }

   public void solve() {
      while (! isSolved())
         step();
   }

}