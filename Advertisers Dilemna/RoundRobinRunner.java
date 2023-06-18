// Author: Mr. McCoy

/**
 * If you create multiple algorithms, 
 * add them to the player list below.
 */

import java.util.*;

public class RoundRobinRunner
{
    private ArrayList<Player> playerList;
    private ArrayList<Integer> scoreList;

    public RoundRobinRunner() {
        buildPlayerList();
        runTournament();
        displayFinalResults();
    }

    private void buildPlayerList() {
        playerList = new ArrayList<Player>();
        scoreList = new ArrayList<Integer>();
        
        //Dummy Algorithms
        playerList.add(new Player1());
        playerList.add(new Player2());
        playerList.add(new Player3());
        playerList.add(new Player4());
        
        //Add your algorithms here.
        playerList.add(new Player2A480()); 
        
        
      

        for (Player p : playerList)
            scoreList.add(0);
    }

    public void runTournament() {        
        for (int a = 0; a < playerList.size(); a++)
            for (int b = a+1; b < playerList.size(); b++) {
                Player playerA = playerList.get(a);
                Player playerB = playerList.get(b);                 

                Head2HeadMatch match = new Head2HeadMatch(playerA, playerB);
                int[] results = match.runYear(false);  //true makes it print the details to the terminal window
                scoreList.set(a, scoreList.get(a)+results[0]);  //update ongoing score for playerA
                scoreList.set(b, scoreList.get(b)+results[1]);  //update ongoing score for playerB

                String aName = playerA.getName();
                String bName = playerB.getName();
                if (aName.length() > 15) aName = aName.substring(0, 15);
                if (bName.length() > 15) bName = bName.substring(0, 15);

                String resultString = String.format("%-15s Results of match ($): %+3d %n",aName,results[0]);
                resultString += String.format("%-15s Results of match ($): %+3d %n",bName,results[1]);
                System.out.println(resultString);
            }
    }

    public void displayFinalResults() {
        for (int i = 0; i < playerList.size(); i++) {
            String name = playerList.get(i).getName();
            if (name.length() > 15) name = name.substring(0, 15);
            System.out.printf("%-15s  $  %5d%n", name, scoreList.get(i));
        }

    }

    public static void main(String[] args) {
        new RoundRobinRunner();                
    }
}
