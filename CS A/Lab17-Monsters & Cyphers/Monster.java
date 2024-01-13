
//Name: 

public class Monster implements Nameable, Comparable<Monster>
{
    private String name;
    private double height;
    private double weight;
    private int age;

    public Monster()
    {
        name = "Unnamed Monster";
        height = weight = 0;
        age = 0;     
    }

    public Monster(String n, double h, double w, int a)
    {
        name = n;
        height = h;
        weight = w;
        age = a;     
    }

    public Monster(double h, double w, int a)
    {
        this("Unnamed monster", h, w, a);    
    }

    public String toString()
    {
        return name;
    }

    public boolean equals(Object o)
    {
        Monster other = (Monster)o;
        if (name.equals(other.name) && height == other.height && weight == other.weight && age == other.age)
            return true;
        return false;
    }

    public String getName(){return name;}

    public void setName(String n){name = n;}

    public int compareTo(Monster o)
    {
        if (height > o.height)
            return 1;
        else if (height < o.height)
            return -1;
        if (weight > o.weight)
            return 1;
        else if (weight < o.weight)
            return -1;
        if (age > o.age)
            return 1;
        else if (age < o.age)
            return -1;
        return 0;
    }
}
