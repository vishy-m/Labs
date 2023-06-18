
//Name: 
import java.util.*;
public class Inventory
{
    ArrayList<Vehicle> inventory;

    public Inventory()
    {
        inventory = new ArrayList<Vehicle>();
    }

    public void addVehicle(Vehicle v)
    {
        inventory.add(v);
    }

    public void listInventory()
    {
        for (int i = 0; i < inventory.size(); i++)
        {
            System.out.println(inventory.get(i).getInfo());
        }
    }
}

