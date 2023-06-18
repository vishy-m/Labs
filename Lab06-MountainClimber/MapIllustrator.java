import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MapIllustrator
{
    private int[][] grid;
    private int     rows;
    private int     cols;

    public MapIllustrator(String filename)
    {
        //TODO
        File file = new File(filename);
        Scanner chopper = null;
        try 
        {
            chopper = new Scanner(file);
        }
        catch (IOException e)
        {
            System.out.println("error " + e);
        }
        rows = chopper.nextInt();
        cols = chopper.nextInt();
        grid = new int[rows][cols];
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[r].length; c++)
            {
                grid[r][c] = chopper.nextInt();
            }
        }
        //System.out.println(grid[123][456] + " " + grid[479][479]);
        initCanvas(); //don't move, should be last line of constructor, initialize drawing window
    }

    public int getRows()
    {
        return -1; 
    }

    public int getCols()
    {
        return -1;
    }

    /** initialize the drawing window */
    private void initCanvas() 
    {
        StdDraw.setCanvasSize(cols, rows);
        StdDraw.setXscale(0, cols);
        StdDraw.setYscale(0, rows);
        StdDraw.enableDoubleBuffering();
    }

    /** @return the min value in the entire grid */
    public int findMin()
    {
        //TODO
        int min = grid[0][0];
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[r].length - 1; c++)
                if (min > grid[r][c])
                    min = grid[r][c];
        return min;
    }

    /** @return the max value in the entire grid */
    public int findMax()
    {
        //TODO
        int max = grid[0][0];
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[r].length - 1; c++)
                if (max < grid[r][c])
                    max = grid[r][c];
        return max;
    }

    /**
     * Draws the grid (map)
     * Colors should be grayscale values 0-255, scaled based on min/max values in grid
     */
    public void drawMap()
    {
        //TODO
        int min = findMin();
        int max = findMax();
        double diff = max - min;
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[r].length; c++)
            {
                int color = (int)(((grid[r][c] - min) / diff) * 255.0);
                StdDraw.setPenColor(color, color, color); 
                StdDraw.filledRectangle(c, grid.length - 1 - r, 0.5, 0.5);
            }
        }
    }

    /**
     * Find/draw a greedy path from West-to-East, starting at given row.
     * Choose a forward step out of 3 possible forward locations, using greedy method described in assignment.
     * @return the total change in elevation traveled from West-to-East
     */
    public int drawPath(int row)
    {
        //TODO
        StdDraw.filledRectangle(0, grid.length - 1 - row, 0.5, 0.5);
        int col = 1;
        int elevationChange = 0;
        int space = 0;
        for (int c = 1; c < cols; c++, col = c)
        {
            space = grid[row][c - 1];
            int forward = Math.abs(grid[row][c] - space);
            int up = Integer.MAX_VALUE;
            int down = Integer.MAX_VALUE;
            if (row - 1 >= 0)
                up = Math.abs(grid[row - 1][c] - space);
            if (row + 1 <= 479)
                down = Math.abs(grid[row + 1][c] - space);
            
            if (forward <= up && forward <= down)
                elevationChange += forward;
            else if (down <= up)
            {
                row += 1;
                elevationChange += down;
            }
            else
            {
                row -= 1;
                elevationChange += up;
            }

            StdDraw.filledRectangle(c, grid.length - 1 - row, 0.5, 0.5);    
        }
        return elevationChange;
    }

    /** @return the index of the starting row for the lowest-elevation-change path in the entire grid. */
    public int getIndexOfLowestPath()
    {   
        //TODO
        int lowestPath = drawPath(0);
        int indexOfRow = 0;
        for (int r = 1; r < grid.length; r++)
        {
            int path = drawPath(r);
            if (lowestPath > path)
            {
                lowestPath = path;
                indexOfRow = r;
            }
        }
        return indexOfRow;
    }
}