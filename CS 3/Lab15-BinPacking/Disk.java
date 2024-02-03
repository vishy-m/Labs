import java.util.*;

public class Disk implements Comparable
{
   private static final int MAX_SIZE = 1000000;
   private static int numDisks = 0;
   
   private int diskSpace;
   private ArrayList<Integer> files;
   private int ID;
   
   public Disk()
   {
      initialize();
   }
   
   public Disk(int fileSize)
   {
      initialize();
      addFile(fileSize);
   }
   
   public void initialize()
   {
      files = new ArrayList<Integer>();
      ID = numDisks;
      numDisks++;
      diskSpace = MAX_SIZE;
   }
   
   public void addFile(int fileSize)
   {
      files.add(fileSize);
      diskSpace -= fileSize;
   }
   
   public boolean canAddFile(int fileSize)
   {
      return fileSize <= diskSpace;
   }
   
   public int getDiskSpace() { return diskSpace; }
   
   public int size()
   {
      int diskSize = 0;
      for (int i = 0; i < files.size(); i++)
      {
         diskSize += files.get(i);
      }
      return diskSize;
   }
   
   public String toString()
   {
      String space = "";
      int numChar = 0;
      int temp = diskSpace;
      
      while (temp > 0)
      {
         numChar++;
         temp = temp / 10;
      }
      
      int diff = 7 - numChar;
      for (int i = 0; i < diff; i++)
      {
         space += " ";
      }
      space += diskSpace;
   
      String str = ID + " " + space + ":";
      
      for (int i = 0; i < files.size(); i++)
      {
         str += " " + files.get(i);
      }
      
      return str;
   }
   
   public int compareTo(Object obj)
   {
      Disk other = (Disk) obj;
      if (diskSpace < other.diskSpace) return -1;
      if (diskSpace > other.diskSpace) return 1;
      return 0; 
   }
   
   public static int getMaxSize() { return MAX_SIZE; }
   
}