
//Name: 

public class Lock
{
    private boolean locked;
    
    public Lock()
    {
        locked = true;
    }
    
    public void open(){locked = false;}
    
    public void close(){locked = true;}
    
    public boolean isLocked(){return locked;}
    
    public String toString()
    {
        if (locked)
            return "Lock is closed";
        return "Lock is open";
    }
}
