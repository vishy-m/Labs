
//Name: 

public class Team
{
    private Player[] players;
    
    public Team()
    {
        players = new Player[12];
    }
    public Team(int numPlayers)
    {
        players = new Player[numPlayers];
    }
    public Team(Player[] p)
    {
        players = p;
    }
    
    public void printTeamStats()
    {
        for ( int i = 0; i < players.length; i++)
        {
            System.out.println(players[i]);
        }
    }
    public Player returnPlayer(int index)
    {
        return players[index];
    }
    public int returnNumPlayers()
    {
        return players.length;
    }
    public void setPlayer(Player p, int index)
    {
        players[index] = p;
    }
}
