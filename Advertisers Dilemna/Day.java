/** 
 * DON'T CHANGE ANYTHING IN THIS CLASS 
*/

//Name: Mr. McCoy

public class Day
{    
    private Player playerA, playerB;
    private int playerAExpense, playerBExpense;
    
    public Day(Player a, int pae, Player b, int pbe) {
        playerA = a;
        playerB = b;
        playerAExpense = pae;
        playerBExpense = pbe;     
    }
    
    public int getMyExpense(Player p) {
        if (p == playerA) return playerAExpense;
        else return playerBExpense;        
    }     
    
    public int getOppExpense(Player p) {
        if (p == playerA) return playerBExpense;
        else return playerAExpense;        
    }
    
    public Player getPlayerA() {return playerA;}
    public Player getPlayerB() {return playerB;}
}
