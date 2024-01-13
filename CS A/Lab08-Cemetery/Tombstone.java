
//Name: 
import java.util.*;
public class Tombstone
{
    private String name, burialDate, address;
    private int ageInDays;
    
    public Tombstone(String n, String b, int a, String ad)
    {
        name = n;
        burialDate = b;
        ageInDays = a;
        address = ad;
    }
    
    public String toString()
    {
        return "name: " + name + "\tBurialDate: " + burialDate + "\tAge: " + ageInDays + "\t Address: " + address;
    }
    
    public String getName(){return name;}
    public String getBurialDate(){return burialDate;}
    public String getAddress(){return address;}
    public int getAgeInDays(){return ageInDays;}
}
