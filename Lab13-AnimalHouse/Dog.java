
//Name: 

public class Dog extends Animal
{
    private boolean goodDoggy;
    
    public Dog(String n, int by, boolean gd)
    {
        super(n, by);
        goodDoggy = gd;
    }
    
    public String toString()
    {
        String gbT = "I'm a good doggy.";
        if(!goodDoggy)
            gbT = "";
        return super.toString() + "\n" + gbT;
    }
}
