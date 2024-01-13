import java.util.*;
public class MazeSolverStack extends MazeSolver
{
   private MyStack stack;
   
   public MazeSolverStack(Maze m)
   {
      super(m);
   }
   
   public void makeEmpty()
   {
      stack = new MyStack();
   }
   
   public boolean isEmpty()
   {
      return stack.isEmpty();
   }
   
   public void add(Square s)
   {
      stack.push(s);
   }
   
   public Square next()
   {
      return stack.peek();
   } 
   
   
}