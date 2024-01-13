public class MazeSolverStack extends MazeSolver {
   MyStack stack;


   public MazeSolverStack(Maze maze) {
      super(maze);
      stack = new MyStack();      
      add(maze.getStart());
   }

   public void makeEmpty() {
      stack.clear();      
   }

   public boolean isEmpty() {
      return stack.isEmpty();
   }

   public void add(Square s) {
      stack.push(s);
   }

   public Square next() {
      return stack.pop();
   }

}