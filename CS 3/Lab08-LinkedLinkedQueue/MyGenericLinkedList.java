import java.util.*;
public class MyGenericLinkedList<T>
{
   class ListNode
   {
      T val;
      ListNode next;
   
      public ListNode(T val) 
      {
         this.val = val;
         next = null;
      }
   
   //@override
      public String toString() 
      {
         return "" + this.val;
      }
   
   }

   ListNode head;
   ListNode tail;
   int size;
   
   public MyGenericLinkedList()
   {
      head = null;
      tail = null;
      size = 0;
   }
   public MyGenericLinkedList(T val)
   {
      head = new ListNode(val);
      tail = head;
      size = 1;
   }
   
   public MyGenericLinkedList(T... vals)
   {
      for (int i = 0; i < vals.length; i++)
      {
         add(vals[i]);
         size++;
      }
   }
   
   public void add(T val)
   {
      if (head == null)
      {
         head = new ListNode(val);
         tail = head;
      }
      else
      {
         tail.next = new ListNode(val);
         if (size == 0)
         {
            head.next = tail;
         }
         tail = tail.next;
      }
      size++;
   }
   
   public boolean contains(T target)
   {
      if (indexOf(target) != -1) 
         return true;
      return false; 
   }
   
   public T get(int index)
   {
      if (index < 0 || index >= size || isEmpty()) throw new IndexOutOfBoundsException();
      ListNode temp = head;
      for (int i = 0; i < index; i++)
      {
         temp = temp.next;
      }
      return temp.val;
   }
   
   public int indexOf(T target)
   {
      ListNode temp = head;
      int i = 0;
      while (temp != null)
      {
         if (temp.val == target) 
            return i;
         temp = temp.next;
         i++;
      } 
      return -1;
   }
   
   public void set(T newVal, int index)
   {
      if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
      ListNode temp = head;
      for (int i = 0; i < index; i++)
      {
         temp = temp.next;
      }
      temp.val = newVal;
   }
   
   public int size()
   {
      return size;
   }
   
   public int sizeRecursive()
   {
      return sizeRecursive(head);
   }
   
   public int sizeRecursive(ListNode temp)
   {
      if (temp == null) 
         return 0;
      else
         return 1 + sizeRecursive(temp.next);
   }
   
   public boolean isEmpty()
   {
      return size == 0;
   }
   
   public T remove(int index)
   {
      if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
      if (index == 0)
      {
         if (head == null) System.out.println("head is null: size: " + size + " " + head + " head next: " + head.next);
         if (tail == null) System.out.println("Tail is null: size: " + size);
         T valHead = head.val;
         head = head.next;
         size--;
         return valHead;
      }
      ListNode temp = head;
      for (int i = 0; i < index - 1; i++)
      {
         temp = temp.next;
      }
      ListNode newNode = temp.next;
      temp.next = newNode.next;
      if (index == size - 1)
      {
         tail = temp;
      }
      newNode.next = null;
      size--;
      return newNode.val;
   }
   
   public void add(T newVal, int index)
   {
      if (index < 0 || index > size) throw new IndexOutOfBoundsException();
      
      size++;
      if (index == 0)
      {
         if (isEmpty())
         {
            head = new ListNode(newVal);
            return;
         }
         ListNode newNode = new ListNode(newVal);
         newNode.next = head;
         head = newNode;
         return;
      }
      
      ListNode temp = head;
      for (int i = 0; i < index - 1; i++)
      {
         temp = temp.next;
      }
      ListNode newNode = new ListNode(newVal);
      newNode.next = temp.next;
      temp.next = newNode;
      if (index == size - 1)
      {
         tail = newNode;
      }
   }
   
   public String toString()
   {
      String s = "[";
      ListNode temp = head;
      while (temp != null && temp.next != null)
      {
         s += "" + temp.val + ", ";
         temp = temp.next;
      }
      if (temp != null)
         s += temp.val;
      s += "]";
      return s;
   }
   
}

