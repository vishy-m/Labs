import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class NBodySimulation
{
    private Body[] bodies;    //stores all the bodies in the simulation
    private int    numBodies; //number of bodies in this simulation
    private double uRadius;   //radius of the universe
    private String fileName;  //file providing the input

    public NBodySimulation(String nameOfFile)
    {
        fileName = nameOfFile;
        File file = new File(fileName);
        Scanner chopper = null;
        try 
        {
            chopper = new Scanner(file);
        }
        catch (IOException e)
        {
            System.out.println("error");
          }
        numBodies = chopper.nextInt();
        chopper.nextLine();
        uRadius = chopper.nextDouble();
        bodies = new Body[numBodies];
        for (int i = 0; i < numBodies; i++)
        {
            double x = chopper.nextDouble();
            double y = chopper.nextDouble();
            double xV = chopper.nextDouble();
            double yV = chopper.nextDouble();
            double m = chopper.nextDouble();
            String fN = chopper.next();
            chopper.nextLine();
            bodies[i] = new Body(x, y, xV, yV, m, fN);
        }

        initCanvas(); //don't move, should be the last line of the constructor
    }

    /** initialize the drawing canvas */
    private void initCanvas()
    {
        StdDraw.setScale(-uRadius, uRadius); //set canvas size / scale
        StdDraw.picture(0, 0, "starfield.jpg"); //paint background

        //below is a for-each loop, which we will cover in the next lab
        //more info is available in the powerpoints, for the curious
        for (Body body : bodies)
            body.draw();
    }

    /**
     * run the n-bodies simulation
     * @param T total time to run the simulation, in seconds
     * @param dt time step, in seconds
     */
    public void run(double T, double dt)
    {
        for (int i = 0; dt <= T; dt++)
        {
            for (int j = 0; j < bodies.length; j++)
            {
                bodies[j].setNetForce(bodies);
                bodies[j].update(dt);
            }
            StdDraw.picture(0, 0, "starfield.jpg");
            for (int j = 0; j < bodies.length; j++)
            {
                bodies[j].draw();
            }
            StdDraw.show(10);
        }
    }
}
