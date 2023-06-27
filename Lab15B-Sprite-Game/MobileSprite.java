
//Name: Vishruth M
public class MobileSprite extends Sprite
{
    private double vx;
    private double vy;
    
    public MobileSprite (double x, double y, int width, int height, String image, double vx, double vy)
    {
        super(x, y, width, height, image);
        this.vx = vx;
        this.vy = vy;
    }
    
    public void step(World world)
    {
        super.setX(super.getX() + vx);
        super.setY(super.getY() + vy);
    }
    
    public double getVX(){return vx;}
    public double getVY(){return vy;}
    
    public void setVX(double vx){this.vx = vx;}
    public void setVY(double vy){this.vy = vy;}
    
    
    
}
