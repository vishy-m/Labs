
//Name: 

public class Player
{
    private String name;
    private int number;
    private int atBats;
    private int hits;
    
    public Player()
    {
        name = null;
        number = 0;
        atBats = 0;
        hits = 0;
    }
    public Player(String pName, int pNum)
    {
        name = pName;
        number = pNum;
    }
    public Player(String pName, int pNum, int atB, int pHit)
    {
        name = pName;
        number = pNum;
        atBats = atB;
        hits = pHit;
    }
    
    public String toString()
    {
        return "" + name + "\t#" + number + "\t average >>> " + this.getBattingAverageString();
    }
    
    public String getName()
    {
        return name;
    }
    public int getNumber()
    {
        return number;
    }
    public int getAtBats()
    {
        return atBats;
    }
    public int getHits()
    {
        return hits;
    }
    
    public double getBattingAverage()
    {
        return (double) hits / (double) atBats;
    }
    public String getBattingAverageString()
    {
        double average = (double) hits / (double) atBats;
        return "" + Math.round(average * 1000.0);
    }
}
