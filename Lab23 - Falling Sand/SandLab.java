import java.awt.*;
import java.util.*;

public class SandLab {
    //add constants for particle types here
    public static final int EMPTY = 0;
    public static final int WATER = 1;
    public static final int METAL = 2;
    public static final int SAND = 3;
    public static final int FOUNTAIN = 4;
    public static final int FULLCLEAR = 5;
    public static final int DRAIN = 6;

    public static int numParticleTypes = DRAIN + 1;

    //do not add any more fields!
    private int[][] grid;
    private SandDisplay display; //SandDisplay is the GUI class

    public SandLab(int numRows, int numCols) {
        String[] names = new String[numParticleTypes];

        names[EMPTY] = "Empty";
        names[METAL] = "Metal";
        names[SAND] = "Sand";
        names[WATER] = "Water";
        names[FOUNTAIN] = "Fountain";
        names[FULLCLEAR] = "Clear";
        names[DRAIN] = "Drain";

        display = new SandDisplay("Falling Sand", numRows, numCols, names);
        grid = new int[numRows][numCols];
    }

    /** called when the user clicks on a location using the given tool */
    private void locationClicked(int row, int col, int tool) {
        //TODO
        grid[row][col] = tool;
    }

    /** copies each element of grid into the display */
    public void updateDisplay() {
        //TODO
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[r].length; c++)
            {
                if (grid[r][c] == METAL) display.setColor(r, c, Color.GRAY);
                else if (grid[r][c] == SAND) display.setColor(r, c, Color.YELLOW);
                else if (grid[r][c] == WATER) display.setColor(r, c, Color.BLUE);
                else if (grid[r][c] == FOUNTAIN) display.setColor(r, c, Color.GREEN);
                else if (grid[r][c] == DRAIN) display.setColor(r, c, Color.RED);
                else if (grid[r][c] == FULLCLEAR) display.setColor(r, c, Color.WHITE);
                else display.setColor(r, c, Color.BLACK);
            }
        }
    }

    /** called repeatedly, causes one random particle to maybe do something */
    public void step()  {
        //TODO
        Random random = new Random();
        int newR = random.nextInt(grid.length);
        int newC = random.nextInt(grid[0].length);
        checkSandPhysics(newR, newC);
        checkWaterPhysics(newR, newC, random);
        if (grid[newR][newC] == FULLCLEAR)
        {
            for (int r = 0; r < grid.length; r++)
            {
                for (int c = 0; c < grid[r].length; c++)
                {
                    grid[r][c] = EMPTY;
                }
            }
        }
        if (grid[newR][newC] == FOUNTAIN)
        {
            if (checkDown(newR, newC) && grid[newR + 1][newC] == EMPTY)
            {
                grid[newR + 1][newC] = WATER;
            }
        }
        if (grid[newR][newC] == DRAIN)
        {
            if (checkUp(newR, newC) && grid[newR - 1][newC] == WATER)
            {
                grid[newR - 1][newC] = EMPTY;
            }
            if (checkDown(newR, newC) && grid[newR + 1][newC] == WATER)
            {
                grid[newR + 1][newC] = EMPTY;
            }
            if (checkLeft(newR, newC) && grid[newR][newC - 1] == WATER)
            {
                grid[newR][newC - 1] = EMPTY;
            }
            if (checkRight(newR, newC) && grid[newR][newC + 1] == WATER)
            {
                grid[newR][newC + 1] = EMPTY;
            }
        }
    }

    public void checkSandPhysics(int newR, int newC)
    {
        if (grid[newR][newC] == SAND)
        {
            if (checkDown(newR, newC))
            moveDirection('d', newR, newC);
        }
    }

    public boolean checkUp(int newR, int newC)
    {
        int r = newR - 1;
        return r >= 0&& grid[r][newC] < METAL;
    }

    public boolean checkDown(int newR, int newC)
    {
        int r = newR + 1;
        return r < grid.length && grid[r][newC] < METAL;
    }

    public boolean checkRight(int newR, int newC)
    {
        int c = newC + 1;
        return c < grid[0].length && grid[newR][c] < METAL;
    }

    public boolean checkLeft(int newR, int newC)
    {
        int c = newC - 1;
        return c >= 0 && grid[newR][c] < METAL;
    }

    public void moveDirection(char c, int newR, int newC)
    {
        switch (c)
        {
            case 'u':
            if (checkUp(newR, newC)) 
            {
                int temp = grid[newR - 1][newC];
                grid[newR - 1][newC] = grid[newR][newC];
                grid[newR][newC] = temp;
            }
            break;

            case 'd':
            if (checkDown(newR, newC))
            {
                int temp = grid[newR + 1][newC];
                grid[newR + 1][newC] = grid[newR][newC];
                grid[newR][newC] = temp;
            }
            break;

            case 'l':
            if (checkLeft(newR, newC))
            {
                int temp = grid[newR][newC - 1];
                grid[newR][newC - 1] = grid[newR][newC];
                grid[newR][newC] = temp;
            }
            break;

            case 'r':
            if (checkRight(newR, newC))
            {
                int temp = grid[newR][newC + 1];
                grid[newR][newC + 1] = grid[newR][newC];
                grid[newR][newC] = temp;
            }
            break;
        }
    }

    public void checkWaterPhysics(int newR, int newC, Random random)
    {
        if (grid[newR][newC] == WATER)
        {

            int n = random.nextInt(3) - 1;
            if (n == 0) moveDirection('d', newR, newC);
            if (n == -1) moveDirection('l', newR, newC);
            if (n == 1) moveDirection('r', newR, newC);
        }
    }

    //do not modify!
    public void run() {
        while (true) {      
            for (int i = 0; i < display.getSpeed(); i++)
                step();
            updateDisplay();
            display.repaint();
            display.pause(1);  //wait for redrawing and for mouse
            int[] mouseLoc = display.getMouseLocation();
            if (mouseLoc != null)  //test if mouse clicked
                locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
        }
    }
}
