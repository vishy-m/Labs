
import static java.lang.System.*;

public class MadLibRunner
{
    public static void main( String args[] )
    {
        MadLib crazySentence = new MadLib();
        for (int i = 0; i < 5; i++)
            out.println(crazySentence + "\n");
            
        //Should print 5 different crazy sentences!
    }
}