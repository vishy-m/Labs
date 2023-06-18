public class CardTester
{
	public static void main(String[] args) {
		test();
	}
	
    public static void test()
    {
        Card fourOfSpades = new Card(4, 3);
        
        int rank1 = fourOfSpades.getRank();
        System.out.println(rank1); // prints 4
        
        int suit1 = fourOfSpades.getSuit();
        System.out.println(suit1); // prints 3
        
        Card twoOfDiamonds = new Card(2, 1);
        
        int rank2 = twoOfDiamonds.getRank();
        System.out.println(rank2); // prints 2
        
        int suit2 = twoOfDiamonds.getSuit();
        System.out.println(suit2); // prints 1
        
        if (rank1 == 4 && suit1 == 3 && rank2 == 2 && suit2 == 1)
        {
            System.out.println("Your Card class works correctly.");
            System.out.println("Woah!");
        }
        else
        {
            System.out.println("Your Card class does not work correctly yet.");
            System.out.println("You can fix it!");
        }
    }
}