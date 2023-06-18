
//Name: 

public class Car extends Vehicle
{
    private double mpg;
    
    public Car()
    {
        super();
        mpg = 0;
    }
    public Car(String t, int y, double p, double milespg)
    {
        super(t,y,p);
        mpg = milespg;
    }
    
    public boolean greatMPG()
    {
        if (mpg >= 36)
            return true;
        return false;
    }
    
    public String getInfo()
    {
        return super.getInfo() + ", " + mpg + " mpg, $" + super.getPrice();
    }
}
