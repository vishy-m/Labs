
//Name: 

public class Cat extends Animal
{
    private int numLives;
    
    public Cat(String n, int by, int nl)
    {
        super(n, by);
        numLives = nl;
    }
    public Cat(String n, int by)
    {
        this(n, by, 9);
    }
    public String toString()
    {
        return super.toString() + "\n" + "I have " + numLives + " lives.";
    }
}
