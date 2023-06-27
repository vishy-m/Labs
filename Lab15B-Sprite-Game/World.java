import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.awt.*;

public class World
{
    private List<Sprite> sprites;
    private int          width;
    private int          height;
    private BulletTracker bt;
    private int count = 0;
    private PlayerSprite player;
    Random random = new Random();
    Sprite canvas;

    /** construct a world 600x600 */
    public World() {
        this(600, 600);
    }

    public World(int h, int w)
    {
        height = h;
        width  = w;

        sprites = new ArrayList<>();

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.clear(Color.BLACK);
    }

    public World(int h, int w, Sprite player)
    {
        height = h;
        width  = w;

        sprites = new ArrayList<>();

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.clear(Color.BLACK);
        bt = new BulletTracker(player);
    }

    /** add a sprite to the simulation */
    public void add(Sprite sprite)
    {
        this.sprites.add(sprite);
    }

    public void remove()
    {
        for (int i = sprites.size() - 1; i > -1; i--)
        {
            if (sprites.get(i).getStatus())
            {
                sprites.remove(i);
            }
        }

    }

    /** ask all sprites in simulation to update themselves */
    public void stepAll()
    {

        for (int i = 0; i < sprites.size(); i++)
            this.sprites.get(i).step(this);
        bt.step(this);
        remove();
        count++;
        int spawnRate = Math.max(60, 180 - TrackingSprite.getNumTrackers() * 2);
        if (count % spawnRate == 0 && !player.isDead)
        {
            int w = 30;
            int h = 20;
            double rx = random.nextInt(801) - 100;
            double ry = random.nextInt(801) - 100;
            while (canvas.collides(rx, ry, w, h))
            {
                rx = random.nextInt(801) - 100;
                ry = random.nextInt(801) - 100;
            }
            TrackingSprite ts = new TrackingSprite(rx, ry, w, h, "spaceship-green.png", player);
            add(ts);
        }
    }

    /** get the width of the world */
    public int getWidth()
    {
        return width;
    }

    /** get the height of the world */
    public int getHeight()
    {
        return height;
    }

    /** get the number of sprites in the simulation currently */
    public int getNumSprites()
    {
        return sprites.size();
    }

    /** get the sprite at the given index */
    public Sprite getSprite(int index)
    {
        return sprites.get(index);
    }

    /** run the simulation, i.e. the main game loop */
    public void run()
    {
        StdDraw.enableDoubleBuffering();
        while (true)
        {
            this.stepAll();
            this.drawAll();
            StdDraw.show(); 
            StdDraw.pause(10);
            StdDraw.clear(Color.BLACK);
        }
    }

    /** draw all sprites in the simulation at their current positions */
    public void drawAll() {
        for (Sprite sprite : this.sprites)
            sprite.draw();
    }

    /**
     * This static main method is used to test the 
     * creation of your world and adding various sprites.
     */
    public static void main(String[] args)
    {
        PlayerSprite player = new PlayerSprite(200, 200, 30, 20, "spaceship.png");
        World world = new World(600, 600,player);
        Sprite canvas = new StationarySprite(300, 300, 600, 600, "square.png");
        //You can create new sprites here and add them to the world
        world.add(player);
        world.setPlayer(player);
        world.setCanvas(canvas); 
        world.run();
    }

    public BulletTracker getBT()
    {
        return bt;
    }

    public void setPlayer(PlayerSprite player)
    {
        this.player = player;
    }

    public void setCanvas(Sprite canvas)
    {
        this.canvas = canvas;
    }
}
