
//Name: 
import java.util.*;
import java.io.*;
import java.awt.*;
public class StarChart
{
    private ArrayList<Star> stars = new ArrayList<Star>();
    HashMap <String, Star> map = new HashMap<>();

    public StarChart(String fileName)
    {
        File file = new File(fileName);
        Scanner chopper = null;
        try {
            chopper = new Scanner(file);
        }
        catch (IOException e) { System.out.print(e); }

        while (chopper.hasNextLine())
        {
            String[] info = chopper.nextLine().split(" ");
            if (info.length == 6)
                addStar(info, false);
            else
                addStar(info, true);
        }
    }

    public void drawStars()
    {
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(Color.WHITE);
        for (int i = 0; i < stars.size(); i++)
        {
            double radius = 1.0 / (100.0 * (stars.get(i).getMag() + 2.0));
            StdDraw.filledCircle(stars.get(i).getX(), stars.get(i).getY(), radius);
        }
        StdDraw.show();
    }

    public void drawConstellation(String fileName)
    {
        File file = new File(fileName);
        Scanner chopper = null;
        try {
            chopper = new Scanner(file);
        }
        catch (IOException e) { System.out.print(e); }

        StdDraw.setPenColor(Color.YELLOW);
        while (chopper.hasNextLine())
        {
            String[] info = chopper.nextLine().split(",");
            double x0, y0, x1, y1;
            x0 = map.get(info[0]).getX();
            y0 = map.get(info[0]).getY();
            x1 = map.get(info[1]).getX();
            y1 = map.get(info[1]).getY();
            StdDraw.line(x0, y0, x1, y1);
        }
        StdDraw.show();
    }

    public void addStar(String[] info, boolean hasName)
    {
        if (!hasName)
        {
            double x = Double.parseDouble(info[0]);
            double y = Double.parseDouble(info[1]);
            double magnitude = Double.parseDouble(info[4]);
            stars.add(new Star(x, y, magnitude, null));
        }
        else
        {
            double x = Double.parseDouble(info[0]);
            double y = Double.parseDouble(info[1]);
            double magnitude = Double.parseDouble(info[4]);
            String name = "";
            for (int i = 6; i < info.length; i++)
            {
                name += info[i] + " ";
            }
            name = name.trim();
            stars.add(new Star(x, y, magnitude, name));
            String[] parts = name.split("; ");
            for (int i = 0; i < parts.length; i++)
            {
                map.put(parts[i], stars.get(stars.size() - 1)); 
            }
        }
    }

    public void printStarDetails()
    {
        for (int i = 0; i < stars.size(); i++)
        {
            System.out.println(stars.get(i));
        }
    }
}
