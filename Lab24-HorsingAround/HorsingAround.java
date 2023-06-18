import java.util.*;
import java.awt.*;

public class HorsingAround {
    public static int totalWidth(ArrayList<Animal> animals)     {
        int sumW = 0;
        for (int i = 0 ; i < animals.size(); i++)
        {
            sumW += animals.get(i).getWidth();
        }
        return sumW;
    }

    public static Animal tallestAnimal(ArrayList<Animal> animals)     {
        int tallestIndex = 0;
        int greatestHeight = 0;
        for (int i = 0; i < animals.size(); i++)
        {
            int aHeight = animals.get(i).getHeight();
            if (aHeight > greatestHeight)
            {
                greatestHeight = aHeight;
                tallestIndex = i;
            }

        }
        return animals.get(tallestIndex);
    }

    public static int countYourChickens(ArrayList<Animal> animals)     {
        int numChickens = 0;
        for (int i = 0; i < animals.size(); i++)
        {
            String name = animals.get(i).getName();
            if (name.equalsIgnoreCase("chicken")) numChickens++;
        }
        return numChickens;
    }

    public static ArrayList<String> inventory(ArrayList<Animal> animals)  {
        ArrayList<String> animalNames = new ArrayList<String>();
        for (int i = 0; i < animals.size(); i++)
        {
            String name = " " + animals.get(i).getName();
            animalNames.add(name);
        }
        return animalNames;
    }

    public static void pestControl(ArrayList<Animal> animals)  {
        for (int i = animals.size() - 1; i > -1; i--)
        {
            String name = animals.get(i).getName();
            if (name.equalsIgnoreCase("mouse")) animals.remove(i);
        }
    }

    public static void horsingAround(ArrayList<Animal> animals)  {
        Animal horse = new Animal("horse");
        animals.add(horse);
        for (int i = animals.size() - 2; i > -1; i--)
        {
            animals.add(i, horse);
        }
    }

    public static void feelingSheepish(ArrayList<Animal> animals)  {
        Animal sheep = new Animal("sheep");
        Animal horse = new Animal("horse");

        for (int i = 0; i < animals.size(); i++)
        {
            String name = animals.get(i).getName();
            if (name.equalsIgnoreCase("sheep"))
            {
                int leftIndex = Math.max(0, i - 1);
                int rightIndex = Math.min(i + 1, animals.size() - 1);
                animals.set(leftIndex, sheep);
                animals.set(rightIndex, sheep);
                i++;
            }
        }
        System.out.print("Animals: ");
        for(int i = 0; i < animals.size(); i++)
        {
            System.out.print(animals.get(i).getName() + ", ");
        }
        System.out.println();
    }

    public static void selectionSort(ArrayList<Animal> animals)
    {
        for (int i = 0; i < animals.size(); i++)
        {
            int minIndex = i;
            Animal min = animals.get(minIndex);

            for (int j = minIndex; j < animals.size(); j++)
            {
                if (min.compareTo(animals.get(j)) < 0)
                {
                    min = animals.get(j);
                    minIndex = j;
                }
            }

            Animal animalAtI = animals.get(i);
            animals.set(i, animals.get(minIndex));
            animals.set(minIndex, animalAtI);
            
        }
    }

    public static void insertionSort(ArrayList<Animal> animals)
    {
        for (int i = 1; i < animals.size(); i++)
        {
            Animal min = animals.get(i);
            int possibleLowest = i - 1;
            while (possibleLowest >= 0 && min.compareTo(animals.get(possibleLowest)) > 0)
            {
                animals.set(possibleLowest + 1, animals.get(possibleLowest));
                possibleLowest--;
            }
            animals.set(possibleLowest + 1, min);
        }
    }
}