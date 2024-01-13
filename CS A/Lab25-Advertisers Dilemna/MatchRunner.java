//Author: Mr. McCoy

/**
 * Use this class to see an analysis of a player 
 * completing a 365-day round against another player.
 */

public class MatchRunner
{
    public static void main(String[] args)
    {
        Player playerA = new Player2A480();  //Set to any player algorithm
        Player playerB = new Player4();  //set to any player algorithm
        Head2HeadMatch m = new Head2HeadMatch(playerA, playerB);
        m.runYear(true);  //true makes it print the details to the terminal window
    }
}
