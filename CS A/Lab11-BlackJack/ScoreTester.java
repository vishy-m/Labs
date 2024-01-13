import java.util.ArrayList;
public class ScoreTester
{
    public static void main(String[] args) {
        test();
    }

    public static void test()
    {
        ArrayList<Card> hand;

        hand = new ArrayList<>();
        hand.add(new Card(4, 3));  //4 of spades
        hand.add(new Card(13, 3)); //King of spades
        hand.add(new Card(7, 3));  //7 of spades
        int score=Blackjack.getScore(hand);
        System.out.println("Hand: 4K7");
        System.out.print("You said the score is: "+score);
        if (score == 21) System.out.println(" (Good job!)");
        else System.out.println(", but it is actually 21.  Try again");
        System.out.println();

        hand.clear();
        hand.add(new Card(12, 3)); //queen of spades
        hand.add(new Card(5, 3));  //5 of spades
        hand.add(new Card(1, 3));  //ace of spades
        score=Blackjack.getScore(hand);
        System.out.println("Hand: Q5A");
        System.out.print("You said the score is: "+score);
        if (score == 16) System.out.println(" (Good job!)");
        else System.out.println(", but it is actually 16.  Try again");
        System.out.println();

        hand.clear();
        hand.add(new Card(2, 3)); //2 of spades
        hand.add(new Card(1, 3));  //ace of spades
        hand.add(new Card(7, 3));  //7 of spades
        score=Blackjack.getScore(hand);
        System.out.println("Hand: 2A7");
        System.out.print("You said the score is: "+score);
        if (score == 20) System.out.println(" (Good job!)");
        else System.out.println(", but it is actually 20.  Try again");
        System.out.println();

        hand.clear();
        hand.add(new Card(13, 3)); //king of spades
        hand.add(new Card(1, 3));  //ace of spades
        hand.add(new Card(1, 3));  //ace of spades
        score=Blackjack.getScore(hand);
        System.out.println("Hand: KAA");
        System.out.print("You said the score is: "+score);
        if (score == 12) System.out.println(" (Good job!)");
        else System.out.println(", but it is actually 12.  Try again");
        System.out.println();

        hand.clear();
        hand.add(new Card(5, 3)); //5 of spades
        hand.add(new Card(1, 3));  //ace of spades
        hand.add(new Card(1, 3));  //ace of spades
        score=Blackjack.getScore(hand);
        System.out.println("Hand: 5AA");
        System.out.print("You said the score is: "+score);
        if (score == 17) System.out.println(" (Good job!)");
        else System.out.println(", but it is actually 17.  Try again");
        System.out.println();

        hand.clear();
        hand.add(new Card(11, 3)); //jack of spades
        hand.add(new Card(5, 3));  //5 of spades
        hand.add(new Card(2, 3));  //2 of spades
        hand.add(new Card(2, 0));  //2 of clubs
        hand.add(new Card(12, 3));  //3 of spades
        score=Blackjack.getScore(hand);
        System.out.println("Hand: J522Q");
        System.out.print("You said the score is: "+score);
        if (score == 29) System.out.println(" (Good job!)");
        else System.out.println(", but it is actually 29.  Try again");

    }
}