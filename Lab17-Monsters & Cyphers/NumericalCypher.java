 
import java.util.*;
public class NumericalCypher implements Cypher
{
    public NumericalCypher()
    {
        
    }

    public String encode(String message)
    {
        String encodedMessage = "";
        char[] messageChars = message.toCharArray();

        for (char c : messageChars)
            encodedMessage += (int) c + " ";

        return encodedMessage;
    }

    public String decode(String secretCode)
    {
        String decodedMessage = "";
        Scanner chopper = new Scanner(secretCode);

        while (chopper.hasNext())
        {
            int ASCII = chopper.nextInt();
            decodedMessage += (char) ASCII;
        }

        return decodedMessage;
    }

}
