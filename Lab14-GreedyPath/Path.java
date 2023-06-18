import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;

public class Path
{
    private Point[] points;
    private double  minX, minY; //min X and Y values, for setting canvas scale
    private double  maxX, maxY; //maxes

    /** construct a path from a given file */
    public Path()
    {
        points = null;
        minY = minX = maxY = maxX = 0;
    }
    public Path(String fileName)
    {
        minX = minY = Integer.MAX_VALUE;
        maxX = maxY = 0;
        File file = new File(fileName);
        Scanner chopper = null;
        try {
            chopper = new Scanner(file);
        }
        catch (IOException e) { System.out.print(e); }
        int length = chopper.nextInt();
        chopper.nextLine();
        points = new Point[length];
        for (int i = 0; i < length; i++)
        {
            double x = chopper.nextDouble();
            double y = chopper.nextDouble();
            chopper.nextLine();
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            points[i] = new Point(x, y);
        }
    }

    /** returns the distance traveled going point to point, in order given in file */
    public double getDistance()
    {
        //TODO
        double distanceTraveled = 0;
        for (int i = 0; i < points.length - 1; i++)
        {
            distanceTraveled += points[i].getDistance(points[i + 1]);
        }
        return distanceTraveled; //replace
    }

    @Override
    public String toString()
    {
        String txt = "";
        for (Point p : points)
        {
            txt += p + "\n";
        }
        txt += "Total Distance: " + this.getDistance();
        return txt;
    }
    
    public double getMinX(){return minX;}
    public double getMinY(){return minY;}
    public double getMaxX(){return maxX;}
    public double getMaxY(){return maxY;}
    public int getNumPoints(){return points.length;}
    public Point getPoint(int index){return points[index];}
}
