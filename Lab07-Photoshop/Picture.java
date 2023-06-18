import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

import java.util.*;

/**
 * A class that represents a picture made up of a rectangle of {@link Pixel}s
 */
public class Picture {

    /** The 2D array of pixels that comprise this picture */
    private Pixel[][] pixels;

    /**
     * Creates a Picture from an image file in the "images" directory
     * @param picture The name of the file to load
     */
    public Picture(String picture) {
        File file = new File("./images/"+picture);
        BufferedImage image;
        if (!file.exists()) throw new RuntimeException("No picture at the location "+file.getPath()+"!");
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        pixels = new Pixel[image.getHeight()][image.getWidth()];
        for (int y = 0; y<pixels.length; y++) {
            for (int x = 0; x<pixels[y].length; x++) {
                int rgb = image.getRGB(x, y);
                /*
                 * For the curious - BufferedImage saves an image's RGB info into a hexadecimal integer
                 * The below extracts the individual values using bit-shifting and bit-wise ANDing with all 1's
                 */
                pixels[y][x] = new Pixel((rgb>>16)&0xff, (rgb>>8)&0xff, rgb&0xff);
            }
        }
    }

    /**
     * Creates a solid-color Picture of a given color, width, and height
     * @param red The red value of the color
     * @param green The green value of the color
     * @param blue The blue value of the color
     * @param height The height of the Picture
     * @param width The width of the Picture
     */
    public Picture(int red, int green, int blue, int height, int width) {
        pixels = new Pixel[height][width];
        for (int y = 0; y<pixels.length; y++) {
            for (int x = 0; x<pixels[y].length; x++) {
                pixels[y][x] = new Pixel(red, green, blue);
            }
        }
    }

    /**
     * Creates a solid white Picture of a given width and height
     * @param color The {@link Color} of the Picture
     * @param height The height of the Picture
     * @param width The width of the Picture
     */
    public Picture(int height, int width) {
        this(Color.WHITE, height, width);
    }

    /**
     * Creates a solid-color Picture of a given color, width, and height
     * @param color The {@link Color} of the Picture
     * @param width The width of the Picture
     * @param height The height of the Picture
     */
    public Picture(Color color, int height, int width) {
        this(color.getRed(), color.getGreen(), color.getBlue(), height, width);
    }

    /**
     * Creates a Picture based off of an existing {@link Pixel} 2D array
     * @param pixels A rectangular 2D array of {@link Pixel}s. Must be at least 1x1
     */
    public Picture(Pixel[][] pixels) {
        if (pixels.length==0 || pixels[0].length==0) throw new RuntimeException("Can't have an empty image!");
        int width = pixels[0].length;
        for (int i = 0; i<pixels.length; i++) if (pixels[i].length!=width)
                throw new RuntimeException("Pictures must be rectangles. pixels[0].length!=pixels["+i+"].length!");
        this.pixels = new Pixel[pixels.length][width];
        for (int i = 0; i<pixels.length; i++) {
            for (int j = 0; j<pixels[i].length; j++) {
                this.pixels[i][j] = new Pixel(pixels[i][j].getColor());
            }
        }
    }

    /**
     * Creates a Picture based off of an existing Picture
     * @param picture The Picture to copy
     */
    public Picture(Picture picture) {
        this(picture.pixels);
    }

    /**
     * Gets the width of the Picture
     * @return The width of the Picture
     */
    public int getWidth() {
        return pixels[0].length;
    }

    /**
     * Gets the height of the Picture
     * @return The height of the Picture
     */
    public int getHeight() {
        return pixels.length;
    }

    /**
     * Gets the {@link Pixel} at a given coordinate
     * @param x The x location of the {@link Pixel}
     * @param y The y location of the {@link Pixel}
     * @return The {@link Pixel} at the given location
     */
    public Pixel getPixel(int x, int y) {
        if (x>=getWidth() || y>=getHeight() || x<0 || y<0) throw new RuntimeException("No pixel at ("+x+", "+y+")");
        return pixels[y][x];
    }

    /**
     * Sets the {@link Pixel} at a given coordinate
     * @param x The x location of the {@link Pixel}
     * @param y The y location of the {@link Pixel}
     * @param pixel The new {@link Pixel}
     */
    public void setPixel(int x, int y, Pixel pixel) {
        if (x>=getWidth() || y>=getHeight() || x<0 || y<0) throw new RuntimeException("No pixel at ("+x+", "+y+")");
        if (pixel==null) throw new NullPointerException("Pixel is null"); //guard is required because pixel's value isn't used in this method
        pixels[y][x] = pixel;
    }

    /**
     * Opens a {@link PictureViewer} to view this Picture
     * @return the {@link PictureViewer} viewing the Picture
     */
    public PictureViewer view() {
        return new PictureViewer(this);
    }

    /**
     * Save the image on disk as a JPEG
     * Call programmatically on a Picture object, it will prompt you to choose a save location
     * In the save dialogue window, specify the file AND extension (e.g. "lilies.jpg")
     * Extension must be .jpg as ImageIO is expecting to write a jpeg
     */
    public void save()
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch(Exception e) {
            e.printStackTrace();
        }

        BufferedImage image = new BufferedImage(this.pixels[0].length, this.pixels.length, BufferedImage.TYPE_INT_RGB);

        for (int r = 0; r < this.pixels.length; r++)
            for (int c = 0; c < this.pixels[0].length; c++)
                image.setRGB(c, r, this.pixels[r][c].getColor().getRGB());

        //user's Desktop will be default directory location
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "/Desktop");

        chooser.setDialogTitle("Select picture save location / file name");

        File file = null;

        int choice = chooser.showSaveDialog(null);

        if (choice == JFileChooser.APPROVE_OPTION)
            file = chooser.getSelectedFile();

        //append extension if user didn't read save instructions
        if (!file.getName().endsWith(".jpg") && !file.getName().endsWith(".JPG") && !file.getName().endsWith(".jpeg") && !file.getName().endsWith(".JPEG"))
            file = new File(file.getAbsolutePath() + ".jpg");

        try {
            ImageIO.write(image, "jpg", file);
            System.out.println("File created at " + file.getAbsolutePath());
        }
        catch (IOException e) {
            System.out.println("Can't write to location: " + file.toString());
        }
        catch (NullPointerException|IllegalArgumentException e) {
            System.out.println("Invalid directory choice");
        }
    }

    /********************************************************
     ** ************* STUDENT METHODS BELOW ******************
     ********************************************************/

    /** remove all blue tint from a picture */
    public void zeroBlue()
    {
        for (Pixel[] rows : pixels)
            for (Pixel p : rows)
                p.setBlue(0);
    }

    /** remove everything BUT blue tint from a picture */
    public void keepOnlyBlue()
    {
        for (Pixel[] rows : pixels)
            for (Pixel p : rows)
            {
                p.setRed(0);
                p.setGreen(0);
            }   
    }

    /** invert a picture's colors */
    public void negate()
    {
        for (Pixel[] rows : pixels)
            for (Pixel p : rows)
            {
                p.setRed(255 - p.getRed());
                p.setGreen(255 - p.getGreen());
                p.setBlue(255 - p.getBlue());
            }   
    }

    /** simulate the over-exposure of a picture in film processing */
    public void solarize(int threshold)
    {
        for (Pixel[] rows : pixels)
            for (Pixel p : rows)
            {
                if (p.getRed() <= threshold)
                    p.setRed(255 - p.getRed());
                if (p.getGreen() <= threshold)
                    p.setGreen(255 - p.getGreen());
                if (p.getBlue() <= threshold)
                    p.setBlue(255 - p.getBlue());
            }  
    }

    /** convert an image to grayscale */
    public void grayscale()
    {
        for (Pixel[] rows : pixels)
            for (Pixel p : rows)
            {
                p.setRed((p.getRed() + p.getGreen() + p.getBlue()) / 3);
                p.setGreen(p.getRed());
                p.setBlue(p.getRed());
            }  
    }

    /** change the tint of the picture by the supplied coefficients */
    public void tint(double red, double blue, double green)
    {
        for (Pixel[] rows : pixels)
            for (Pixel p : rows)
            {
                if (p.getRed() * red > 255)
                    p.setRed(255);
                else
                    p.setRed((int)((double)p.getRed() * red));
                if (p.getGreen() * green > 255)
                    p.setGreen(255);
                else
                    p.setGreen((int)((double)p.getGreen() * green));
                if (p.getBlue() * blue > 255)
                    p.setBlue(255);
                else
                    p.setBlue((int)((double)p.getBlue() * blue));
            }  
    }

    /** reduces the number of colors in an image to create a "graphic poster" effect */
    public void posterize(int span)
    {
        for (Pixel[] rows : pixels)
            for (Pixel p : rows)
            {
                int red = (p.getRed() / span) * span;
                int green = (p.getGreen() / span) * span;
                int blue = (p.getBlue() / span) * span;
                p.setColor(red, green, blue);
            } 
    }

    /** mirror an image about a vertical midline, left to right */
    public void mirrorVertical()
    {
        Pixel leftPixel  = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < width / 2; c++)
            {
                leftPixel  = pixels[r][c];
                rightPixel = pixels[r][(width - 1) - c];

                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** mirror about a vertical midline, right to left */
    public void mirrorRightToLeft()
    {
        Pixel leftPixel  = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < width / 2; c++)
            {
                leftPixel  = pixels[r][(width - 1) - c];
                rightPixel = pixels[r][c];

                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** mirror about a horizontal midline, top to bottom */
    public void mirrorHorizontal()
    {
        Pixel topPixel  = null;
        Pixel bottomPixel = null;

        int height = pixels.length;

        for (int c = 0; c < pixels[0].length; c++)
        {
            for (int r = 0; r < height / 2; r++)
            {
                topPixel  = pixels[r][c];
                bottomPixel = pixels[(height - 1) - r][c];

                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    /** flip an image upside down about its bottom edge */
    public void verticalFlip()
    {
        int height = pixels.length;
        int width = pixels[0].length;
        //Pixel topPixel = null;
        //Pixel bottomPixel = null;

        for (int r = 0; r < height / 2; r++)
        {
            for (int c = 0; c < width; c++)
            {
                Pixel topPixel  = pixels[r][c];
                Pixel topColor = new Pixel(topPixel.getColor());
                Pixel bottomPixel = pixels[(height - 1) - r][c];

                topPixel.setColor(bottomPixel.getColor());
                bottomPixel.setColor(topColor.getColor());
            }
        }

    }

    /** fix roof on greek temple */
    public void fixRoof()
    {
        Pixel leftPixel  = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;
        int height = pixels.length;

        for (int r = 0; r < height / 4; r++)
        {
            for (int c = 0; c < width / 2; c++)
            {
                leftPixel  = pixels[r][(width - 1) - c];
                rightPixel = pixels[r][c];

                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

    /** detect and mark edges in an image */
    public void edgeDetection(int dist)
    {
        Pixel leftPixel  = null;
        Pixel rightPixel = null;
        Pixel downPixel = null;

        int width = pixels[0].length;
        int height = pixels.length;

        for (int r = 0; r < height - 1; r++)
        {
            for (int c = 0; c < width - 1; c++)
            {
                leftPixel  = pixels[r][c];
                rightPixel = pixels[r][c + 1];
                downPixel = pixels[r + 1][c];

                if (leftPixel.colorDistance(rightPixel.getColor()) < dist && leftPixel.colorDistance(downPixel.getColor()) < dist)
                    leftPixel.setColor(Color.WHITE);
                else
                    leftPixel.setColor(Color.BLACK);
            }
        }

    }

    /** copy another picture's pixels into this picture, if a color is within dist of param Color */
    public void chromakey(Picture other, Color color, int dist)
    {
        Pixel leftPixel  = null;

        int width = pixels[0].length;
        int height = pixels.length;

        for (int r = 0; r < height; r++)
        {
            for (int c = 0; c < width; c++)
            {
                leftPixel  = pixels[r][c];

                if (leftPixel.colorDistance(color) < dist)
                    leftPixel.setColor(other.pixels[r][c].getColor());
            }
        }
    }

    /** steganography encode (hide the message in msg in this picture) */
    public void encode(Picture msg)
    {
        Pixel leftPixel  = null;
        Pixel msgPixel = null;

        int width = pixels[0].length;
        int height = pixels.length;

        for (int r = 0; r < height; r++)
        {
            for (int c = 0; c < width; c++)
            {
                leftPixel  = pixels[r][c];

                if (leftPixel.getRed() % 2 != 0)
                    leftPixel.setRed(leftPixel.getRed() - 1);
            }
        }

        for (int r = 0; r < height; r++)
        {
            for (int c = 0; c < width; c++)
            {
                leftPixel  = pixels[r][c];
                msgPixel = msg.pixels[r][c];

                if (msgPixel.colorDistance(Color.BLACK) < 50)
                    leftPixel.setRed(leftPixel.getRed() + 1);
            }
        }
    }

    /** steganography decode (return a new Picture containing the message hidden in this picture) */
    public Picture decode()
    {
        //TODO
        int width = pixels[0].length;
        int height = pixels.length;

        Pixel leftPixel = null;
        Pixel msgPixel = null;

        Picture hiddenMsg = new Picture(height, width);

        for (int r = 0; r < height; r++)
        {
            for (int c = 0; c < width; c++)
            {
                leftPixel = pixels[r][c];
                msgPixel = hiddenMsg.pixels[r][c];

                if (leftPixel.getRed() % 2 != 0)
                    msgPixel.setColor(Color.BLACK);
                else
                {
                    msgPixel.setColor(Color.WHITE);
                }
            }
        }

        return hiddenMsg; //REPLACE
    }

    /** perform a simple blur using the colors of neighboring pixels */
    public Picture simpleBlur()
    {
        //TODO
        return blur(1);
    }

    /** perform a blur using the colors of pixels within radius of current pixel */
    public Picture blur(int radius)
    {
        //TODO
        Pixel[][] grid = new Pixel[(radius * 2) + 1][(radius * 2) + 1];

        int width = pixels[0].length;
        int height = pixels.length;

        int gWidth = grid[0].length;
        int gHeight = grid.length;

        int count = 0;

        int redA = 0;
        int greenA = 0;
        int blueA = 0;

        int wRadius = radius;
        int hRadius = radius;

        Pixel blurPixel = null;

        Picture blurImage = new Picture(height, width);

        for (int r = 0; r < height; r++)
        {
            for (int c = 0; c < width; c++)
            {
                blurPixel = blurImage.pixels[r][c];

                for (int r2 = 0; r2 < gHeight; r2++)
                {
                    for (int c2 = 0; c2 < gWidth; c2++)
                    {
                        if (c - wRadius >= 0 && c - wRadius < width && r - hRadius >= 0 && r - hRadius < height)
                        {
                            grid[r2][c2] = pixels[r - hRadius][c - wRadius];
                            redA += grid[r2][c2].getRed();
                            greenA += grid[r2][c2].getGreen();
                            blueA += grid[r2][c2].getBlue();
                            count++;
                        }
                        wRadius--;
                    }
                    hRadius--;
                    wRadius = radius;
                }

                wRadius = radius;
                hRadius = radius;

                blurPixel.setRed(redA / count);
                blurPixel.setGreen(greenA / count);
                blurPixel.setBlue(blueA / count);

                redA = greenA = blueA = count = 0;

            }
        }

        return blurImage; //REPLACE
    }

    /**
     * Simulate looking at an image through a pane of glass
     * @param dist the "radius" of the neighboring pixels to use
     * @return a new Picture with the glass filter applied
     */
    public Picture glassFilter(int dist) 
    {
        //TODO
        int width = pixels[0].length;
        int height = pixels.length;

        Random random = new Random();
        int distance = random.nextInt(dist * 2) - dist;

        Pixel pixel = null;
        Pixel pixel2 = null;

        Picture glassedImage = new Picture(height, width);

        for (int r = 0; r < height; r++)
        {
            for (int c = 0; c < width; c++)
            {
                int distanceR = random.nextInt((dist * 2) + 1) - dist;
                int distanceC = random.nextInt((dist * 2) + 1) - dist;
                if (c + distanceC >= 0 && c + distanceC < width && r + distanceR >= 0 && r + distanceR < height)
                {
                    glassedImage.pixels[r][c] = pixels[r + distanceR][c + distanceC];
                }
                else if (c + distanceC < 0 && r + distanceR >= 0 && r + distanceR < height)
                {
                    glassedImage.pixels[r][c] = pixels[r + distanceR][width + distanceC];
                }
                else if (c + distanceC > width && r + distanceR >= 0 && r + distanceR < height)
                {
                    glassedImage.pixels[r][c] = pixels[r + distanceR][0 + distanceC];
                }
                else if (c + distanceC >= 0 && c + distanceC < width && r + distanceR < 0)
                {
                    glassedImage.pixels[r][c] = pixels[height + distanceR][c + distanceC];
                }
                else if (c + distanceC >= 0 && c + distanceC < width && r + distanceR > height)
                {
                    glassedImage.pixels[r][c] = pixels[0 + distanceR][c + distanceC];
                }
            }
        }
        return glassedImage; //REPLACE
    }
}
