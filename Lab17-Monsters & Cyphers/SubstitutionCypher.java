
//Name: 
import java.util.*;
import java.io.*;

public class SubstitutionCypher implements Cypher
{
    HashMap<String, String> encodeMap = new HashMap<String, String>();
    HashMap<String, String> decodeMap = new HashMap<String, String>();

    public SubstitutionCypher()
    {
        File file = new File("translationKey.txt");
        Scanner chopper = null;
        try {
            chopper = new Scanner(file);
        }
        catch (IOException e) { System.out.print(e); }
        while (chopper.hasNextLine())
        {
            String key = chopper.next();
            String value = chopper.next();
            
            encodeMap.put(key, value);
            decodeMap.put(value, key);
        }
    }

    public String encode(String messsage)
    {
        String encodedMessage = "";
        char[] messageChars = messsage.toCharArray();

        for(char c : messageChars)
        {
            String key = "" + c;
            if (encodeMap.containsKey(key))
            {
                encodedMessage += encodeMap.get(key);
            }
            else
            {
                encodedMessage += c;
            }
        }

        return encodedMessage;
    }

    public String decode(String secretCode)
    {
        String decodedMessage = "";
        char[] codeChars = secretCode.toCharArray();

        for(char c : codeChars)
        {
            String key = "" + c;
            if (decodeMap.containsKey(key))
            {
                decodedMessage += decodeMap.get(key);
            }
            else
            {
                decodedMessage += c;
            }
        }
        return decodedMessage;
    }
}
