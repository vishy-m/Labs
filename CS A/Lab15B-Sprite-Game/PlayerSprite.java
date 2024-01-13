//Name: 
import java.util.*;
import java.awt.*;
public class PlayerSprite extends ControllableSprite
{
    public int lives = 3;
    public int score = 0;
    private int steps = 0;
    private boolean hasCollided = false;
    public boolean isDead = false;
    private int numReset = 0;
    private int highScore = 0;

    public PlayerSprite(double x, double y, int width, int height, String image)
    {
        super(x, y, width, height, image);
    }

    public void step(World world)
    {
        super.step(world);
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.setFont(new Font("Berlin Sans FB", Font.BOLD, 16));
        if (lives <= 0)
        {
            isDead = true;
        }

        checkCollision();
        if (!isDead)
        {
            drawText();
            if (numReset != 0)
                drawHighScore(540, 580);
        }
        else
        {
            drawDeathScreen();
            checkReset();
        }
        
    }
    public void drawLives(int xc, int yc)
    {
        StdDraw.text(xc, yc, "Lives: " + lives);
    }

    public void drawScore(int xc, int yc)
    {
        StdDraw.text(xc, yc, "Score: " + score);
    }

    public void drawHighScore(int xc, int yc)
    {
        StdDraw.text(xc, yc, "Highscore: " + highScore);
    }

    public void hasCollided()
    {
        setImage("spaceship-damaged.png");
        hasCollided = true;
    }

    public void checkCollision()
    {
        if (hasCollided)
        {
            steps++;
            if (steps > 20)
            {
                setImage("spaceship.png");
                hasCollided = false;
                steps = 0;
            }
        }
    }

    public void remove()
    {
        shouldRemove = true;
    }

    public void drawText()
    {
        drawLives(30, 580);
        drawScore(550, 550);
    }

    public void drawDeathScreen()
    {
        StdDraw.text(300, 300, "GAME OVER");
        drawScore(300, 280);
        StdDraw.text(300, 220, "Press R to restart");
    }

    public void reset()
    {
        highScore = Math.max(highScore, score);
        isDead = false;
        hasCollided = false;
        steps = 0;
        lives = 3;
        score = 0;
        numReset++;
        TrackingSprite.reset();
    }

    public void checkReset()
    {
        if (StdDraw.isKeyPressed(82))
        {
            reset();
        }
    }
}

