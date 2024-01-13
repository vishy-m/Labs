import java.util.*;
public class MazeSolverQueue extends MazeSolver {
   
   MyQueue<Square> queue;

   public MazeSolverQueue(Maze maze) {
      super(maze);
      queue = new MyQueue<Square>();      
      add(maze.getStart());
   }

   public void makeEmpty() {
      queue.clear();      
   }

   public boolean isEmpty() {
      return queue.isEmpty();
   }

   public void add(Square s) {
      queue.offer(s);
   }

   public Square next() {
      return queue.poll();
   }

}