//Name: Vishruth M

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Shopping
{
   public static void main(String[] args)
   {
      //Complete all of the shopping lab here.
      ArrayList<String> items = new ArrayList<String>();
      Scanner console = new Scanner(System.in);
      String input = "";
      do
      {
          System.out.print("Add item to list (or 0 when done) >>> ");
          input = console.nextLine();
          if (input.equals("0"))
              break;
          else
              items.add(input);
      }
      while (! input.equals("0"));
      
      Collections.sort(items);
      
      System.out.println("\nShopping List:");
      System.out.println(items);
      
      if (items.size() >= 3)
          System.out.println("\nThird item: " + items.get(2));
      else
          System.out.println("\nNo third item");
      
      for (int i = 0;i < items.size(); i++)
      {
          if (items.get(i).length() > 10)
              items.set(i, "ramen noodles");
      }
      
      System.out.println("\nCheaper List:");
      System.out.println(items + "\n");
      
      boolean ramen = false;
      for (int i = 0;i < items.size(); i++)
      {
          if (items.get(i).contains("ramen"))
          {
              ramen = true;
              System.out.println("ramen found at index " + i);
          }  
      }
      if (! ramen)
        System.out.println("ramen not found");
   }
}
