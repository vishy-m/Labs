
//Name: 
import java.util.*;
public class Bookstore
{
    private ArrayList<Book> inventory = new ArrayList<Book>();
    
    public void addBook(Book b){inventory.add(b);}
    public int numBooks(){return inventory.size();}
    public Book getBook(int index)
    {
        if (index < 0 || index > inventory.size() - 1)
            return null;
        return inventory.get(index);
    }
}

