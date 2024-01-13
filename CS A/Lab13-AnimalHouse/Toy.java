
//Name: 

public class Toy
{
    private String name;
    
    public Toy()
    {
        name = "";
    }
    public Toy(String n)
    {
        name = n;
    }
    
    public String toString()
    {
        return "A " + name;
    }
    
    
    public boolean equals(Object o)
    {
        Toy other = (Toy)o;
        return this.name == other.name;
    }
}
