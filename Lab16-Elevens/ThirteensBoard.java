
//Name: 
import java.util.*;
public class ThirteensBoard extends Board
{
    private static final int[] POINT_VALUES =
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    public ThirteensBoard() {
        super(9, POINT_VALUES);
    }
    
    public boolean isLegal(List<Integer> selectedCards) {
        //TODO
        if (selectedCards.size() == 2 && containsPairSum(selectedCards) || selectedCards.size() == 1 && containsKing(selectedCards))
            return true;
        return false; //REPLACE
    }

    public boolean anotherPlayIsPossible() {
        //TODO
        List<Integer> indexes = cardIndexes(); 
        for (int i = 0; i < indexes.size(); i++)
        {
            ArrayList<Integer> sCards = new ArrayList<Integer>();
            sCards.add(indexes.get(i));
            if (isLegal(sCards))
                return true;
            for (int r = 0; r < indexes.size(); r++)
            {
                if (r == i)
                    continue;
                sCards.add(indexes.get(r));
                System.out.println(sCards.size());
                if (isLegal(sCards))
                    return true;
                sCards.remove(sCards.size() - 1);
            }
        }
        return false; //REPLACE
    }
    
    public boolean containsPairSum(List<Integer> selectedCards) {
        //TODO
        if (cardAt(selectedCards.get(0)).pointValue() + cardAt(selectedCards.get(1)).pointValue() == 13)
             return true;
        return false; //REPLACE
    }
    
    private boolean containsKing(List<Integer> selectedCards) {
        //TODO
        if(cardAt(selectedCards.get(0)).pointValue() == 13)
            return true;
        return true;//REPLACE
    }
}
