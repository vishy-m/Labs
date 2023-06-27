
//Name: 
import java.util.*;
public class TrackingSprite extends MobileSprite
{
    private PlayerSprite player;
    public static int numTrackers = 0;

    public TrackingSprite(double x, double y, int width, int height, String image, PlayerSprite player)
    {
        super(x, y, width, height, image, 0, 0);
        this.player = player;
        numTrackers++;
    }

    public void step(World world)
    {
        super.step(world);
        track();
        BulletTracker bt = world.getBT();
        ArrayList<BulletSprite> bullets = bt.getBullets();
        for (int i = 0; i < bullets.size(); i++)
        {
            BulletSprite bullet = bullets.get(i);
            if (collides(bullet))
            {
                shouldRemove = true;
                player.score += 10;
                bullet.shouldRemove = true;
            }
        }
        if (collides(player))
        {
            shouldRemove = true;
            player.lives--;
            player.hasCollided();
        }
    }

    public void track()
    {
        double dx = player.getX() - getX();
        double dy = player.getY() - getY();
        double hyp = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        double speed = Math.min(hyp, Math.max(3, numTrackers / 5));
        setVX(dx / (hyp / speed));
        setVY(dy / (hyp / speed));
    }
    
    public static void reset()
    {
        numTrackers = 0;
    }
    
    public static int getNumTrackers()
    {
        return numTrackers;
    }
}
