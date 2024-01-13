
//Name: 

public class BulletSprite extends MobileSprite
{
    public BulletSprite(double x, double y, int width, int height, String image, double vx, double vy)
    {
        super(x, y, width, height, image, vx, vy);
    }
    
    public void step(World world)
    {
        super.step(world);
        if (getX() > world.getWidth() || getX() < 0 || getY() > world.getHeight() || getY() < 0)
        {
            shouldRemove = false;
        }
    }
}
