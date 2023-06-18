
//Name: 

public class Truck extends Vehicle
{
    private int towing;
    
    public Truck()
    {
        super();
        towing = 0;
    }
    public Truck(String t, int y, double p, int tow)
    {
        super(t,y,p);
        towing = tow;
    }
    
    public boolean canTowBoat()
    {
        if (towing >= 2000)
            return true;
        return false;
    }
    
    public String getInfo()
    {
        return super.getInfo() + ", " + towing + " lbs. towing, $" + super.getPrice();
    }
}
