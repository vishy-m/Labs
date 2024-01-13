import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CircleAnimations
{
    private ArrayList<Circle> circles; //the circles to animate
    private int               size;    //canvas width and height (will be square)
    private Random            rng;     //use to make random numbers

    /** create a drawing pane of a particular size */
    public CircleAnimations(int s) {
        circles = new ArrayList<>();
        size    = s;
        rng     = new Random();

        //don't mess with this
        StdDraw.setCanvasSize(size, size); //set up drawing canvas
        StdDraw.setXscale(0, size);        //<0, 0> is bottom left.  <size-1, size-1> is top right
        StdDraw.setYscale(0, size);
    }

    public void addCircles()
    {
        for (int i = 0; i < 3; i++)
        {
            circles.add(makeCircle());
            circles.get(i).draw();
        }
    }

    public void addCircles(int number)
    {
        for (int i = 0; i < number; i++)
        {
            circles.add(makeCircle());
            circles.get(i).draw();
        }
    }

    public void noOverlapping(int number)
    {
        for (int i = 0; i < number; i++)
        {
            Circle circ = makeCircle();
            if (i > 0)
            {
                while(checkOverlap(circ) == true)
                {
                    circ = makeCircle();
                }
            }
            circles.add(circ);
            circles.get(i).draw();
        }
    }

    public void movingCircles(int num, int frameLimit)
    {
        addCircles(num, true);
        for (int f = 0; f < frameLimit; f++)
        {
            StdDraw.clear();
            removeClicked();
            for (int i = 0; i < circles.size(); i++)
            {
                circles.get(i).update(size);
            }
            drawCircles();
            StdDraw.show(10);
        }
    }

    public void paint()
    {
        int mx = 0, my = 0;
        int dmx = 0, dmy = 0;
        boolean pressed = false;
        boolean keyPressed = false;
        System.out.println("Escape - will exit paint");
        System.out.println("Extra functions:");
        System.out.println("Backspace - will remove last circle in list"); 
        System.out.println("Number 1 = Black"); 
        System.out.println("Number 2 = Red"); 
        System.out.println("Number 3 = Orange"); 
        System.out.println("Number 4 = Yellow"); 
        System.out.println("Number 5 = Green"); 
        System.out.println("Number 6 = Blue"); 
        System.out.println("Number 7 = Random Color"); 
        Color color = Color.WHITE;
        Boolean randColor = true;
        int counter = 0;
        while (!StdDraw.isKeyPressed(27))
        {
            StdDraw.clear();
            //Colors
            if (StdDraw.isKeyPressed(49))
            {
                color = Color.BLACK;
                randColor = false;
            }
            else if (StdDraw.isKeyPressed(50))
            {
                color = Color.RED;
                randColor = false;
            }
            else if (StdDraw.isKeyPressed(51))
            {
                color = Color.ORANGE;
                randColor = false;
            }
            else if (StdDraw.isKeyPressed(52))
            {
                color = Color.YELLOW;
                randColor = false;
            }
            if (StdDraw.isKeyPressed(53))
            {
                color = Color.GREEN;
                randColor = false;
            }
            else if (StdDraw.isKeyPressed(54))
            {
                color = Color.BLUE;
                randColor = false;
            }
            else if (StdDraw.isKeyPressed(55))
            {
                randColor = true;
            }
            
            if (StdDraw.isMousePressed() && !pressed)
            {
                mx = (int)StdDraw.mouseX();
                my = (int)StdDraw.mouseY();
                pressed = true;
            }
            else if (pressed && ! StdDraw.isMousePressed())
            {
                dmx = (int)StdDraw.mouseX();
                dmy = (int)StdDraw.mouseY();
                int hyp = (int) Math.sqrt(Math.pow(dmx - mx, 2) + Math.pow(dmy - my, 2));
                int rad = (int) Math.abs(hyp) / 2;
                int tx = mx + ((dmx - mx) / 2);
                int ty = my + ((dmy - my) / 2);
                if (randColor)
                    color = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
                circles.add(new Circle(tx, ty, rad, color));
                pressed = false;
            }
            
            if (StdDraw.isKeyPressed(8) && !keyPressed && !pressed && circles.size() > 0)
            {
                circles.remove(circles.size() - 1);
                keyPressed = true;
            }
            
            if (!StdDraw.isKeyPressed(8))
            {
                keyPressed = false;
            }
            drawCircles();
            StdDraw.show(10);
            counter++;
        }
        System.out.println("Program successfully exited");
    }

    public void removeClicked()
    {
        if (StdDraw.isMousePressed())
        {
            int mx = (int)StdDraw.mouseX();
            int my = (int)StdDraw.mouseY();
            for (int i = circles.size() - 1; i > -1; i--)
            {
                if (circles.get(i).overlaps(mx, my))
                    circles.remove(i);
            }
        }
    }

    public void drawCircles()
    {
        for (int i = 0; i < circles.size(); i++)
        {
            circles.get(i).draw();
        }
    }

    public void addCircles(int number, Boolean t)
    {
        for (int i = 0; i < number; i++)
        {
            circles.add(makeCircle(true));
            circles.get(i).draw();
        }
    }

    public Circle makeCircle()
    {
        int randomRadius = rng.nextInt(100);
        int randomX = rng.nextInt(size - (randomRadius * 2)) + randomRadius;
        int randomY = rng.nextInt(size - (randomRadius * 2)) + randomRadius;
        Color randomColor = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
        return new Circle(randomX, randomY, randomRadius, randomColor);
    }

    public Circle makeCircle(boolean t)
    {
        int randomRadius = rng.nextInt(100);
        int randomX = rng.nextInt(size - (randomRadius * 2)) + randomRadius;
        int randomY = rng.nextInt(size - (randomRadius * 2)) + randomRadius;
        int randomDX = rng.nextInt(5) + 1;
        int randomDY = rng.nextInt(5) + 1;
        Color randomColor = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
        return new Circle(randomX, randomY, randomRadius, randomColor, randomDX, randomDY);
    }

    public boolean checkOverlap(Circle circ)
    {
        for (int i = 0; i < circles.size(); i++)
        {
            if (circ.overlaps(circles.get(i)))
                return true;
        }
        return false;
    }

}
