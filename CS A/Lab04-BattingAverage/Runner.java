import java.util.*;
import java.io.*;
public class Runner
{
    public static void main (String[] args)
    {
        File file = new File("players.txt");
        Scanner console = null;
        try 
        {
            console = new Scanner(file);
        }
        catch (IOException e) 
        {
            System.out.println("file not found");
        }
        int p = 9;
        if (console.hasNextLine())
        {
            p = console.nextInt();
            console.nextLine();
        }

        // String[] names = {"Tom", "Mark", "Frank", "Roger", "Alan", "Harry", "Ron", "Tim", "Kyle"};
        //int[] numbers = {8, 4, 23, 45, 12, 11, 36, 1, 2};
        //int[] bats = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        //int[] hits = {100, 110, 120, 130, 140, 150, 160, 170, 180};
        Player[] players = new Player[p];
        for (int i = 0; i < p; i++)
        {
            if (console.hasNextLine())
            {
                String name = console.next();
                int num = console.nextInt();
                int bats = console.nextInt();
                int hits = console.nextInt();
                players[i] = new Player(name, num, bats, hits);
            }
        }
        Team frisco = new Team(players);
        frisco.printTeamStats();
    }
}
