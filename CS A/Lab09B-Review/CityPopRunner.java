//Name: 
import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class CityPopRunner
{
    public static void printList(ArrayList<CityPop> temp)
    {
        /**
         * PART 1 - complete this method so that it will print
         * each object of ArrayList temp, one object per line
         * You will call this method in various other parts of the lab.
         */

        //your code here for part 1
        for (int i = 0; i < temp.size(); i++)
        {
            System.out.println(temp.get(i));
        }
    }

    public static void main(String[] args)
    {
        /**
        //PART 2
        //Make 2 ArrayLists
        //One called cityListA and one called cityListB
        //These arraylists can hold CityPop objects
         */
        //your code here for part 2
        ArrayList<CityPop> cityListA = new ArrayList<CityPop>();
        ArrayList<CityPop> cityListB = new ArrayList<CityPop>();

        /**
        //PART 3
        //Write code to read all the data from popA.dat and popB.dat
        //into your ArrayLists cityListA and cityListB
        //Then, uncomment the provided code to print each list.  
         */

        //your code here for part 3

        File popA = new File("popA.dat");
        File popB = new File("popB.dat");
        Scanner chopperA = null;
        Scanner chopperB = null;
        try {
            chopperA = new Scanner(popA);
            chopperB = new Scanner(popB);
        }
        catch (IOException e) { System.out.print(e); }

        while (chopperA.hasNextLine())
        {
            String cN = chopperA.next();
            int pop = chopperA.nextInt();
            cityListA.add(new CityPop(cN, pop));
        }
        
        while (chopperB.hasNextLine())
        {
            String cN = chopperB.next();
            int pop = chopperB.nextInt();
            cityListB.add(new CityPop(cN, pop));
        }

        out.println("LIST A:");
        printList(cityListA);
        out.println("\nLIST B:");
        printList(cityListB);

        /**
        //PART 4
        //Make an ArrayList of CityPop objects called duplicates
        //that contains one instance of any CityPop object found 
        //in both cityListA and cityListB.
        //Print the list of duplicate cities using the 
        //printList that you coded above.
         */

        //your code here for part 4
//         ArrayList<CityPop> dupes = new ArrayList<CityPop>();
//         if (listA.size() > listB.size())
//         {
//             for (int i = 0;i < listA.size(); i++)
//             {
//                 if (listA.get(i).equals(listB.get(i)))
//                 {
//                 }
//             }
//         }
        //out.println("\nDUPLICATES:");
        //printList(duplicates);

        /**
        //PART 5
        //Remove any objects from cityListB that are found on
        //the duplicates list.
        //Print the altered cityListB
         */

        //your code here for part 5

        //out.println("\nLIST B (without duplicates):");
        //printList(cityListB);

    }
}
