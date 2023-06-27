
//Name: Vishruth M
import java.util.*;
import java.awt.Color;
public class Circle
{
    private int x;
    private int y;
    private int dx, dy;
    private int radius;
    private Color color;

    public Circle(int xPos, int yPos, int rad, Color col)
    {
        x = xPos;
        y = yPos;
        radius = rad;
        color = col;
    }
    
    public Circle(int xPos, int yPos, int rad, Color col, int dX, int dY)
    {
        x = xPos;
        y = yPos;
        radius = rad;
        color = col;
        dx = dX;
        dy = dY;
    }
    
    public void setVeloctiy(int dX, int dY)
    {
        dx = dX;
        dy = dY;
    }
    
    public void update(int size)
    {
        x += dx;
        y += dy;
        bounce(size);
    }
    
    public boolean overlaps(Circle other)
    {
        if (Math.sqrt(Math.pow((other.x - x), 2) + Math.pow((other.y - y), 2)) < other.radius + radius)
        {
            return true;
        }
        return false;
    }
    
    public boolean overlaps(int oX, int oY)
    {
        if (Math.sqrt(Math.pow((oX - x), 2) + Math.pow((oY - y), 2)) < 1 + radius)
        {
            return true;
        }
        return false;
    }
    
    public void bounce(int size)
    {
        if (x - radius < 0 || x + radius > size)
            dx *= -1;
        if (y - radius < 0 || y + radius > size)
            dy *= -1;
    }
    
    public void draw()
    {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x, y, radius);
    }
}
