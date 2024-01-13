import java.util.*;
import java.io.*;

public class WordLadder
{
   private static HashSet<String> dictionary = new HashSet<String>();
   private String startWord;
   private String endWord; 
   
   public WordLadder()
   {
      
   }
   
   public void setWords(String sW, String eW)
   {
      startWord = sW;
      endWord = eW;
      initializeDictionary();
   }
   
   public Stack<String> solve()
   {
      if (!dictionary.contains(startWord.toUpperCase())) 
         return null;
      Queue<Stack> wordLadder = new LinkedList<Stack>();
      HashSet<String> usedWords = new HashSet<String>();;
   
      usedWords.add(startWord);
   
      Stack<String> words = new Stack<String>();
      words.push(startWord);
      wordLadder.offer(words);
      while (!wordLadder.isEmpty())
      {
         Stack<String> currentStack = wordLadder.peek();
         String currentWord = currentStack.peek();
         if (currentWord.equals(endWord)) 
            return currentStack;
         for (int i = 0; i < currentWord.length(); i++)
         {
            char[] chars = currentWord.toCharArray();
            char currentChar = chars[i];
            for (char c = 'a'; c <= 'z'; c++)
            {
               chars[i] = c;
               if (chars[i] == currentChar) 
                  continue;
               String newWord = charToString(chars); 
               if (!usedWords.contains(newWord) && dictionary.contains(newWord.toUpperCase()))
               {
                  Stack<String> newStack = copyStack(currentStack);
                  newStack.push(newWord);
                  
                  if (newWord.equals(endWord))
                  {
                     return copyStack(newStack);
                  }
                  wordLadder.offer(newStack);
                  usedWords.add(newWord);
               }
            }
         }
         wordLadder.poll();
      }
      
      return null;
      
   }
   
   public String toString()
   {
      Stack<String> ladder = solve();
      if (ladder == null) 
         return "No ladder found between " + startWord + " and " + endWord;
      return "Found a Ladder!!!!!!!! >>> " + ladder;
   }
   
   public static void initializeDictionary()
   {
      if (!dictionary.isEmpty()) 
         return;
      
      File file = new File("dictionary.txt");
      Scanner input = null;
      try 
      {
         input = new Scanner(file);
      }
      catch (IOException e) { System.out.print(e); }
        
      while (input.hasNextLine())
      {
         dictionary.add(input.nextLine());
      }
      
   }
   
   private String charToString(char[] chars)
   {
      String word = "";
      for (int i = 0; i < chars.length; i++)
      {
         word += chars[i];
      }
      return word;
   }
   
   private Stack<String> copyStack(Stack<String> stack)
   {
      Stack<String> nStack = new Stack<String>();
      while(!stack.isEmpty())
      {
         nStack.push(stack.pop());
      }
      Queue<String> list = new LinkedList<String>();
      while (!nStack.isEmpty())
      {
         list.offer(nStack.pop());
      }
      while (!list.isEmpty())
      {
         stack.push(list.peek());
         nStack.push(list.poll());
      }
      return nStack;
   }
   
   private void printLadderStatus(Queue<Stack> q)
   {
      int size = q.size();
      for (int i = 0; i < size; i++)
      {
         Stack<String> s = q.poll();
         System.out.println(s);
         q.offer(s);
      }
   }
}