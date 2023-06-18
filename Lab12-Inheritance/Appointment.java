
//Name: 
import java.util.*;
public class Appointment extends Date
{
    private String text;
    
    public Appointment()
    {
        super();
        text = "Do nothing";
    }
    public Appointment(int month, int day, int year, String txt)
    {
        super(month, day, year);
        text = txt;
    }
    
    public String getText(){return text;}
    
    public String toString()
    {
        return super.toString() + " " + text;
    }
}
