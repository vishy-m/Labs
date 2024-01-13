public class NRunner
{
   public static void main(String[] args)
   {
      NumberList test = new NumberList();
      
      test.add(44);
      test.add(23);
      test.add(17);
      test.add(6);
      test.add(8);
      System.out.println(test.get(5));
      
      //[44, 23, 17, 6, 8]
   }
}