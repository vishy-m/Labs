public class Runner
{
   public static void main(String[] args) 
   {
   
   /* EXPECTED OUTPUT FROM RUNNING THIS RUNNER
   
       Heap toString: -1, 4, 35, 20, 8, 99, 76, 42
 
       initial state of the heap
       ..............................................................
                                       -1
                       4                              35
               20              8              99              76
           42      
       ..............................................................
       inserting 36 into the heap...
       ..............................................................
                                       -1
                       4                              35
               20              8              99              76
           42      36      
       ..............................................................
       inserting 3 into the heap...
       ..............................................................
                                       -1
                       3                              35
               20              4              99              76
           42      36      8      
       ..............................................................
       Pop min (new min at root) = -1
       ..............................................................
                                       3
                       4                              35
               20              8              99              76
           42      36      
       ..............................................................
       Peek min (shouldn't change) = 3
       ..............................................................
                                       3
                       4                              35
               20              8              99              76
           42      36      
       ..............................................................
       
       Popping all remaining elements should list all number in ascending order.
       3 4 8 20 35 36 42 76 99 
       Popping all remaining elements should list all number in ascending order.
       -1 0 1 2 3 4 5 6 7 8 
       Popping all remaining elements should list all in ascending (alpha) order.
       a b c d e f g 

   */

      MinHeap heap = new MinHeap();
   	
      //loading several numbers into the empty heap, one at a time
      int[] nums = {8, 42, 35, 4, -1, 99, 76, 20};        	
      for (int i = 0; i < nums.length; i++) 
         heap.insert(nums[i]); //inserting numbers one at a time
   	
      System.out.println("Heap toString: " + heap);
      System.out.println("\ninitial state of the heap");
      heap.display();
   	
      heap.insert(36); System.out.println("inserting 36 into the heap...");
      heap.display();
   	
      heap.insert(3); System.out.println("inserting 3 into the heap...");
      heap.display();
   	
      System.out.println("Pop min (new min at root) = " + heap.popMinimum());
      heap.display();
   
      System.out.println("Peek min (shouldn't change) = " + heap.peekMinimum());
      heap.display();         
      
      System.out.println("\nPopping all remaining elements should list all number in ascending order.");
      while (!heap.isEmpty()) 
         System.out.print(heap.popMinimum() + " ");         
      
      //Let's call the varArgs constructor, which should utilize an O(N) buildHeap method
      heap = new MinHeap(8, 2, 5, 4, -1, 3, 7, 0, 1, 6);     
              
      System.out.println("\nPopping all remaining elements should list all number in ascending order.");
      while (!heap.isEmpty()) 
         System.out.print(heap.popMinimum() + " "); 
         
      //Now let's test the generics
      MinHeapGeneric<String> genHeap1 = new MinHeapGeneric<>("e","f","c","a","g","b","d");           
      System.out.println("\nPopping all remaining elements should list all in ascending (alpha) order.");
      while (!genHeap1.isEmpty()) 
         System.out.print(genHeap1.popMinimum() + " ");       
   }
}
