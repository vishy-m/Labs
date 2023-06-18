
//Name: 
import java.util.*;
import java.io.*;
public class HashMapProbs
{
    public static void main(String[] args)
    {
        zoo();
    }

    public static void zoo()
    {
        HashMap<String, String> animalSounds = new HashMap<>();
        Scanner console = new Scanner(System.in);

        animalSounds.put("cat", "meow");
        animalSounds.put("dog", "woof");
        System.out.println(animalSounds);

        System.out.println();
        System.out.print("Name an animal >>> ");
        String key = console.nextLine();
        System.out.print("What sound does that animal make? >>> ");
        String value = console.nextLine();
        animalSounds.put(key, value);
        System.out.println(animalSounds);

        System.out.println();
        System.out.print("Choose an animal to speak with >>> ");
        key = console.nextLine();
        System.out.println("The " + key + " says " + animalSounds.get(key));

        System.out.println();
        System.out.println("Number of key/value pairs >>> " + animalSounds.size());
    }

    public static HashMap<Character, Boolean> multiple(String s)
    {
        HashMap<Character, Boolean> maps = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            boolean b = false;
            if (maps.containsKey(c))
                b = true;
            else
                b = false;
            maps.put(c, b);
        }

        return maps;
    }

    public static HashMap<Character, String> charWord(String[] words)
    {
        HashMap<Character, String> maps = new HashMap<>();

        for (int i = 0; i < words.length; i++)
        {
            if (!maps.containsKey(words[i].charAt(0)))
            {
                maps.put(words[i].charAt(0), words[i]);
            }
            else
            {
                maps.put(words[i].charAt(0), maps.get(words[i].charAt(0)) + words[i]);
            }
        }

        return maps;
    }

    public static HashMap<String, Integer> dreamAnalyzer()
    {
        File file = new File("dream.txt");
        Scanner chopper = null;
        try {
            chopper = new Scanner(file);
        }
        catch (IOException e) { System.out.print(e); }

        HashMap<String, Integer> map = new HashMap<>();

        while (chopper.hasNextLine())
        {
            String word = chopper.next();
            if (! map.containsKey(word.toLowerCase()))
            {
                map.put(word.toLowerCase(), 1);
            }
            else
            {
                map.put(word.toLowerCase(), map.get(word.toLowerCase()) + 1);
            }
        }

        int max = Collections.max(map.values()); //the largest value in the map
        for (String key : map.keySet()) //iterate through all the keys in the map
            if (map.get(key) == max)    //if this key's value matches max...
                System.out.println("Highest frequency word: " + key + ", " + max);

        return map;
    }
}
