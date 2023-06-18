public abstract class Sprite
{
    private double x;      //the x-coordinate of the center of the sprite
    private double y;      //the y-coordinate of the center of the sprite
    private int    width;  //width of the sprite (for drawing)
    private int    height; //height of the sprite (for drawing)
    private String image;  //filename of the sprite's image

    public Sprite(double x, double y, int width, int height, String image)
    {
        this.x      = x;
        this.y      = y;
        this.width  = width;
        this.height = height;
        this.setImage(image);
    }

    /** draw the sprite to the screen */
    public void draw() {
        //draw based on sprite's size, so you don't have to manually scale images
        StdDraw.picture(this.getX(), this.getY(), this.getImage(), this.width, this.height);
    }

    /**
     * One step of the simulation - a Sprite does whatever a Sprite does (move around, etc.)
     * must be supplied with a reference to the world this sprite exists in
     */
    public abstract void step(World world);

    //-----------------Getters-------------------

    public double getX()      { return this.x;      }    
    public int    getWidth()  { return this.width;  }
    public double getY()      { return this.y;      }
    public int    getHeight() { return this.height; }
    public String getImage()  { return this.image;  }

    //-----------------Setters-------------------

    public void setX(double x)         { this.x      = x;      }    
    public void setY(double y)         { this.y      = y;      }
    public void setWidth(int width)    { this.width  = width;  }
    public void setHeight(int height)  { this.height = height; }
    public void setWH(int w, int h)    { this.width  = w; this.height = h; }    
    public void setImage(String image) { this.image  = image;  }
    
    public boolean collides(Sprite other)
    {
        double left = x - width / 2;
        double right = x + width / 2;
        double top = y + height / 2;
        double bottom = y - height / 2;
        
        double oleft = other.x - other.width / 2;
        double oright = other.x + other.width / 2;
        double otop = other.y + other.height / 2;
        double obottom = other.y - other.height / 2;
        
        boolean colR = right > oleft && left < oleft && bottom < obottom && top > obottom || right > oleft && left < oleft && bottom < otop && top > otop || right > oleft && left < oleft && bottom < otop && top > obottom;
        boolean colL = right > oright && left < oright && bottom < obottom && top > obottom || right > oright && left < oright && bottom < otop && top > otop || right > oleft && left < oleft && bottom < otop && top > obottom;
        boolean colT = top > otop && bottom < otop && right > oleft && left < oleft || top > otop && bottom < otop && right > oright && left < oright;
        boolean colB = top > obottom && bottom < obottom && right > oleft && left < oleft || top > obottom && bottom < obottom && right > oright && left < oright;
        
        if (colR || colL || colL || colB)
        {
            return true;
        }
        return false;
    }
}
