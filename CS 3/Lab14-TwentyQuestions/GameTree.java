import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.nio.*;

/**
 * A model for the game of 20 questions
 *
 * @author Rick Mercer
 */
public class GameTree
{
   public Node<String> root;
   public Node<String> currentQuestion;
   public Node<String> currentNode;
   public static String saveFilePath;
   public static int saveNum = 0;
   public String fileName;
	/**
	 * Constructor needed to create the game.
	 *
	 * @param fileName
	 *          this is the name of the file we need to import the game questions
	 *          and answers from.
	 */
   public GameTree(String fileName)
   {
   	//TODO
      this.fileName = fileName;
      File file = new File(fileName);
      Scanner input = null;
      
      try 
      {
         input = new Scanner(file);
      }
      catch (Exception e)
      {
         try
         {
            file = new File("saves\\" + fileName);
            input = new Scanner(file);
         }
         catch (Exception exc)
         {
            System.out.println("file messed up");
            return; 
         }
      
      }
      
      root = new Node<String>();
      makeTree(input, root);
      currentQuestion = root;
      currentNode = root;
      
      
      String path = file.getAbsolutePath();
      
      if (!path.contains("saves"))
      {
         int textFileLen = fileName.length();
         path = path.substring(0, path.length() - textFileLen);
         path += "saves";
         new File(path).mkdir();
         saveFilePath = path;
      }
      else
      {
         int indexSave = path.indexOf("saves");
         indexSave += 5;
         saveFilePath = path.substring(0, indexSave);
      }
      
      
   }
   
   public void makeTree(Scanner input, Node current)
   {
      if (!input.hasNextLine()) 
         return;
   
      if (current == null)
      {
         return;
      }
      
      String line = input.nextLine().trim();
      
      current.val = line;
      
      if (!line.contains("?"))
      {
         return;
      }
      else
      {
         current.left = new Node<String>();
         current.right = new Node<String>();
         
         makeTree(input, current.left);
         makeTree(input, current.right);
      }
      
   }

	/*
	 * Add a new question and answer to the currentNode. If the current node has
	 * the answer chicken, theGame.add("Does it swim?", "goose"); should change
	 * that node like this:
	 */
	// -----------Feathers?-----------------Feathers?------
	// -------------/----\------------------/-------\------
	// ------- chicken  horse-----Does it swim?-----horse--
	// -----------------------------/------\---------------
	// --------------------------goose--chicken-----------
	/**
	 * @param newQ
	 *          The question to add where the old answer was.
	 * @param newA
	 *          The new Yes answer for the new question.
	 */
   public void add(String newQ, String newA)
   {
      boolean wentRight = currentQuestion.right.val.equals(currentNode.val);
      boolean wentLeft = currentQuestion.left.val.equals(currentNode.val);
      
      String savedAnswer = (String) currentQuestion.left.val;
      Node<String> newNode = currentQuestion.left;
      if (wentLeft)
      {
         currentQuestion.left = new Node<String>(newQ);
      }
      else
      {
         savedAnswer = (String) currentQuestion.right.val;
         currentQuestion.right = new Node<String>(newQ);
         newNode = currentQuestion.right;
      }
      
      newNode.left = new Node<String>(newA);
      newNode.right = new Node<String>(savedAnswer);
   }
   
  
   
   
	/**
	 * True if getCurrent() returns an answer rather than a question.
	 *
	 * @return False if the current node is an internal node rather than an answer
	 *         at a leaf.
	 */
   public boolean foundAnswer()
   {
      if (currentNode.left == null) 
         return true;
      return false; //replace
   }

	/**
	 * Return the data for the current node, which could be a question or an
	 * answer.  Current will change based on the users progress through the game.
	 *
	 * @return The current question or answer.
	 */
   public String getCurrent()
   {
   	//TODO
      if (foundAnswer()) 
         return currentNode.val;
      return currentQuestion.val; //replace
   }

	/**
	 * Ask the game to update the current node by going left for Choice.yes or
	 * right for Choice.no Example code: theGame.playerSelected(Choice.Yes);
	 *
	 * @param yesOrNo
	 */
   public void playerSelected(Choice yesOrNo)
   {
      if (yesOrNo == Choice.Yes)
      {
         currentNode = currentQuestion.left;
         if (!foundAnswer())
         {
            currentQuestion = currentQuestion.left;
         }
         return;
      }
      currentNode = currentQuestion.right;
      if (!foundAnswer())
      {
         currentQuestion = currentQuestion.right;
      }
   }

	/**
	 * Begin a game at the root of the tree. getCurrent should return the question
	 * at the root of this GameTree.
	 */
   public void reStart()
   {
      currentNode = root;
      currentQuestion = root;
   }

   @Override
   public String toString()
   {
      return toString(root, 1);
   }
   
   public String toString(Node current, int depth)
   {
      if (current == null)
      {
         return "";
      }
      
      String currentStr = "";
      for (int i = 0; i < depth - 1; i++)
         currentStr += "- ";
      currentStr += (String) current.val + "\n";
      
      return toString(current.right, depth + 1) + currentStr + toString(current.left, depth + 1);
   }
   
   public String getCurrentGameNode()
   {
      return currentNode.val;
   }
   
	/**
	 * Overwrite the old file for this gameTree with the current state that may
	 * have new questions added since the game started.
	 *
	 */
   public void saveGame()
   {
      //animals.txt
      //animals_save_0.txt
      //String actualFileName = fileName.substring(0, fileName.length() - 4);
      String outputFileName = fileName;
      // if (actualFileName.contains("save"))
      // {
         // String strNum = actualFileName.substring(actualFileName.length() - 2, actualFileName.length());
         // int num = Integer.parseInt(strNum) + 1;
         // actualFileName = actualFileName.substring(0, actualFileName.length() - 2);
         // actualFileName += num;
      // }
      // else
      // {
         // String saveNumStr = "" + saveNum;
         // if (saveNum < 10)
         // {
            // saveNumStr = "0" + saveNum;
         // }
         // actualFileName += "_save_" + saveNumStr;
      // }
   //    
      // actualFileName += ".txt";
      // outputFileName = saveFilePath + "\\" + actualFileName;
      
      PrintWriter diskFile = null;
      //System.out.println(outputFileName);
      
      try 
      {
         diskFile = new PrintWriter(new File(outputFileName));
         saveNum++;
      }
      catch (Exception e)
      {
         System.out.println("Could not create file: " + outputFileName);
      }
      
      saveGame(root, diskFile);
      diskFile.close();
   }
   
   public void saveGame(Node current, PrintWriter diskFile)
   {
      if (current == null)
      {
         return;
      }
      diskFile.println(current.val);
      saveGame(current.left, diskFile);
      saveGame(current.right, diskFile);
   }
   
   
   public static void main(String[] args)
   {
      GameTree tree = new GameTree("zelda.txt");
      System.out.println(tree);
      
   }
   
   
   private class Node<T>
   {
      private T val;
      private Node right;
      private Node left;
      
      public Node()
      {
         val = null;
         right = null;
         left = null;
      }
      public Node(T value)
      {
         val = value;
         right = left = null;
      }
   }
   
}
