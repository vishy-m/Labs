import java.awt.Color;

public class RecursiveDrawings {

   public static final int CANVAS_SIZE = 1000;
   
   private static final double RAD_DECAY_FACTOR = 3.2;
   private static final double SIERPINSKI_END_SIZE = 1;
   private static final double SNOWFLAKE_NUM_SIDES = 6;
   private static final double BLIZZARD_MAX_RAD = 75;
   private static final double BLIZZARD_MIN_RAD = 20;
   

   //WRITE YOUR RECURSIVE METHODS HERE
   
   public static void drawSnowFlake()
   {
   
      double rad = (double)CANVAS_SIZE / 3;
      int x1 = CANVAS_SIZE / 2, y1 = x1;
      
      
      StdDraw.setPenColor(StdDraw.BLUE);
      //snowFlake(x1, y1,rad, 0, 5);
      
      //blizzard(15, 3);
      
      StdDraw.setPenColor(StdDraw.RED);
      drawSierpinski(0, 0, CANVAS_SIZE / 2);
      
   }
   
   public static void snowFlake(int x1, int y1, double radius, int numSides, int depth)
   { 
      double newX = x1, newY = y1;
      
      if (numSides < SNOWFLAKE_NUM_SIDES)
      {   
         int x2 = 0, y2 = 0;   
         double angle = numSides * ((2 * Math.PI) / SNOWFLAKE_NUM_SIDES);
         double xLen = radius * Math.cos(angle) + x1;
         double yLen = radius * Math.sin(angle) + y1;
         newX = xLen;
         newY = yLen;
         
         StdDraw.line(x1, y1, xLen, yLen);
         snowFlake(x1, y1, radius, numSides + 1, depth);
      
      }
      if (depth > 0)
      {
         if (numSides < SNOWFLAKE_NUM_SIDES)
            snowFlake((int)newX, (int)newY, radius / RAD_DECAY_FACTOR, 0, depth - 1);
      }
      
   }
   
   public static void blizzard(int numFlakes, int depth)
   {
      if (numFlakes > 0)
      {
         double x = Math.random() * (double)CANVAS_SIZE;
         double y = Math.random() * (double)CANVAS_SIZE;
         
         double rad = (Math.random() * BLIZZARD_MIN_RAD) + (BLIZZARD_MAX_RAD - BLIZZARD_MIN_RAD);
         
         StdDraw.setPenColor(makeColor(200));
         snowFlake((int)x, (int)y, rad, 0, depth);
         
         blizzard(numFlakes - 1, depth);
         
      }
   }
   
   public static Color makeColor(int brightness)
   {
      int r = 0; 
      int g = 0;
      int b = 0;
      
      do
      {
         r = (int)(Math.random() * 255.0);
         g = (int)(Math.random() * 255.0);
         b = (int)(Math.random() * 255.0);
      }
      while (r < brightness && g < brightness && b < brightness);
      
      return new Color(r, g, b);
   }
   
   public static void drawSierpinski(int originX, int originY, int size)
   {
   
      if (size > SIERPINSKI_END_SIZE)
      {
         int[] endLoc = makeTriangle(originX, originY, size);
         
         drawSierpinski(originX, originY, size / 2);
         drawSierpinski(originX, endLoc[1], size / 2);
         drawSierpinski(endLoc[0], originY, size / 2);
      }
      
      
   }
   
   public static int[] makeTriangle(int x, int y, int size)
   {
      int endX = x + size;
      int endY = y + size;
      
      StdDraw.line(endX, y, endX, endY);
      StdDraw.line(x, endY, endX, endY);
      StdDraw.line(endX, y, x, endY);
      
      int[] endLocation = {endX, endY};
      return endLocation;
   }
     

   public static void main ( String[] args )
   {
      //Setting up drawing canvas
      StdDraw.setCanvasSize(CANVAS_SIZE, CANVAS_SIZE); 
      StdDraw.setXscale(0, CANVAS_SIZE);        //Point (0, 0) is located in the top left corner of the canvas
      StdDraw.setYscale(CANVAS_SIZE, 0);           
      
      /*
        Double buffering allows for the entire image to be generated in a second buffer, which is only displayed when
        the entire image is done.  You can uncomment the line below to enable double buffer and your image will display
        faster.  (The completed image will pop in when 100% done instead of displaying each line as it is drawn.)
      */
      StdDraw.enableDoubleBuffering(); 
      
      //Call your snowflake method here
      StdDraw.setPenColor(StdDraw.BLUE);
      drawSnowFlake();
                  
      //Put your blizzard code here  (Create random snowflakes in a loop.)
      
      
      //Call your Sierpinski method here
      StdDraw.setPenColor(StdDraw.RED);
      
            
      //Display final image
      StdDraw.show(); //This has to be called last (if you are using double buffering)
   }
}
