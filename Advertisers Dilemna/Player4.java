/** 
 * DON'T CHANGE ANYTHING IN THIS CLASS 
*/

//Name: Mr. McCoy

import java.util.*;

public class Player4 extends Player
{
    private final String name = "McHustle R.";  //You MUST use first name, last initial.  

    public String getName() 
    {
        return name;
    }

    public int getAdvertisingAmount()
    {
        ArrayList<Day> dayHistory = getMatch().getHistory(); //get the list of previous Day objects
        int day = dayHistory.size();
        if (day == 0) 
            return 1; //bids zero on the first day
        return dayHistory.get(day-1).getOppExpense(this)+1; //bids 1 more than what my opponent previously bid
    }
}
