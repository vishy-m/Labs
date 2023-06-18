import java.awt.*;
import javax.swing.*;

public class Animal implements Comparable
{
    private String name;
    private Image image;

    public Animal(String n)
    {    
        name  = n;
        image = new ImageIcon(name + ".png").getImage();
    }

    public String getName()
    {
        return name;
    }

    public int getWidth()
    {
        return image.getWidth(null);
    }

    public int getHeight()
    {
        return image.getHeight(null);
    }

    public Image getImage()
    {
        return image;
    }
    
    public int compareTo(Object o)
    {
        Animal other = (Animal) o;
        
        if (getHeight() < other.getHeight()) return -1;
        if (getHeight() > other.getHeight()) return 1;
        
        if (getWidth() < other.getWidth()) return -1;
        if (getWidth() < other.getWidth()) return 1;
        
        return 0;
    }
}