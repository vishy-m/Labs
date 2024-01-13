//v2.0
import java.util.*;
public class Tester08Cemetery extends TestGUI.TestData{ 
    public static void main (String[] args) {        
        if (VERSION_NUM < 2.172)
            System.out.println("This test script requires TestGUI version 2.172 or higher.\nPlease download a newer version of TestGUI.java.");
        else
            new TestGUI();     
    }


    public static void runTests() {  //Your test sequence must be within a method called runTests()
        //WRITE ALL YOUR TEST CASES IN HERE       
        setTimeOutSec(3);

        srcButton("ArrayListProbs, Person, Book, Bookstore, Tombstone, Cemetery");
        message("Best Possible Score: 22 Green, 0 Yellow, 0 Red");
        header("Various test of ArrayListProbs");        
        Object o = makeObject("ArrayListProbs", null);    
        testMethod(o, "makeListAndPrint", new Object[]{10, 5});
        message("The random numbers from the test above cannot be verified (because they are random.) But the test below should work.");

        testMethod(o, "makeListAndPrint", new Object[]{
                4, 1    
            }, "[1, 1, 1, 1]");

        message("Input list for test below = [1, 2, 3, 4]");
        testMethod(o, "addOne", new Object[]{
                new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4))    
            }, "[2, 3, 4, 5]");

        message("Input list for test below = [0, 10, 100, 1000]");
        testMethod(o, "addOne", new Object[]{
                new ArrayList<Integer>(Arrays.asList(0, 10, 100, 1000))    
            }, "[1, 11, 101, 1001]");

        message("Input list for test below = [2, 4, -5, 3]");
        testMethod(o, "minToFront", new Object[]{
                new ArrayList<Integer>(Arrays.asList(2, 4, -5, 3))    
            }, "[-5, 2, 4, -5, 3]");

        message("Input list for test below = [9, 2, 3, 2, 0, 9]");
        testMethod(o, "minToFront", new Object[]{
                new ArrayList<Integer>(Arrays.asList(9, 2, 3, 2, 0, 9))    
            }, "[0, 9, 2, 3, 2, 0, 9]");

        message("Input list for test below = [to, to, be, be, be, be, or]");
        testMethod(o, "removeDupes", new Object[]{
                new ArrayList<String>(Arrays.asList("to", "to", "be", "be", "be", "be", "or"))   
            }, "[to, be, or]");

        message("Input list for test below = [aa, aa, aa, bb, cc, cc, dd]");
        testMethod(o, "removeDupes", new Object[]{
                new ArrayList<String>(Arrays.asList("aa", "aa", "aa", "bb", "cc", "cc", "dd"))   
            }, "[aa, bb, cc, dd]");

        message("Input list for test below = [1, 2, 3, 4]");
        testMethod(o, "swapPairs", new Object[]{
                new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4))    
            }, "[2, 1, 4, 3]");

        message("Input list for test below = [5, 7, 4, 6, 6, 5, 0]");
        testMethod(o, "swapPairs", new Object[]{
                new ArrayList<Integer>(Arrays.asList(5, 7, 4, 6, 6, 5, 0))    
            }, "[7, 5, 6, 4, 5, 6, 0]");

        message("Input list for test below = [wow, hello, world, omg]");
        testMethod(o, "removeLenN", new Object[]{
                new ArrayList<String>(Arrays.asList("wow", "hello", "world", "omg")), 3  
            }, "[hello, world]");

        message("Input list for test below = [aa, salsa, bb, tastes, cc, good]");
        testMethod(o, "removeLenN", new Object[]{
                new ArrayList<String>(Arrays.asList("aa", "salsa", "bb", "tastes", "cc", "good")), 2  
            }, "[salsa, tastes, good]");

        header("ArrayList<Person> tests");    
        Object p1 = makeObject("Person", new Object[]{ "Rita", 150 });
        Object p2 = makeObject("Person", new Object[]{ "Ron", 100 });
        Object p3 = makeObject("Person", new Object[]{ "Ronda", 120 });
        Object p4 = makeObject("Person", new Object[]{ "Roger", 99 });

        Class c = getClassFromName("Person");        
        if (c == null)
            message("Unable to test dumbestPerson() because of missing Person class", false);
        else {
            testMethod(o, "dumbestPersonLocation", new Object[]{
                    new ArrayList<>(Arrays.asList(c.cast(p1), c.cast(p2), c.cast(p3)))
                }, "1");
            testMethod(o, "dumbestPersonLocation", new Object[]{
                    new ArrayList<>(Arrays.asList(c.cast(p1), c.cast(p2), c.cast(p3), c.cast(p4)))
                }, "3");
        }

        header("ArrayList<Book> tests");    
        Object b1 = makeObject("Book", new Object[]{ "Book 1", "Author 1", 12.99 });
        Object b2 = makeObject("Book", new Object[]{ "Book 2", "Author 2", 15.99 });
        Object b3 = makeObject("Book", new Object[]{ "Book 3", "Author 3", 9.99 });
        Object b4 = makeObject("Book", new Object[]{ "Book 1", "Author 1", 12.99 });
        Object b5 = makeObject("Book", new Object[]{ "Salsa for Dummies", "Mr. McCoy", 22.11 });
        Object b6 = makeObject("Book", new Object[]{ "Book 3", "Author 3", 9.99 });

        c = getClassFromName("Book");
        if (c == null)
            message("Unable to test highestPricedBook() because of missing Book class", false);
        else {
            testMethod(o, "highestPricedBook", new Object[]{
                    new ArrayList<>(Arrays.asList(c.cast(b1), c.cast(b2), c.cast(b3)))
                }, "Book 2, by Author 2. Cost $15.99");
            testMethod(o, "highestPricedBook", new Object[]{
                    new ArrayList<>(Arrays.asList(c.cast(b1), c.cast(b2), c.cast(b5), c.cast(b4)))
                }, "Salsa for Dummies, by Mr. McCoy. Cost $22.11");
        }

        if (c == null)
            message("Unable to test banBook() because of missing Book class", false);
        else {
            testMethod(o, "banBook", new Object[]{
                    new ArrayList<>(Arrays.asList(c.cast(b1), c.cast(b2), c.cast(b3))), "Book 1"
                }, "[Book 2, by Author 2. Cost $15.99, Book 3, by Author 3. Cost $9.99]");
            testMethod(o, "banBook", new Object[]{
                    new ArrayList<>(Arrays.asList(c.cast(b3), c.cast(b3), c.cast(b6), c.cast(b5), c.cast(b3))), "Book 3"
                }, "[Salsa for Dummies, by Mr. McCoy. Cost $22.11]");
        }

        header("Bookstore tests");    
        Object bs = makeObject("Bookstore", null);  

        testMethod(bs, "addBook", new Object[]{b1});
        testMethod(bs, "addBook", new Object[]{b2});
        testMethod(bs, "addBook", new Object[]{b3});
        testMethod(o, "bookstoreValue", new Object[]{bs}, "38.97");
        testMethod(bs, "addBook", new Object[]{b5});
        testMethod(o, "bookstoreValue", new Object[]{bs}, "61.08");

        header("Cemetery"); 
        o = makeObject("Cemetery", new Object[] {"cemetery.txt"});
        testMethod(o, "averageAgeByStreet", new Object[] {"Little Carter Lane"}, "26.9");
        testMethod(o, "averageAgeByStreet", new Object[] {"Green Arbour"}, "27.2");
        testMethod(o, "averageAgeByStreet", new Object[] {"Crane Court"}, "23.5");
    }    
}