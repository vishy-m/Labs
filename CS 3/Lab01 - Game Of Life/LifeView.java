import java.awt.*;
import javax.swing.*;
import java.util.*;

/** The view (graphical) component */
public class LifeView extends JPanel
{
	private static final long serialVersionUID = 1L;
	private static int SIZE = 60;
   private static Random random = new Random();

	/** store a reference to the current state of the grid */
    private LifeCell[][] grid;
    private int randomColorTimer = 0;

    public LifeView()
    {
        grid = new LifeCell[SIZE][SIZE];
    }

    /** entry point from the model, requests grid be redisplayed */
    public void updateView( LifeCell[][] mg )
    {
        grid = mg;
        repaint();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int testWidth = getWidth() / (SIZE+1);
        int testHeight = getHeight() / (SIZE+1);
        // keep each life cell square
        int boxSize = Math.min(testHeight, testWidth);

        for ( int r = 0; r < SIZE; r++ )
        {
            for (int c = 0; c < SIZE; c++ )
            {
                if (grid[r][c] != null)
                {
                    if ( grid[r][c].isAliveNow() )
                    {
                        g.setColor( Color.BLUE );
                        if (randomColorTimer % 2 != 0)
                        {
                           float hue = random.nextFloat();
                           float saturation = 0.7f;
                           float luminance = 0.9f;
                           Color color = Color.getHSBColor(hue, saturation, luminance);
                           g.setColor(color);
                        }
                    }
                    else
                        g.setColor( new Color(235,235,255) );

                    g.fillRect( (c+1)*boxSize, (r+1)* boxSize, boxSize-2, boxSize-2);
                }
            }
        }
    }
    
   public void randomColorTick()
   {
      randomColorTimer++;
   }
}
