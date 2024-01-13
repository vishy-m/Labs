public class NumberList
{
   private Integer[] list;
   private int size;
   
   public NumberList()
   {
      list = new Integer[2];
      size = 0;
   }
   
   public NumberList(int s)
   {
      list = new Integer[s];
      size = 0;
   }
   
   public int size()
   {
      return size;
   }
   
   public Boolean isEmpty()
   {
      return size == 0;
   }
   
   public String toString()
   {
      String str = "[";
      for (int i = 0; i < size; i++)
      {
         if (i == 0) str += list[i];
         else str += ", " + list[i];
      }
      str += "]";
      return str;
   }
   
   public void doubleCapacity()
   {
      Integer[] temp = new Integer[(size + 1) * 2];
      for (int i = 0; i < list.length; i++)
      {
         temp[i] = list[i];
      }
      list = temp;
   }
   
   public void add(int pos, int num)
   {
      checkDoubleCapacity(pos);
      
      for (int i = size - 1; i > pos - 1; i--)
      {
         int n = list[i];
         list[i + 1] = n;
      }
      list[pos] = num;
      size++;
   }
   
   public void add(int num)
   {
      checkDoubleCapacity(size);
      list[size] = num;
      size++;
   }
   
   public int get(int pos)
   {
      checkDoubleCapacity(pos + 1);
      return list[pos];
   }
   
   public int set(int index, int num)
   {
      checkDoubleCapacity(index + 1);
      int replacedNum = list[index];
      list[index] = num;
      return replacedNum;
   }
   
   public int remove(int pos)
   {
      checkDoubleCapacity(pos + 1);
      int removedNum = list[pos];
      for (int i = pos + 1; i < size; i++)
      {
         int n = list[i];
         list[i - 1] = n;
      }
      size--;
      return removedNum;
   }
   
   public void checkDoubleCapacity(int pos)
   {
      
      if (pos > size || pos < 0) throw new IndexOutOfBoundsException();
      
      if (size + 1 >= list.length || size >= list.length) doubleCapacity();
   }
   
}
