
public class CaesarShift implements Cypher
{
    private int startingASCII = 65;
    private int endingASCII = 90;
    

    public CaesarShift()
    {

    }

    public String encode(String messsage)
    {
        String encodedMessage = "";
        char[] messageChars = messsage.toUpperCase().toCharArray();
        

        for(char c : messageChars)
        {
            int charIndex = (int) c;
            if (charIndex >= startingASCII && charIndex <= endingASCII)
            {
                charIndex += 3;
                
                if (charIndex > endingASCII)
                    charIndex = startingASCII + (charIndex - (endingASCII + 1));
                
                encodedMessage += (char) charIndex;
            }
            else
                encodedMessage += c;

        }
        
        return encodedMessage;
    }
    
    public String decode(String secretCode)
    {
        String decodedMessage = "";
        char[] codeChars = secretCode.toUpperCase().toCharArray();

        for(char c : codeChars)
        {
            int charIndex = (int) c;

            if (charIndex >= startingASCII && charIndex <= endingASCII)
            {
                charIndex -= 3;
                
                if (charIndex < startingASCII)
                    charIndex = (endingASCII + 1) + (charIndex - startingASCII);
                decodedMessage += (char) charIndex;
            }
            else
                decodedMessage += c;

        }
        
        return decodedMessage;
    }
}

