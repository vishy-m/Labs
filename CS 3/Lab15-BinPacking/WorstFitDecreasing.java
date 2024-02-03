import java.util.*;
import java.io.*;

public class WorstFitDecreasing
{
   private Queue<Disk> disks;
   private Queue<Disk> tempDisks;
   private Queue<Integer> files;
   
   public WorstFitDecreasing()
   {
      this("input20.txt");
   }
   
   public WorstFitDecreasing(String fileName)
   {
      disks = new PriorityQueue<Disk>(Collections.reverseOrder());
      disks.offer(new Disk());
      
      tempDisks = new LinkedList<Disk>();
      files = new PriorityQueue<Integer>(Collections.reverseOrder());
      
      File file = new File(fileName);
      Scanner input = null;
      
      try 
      {
         input = new Scanner(file);
      }
      catch (Exception e)
      {
         return;      
      }
      
      while (input.hasNextLine())
      {
         String strNum = input.nextLine().trim();
         int num = Integer.parseInt(strNum);
         files.offer(num);      
      }
      addDisks();
   }
   
   public void addDisks()
   {
   
      int size = files.size();
      
      for (int i = 0; i < size; i++)
      {
         Disk currentDisk = disks.poll();
         
         int file = files.poll();
         
         if (currentDisk.canAddFile(file))
         {
            currentDisk.addFile(file);
         }
         else
         {
            Disk newDisk = new Disk(file);
            disks.offer(newDisk);
         }
         
         disks.offer(currentDisk);
       }

   }
   
   public double size()
   {
     int size = disks.size();
     int totalSpace = 0;
     for (int i = 0; i < size; i++)
     {
         Disk currentDisk = disks.poll();
         totalSpace += currentDisk.size();
         tempDisks.offer(currentDisk);
     }
     for (int i = 0; i < size; i++)
     {
         disks.offer(tempDisks.poll());
     }
     return totalSpace / (double) Disk.getMaxSize();
      
   }
   
   public String toString()
   {
      int size = disks.size();
      String ret = "Total size = " + size() + " GB\n";
      ret += "Disks req'd = " + size + "\n";
      
      
      
      for (int i = 0; i < size; i++)
      {
         Disk currentDisk = disks.poll();
         ret += "\t " + currentDisk.toString() + "\n";
         tempDisks.offer(currentDisk);
      }
      
      for (int i = 0; i < size; i++)
      {
         disks.offer(tempDisks.poll());
      }
      
      return ret;
      
   }
   
   public static void main(String[] args)
   {
      WorstFitDecreasing bin = new WorstFitDecreasing("input20.txt");
      System.out.println(bin);
   }
   
}