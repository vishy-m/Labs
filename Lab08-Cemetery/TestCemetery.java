
//Name: 

public class TestCemetery
{
    public static void main(String[] args)
    {
        Cemetery cemetery = new Cemetery("cemetery.txt");
        //cemetery.tombstoneInfo();
        System.out.println(cemetery.averageAgeByStreet("Little Carter Lane"));
    }
}
