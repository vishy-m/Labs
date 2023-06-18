
//Name: 
import java.util.*;
public class ArrayListProbsRunner
{

    public static void main(String[] args)
    {
        ArrayListProbs a = new ArrayListProbs(); //use this object to call the methods

        a.makeListAndPrint(12, 50); //make 12 random items, from 1 to 50
        System.out.println(a.addOne(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4))));
        System.out.println(a.minToFront(new ArrayList<Integer>(Arrays.asList(2, 4, -5, 3))));
        System.out.println(a.removeDupes(new ArrayList<String>(Arrays.asList("to", "to", "be", "be", "be", "be", "or"))));
        System.out.println(a.swapPairs(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4))));
        System.out.println(a.removeLenN(new ArrayList<String>(Arrays.asList("wow", "hello", "world", "omg")), 3));
        System.out.println(a.dumbestPersonLocation(new ArrayList<Person>(Arrays.asList(new Person("Rita", 150), 
                        new Person("Ron", 100), new Person("Ronda", 120))))); 
        System.out.println(a.highestPricedBook(new ArrayList<Book>(Arrays.asList(new Book("Book 1", "Author 1", 12.99), 
                        new Book("Book 2", "Author 2", 15.99), new Book("Book 3", "Author 3", 9.99)))).toString());
        System.out.println(a.banBook(new ArrayList<Book>(Arrays.asList(new Book("Book 1", "Author 1", 12.99), 
                        new Book("Book 2", "Author 2", 15.99), new Book("Book 3", "Author 3", 9.99))), "Book 1"));
        Bookstore store = new Bookstore();
        store.addBook(new Book("Book 1", "Author 1", 12.99)); 
        store.addBook(new Book("Book 2", "Author 2", 15.99));
        store.addBook(new Book("Book 3", "Author 3", 9.99));
        System.out.println(a.bookstoreValue(store));

    }
}
