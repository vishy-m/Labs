
//Name: 
import java.util.*;
import java.lang.*;
public class GreedyPath extends Path
{
    private Point[] gPoints;
    
    public GreedyPath(String fileName)
    {
        super(fileName);
        double smallestDistance = Integer.MAX_VALUE;
        int index = 0;
        gPoints = new Point[getNumPoints()];
        gPoints[0] = super.getPoint(0);
        gPoints[0].setVisited(true);
        for (int i = 1; i < getNumPoints(); i++)
        {
            for(int r = 1; r < getNumPoints(); r++)
            {
                Point p = super.getPoint(r);
                if (p.getVisited())
                {
                    continue;
                }
                double distance = gPoints[i - 1].getDistance(p);
                if (smallestDistance > distance)
                {
                    index = r;
                    smallestDistance = distance;
                }
            }
            gPoints[i] = super.getPoint(index);
            gPoints[i].setVisited(true);
            smallestDistance = Integer.MAX_VALUE;
        }
    }
    public double getDistance()
    {
        double distanceTraveled = 0;
        for (int i = 0; i < gPoints.length - 1; i++)
        {
            distanceTraveled += gPoints[i].getDistance(gPoints[i + 1]);
        }
        return distanceTraveled;
    }
    public Point getPoint(int i){return gPoints[i];}
    
    @Override
    public String toString()
    {
        String txt = "";
        for (Point p : gPoints)
        {
            txt += p + "\n";
        }
        txt += "Total Distance: " + this.getDistance();
        return txt;
    }
}
