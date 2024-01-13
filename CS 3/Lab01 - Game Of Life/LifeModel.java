import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.Timer;

public class LifeModel implements ActionListener
{

	/*
	 *  This is the Model component.
	 */

   private static int SIZE = 60;
   private LifeCell[][] grid;   	
   private LifeView myView;
   private Timer timer;
   private String file;

	/** Construct a new model using a particular file */
   public LifeModel(LifeView view, String fileName) 
   {       
      int r, c;
      file = fileName;
      grid = new LifeCell[SIZE][SIZE];
      for ( r = 0; r < SIZE; r++ )
         for ( c = 0; c < SIZE; c++ )
            grid[r][c] = new LifeCell();
   
      if ( fileName == null ) //use random population
      {                                           
         for ( r = 0; r < SIZE; r++ )
         {
            for ( c = 0; c < SIZE; c++ )
            {
               if ( Math.random() > 0.85) //15% chance of a cell starting alive
                  grid[r][c].setAliveNow(true);
            }
         }
      }
      else
      {                 
         Scanner input = null;
         try {      
            input = new Scanner(new File(fileName));
         } catch (IOException e) { System.out.println("bad filename"); }
         int numInitialCells = input.nextInt();
         for (int count=0; count<numInitialCells; count++)
         {
            r = input.nextInt();
            c = input.nextInt();
            grid[r][c].setAliveNow(true);
         }
         input.close();
      }
      
      myView = view;
      myView.updateView(grid);
   
   }

	/** Constructor a randomized model */
   public LifeModel(LifeView view) throws IOException
   {
      this(view, null);
   }

	/** pause the simulation (the pause button in the GUI */
   public void pause()
   {
      timer.stop();
   }
	
	/** resume the simulation (the pause button in the GUI */
   public void resume()
   {
      timer.restart();
   }
	
	/** run the simulation (the pause button in the GUI */
   public void run()
   {
      timer = new Timer(50, this);
      timer.setCoalesce(true);
      timer.start();
   }
   
   public void reset()
   {
      LifeModel model = new LifeModel(myView, file);
      grid = model.getGrid();
   }

	/** called each time timer fires */
   public void actionPerformed(ActionEvent e)
   {
      oneGeneration();
      myView.updateView(grid);
   }

	/** main logic method for updating the state of the grid / simulation */
   private void oneGeneration()
   {
   	/* 
   	 * student code here 
   	 */
       
      for (int r = 0; r < grid.length; r++)
      {
         for (int c = 0; c < grid[r].length; c++)
         {
         
            int numOccNeighbours = 0;
            
            for (int i = r - 1; i < r + 2; i++)
            {
               for (int j = c - 1; j < c + 2; j++)
               {
                  
                  if (i == r && j == c) 
                     continue;
                  if (i < 0 || i >= grid.length || j < 0 || j >= grid[r].length) 
                     continue;
                  if (!grid[i][j].isAliveNow()) 
                     continue;
                  
                  numOccNeighbours++;
                  
               }
            } 
            
            if (numOccNeighbours != 2 && numOccNeighbours != 3)
            {
               //System.out.println("Num Neigh: " + numOccNeighbours); 
               grid[r][c].setAliveNext(false);
               continue;
            }
         
            if (grid[r][c].isAliveNow())
            {
               grid[r][c].setAliveNext(true);
               continue;
            }
         
            if (numOccNeighbours == 3)
            {
               grid[r][c].setAliveNext(true);
               continue;
            }
            
            grid[r][c].setAliveNext(false);
         
         }
      }
       
      updateGrid();
       
   }
   
   private void updateGrid()
   {
      for (int r = 0; r < grid.length; r++)
      {
         for (int c = 0; c < grid[r].length; c++)
         {
            grid[r][c].setAliveNow(grid[r][c].isAliveNext());
         }
      }
   }
   
   private LifeCell[][] getGrid()
   { 
      return grid;
   }
   
   
}

