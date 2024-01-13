import java.util.*;

public class Blackjack
{
    public static ArrayList<Card> makeDeck()
    {
        ArrayList<Card> cards = new ArrayList<Card>();
        
        for (int rank = 1; rank <= 13; rank = rank + 1)
        {
            for (int suit = 0; suit <= 3; suit = suit + 1)
            {
                cards.add(new Card(rank, suit));
            }
        }

        return cards;  //change
    }

    public static void swap(ArrayList<Card> cards, int i, int j)
    {
        Card placeCard = new Card(cards.get(i).getRank(), cards.get(i).getSuit());
        cards.set(i, cards.get(j));
        cards.set(j, placeCard);
    }

    public static void dealOneCard(ArrayList<Card> deck, ArrayList<Card> hand)
    {
        Card card = new Card(deck.get(deck.size() - 1).getRank(), deck.get(deck.size() - 1).getSuit());
        deck.remove(deck.size() - 1);
        hand.add(card);
    }

    public static int getScore(ArrayList<Card> hand)
    {
        //TODO
        int sum = 0;
        boolean hasAce = false;
        for (int i = 0; i < hand.size(); i++)
        {
            if (hand.get(i).getRank() == 1)
                hasAce = true;
            if (!hasAce)
                sum += Math.min(hand.get(i).getRank(), 10);
            else if (hasAce)
            {
                if (sum + 11 < 21)
                    sum += 11;
                else
                    sum++;
                hasAce = false;
            }
        }
        return sum;  //change
    }
}