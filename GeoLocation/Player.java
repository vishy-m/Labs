
//Name: Vishruth M

public class Player
{
    private String name;
    private int number;
    
    public Player()
    {
        name = "Default";
        number = -1;
    }
    public Player(String n, int num)
    {
        name = n;
        number = num;
    }
    // Accessor
    
    
    //Modifier
    public String playerInfo()
    {
        return "Player: " + name + ", " + number;
    }
}
