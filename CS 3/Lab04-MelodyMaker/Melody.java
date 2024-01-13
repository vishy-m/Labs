import java.util.*;
public class Melody
{
   private Queue<Note> song;
   

   public Melody(Queue<Note> song)
   {
      this.song = song;
   }

   public Queue<Note> notes()
   {
      return null;
   }
   
   public Queue<Note> getNotes()
   {
      return song;
   }
   
   public String toString()
   {
      String str = "";
      int size = song.size();
      for (int i = 0; i < size; i++)
      {
         Note note = song.poll();
         str += note + "\n";
         song.offer(note);
      }
      
      return str;
   }
   
   public double getTotalDuration()
   {
      int size = song.size();
      double totalDuration = 0;
      boolean repeat = false;
      for (int i = 0; i < size; i++)
      {
         Note n = song.poll();
         if (!repeat)
         {
            if (!n.isRepeat())
               totalDuration += n.getDuration();
            else 
            {
               totalDuration += n.getDuration() * 2;
               repeat = true;
            }
         }
         else
         {
            if (!n.isRepeat())
               totalDuration += n.getDuration() * 2;
            else
            {
               totalDuration += n.getDuration() * 2;
               repeat = false;
            }
         }
         song.offer(n);
      }
      return totalDuration;
   }
   
   public void changeTempo(double factor)
   {
      int size = song.size();
      for (int i = 0; i < size; i++)
      {
         Note n = song.poll();
         n.setDuration(n.getDuration() * factor);
         song.offer(n);
      }
   }
   
   public void reverse()
   {
      Stack<Note> reverseNotes = new Stack<Note>();
      while (!song.isEmpty())
      {
         reverseNotes.push(song.poll());
      }
      while (!reverseNotes.isEmpty())
      {
         song.offer(reverseNotes.pop());
      }
   }
   
   public void append(Melody other)
   {
      Queue<Note> otherNotes = other.getNotes();
      while (!otherNotes.isEmpty())
      {
         song.offer(otherNotes.poll());
      }
   }
   
   public void play()
   {
      int size = song.size();
      boolean repeat = false;
      Queue<Note> repeatQueue = new LinkedList<Note>();
      for (int i = 0; i < size; i++)
      {
         Note n = song.poll();
         if (!repeat)
         {
            if (!n.isRepeat())
            {
               n.play();
            }
            else
            {
               repeat = true;
               n.play();
               repeatQueue.offer(n);
            }
         }
         else
         {
            if (!n.isRepeat())
            {
               n.play();
               repeatQueue.offer(n);
            }
            else
            {
               n.play();
               repeatQueue.offer(n);
               while (!repeatQueue.isEmpty())
               {
                  repeatQueue.poll().play();
               }
               repeat = false;
            }
         }
        
         song.offer(n);
      }
   }
   
}