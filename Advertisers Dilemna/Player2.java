/** 
 * DON'T CHANGE ANYTHING IN THIS CLASS 
*/

//Name: Mr. McCoy

import java.util.*;

public class Player2 extends Player
{
    private final String name = "McRando Z.";  //You MUST use first name, last initial.  

    public String getName() 
    {
        return name;
    }
    
    public int getAdvertisingAmount()
    {        
        return (int)(Math.random()*11);  //Always advertises a random amount from 0 to 10
    }
}
