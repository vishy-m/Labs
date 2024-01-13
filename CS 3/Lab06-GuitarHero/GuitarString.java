import java.util.*;
public class GuitarString 
{
   private static final double SAMPLING_RATE = 44100;
   private static final double DECAY_FACTOR = .994;
   private RingBuffer buffer; // ring buffer
   private int time;
   private double N;
   
   // YOUR OTHER INSTANCE VARIABLES HERE

   /** create a guitar string of the given frequency */
   public GuitarString(double frequency) {
      
      N = Math.ceil(SAMPLING_RATE / frequency);
      buffer = new RingBuffer((int)N);
      for (int i = 0; i < (int)N; i++)
      {
         buffer.enqueue(0);
      }
      time = 0;
   }

   /** create a guitar string with size & initial values given by the array */
   public GuitarString(double[] init) {
      
      buffer = new RingBuffer(init.length);
      
      for (int i = 0; i < init.length; i++)
      {
         buffer.enqueue(init[i]);
      }
      time = 0;
   }

   /** pluck the guitar string by replacing the buffer with white noise */
   public void pluck() {
      
      int size = buffer.size();
      //System.out.println(size);
      for (int i = 0; i < size; i++)
      {
         buffer.dequeue();
         double randomNum = (Math.random())  - 0.5;
         buffer.enqueue(randomNum);
         //System.out.println(buffer);
      }
      
   }

   /** advance the simulation one time step */
   public void tic() {
      
      if (!buffer.isEmpty())
      {
         double num1 = buffer.dequeue();
         double num2 = buffer.peek();
         double average = ((num1 + num2) / 2.0) * DECAY_FACTOR;
         
         buffer.enqueue(average);
         time++;
      }
   }

   /** return the current sample */
   public double sample() {
      // YOUR CODE HERE
      if (!buffer.isEmpty()) 
         return buffer.peek();
      return 0; //REPLACE
   }

   /** return number of times tic was called */
   public int time() {
      // YOUR CODE HERE
   
      return time; //REPLACE
   }

   public static void main(String[] args) {
      int N = 25;
      double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
      GuitarString testString = new GuitarString(samples);
      for (int i = 0; i < N; i++) {
         int t = testString.time();
         double sample = testString.sample();
         System.out.printf("%6d %8.4f\n", t, sample);
         testString.tic();
      }
      /*
       * Your program should produce the following output when the main() 
       * method runs (DON'T WORRY ABOUT VERY MINOR DIFFERENCES, E.G. OFF BY 0.001):
              0   0.2000
   		    1   0.4000
   		    2   0.5000
   		    3   0.3000
   		    4  -0.2000
   		    5   0.4000
   		    6   0.3000
   		    7   0.0000
   		    8  -0.1000
   		    9  -0.3000
   		   10   0.2988
   		   11   0.4482
   		   12   0.3984
   		   13   0.0498
   		   14   0.0996
   		   15   0.3486
   		   16   0.1494
   		   17  -0.0498
   		   18  -0.1992
   		   19  -0.0006
   		   20   0.3720
   		   21   0.4216
   		   22   0.2232
   		   23   0.0744
   		   24   0.2232
       */
   }
}
