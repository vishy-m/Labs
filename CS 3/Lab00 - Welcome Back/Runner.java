public class Runner
{
   public static void main(String[] args)
   {
      WelcomeBack test = new WelcomeBack();
      System.out.println(test.getMiddle("hell"));
      
      System.out.println(test.sumNumbers(5).toString());
      System.out.println(test.sumDigits(234));
      System.out.println(test.keepSummingDigits(29));
      
      int[] a = {1, 2, 3, 4, 1};
      int[] b = {9, 0, 4, 3, 4, 1};
      System.out.println(test.getIntersection(a, b));
      
      String[] words = {"a", "b", "hello", "hi", "yo", "I"};
      System.out.println(test.mapLengths(words));
      
      System.out.println(test.sumWithoutCarry(861, 450));
      
   }
}