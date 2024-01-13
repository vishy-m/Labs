
//Name: 
import java.util.*;
public class House
{
    private ArrayList<Animal> animals;

    public House()
    {
        animals = new ArrayList<Animal>();
    }

    public void add(Animal a)
    {
        animals.add(a);
    }

    public void printAnimals()
    {
        for (Animal a : animals)
        {
            System.out.println(a + "\n");
        }
    }

    public void cleanHouse()
    {
        for (Animal a : animals) 
        {
            ArrayList<Toy> toys = a.getToys();
            for (int i = toys.size() - 1; i > 0; i--)
            {
                Toy t = toys.get(i);
                int index = toys.indexOf(t);
                int lastIndex = toys.lastIndexOf(t);
                if (index != lastIndex)
                    toys.remove(index);
            }
        }
    }
}
