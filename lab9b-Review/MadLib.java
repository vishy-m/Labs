import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class MadLib
{
    private ArrayList<String> nouns = new ArrayList<String>();
    private ArrayList<String> verbs = new ArrayList<String>();
    private ArrayList<String> adjectives = new ArrayList<String>();;
    //Need more PIVs?    

    public MadLib()
    {
        loadNouns();
        loadVerbs();
        loadAdjectives();
    }

    public void loadNouns()
    {        
        //Read the noun data file and load each word into the correct ArrayList
        File file = new File("madlib_nouns.dat");
        Scanner input = null;
        try {
            input = new Scanner(file);
        }
        catch (IOException e) { System.out.print(e); }

        while (input.hasNextLine())
        {
            nouns.add(input.nextLine());
        }

    }

    public void loadVerbs()
    {
        //Read the verb data file and load each word into the correct ArrayList
        File file = new File("madlib_verbs.dat");
        Scanner input = null;
        try {
            input = new Scanner(file);
        }
        catch (IOException e) { System.out.print(e); }

        while (input.hasNextLine())
        {
            verbs.add(input.nextLine());
        }

    }

    public void loadAdjectives()
    {
        //Read the adjective data file and load each word into the correct ArrayList
        File file = new File("madlib_adj.dat");
        Scanner input = null;
        try {
            input = new Scanner(file);
        }
        catch (IOException e) { System.out.print(e); }

        while (input.hasNextLine())
        {
            adjectives.add(input.nextLine());
        }

    }

    public String getRandomVerb()
    {
        Random random = new Random();
        return verbs.get(random.nextInt(verbs.size() - 1));
    }

    public String getRandomNoun()
    {
        Random random = new Random();
        return nouns.get(random.nextInt(nouns.size() - 1));
    }

    public String getRandomAdjective()
    {
        Random random = new Random();
        return adjectives.get(random.nextInt(adjectives.size() - 1));
    }       

    public String toString()
    {
        //This method should build an output string.  It will do this by
        //reading the madlib_story.dat one word at a time and making
        //replacements as necessary.

        String madlib = "The & # @ the & # while the & # @ the # until it is &";

        Scanner chopper = new Scanner(madlib);
        String funny = "";
        while (chopper.hasNext())
        {
            String token = chopper.next();
            if (token.equals("&"))
                funny += getRandomAdjective();
            else if (token.equals("#"))
                funny += getRandomNoun();
            else if (token.equals("@"))
                funny += getRandomVerb();
            else
                funny += token;
            funny += " ";
        }

        //Load the madlib string in to a Scanner/chopper
        //Parse through it, one token at a time, to help build String funny.

        return funny;
    }
}