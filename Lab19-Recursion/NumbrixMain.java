/**
 * NumbrixMain.java  05/08/11
 *
 * @author - Robert Glen Martin
 * @author - School for the Talented and Gifted
 * @author - Dallas ISD
 *
 * Solves Numbrix puzzles
 * http://www.parade.com/numbrix
 */

import java.io.FileNotFoundException;

public class NumbrixMain
{
	/**
	 * Constructs a Numbrix object and uses it to solve a Numbrix puzzle.
	 * @throws FileNotFoundException when fileName file does not exist.
	 */
   public static void main(String[] args) throws FileNotFoundException
   {
     Numbrix puzzle = new Numbrix("puzzle1.txt");
        System.out.println("Puzzle One:");
        System.out.println(puzzle);
        System.out.println("Solution:");
        puzzle.solve();

        puzzle = new Numbrix("puzzle2.txt");
        System.out.println("\n\nPuzzle Two:");
        System.out.println(puzzle);
        System.out.println("Solution:");   
        puzzle.solve();
   }
}
