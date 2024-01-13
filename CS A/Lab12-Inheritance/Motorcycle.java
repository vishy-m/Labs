import java.util.*;
public class Motorcycle extends Vehicle
{
    private Boolean hasSideCar;
    
    public Motorcycle()
    {
        super();
        hasSideCar = false;
    }
    public Motorcycle(String t, int y, double p, boolean sc)
    {
        super(t,y,p);
        hasSideCar = sc;
    }
    public boolean hasSideCar(){return hasSideCar;}
    public String getInfo()
    {
        String sideCar = "without side car";
        if (hasSideCar)
            sideCar = "with side car";
        return super.getInfo() + " " + sideCar + ", $" + super.getPrice();
    }
}
