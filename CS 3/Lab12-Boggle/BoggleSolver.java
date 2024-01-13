import java.util.*;
import java.io.*;
public class BoggleSolver
{

   private HashSet<String> dictionary;
   private HashSet<String> possibleWords;
   
	// Initializes the data structure using the given array of strings as the dictionary.
	// (You can assume each word in the dictionary contains only the uppercase letters A - Z.)
   public BoggleSolver(String dictionaryName)
   {
   
      dictionary = new HashSet<String>();
      possibleWords = new HashSet<String>();
   
      File file = new File(dictionaryName);
      Scanner input = null;
      try 
      {
         input = new Scanner(file);
      }
      catch (IOException e) { System.out.print(e); }
        
      while (input.hasNextLine())
      {
         String word = input.nextLine();
         //System.out.println(word);
         dictionary.add(word);
      }
   
   	//TODO
   }

	// Returns the set of all valid words in the given Boggle board, as an Iterable object
   public Iterable<String> getAllValidWords(BoggleBoard board)
   {
   	//TODO
      possibleWords = new HashSet<String>();
      
      int rows = board.rows();
      int cols = board.cols();
      
      HashSet<String> visitedWords = new HashSet<String>();
      
      
      for (int r = 0; r < rows; r++)
      {
         for (int c = 0; c < cols; c++)
         {
            getWords("", r, c, board, visitedWords);
         }
      }
   
   
      
      return possibleWords;
   }
   
   public void getWords(String word, int r, int c, BoggleBoard board, HashSet<String> visitedCords)
   {
      boolean rowOutOfBounds = r < 0 || r >= board.rows();
      boolean cordOutOfBounds = c < 0 || c >= board.cols();
      
      if (rowOutOfBounds || cordOutOfBounds)
      {
         return;
      }
   
      String cord = "" + r + "" + c;
      if (visitedCords.contains(cord))
      {
         return;
      }
         
      HashSet<String> newSet = (HashSet)visitedCords.clone();
         
      newSet.add(cord);
      
      String letter = ("" + board.getLetter(r, c)).toUpperCase();
      if (letter.charAt(0) == 'Q')
         letter += "U";
      String newStr = word + letter;
      int size = newStr.length();
         
      if (size >= 3)
      {
         if (dictionary.contains(newStr))
         {
            possibleWords.add(newStr);
         }
      }
         
      for (int row = r - 1; row <= r + 1; row++)
      {
         for (int col = c - 1; col <= c + 1; col++)
         {
            getWords(newStr, row, col, board, newSet);
         }
      }
              
   }
   


	// Returns the score of the given word if it is in the dictionary, zero otherwise.
	// (You can assume the word contains only the uppercase letters A - Z.)
   public int scoreOf(String word)
   {
      int size = word.length();
         
      if (size > 7) 
         return 11;
      if (size == 7) 
         return 5;
      if (size == 6) 
         return 3;
      if (size == 5) 
         return 2;
         
      return 1;
   }

   public static void main(String[] args) {
      System.out.println("WORKING");
   
      final String PATH   = "./data/";
      BoggleBoard  board  = new BoggleBoard(PATH + "board-q.txt");
      BoggleSolver solver = new BoggleSolver(PATH + "dictionary-algs4.txt");
   
      int totalPoints = 0;
      for (String s : solver.getAllValidWords(board)) {
         System.out.println(s + ", points = " + solver.scoreOf(s));
         totalPoints += solver.scoreOf(s);
      }
   
      System.out.println("Score = " + totalPoints); //should print 84
   
   	//new BoggleGame(4, 4);
   }

}
