import java.util.*;
import java.io.*;
public class GuitarHeroAutomated
{
   private static Queue<Key> keys;
   
   public static void loadSong(String filePath)
   {
      keys = new LinkedList<Key>();
      File file = new File(filePath);
      Scanner input = null;
      try 
      {
         input = new Scanner(file);
      }
      catch (IOException e) { System.out.print(e); }
        
      while (input.hasNextLine())
      {
         String info = input.nextLine();
         //System.out.println(info);
         String[] infos = info.split(" ");
         String k = infos[0];
         int t = Integer.parseInt(infos[1]);
         Key key = new Key(k, t);
         keys.offer(key);
      }
   
   }
   public static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

   public static void main(String[] args) {
   
      // Create two guitar strings, for concert A and C
      loadSong("song.txt");
      GuitarString[] strings = new GuitarString[37];
      for (int i = 0; i < strings.length; i++)
      {
         double N = Math.ceil(400 * Math.pow(1.05956, i - 24));
         strings[i] = new GuitarString((int) N);
      }
   
      // the main input loop
      int index = 0;
      int timer = 0;
      Key currentKey = keys.poll();
      int numEnd = 0;
      while (true) {
      
         // check if the user has typed a key, and, if so, process it
         
         if (keys.isEmpty() && timer == 0)
         {
            if (numEnd == 0) numEnd++;
            else 
               break;
         }
         
         if (timer <= currentKey.getTime())
         {
            if (timer == 0)
            {
               strings[keyboard.indexOf(currentKey.getKey())].pluck();
               index++;
            }
            timer++;
         }
         else 
         {
            timer = 0;
            if (!keys.isEmpty())
            {
               currentKey = keys.poll();
            }
         }
         
         
         double sample = 0.0;
         for (int i = 0; i < strings.length; i++)
         {
            sample += strings[i].sample();
         }
      
         StdAudio.play(sample);
      
         for (int i = 0; i < strings.length; i++)
         {
            strings[i].tic();
         }
      }
   }

}