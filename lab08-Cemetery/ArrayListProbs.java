
//Name: Vishruth M
import java.util.*;

public class ArrayListProbs
{
    public void makeListAndPrint(int num, int limit)
    {
        List<Integer> numList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < num; i++)
            numList.add(random.nextInt(limit) + 1);
        System.out.println(numList);
    }
    
    public ArrayList<Integer> addOne(ArrayList<Integer> list)
    {
        for (int i = 0; i < list.size(); i++)
            list.set(i, list.get(i) + 1);
        return list;
    }
    
    public ArrayList<Integer> minToFront(ArrayList<Integer> list)
    {
        int min = 0;
        for (int i = 0; i < list.size() - 1; i++)
            min = Math.min(list.get(i), list.get(i + 1));
        list.add(0, min);
        return list;
    }
    
    public ArrayList<String> removeDupes(ArrayList<String> list)
    {
        for (int i = list.size() - 1; i > 0; i--)
            if (list.get(i) == list.get(i - 1))
            {
                list.remove(i);
            }
        return list;
    }
    
    public ArrayList<Integer> swapPairs(ArrayList<Integer> list)
    {
        for (int i = 0; i < list.size() - 1; i++)
        {
            int num = list.get(i);
            list.remove(i);
            i++;
            list.add(i, num);
        }
        return list;
    }
    
    public ArrayList<String> removeLenN(ArrayList<String> list, int n)
    {
        for (int i = 0; i < list.size(); i++)
            if (list.get(i).length() == n)
                list.remove(i);
        return list;
    }
    
    public int dumbestPersonLocation(ArrayList<Person> list)
    {
        int p = -1;
        for (int i = 0; i < list.size() - 1; i++)
        {
            if (Math.min(list.get(i).getIQ(), list.get(i + 1).getIQ()) == list.get(i).getIQ())
                p = i; 
            else if (Math.min(list.get(i).getIQ(), list.get(i + 1).getIQ()) == list.get(i + 1).getIQ())
                p = i + 1;
        }
            
        return p;
    }
    
    public Book highestPricedBook(ArrayList<Book> list)
    {
        Book b = null;
        for (int i = 0; i < list.size() - 1; i++)
        {
            double price = Math.max(list.get(i).getPrice(), list.get(i + 1).getPrice());
            if (price == list.get(i).getPrice())
                b = list.get(i);
            else
                b = list.get(i + 1);
        }
        return b;
    }
    
    public ArrayList<Book> banBook(ArrayList<Book> list, String badBookName)
    {
        for (int i = list.size() - 1; i > -1; i--)
            if (list.get(i).getTitle().equals(badBookName))
                list.remove(i);
        return list;
    }
    
    public double bookstoreValue(Bookstore store)
    {
        double sum = 0;
        for (int i = 0; i < store.numBooks(); i++)
            sum += store.getBook(i).getPrice();
        return sum;
    }
}
