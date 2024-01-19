public class Runner 
{

  //  Comment out sections you haven't finished so you can test as you go.
  //  Expected output is shown at the bottom of this file.

   public static void main(String[] args) 
   {
      MyBST a = new MyBST();
   
      a.insert(3); a.insert(8); a.insert(1);  a.insert(4);  a.insert(0);  
      a.insert(2); a.insert(9); a.insert(11); a.insert(5); a.insert(5);
      
         // After you finish the insert methods, utilize the debugger to see what your tree looks like 
         // JGrasp will draw it for you if you drag object a out into its own window!!
   	
      System.out.println("Size of tree: " + a.size()); //9
   
      System.out.println("\nCheck if Node with value 4 exists:   " + a.contains(4)); //true
      System.out.println("Check if Node with value -1 exists:  " + a.contains(-1));   //false
   	   
      System.out.println("\nMin value: " + a.getMin());
      System.out.println("Max value: "   + a.getMax());
   
      System.out.println("\nOriginal Tree: ");
      a.print();
   	
      System.out.println("\nIn-order traversal: ");
      a.inOrder();
   	
      System.out.println("\n\nDelete node that doesn't exist (shouldn't change): ");
      a.delete(10);
      a.print();
   	
      System.out.println("\nDelete leaf node (value 2): ");
      a.delete(2);
      a.print();
   	
      System.out.println("\nDelete node (value 1) with one child: ");
      a.delete(1);
      a.print();
   	
      System.out.println("\nDelete node (value 8) with two children: ");
      a.delete(8);
      a.print();
   	
      MyBST b = new MyBST();
      System.out.println("\n\nThe tree from the print method example: ");
      b.insert(5); b.insert(2); b.insert(6); b.insert(1); b.insert(3); b.insert(9);
      b.print();         
   }
}         
  
/*  OUTPUT SHOULD LOOK LIKE THIS
   
   Size of tree: 9
   
   Check if Node with value 4 exists:   true
   Check if Node with value -1 exists:  false
   
   Min value: 0
   Max value: 11
   
   Original Tree: 
            11
        9
    8
            5
        4
   3
        2
    1
        0
   
   In-order traversal: 
   0 1 2 3 4 5 8 9 11
   
   Delete node that doesn't exist (shouldn't change): 
            11
        9
    8
            5
        4
   3
        2
    1
        0
   
   Delete leaf node (value 2): 
            11
        9
    8
            5
        4
   3
    1
        0
   
   Delete node (value 1) with one child: 
            11
        9
    8
            5
        4
   3
    0
   
   Delete node (value 8) with two children: 
        11
    9
            5
        4
   3
    0
   
   
   The tree from the print method example: 
        9
    6
   5
        3
    2
        1
      
*/