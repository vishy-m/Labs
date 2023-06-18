
//Name: 

public class ControllableSprite extends MobileSprite
{
    public ControllableSprite(double x, double y, int width, int height, String image)
    {
        super(x, y, width, height, image, 5, 5);
    }
    
    public void step(World world)
    {
        if (StdDraw.isKeyPressed(37) && getX() - getWidth() / 2 > 0)
        {
            setX(getX() - getVX());
        }
        if (StdDraw.isKeyPressed(39) && getX() + getWidth() / 2 < world.getWidth())
        {
            setX(getX() + getVX());
        }
        if (StdDraw.isKeyPressed(38) && getY() + getHeight() / 2 < world.getHeight())
        {
            setY(getY() + getVY());
        }
        if (StdDraw.isKeyPressed(40) && getY() - getHeight() / 2 > 0)
        {
            setY(getY() - getVY());
        }
    }
}
