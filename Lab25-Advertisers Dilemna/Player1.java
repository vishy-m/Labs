/** 
 * DON'T CHANGE ANYTHING IN THIS CLASS 
*/

//Name: Mr. McCoy

import java.util.*;

public class Player1 extends Player
{
    private final String name = "McJerk F.";  //You MUST use first name, last initial.  
    
    public String getName() 
    {
        return name;
    }
        
    public int getAdvertisingAmount()
    {       
        return 10;   //always spends maximum budget (probably not a good strategy)      
    }
}
