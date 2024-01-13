public class MazeRunner
{
   public static void main(String[] args)
   {
      Maze maze = new Maze();
      maze.loadMaze("maze-2");
      System.out.println("hi");
      System.out.println(maze);
      Square s = maze.getExit();
      System.out.println(maze.getNeighbors(s));
      MyStack stack = new MyStack();
      System.out.println(stack);
      stack.clear();
      System.out.println(stack);
      
   }
}