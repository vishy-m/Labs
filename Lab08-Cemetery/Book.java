
//Name: 
import java.util.*;
public class Book
{
    private String title, author;
    private double price;
    public Book(String t, String a, double p)
    {
        title = t;
        author = a;
        price = p;
    }
    
    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public double getPrice(){return price;}
    
    public String toString()
    {
        return title + ", by " + author + ". Cost $" + price;
    }
}
