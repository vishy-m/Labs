/**
 * Numbrix.java  6/11/2011
 *
 * @author - Jane Doe
 * @author - Period n
 * @author - Id nnnnnnn
 *
 * @author - I received help from ...
 *
 *
 * Solves Numbrix puzzles
 * http://www.parade.com/numbrix
 */

import java.util.*;
import java.io.*;

/**
 * Represents a Numbrix puzzle.
 */
public class Numbrix
{
    /** The puzzle data */
   private int[][] grid;

    /** Indicates whether numbers are used in the original puzzle
     *  If the number n is used, then used[n] is true;  Otherwise it's false */
   private boolean[] used;


    /**
     * Constructs a Numbrix object.
     * @param fileName the name of the file containing the puzzle data.
     * @throws FileNotFoundException when fileName file does not exist.
     */
   public Numbrix(String fileName) throws FileNotFoundException
   {
       Scanner input = new Scanner(new File(fileName));
       
       int rows = input.nextInt();
       int columns = input.nextInt();
       grid = new int[rows][columns];
       used = new boolean[rows * columns + 1];
       
       for (int r = 0, i = 0; r < rows; r++)
       {
           for (int c = 0; c < columns; c++, i++)
           {
               int num = input.nextInt();
               grid[r][c] = num;
               if (num != 0)    used[i] = true;
               else used[i] = false;
           }
       }
   }

    /**
     * Finds all solutions to the Numbrix stored in grid by
     * calling recursiveSolve for every possible cell in grid that
     * originally contains a 0 or a 1.  Each of these calls should
     * attempt to solve the puzzle beginning with the number 1.
     */
   public void solve()
   {
       for (int r = 0; r < grid.length; r++)
       {
           for (int c = 0; c < grid[r].length; c++)
           {
               recursiveSolve(r, c, 1);
               //System.out.println("R: " + r + "\tC: " + c);
           }
       }
   }

    /**
     * Attempts to solve the Numbrix by placing n in grid[r][c]
     * and then makeing recursive calls (up, down, left, and right) to
     * place n+1 and higher numbers.
     * @param r the row of the cell in which to place n.
     * @param c the column of the cell in which to place n.
     * @param n the number to place in grid[r][c].
     */
   private void recursiveSolve(int r, int c, int n)
   {
       //System.out.println("R: " + r + "\tC: " + c + "\tN: " + n);
       if (r < 0 || r >= grid.length || c < 0 || c > grid[1].length) grid[r][c] = n;
       boolean hasZero = grid[r][c] == 0;
       if (!hasZero && grid[r][c] != n) return 
   }

    /**
     * Returns a String which represents the puzzle.
     * @return the puzzle numbers with a tab after each number in a row
     *         and a new line character after each row.
     *         '-' characters should replace 0s in the output.
     */
   public String toString()
   {
      String result = "";
      for (int r = 0, i = 0; r < grid.length; r++)
      {
          for (int c = 0; c < grid[r].length; c++, i++)
          {
              if (used[i])  result += grid[r][c] + "\t";
              else  result += "-\t";
          }
          result += "\n";
      }
      return result;
   }
}