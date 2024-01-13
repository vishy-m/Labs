public class FireModel
{
   public static int SIZE = 47;
   private FireCell[][] myGrid;
   private FireView myView;
   private boolean reachedTown;

   public FireModel(FireView view)
   {
      reachedTown = false;
      myGrid = new FireCell[SIZE][SIZE];
      int setNum = 0;
      for (int r=0; r<SIZE; r++)
      {
         for (int c=0; c<SIZE; c++)
         {
            myGrid[r][c] = new FireCell();
         }
      }
      myView = view;
      myView.updateView(myGrid);
   }

   public void fireRecurse(int r, int c)
   {
      boolean rOutOfBounds = r < 0 || r >= SIZE;
      boolean cOutOfBounds = c < 0 || c >= SIZE;
      if (rOutOfBounds || cOutOfBounds)
      {
         return;
      }
      
      if (myGrid[r][c].getStatus() != FireCell.GREEN)
      {
         return;
      }
      
      myGrid[r][c].setStatus(FireCell.BURNING);
      
      if (r == 0)
      {
         reachedTown = true;
         return;
      }
      
      //Vertically
      fireRecurse(r + 1, c);
      fireRecurse(r - 1, c);
      
      //Horizontally
      fireRecurse(r, c + 1);
      fireRecurse(r, c - 1);
      
   
   }

   public void solve()
   {
      for (int i = 0; i < SIZE; i++)
      {
         fireRecurse(SIZE - 1, i);
      }
      
      if (reachedTown)
         System.out.println("Onett is in trouble!");
      else
         System.out.println("Onett is safe.");
      
      myView.updateView(myGrid);
   }

}
