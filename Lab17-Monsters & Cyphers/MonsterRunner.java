
//Name: 
import java.util.*;

public class MonsterRunner
{
    public static void main(String[] args)
    {
        Monster m1 = new Monster("Gorlock", 19, 867, 30);
        Monster m2 = new Monster(19, 1000, 27);
        Monster m3 = new Monster("Lurr", 19, 1000, 28);
        Monster m4 = new Monster();
        Monster m5 = new Monster();
        
        m2.setName("Bob");
        System.out.println(m1.equals(m2));
        System.out.println(m5.equals(m4));
        System.out.println(m1.compareTo(m2));
        System.out.println(m3.compareTo(m2));
        System.out.println(m4.compareTo(m5));
        
        ArrayList<Monster> monsters = new ArrayList<Monster>();
        monsters.add(m1);
        monsters.add(m2);
        monsters.add(m3);
        monsters.add(m4);
        monsters.add(m5);
        Collections.sort(monsters);
        System.out.println(monsters);
        
    }
}
