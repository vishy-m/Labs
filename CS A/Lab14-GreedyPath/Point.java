import java.util.*;
public class Point 
{
    private double  x, y;
    private boolean visited;
    
    public Point(double _x, double _y)
    {
        x = _x;
        y = _y;
        visited = false;
    }
    
    /** getters and setters*/
    public double getX(){return x;}
    public double getY(){return y;}
    public void setX(double _x){x = _x;}
    public void setY(double _x){y = _x;}
    public boolean getVisited(){return visited;}
    public void setVisited(boolean b){visited = b;}
    
    /** get the Euclidean distance between two points */
    public double getDistance(Point other)
    {
        //TODO
        double xDiff = Math.abs(other.x - x);
        double yDiff = Math.abs(other.y - y);
        double hyp = Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
        return hyp; //replace
    }
    
    @Override
    public String toString()
    {
        //TODO
        return "(" + x + ", " + y + ")";
    }
    
    public boolean equals(Object o)
    {
        Point other = (Point)o;
        return this.x == other.x && this.y == other.y;
    }
}
