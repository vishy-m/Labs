import java.util.*;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board{

    private static final int[] POINT_VALUES =
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

    public ElevensBoard() {
        super(9, POINT_VALUES);
    }

    public boolean isLegal(List<Integer> selectedCards) {
        //TODO
        if (selectedCards.size() == 2 && containsPairSum(selectedCards) || selectedCards.size() == 3 && containsJQK(selectedCards))
            return true;
        return false; //REPLACE
    }

    public boolean anotherPlayIsPossible() {
        //TODO
        List<Integer> sCards = cardIndexes(); 
        
        for (int i = 0; i < sCards.size(); i++)
        {
            if (containsJQK(sCards))
                return true;
            for(int r = 0; r < sCards.size(); r++)
            {
                if (r == i)
                    continue;
                ArrayList<Integer> cardsP = new ArrayList<Integer>();
                cardsP.add(sCards.get(i));
                cardsP.add(sCards.get(r));
                if (containsPairSum(cardsP))
                    return true;
            }
        }
        return false; //REPLACE
    }

    public boolean containsPairSum(List<Integer> selectedCards) {
        //TODO
        if (cardAt(selectedCards.get(0)).pointValue() + cardAt(selectedCards.get(1)).pointValue() == 11)
        {
            return true;
        }
        return false; //REPLACE
    }

    private boolean containsJQK(List<Integer> selectedCards) {
        //TODO
        boolean kingFound = false;
        boolean queenFound = false;
        boolean jackFound = false;
        for (int i = 0; i < selectedCards.size(); i++)
        {
            if ((cardAt(selectedCards.get(i)).rank().equals("king")))
            {
                kingFound = true;
                continue;
            }
            if ((cardAt(selectedCards.get(i)).rank().equals("queen")))
            {
                queenFound = true;
                continue;
            }
            if ((cardAt(selectedCards.get(i)).rank().equals("jack")))
            {
                jackFound = true;
                continue;
            }
        }
        if (kingFound && queenFound && jackFound)
                return true;
        return false;//REPLACE
    }
}
