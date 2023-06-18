
//Name: 
import java.util.*;
public class BulletTracker
{
    private ArrayList<BulletSprite> bullets;
    private PlayerSprite player;
    private boolean oldPressed = StdDraw.isMousePressed();
    private boolean autoFire = false;

    public BulletTracker(Sprite player)
    {
        bullets = new ArrayList<BulletSprite>();
        this.player = (PlayerSprite)player;
    }

    public void step(World world)
    {
        if (StdDraw.isMousePressed() && !oldPressed)
        {
            double dx = (StdDraw.mouseX() - player.getX()) / 10.0;
            double dy = (StdDraw.mouseY() - player.getY()) / 10.0;
            double hyp = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
            double xv = dx / (hyp / 10.0);
            double yv = dy / (hyp / 10.0);
            bullets.add(new BulletSprite(player.getX(), player.getY(), 30, 20, "asteroid.png",xv,yv));
        }
        stepAll(world);
        drawAll();
        if (!player.isDead)
            oldPressed = StdDraw.isMousePressed();
        else
            oldPressed = false;
        remove();
    }

    public ArrayList<BulletSprite> getBullets()
    {
        return bullets;
    }

    public int getBulletsSize()
    {
        return bullets.size();
    }

    public BulletSprite getBullet(int i)
    {
        return bullets.get(i);
    }

    public void stepAll(World world)
    {
        for (BulletSprite b : bullets)
        {
            b.step(world);
        }
    }

    public void drawAll()
    {
        for (BulletSprite b : bullets)
            b.draw();
    }
    
    public void remove()
    {
        for (int i = bullets.size() - 1; i >= 0; i--)
        {
            if (bullets.get(i).shouldRemove)
                bullets.remove(i);
        }
    }
}
