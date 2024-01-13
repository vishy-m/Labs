public class GemList 
{
      
   
   class Node
   {
      private Gem gem;
      private Node next;
      
      public Node()
      {
         gem = null;
         next = null;
      }
      
      public Node(Gem gem)
      {
         this.gem = gem;
         next = null;
      }
      
   }

   private Node head;
   private Node tail;
   private int size;
   
   public GemList()
   {
      head = null;
      tail = null;
      size = 0;
   }
   
   public GemList(Gem gem)
   {
      head = new Node(gem);
      tail = head;
      size = 1;
   }
   
   public int size()
   {
      return size;
   }
   
   public void draw(double y)
   {
      Node temp = head;
      for (int i = 0; i < size; i++)
      {
         temp.gem.draw(GemGame.indexToX(i), y);
         temp = temp.next;
      }
   }
   
   public String toString()
   {
      String ret = "";
      Node temp = head;
      for (int i = 0; i < size; i++)
      {
         ret += "" + temp.gem.getType().toString().toUpperCase();
         if (i < size - 1)
            ret += " -> ";
         temp = temp.next;
      }
      if (ret.equalsIgnoreCase(""))
      {
         ret += "<none>";
      }
      return ret;
   }
   
   public void insertBefore(Gem gem, int index)
   {
      if (index < 0) 
         return;
         
      Node temp = new Node(gem);
         
      if (size == 0)
      {
         head = temp;
         tail = head;
         size++;
         return;
      }
               
      if (index >= size)
      {
         tail.next = temp;
         tail = temp;
         size++;
         return;
      }
      
      size++;
   
      if (index == 0)
      {
         temp.next = head;
         head = temp;
         return;
      }
   
      Node current = head;
      for (int i = 0; i < index - 1; i++)
      {
         current = current.next;
      }
      
      temp.next = current.next;
      current.next = temp;
      
   }
   
   public int score()
   {
      
      if (size == 0) 
         return 0;
   
      int score = 0;
      
      Node temp = head;
      while (temp != null)
      {
      
         int cummulativePoints = temp.gem.getPoints();
         int numChain = 1;
         
         while (temp.next != null)
         {
            
               
            Gem g = temp.gem;
            Gem next = temp.next.gem;
            
            if (g.getType() != next.getType()) 
               break;
            
            cummulativePoints += next.getPoints();
            numChain++;
            
            temp = temp.next;
            
         }
         //while (temp.next != null);
         
         score += cummulativePoints * numChain;
         temp = temp.next;
      }
      
      return score;
   }
   
   
   
   
   public static void main(String [] args)
   {
      GemList list = new GemList();
      System.out.println(list);
      System.out.println("size = " + list.size() + ", score = " + list.score());
      list.draw(0.9);		
   		
      list.insertBefore(new Gem(GemType.BLUE, 10), 0);
      System.out.println("\n" + list);
      System.out.println("size = " + list.size() + ", score = " + list.score());
      list.draw(0.8);
   		
      list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
      System.out.println("\n" + list);
      System.out.println("size = " + list.size() + ", score = " + list.score());
      list.draw(0.7);
   		
      list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
      System.out.println("\n" + list);
      System.out.println("size = " + list.size() + ", score = " + list.score());
      list.draw(0.6);
   		
      list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
      System.out.println("\n" + list);
      System.out.println("size = " + list.size() + ", score = " + list.score());
      list.draw(0.5);
   		
      list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
      System.out.println("\n" + list);
      System.out.println("size = " + list.size() + ", score = " + list.score());
      list.draw(0.4);
   		
      list.insertBefore(new Gem(GemType.GREEN, 50), 2);
      System.out.println("\n" + list);
      System.out.println("size = " + list.size() + ", score = " + list.score());
      list.draw(0.3);		
   }
   

   	
}
