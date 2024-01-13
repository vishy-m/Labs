
//Name: 
import java.util.*;
public class Animal
{
    public static int currentYear = 2023;
    
    private String name;
    private int birthYear;
    private ArrayList<Toy> toys;
    private Animal friend;
    
    public Animal(String n, int by)
    {
        name = n;
        birthYear = by;
        toys = new ArrayList<Toy>();
    }
    
    public void setFriend(Animal a){friend = a;}
    public void addToy(Toy t){toys.add(t);}
    public ArrayList<Toy> getToys(){return toys;}
    
    public int getAge(){return currentYear - birthYear;}
    
    public String toString()
    {
        String friendTxt = "I have no friends.";
        int age = currentYear - birthYear;
        if (friend != null)
            friendTxt = "I have a friend named " + friend.name + ".";
        return "Hello, I am " + name + ". I am " + age + " years old.\n" + friendTxt + "\nI have these " + this.toys.size() + " toys: " + toys;
    }
}
