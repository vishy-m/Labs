import java.util.*;

public class MyBST
{
   public BSTNode root;
   public int size;
   
   public MyBST()
   {
      root = null;
   }
   
   public MyBST(BSTNode node) { root = node; }
   
   public int size() { 
      return size; }
   
   public void insert(Integer n) { root = insert(root, n); }
     
   public BSTNode insert(BSTNode current, Integer n)
   {
      if (current == null) 
      {
         current = new BSTNode(n);
         size++;
      }
         
      if (n < current.val)
      {
         current.left = insert(current.left, n);
      }
      else if (n > current.val)
      {
         current.right = insert(current.right, n);
      }
         
      return current;
   }
   
   public boolean contains(Integer n) { 
      return contains(root, n); }
   
   public boolean contains(BSTNode current, Integer n)
   {
      if (current == null) 
         return false;
      
      if (current.val == n) 
         return true;
      
      if (n < current.val) 
         return contains(current.left, n);
      
      else 
         return contains(current.right, n);
      
   }
   
   public int getMax() { 
      return getMax(root); }
   
   public int getMax(BSTNode current)
   {
      if (current == null) 
         return 0;
      
      if (current.right == null)
      {
         return current.val;
      }
      
      return getMax(current.right); 
   }
   
   public int getMin() { 
      return getMin(root); }
   
   public int getMin(BSTNode current)
   {
      if (current == null) 
         return 0;
      
      if (current.left == null)
      {
         return current.val;
      }
      
      return getMin(current.left); 
   }
   
   public void delete(Integer n) { delete(root, n, null, true); }
   
   public void delete(BSTNode current, int n, BSTNode previous, boolean wentRight)
   {
   
      if (current == null) 
         return;
      
      if (current.val == n)
      {
         size--;
         
         if (size == 0)
         {
            current = null;
            root = null;
            return;
         }
         
         if (current.right == null && current.left == null) 
         {
            if (previous != null)
            {
               if (wentRight)
                  previous.right = null;
               else
                  previous.left = null;
            }
            current = null;
            
            return;
         }
         
         if (current.right != null)
         {
            current.val = deleteReplace(current.right, true, current, true);
            return;
         }
         
         current.val = deleteReplace(current.left, false, current, false);
      }
      
      if (n < current.val)
      {
         delete(current.left, n, current, false);
      }
      else if (n > current.val)
      {
         delete(current.right, n, current, true);
      }
      
      
      return;
   }
   
   public int deleteReplace(BSTNode current, boolean goRight, BSTNode previous, boolean wentRight)
   {
      if (current == null) 
         return 0;
      
      int val = current.val;
      
      if (goRight)
      {
      
         if (current.left == null)
         {
            if (current.right != null)
            {
               if (wentRight)
                  previous.right = current.right;
               else
                  previous.left = current.right;
            }
            else
               previous.right = null;
            current = null;
            return val;
         }
         
         return deleteReplace(current.left, goRight, current, false);
      }
      
      if (current.right == null)
      {
         if (current.left != null)
         {
            if (wentRight)
               previous.right = current.left;
            else
               previous.left = current.left;
         }
         else
            previous.left = null;
         current = null;
         return val;
      }
      
      return deleteReplace(current.right, goRight, current, true);
      
   }
   
   public void inOrder() { inOrder(root); System.out.println(); };
   
   public void inOrder(BSTNode current)
   {
      if (current == null) 
         return;
   
      inOrder(current.left);
      System.out.print(current.val + " ");
      inOrder(current.right);
   }
   
   public void print() { print(root, 0); }
   
   public void print(BSTNode current, int depth)
   {
      if (current == null) 
         return;
      
      print(current.right, depth + 1);
      
      for (int i = 0; i < depth * 4; i++)
         System.out.print(" ");
      
      System.out.println("" + current.val);
      print(current.left, depth + 1);
   }
   
   
   private class BSTNode 
   {
      public Integer val;
      public BSTNode left, right;
   
      public BSTNode(Integer val) 
      {
         this.val = val;
         left = right = null;
      }
   
      @Override
         public String toString() 
      { 
         return "" + this.val;
      }
      
   }

}