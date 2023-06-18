
//Name: 
import java.util.*;
public abstract class Board
{
    private static  int BOARD_SIZE;
  
    private static final boolean IM_DEBUGGING = false;
    
    private static final String[] RANKS = 
        {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
    private static final String[] SUITS =
        {"Spades", "Hearts", "Diamonds", "Clubs"};
    
    private Deck deck;
    private Card[] cards;
    
    private static int[] POINT_VALUES;
    
    public Board(int boardSize, int[] pointValues)
    {
        setBoardSize(boardSize);
        setPointValues(pointValues);
        cards = new Card[BOARD_SIZE];
        deck = new Deck(RANKS, SUITS, POINT_VALUES);
        if (getDebugging()) {
            System.out.println(deck);
            System.out.println("----------");
        }
        dealMyCards();
    }

    public static boolean getDebugging()
    {
        return IM_DEBUGGING;
    }
    
    public static void setBoardSize(int boardSize)
    {
        BOARD_SIZE = boardSize;
    }
    
    public static void setPointValues(int[] pointValues)
    {
        POINT_VALUES = pointValues;
    }
    
    public int size() {
        return cards.length;
    }
    
    public boolean isEmpty() {
        for (int k = 0; k < cards.length; k++) {
            if (cards[k] != null) {
                return false;
            }
        }
        return true;
    }
    
    public void deal(int k) {
        cards[k] = deck.deal();
    }
    
    public int deckSize() {
        return deck.size();
    }
    
    public Card cardAt(int k) {
        return cards[k];
    }
    
    public List<Integer> cardIndexes() {
        //TODO
        List<Integer> cardIndexes = new ArrayList<>();
        for (int i = 0; i < cards.length; i++)
        {
            if (cards[i] != null)
            {
                cardIndexes.add(i);
            }
        }
        return cardIndexes; //REPLACE
    }
    
    public String toString() {
        String s = "";
        for (int k = 0; k < cards.length; k++) {
            s = s + k + ": " + cards[k] + "\n";
        }
        return s;
    }
    
    public boolean gameIsWon() {
        if (deck.isEmpty()) {
            for (Card c : cards) {
                if (c != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public abstract boolean isLegal(List<Integer> selectedCards);
    
    private void dealMyCards() {
        for (int k = 0; k < cards.length; k++) {
            cards[k] = deck.deal();
        }
    }
    
    public abstract boolean containsPairSum(List<Integer> selectedCards);
    public abstract boolean anotherPlayIsPossible();
    
    public void replaceSelectedCards(List<Integer> selectedCards) {
        for (Integer k : selectedCards) {
            deal(k.intValue()); //intValue() returns the int value for an Integer object
        }
    }
    
    public void newGame() {
        deck.shuffle();
        dealMyCards();
    }
    
    public void shuffleTheDeck()
    {
        deck.shuffle();
    }
}
