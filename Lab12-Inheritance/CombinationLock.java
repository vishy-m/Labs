
//Name: 
import java.util.*;

public class CombinationLock extends Lock
{
    private String combination;
    
    public CombinationLock()
    {
        super();
        combination = "";
    }
    public CombinationLock(String combo)
    {
        super();
        combination = combo;
    }
    public void open()
    {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter combination >>> ");
        String input = console.nextLine();
        if (input.equals(combination))
            super.open();
    }
    public String toString()
    {
        return super.toString() + ", combination is " + combination;
    }
    public void setCombination(String combo){combination = combo;}
    public String getCombination(){return combination;}
}
