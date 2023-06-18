import java.util.*;
import java.awt.Color;

public class BlackjackDisplay
{
    private ArrayList<Card> deck;
    private ArrayList<Card> dealerHand;
    private ArrayList<Card> playerHand;
    private GridDisplay grid;
    
    public static void main(String[] args) {
		//feel free to call methods here!  no charge
    	run();
	}

    public static void run()
    {
        BlackjackDisplay display = new BlackjackDisplay();
        if (display.isReady())
            display.play();
        else
            display.showDeck();
    }

    public BlackjackDisplay()
    {
        reset();
    }

    public BlackjackDisplay(boolean testOnly)
    {
        deck = Blackjack.makeDeck();

        //shuffle deck
        for (int i = 0; i < deck.size(); i++)
        {
            int r = (int)(Math.random() * (deck.size() - i)) + i;
            Blackjack.swap(deck, i, r);
        }
    }
    
    private void reset()
    {
        deck = Blackjack.makeDeck();

        //shuffle deck
        for (int i = 0; i < deck.size(); i++)
        {
            int r = (int)(Math.random() * (deck.size() - i)) + i;
            Blackjack.swap(deck, i, r);
        }

        dealerHand = new ArrayList<Card>();
        playerHand = new ArrayList<Card>();

        //deal 2 cards to each player
        Blackjack.dealOneCard(deck, dealerHand);
        Blackjack.dealOneCard(deck, dealerHand);
        Blackjack.dealOneCard(deck, playerHand);
        Blackjack.dealOneCard(deck, playerHand);
    }

    private boolean isReady()
    {
        return deck.size() == 48 && dealerHand.size() == 2 &&
        playerHand.size() == 2;
    }

    public void showDeck()
    {
        grid = new GridDisplay(7, 8);
        int row = 0;
        int col = 0;
        for (int i = 0; i < deck.size(); i++)
        {
            grid.setImage(new Location(row, col), toImage(deck.get(i)));
            row++;
            if (row >= grid.getNumRows())
            {
                row = 0;
                col++;
            }
        }
    }

    public ArrayList<Card> getDeck() { return deck; }
    
    private void play()
    {
        grid = new GridDisplay(2, 5);

        for (int row = 0; row < grid.getNumRows(); row++)
            for (int col = 0; col < grid.getNumCols(); col++)
                grid.setColor(new Location(row, col), new Color(0, 127, 0));

        updateDisplay(false);

        while (true)
        {
            try{Thread.sleep(10);}catch(Exception e){} //pause 10ms between screen updates

            int key = grid.checkLastKeyPressed();

            if (key == 72)  // h pressed
            {
                Blackjack.dealOneCard(deck, playerHand);
                updateDisplay(false);
            }

            if (Blackjack.getScore(playerHand) > 21)
            {
                updateDisplay(true);
                grid.showMessageDialog("You busted");
                reset();
                updateDisplay(false);
            }
            else if (key == 83 || playerHand.size() == 5 ||
            Blackjack.getScore(playerHand) == 21)  // s pressed or player can't hit anymore
            {
                updateDisplay(true);

                while (dealerHand.size() < 5 && Blackjack.getScore(dealerHand) < 17)
                {
                    try{Thread.sleep(500);}catch(Exception e){}
                    Blackjack.dealOneCard(deck, dealerHand);
                    updateDisplay(true);
                }

                int dealerScore = Blackjack.getScore(dealerHand);
                int playerScore = Blackjack.getScore(playerHand);

                if (dealerScore > 21 || playerScore > dealerScore)
                    grid.showMessageDialog("You win");
                else if (dealerScore == playerScore)
                    grid.showMessageDialog("We tie");
                else
                    grid.showMessageDialog("You lose");

                reset();
                updateDisplay(false);
            }
        }
    }

    private void updateDisplay(boolean showDealerCard)
    {
        if (Blackjack.getScore(playerHand) == -1)
            grid.setTitle("Blackjack");
        else
        {
            if (showDealerCard)
                grid.setTitle("Dealer has " + Blackjack.getScore(dealerHand) +
                    " and Player has " + Blackjack.getScore(playerHand));
            else
                grid.setTitle("Player has " + Blackjack.getScore(playerHand));
        }

        for (int row = 0; row < grid.getNumRows(); row++)
            for (int col = 0; col < grid.getNumCols(); col++)
                grid.setImage(new Location(row, col), null);

        if (dealerHand.size() > 0)
        {
            if (showDealerCard)
                grid.setImage(new Location(0, 0), toImage(dealerHand.get(0)));
            else
                grid.setImage(new Location(0, 0), "images/back.gif");
        }

        for (int i = 1; i < dealerHand.size(); i++)
            grid.setImage(new Location(0, i), toImage(dealerHand.get(i)));

        for (int i = 0; i < playerHand.size(); i++)
            grid.setImage(new Location(1, i), toImage(playerHand.get(i)));
    }

    private static String toImage(Card card)
    {
        return "images/" + card.getRank() + "cdhs".charAt(card.getSuit()) + ".gif";
    }
}