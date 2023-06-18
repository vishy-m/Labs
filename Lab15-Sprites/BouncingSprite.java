
//Name: 

public class BouncingSprite extends MobileSprite
{
    
    public BouncingSprite(double x, double y, int width, int height, String image, double vx, double vy)
    {
        super(x, y, width, height, image, vx, vy);
    }
    
    public void step(World world)
    {
        super.step(world);
        
        if (getX() + getWidth() / 2 > world.getWidth() || getX() - getWidth() / 2 < 0)
        {
            super.setVX(super.getVX() * -1);
        }
        
        if (getY() + getHeight() / 2 > world.getHeight() || getY() - getHeight() / 2 < 0)
        {
            setVY(getVY() * -1);
        }
    }
}
