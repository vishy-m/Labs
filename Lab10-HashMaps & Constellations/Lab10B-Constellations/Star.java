
//Name: 

public class Star
{
    private double x, y;
    private double magnitude;
    private String name;
    
    public Star(double xc, double yc, double m, String n)
    {
        x = xc;
        y = yc;
        magnitude = m;
        name = n;
    }
    
    public String toString()
    {
        return "x: " + x + " y: " + y + " magnitude: " + magnitude + " name: " + name;
        //return x + " " + y;
    }
    
    public double getX() {return x;}
    public double getY() {return y;}
    public double getMag() {return magnitude;}
}
