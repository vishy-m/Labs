
//Name: 
import java.util.*;
import java.io.*;

public class Runner
{
    public static void main(String[] args)
    {
        final int SIZE = 600;
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(SIZE, SIZE);
        StdDraw.setXscale(-1, 1);
        StdDraw.setYscale(-1, 1);
        StarChart sc = new StarChart("stars.txt");
        sc.drawStars();
        sc.drawConstellation("BigDipper.txt");
        sc.drawConstellation("Bootes.txt");
        sc.drawConstellation("Cassiopeia.txt");
        sc.drawConstellation("Cygnet.txt");
        sc.drawConstellation("Gemini.txt");
        sc.drawConstellation("Hydra.txt");
        sc.drawConstellation("UrsaMajor.txt");
        sc.drawConstellation("UrsaMinor.txt");

        //starChart.printStarDetails();
    }
}
