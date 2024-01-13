   /*****************************************************************************
 *  Compilation:  javac GuitarHeroLite.java
 *  Execution:    java  GuitarHeroLite
 *  Dependencies: StdAudio.java StdDraw.java GuitarString.java
 *
 *  Plays two guitar strings (concert A and concert C) when the user
 *  types the lowercase letters 'a' and 'c', respectively in the 
 *  standard drawing window.
 *
 ****************************************************************************/
import java.util.*;
public class GuitarHero { 

   public static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

   public static void main(String[] args) {
   
      // Create two guitar strings, for concert A and C
      GuitarString[] strings = new GuitarString[37];
      for (int i = 0; i < strings.length; i++)
      {
         double N = Math.ceil(400 * Math.pow(1.05956, i - 24));
         strings[i] = new GuitarString((int) N);
      }
   
      // the main input loop
      while (true) {
      
         // check if the user has typed a key, and, if so, process it
         if (StdDraw.hasNextKeyTyped()) {
         
            char key = StdDraw.nextKeyTyped();
            
            for (int i = 0; i < strings.length; i++)
            {
               if (key == keyboard.charAt(i))
               {
                  strings[i].pluck();
               }
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