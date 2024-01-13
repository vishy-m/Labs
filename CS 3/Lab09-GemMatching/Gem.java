import java.awt.Font;
import java.util.*;
import java.awt.*;

enum GemType {
   GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
}

public class Gem 
{	
   
   private GemType color;
   private int points;
   
   final GemType[] TYPES = {GemType.GREEN, GemType.BLUE, GemType.ORANGE};


   public Gem()
   {
      Random random = new Random();
      int randomNum = random.nextInt(TYPES.length);
      color = TYPES[randomNum];
      points = random.nextInt(11) * 5;
   }
    
   public Gem(GemType type, int points)
   {
      color = type;
      this.points = points;
   }
   
   public String toString()
   {
      return "" + color + " " + points;
   }
   
   public GemType getType() {
      return color;}
   
   public int getPoints() {
      return points;}
      
      
   public void draw(double x, double y)
   {
      StdDraw.picture(x, y, "gem_" + color.toString().toLowerCase() + ".png"); 
      Font shadow = new Font(Font.MONOSPACED, Font.BOLD, 18);
      StdDraw.setPenColor(Color.WHITE);
      StdDraw.text(x, y, "" + points); 
      Font light = new Font(Font.MONOSPACED, Font.BOLD, 17);
      StdDraw.setPenColor(Color.WHITE);
      StdDraw.text(x, y, "" + points); 
   }

	/** Tester main method */
   public static void main(String [] args)
   {
      final int maxGems = 16;
   		
   		// Create a gem of each type
      Gem green  = new Gem(GemType.GREEN, 10);
      Gem blue   = new Gem(GemType.BLUE, 20);
      Gem orange = new Gem(GemType.ORANGE, 30);
      System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());		
      System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
      System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
      green.draw(0.3, 0.7);
      blue.draw(0.5, 0.7);
      orange.draw(0.7, 0.7);
   		
   		// A row of random gems
      for (int i = 0; i < maxGems; i++)
      {
         Gem g = new Gem();
         g.draw(1.0 / maxGems * (i + 0.5), 0.5);
      }
   }
}
