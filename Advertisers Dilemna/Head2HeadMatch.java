/** 
 * DON'T CHANGE ANYTHING IN THIS CLASS 
*/

//Name: Mr. McCoy

import java.util.*;
import static java.lang.System.*;

public class Head2HeadMatch
{
    private ArrayList<Day> dayHistory; 
    private Player playerA, playerB;
    private int playerAProfit = 0, playerBProfit = 0;
    private boolean showDetails;

    public Head2HeadMatch(Player playerA, Player playerB) 
    {        
        dayHistory = new ArrayList<Day>();
        this.playerA = playerA;
        this.playerB = playerB;
        playerA.enterGame(this);
        playerB.enterGame(this);
    }

    public ArrayList<Day> getHistory() {
        ArrayList<Day> historyClone = (ArrayList<Day>)(dayHistory.clone());
        return historyClone;
    }

    public int[] runYear(boolean showDetails) 
    {
        String aName = playerA.getName();
        String bName = playerB.getName();
        if (aName.length() > 15) aName = aName.substring(0, 15);
        if (bName.length() > 15) bName = bName.substring(0, 15);

        for (int day = 0; day < 365; day++) 
        {
            //Allow each player to advertise.
            int aExpense = Math.max(0, Math.min(10, playerA.getAdvertisingAmount())); //the max/min forces number into bounds
            int bExpense = Math.max(0, Math.min(10, playerB.getAdvertisingAmount())); //the max/min forces number into bounds
            String results = "";

            //Determine who got the customers
            if (aExpense == bExpense) //split customers
            {
                playerAProfit += 5 - aExpense;
                playerBProfit += 5 - bExpense;

                results += String.format("Day %3d   %-15s Attracts  5 customers after spending $%2d (%+3d)     Total ($): %,5d%n",day+1,aName,aExpense,5-aExpense,playerAProfit);
                results += String.format("          %-15s Attracts  5 customers after spending $%2d (%+3d)     Total ($): %,5d%n",bName,bExpense,5-bExpense,playerBProfit);
            }

            else if (aExpense > bExpense) //Player A won the ad battle today
            {
                playerAProfit += 10 - aExpense;
                playerBProfit -= bExpense;

                results += String.format("Day %3d   %-15s Attracts 10 customers after spending $%2d (%+3d)     Total ($): %,5d      All sales go to %s%n",day+1,aName,aExpense,10-aExpense,playerAProfit,aName);
                results += String.format("          %-15s Attracts  0 customers after spending $%2d (%+3d)     Total ($): %,5d%n",bName,bExpense,-bExpense,playerBProfit);
            }
            else //Player B won the ad battle today
            {
                playerBProfit += 10 - bExpense;
                playerAProfit -= aExpense;

                results += String.format("Day %3d   %-15s Attracts  0 customers after spending $%2d (%+3d)     Total ($): %,5d%n",day+1,aName,aExpense,-aExpense,playerAProfit);
                results += String.format("          %-15s Attracts 10 customers after spending $%2d (%+3d)     Total ($): %,5d      All sales go to %s%n",bName,bExpense,10-bExpense,playerBProfit,bName);

            }

            if (showDetails) 
                out.println(results);

            //Save data to dayHistory  (players might need this data for future decisions)
            dayHistory.add(new Day(playerA, aExpense, playerB, bExpense));
        }      
        
        //return the results of the year-long match
        return new int[] { playerAProfit, playerBProfit };        
    }
}
