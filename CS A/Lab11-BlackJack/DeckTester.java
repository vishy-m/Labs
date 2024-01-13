import java.util.*;
public class DeckTester
{
    public static void main(String[] args)
    {
        BlackjackDisplay display = new BlackjackDisplay(true);
        display.showDeck();

        ArrayList<Card> deck = display.getDeck();

        //Verify card count
        System.out.print("Num of cards: " + deck.size());
        if (deck.size() == 52)
            System.out.println("  (Good job)\n");
        else
            System.out.println("  (But you should have 52 cards!)\n");

        //Verify that all cards are valid and no repeats
        for (int i = 0; i < deck.size(); i++) {
            Card c1 = deck.get(i);
            if (c1.getRank()<0||c1.getRank()>13||c1.getSuit()<0||c1.getSuit()>3)
                System.out.println("Problem: Bad card found (invalid rank or suit)");
            for (int j = 0; j < deck.size(); j++) {
                if (i == j) continue;
                Card c2 = deck.get(j);
                if (c1 == c2) System.out.println("Problem: Duplicate card found");
                if (c1.getRank()==c2.getRank() && c1.getSuit()==c2.getSuit())
                    System.out.println("Problem: Duplicate card found");
            }
        }        

    }
}
