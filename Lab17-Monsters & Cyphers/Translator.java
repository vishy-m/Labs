import java.util.*;

public class Translator {
    public static void main(String[] args)  {
        Scanner console = new Scanner(System.in);

        while (true) {     
            System.out.print("0) Quit\n1) Encode \n2) Decode\nChoice >> ");
            int choice = console.nextInt();
            console.nextLine(); //buffer clear
            System.out.println();
            if (choice == 0) break;

            System.out.print("What is the input String? >> ");
            String input = console.nextLine();
            System.out.println();

            /* 
             * An ArrayList of Cypher objects can hold any object
             * that is a Cypher (which includes an object that 
             * implements the Cypher interface!)
             */
            ArrayList<Cypher> cypherList = new ArrayList<>();

            //Make sure all 3 of your cyphers get into the list.
            cypherList.add(new NumericalCypher());
            cypherList.add(new CaesarShift());
            cypherList.add(new SubstitutionCypher());

            System.out.println("Here are the available cyphers.");
            for (int i = 0; i < cypherList.size(); i++) {
                System.out.println(i + ") " + cypherList.get(i).getClass().getName());
            }
            System.out.print("Cypher choice >> ");
            int cypherChoice = console.nextInt();
            console.nextLine(); //buffer clear           
            System.out.println();

            /*
             * The code below works nicely because any Cypher
             * in our ArrayList is capable of running encode
             * or decode methods.  It doesn't matter which object
             * we choose because they can all do those tasks!
             */            
            String output;            
            if (choice == 1) //encode 
                output = cypherList.get(cypherChoice).encode(input);
            else //decode
                output = cypherList.get(cypherChoice).decode(input);

            System.out.println("Output String >> " + output);
            System.out.println("Press enter to continue.");
            console.nextLine(); //Since buffer is clean, waits for enter
        }
    }
}

