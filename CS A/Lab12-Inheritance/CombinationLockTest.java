
//Name: 

public class CombinationLockTest
{
    public static void main(String[] args)
    {
        CombinationLock myLock = new CombinationLock("11-22-33");
        System.out.println("The current combination is " + myLock.getCombination());
        System.out.println();
        myLock.open();
        System.out.println(myLock.toString());       
        System.out.println();

        System.out.println("Changing combination to 55-66-77.");
        myLock.setCombination("55-66-77");
        System.out.println("Closing the lock");
        myLock.close();
        System.out.println();

        myLock.open();
        System.out.println(myLock.toString());
        System.out.println("Closing the lock");
        myLock.close();

        System.out.println();
        System.out.println("Type an incorrect combination this time.");

        myLock.open();
        System.out.println(myLock.toString());
        myLock.close(); 
    }
}
