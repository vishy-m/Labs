/** 
 * DON'T CHANGE ANYTHING IN THIS CLASS 
*/ 

//Author: Mr. McCoy

public abstract class Player
{
    private Head2HeadMatch match;    
    
    public void enterGame(Head2HeadMatch match) 
    {
        this.match = match;
    }
    
    public abstract String getName();

    public Head2HeadMatch getMatch() 
    {
        return match;
    } 
    
    public abstract int getAdvertisingAmount();
    
}
