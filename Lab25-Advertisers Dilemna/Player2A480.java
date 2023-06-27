//Name: 

import java.util.*;

public class Player2A480 extends Player
{
    private final String name = "BadStudent F.";  //You MUST use first name, last initial.  

    public String getName() 
    {
        return "Vishruth Meda";
    }

    /**
     * How much money are you going to spend on advertising today?
     * Minimum amount is 0.  Maximum amount is 10.
     * Trying to spend outside of that range will automatically adjust value.
     * 
     * 10 customers plan to spend $1 each day.
     * If you spend more on advertising than the other player, you get all 10 of the customers that day. 
     * If the other player spends more money than you on advertising, you get 0 customers that day.
     * If you and the other player spend the same on advertising, you split the 10 customers. (5 each)
     *  
     * Example:
     * If you spend $3 on ads and your opponent spends $2, you get all the customers.
     * You make $7 ($10 from your customers minus $3 in advertisting.)
     * Your opponent got -$2 for the day (spent money on ads, but got no customers.)
     * 
     * The game: Make as much money as possible over 365 days by outwitting your opponent.
     * A good algorithm might analyze what happened in previous rounds to learn the opponent's 
     * strategy and predict their behavior. 
     */
    public int getAdvertisingAmount()
    {
        //This method should return a number from 0 to 10, inclusive.  
        //It might be helpful to look back at the day history to see what has happened 
        //in the past.  This can help you determine the best amount to spend.

        ArrayList<Day> dayHistory = getMatch().getHistory(); //get the list of previous Day objects
        //How many days have passed?                  dayHistory.size()
        //How much did I spend on day 37?             dayHistory.get(37).getMyExpense(this)
        //How much did my opponent spend on day 37?   dayHistory.get(37).getOppExpense(this)
        int outcome = 0;

        HashMap<Integer, Integer> map = initializeMap(dayHistory);
        
        //ArrayList<Integer> values = new ArrayList<Integer>(oppExpenses.values());
        
        ArrayList<Integer> commonNums = new ArrayList<Integer>();
        int numCommons = 5;
        int sum = 0;
        int fCommonNum = getMostCommonNum(map);
        for (int i = 0; i < numCommons; i++)
        {
            int cNum = getMostCommonNum(map);
            map.remove(cNum);
            sum += cNum;
        }
        
        System.out.println("Sum: " + sum / numCommons);
        outcome = fCommonNum;
        if (outcome >= 10)
        {
            return 0;
        }
        if (dayHistory.size() <= 0) return 0;
        return outcome+=1;   

    }
    
    public HashMap<Integer, Integer> initializeMap(ArrayList<Day> dayHistory)
    {
        HashMap<Integer, Integer> oppExpenses = new HashMap<Integer, Integer>();
        for (int i = 0; i < dayHistory.size(); i++)
        {
            int oppE = dayHistory.get(i).getMyExpense(null);
            if (!oppExpenses.containsKey(oppE))
            {
                oppExpenses.put(oppE, 0);
            }
            else
            {
                oppExpenses.put(oppE, oppExpenses.get(oppE) + 1);
            }
        }
        return oppExpenses;
    }
    
    public int getMostCommonNum(HashMap<Integer, Integer> oppExpenses)
    {
        ArrayList<Integer> keys = getKeys(oppExpenses);
        
        int mostCommonNum = 0;
        if (keys.size() > 0)
        {
            int maxNum = oppExpenses.get(keys.get(0));
            mostCommonNum = keys.get(0);
            for (int i = 0; i < keys.size(); i++)
            {
                if (maxNum < oppExpenses.get(keys.get(i)))
                {
                    maxNum = oppExpenses.get(keys.get(i));
                    mostCommonNum = keys.get(i);
                }
            }
        }
        
        return mostCommonNum;
    }
    
    public ArrayList<Integer> getKeys(HashMap<Integer, Integer> map)
    {
        HashSet<Integer> oppKeys = new HashSet<Integer>(map.keySet());
        ArrayList<Integer> keys = new ArrayList<Integer>(oppKeys);
        return keys;
    }
    
    public ArrayList<Integer> getValues(HashMap<Integer, Integer> map)
    {
        return new ArrayList<Integer>(map.values());
    }
}
