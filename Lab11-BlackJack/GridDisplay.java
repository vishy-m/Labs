import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import javax.swing.*;

public class GridDisplay extends JComponent implements KeyListener, MouseListener
{
    private static final int MAX_SIZE = 600;

    private Color[][] colors;
    private String[][] imageFileNames;
    private JFrame frame;
    private int lastKeyPressed;
    private Location lastLocationClicked;
    private Color lineColor;
    private int cellSize;

    public GridDisplay(int numRows, int numCols)
    {
        init(numRows, numCols);
    }

    public GridDisplay(String imageFileName)
    {
        BufferedImage image = loadImage(imageFileName);
        int height = image.getHeight();
        int width = image.getWidth();
        int size = Math.max(height, width);
        if (size > MAX_SIZE)
        {
            if (height > width)
            {
                width = width * MAX_SIZE / height;
                height = MAX_SIZE;
            }
            else
            {
                height = height * MAX_SIZE / width;
                width = MAX_SIZE;
            }
        }
        init(height, width);
        showImage(image);
        setTitle(imageFileName);
    }

    private BufferedImage loadImage(String imageFileName)
    {
        //URL url = getClass().getResource(imageFileName);
        //if (url == null)
           //throw new RuntimeException("cannot find file:  " + imageFileName);
        try
        {
			//return ImageIO.read(url);
            return ImageIO.read(new File(imageFileName));
        }
        catch(IOException e)
        {
            throw new RuntimeException("unable to read/find file:  " + imageFileName);
        }
    }

    public int getNumRows()
    {
        return colors.length;
    }

    public int getNumCols()
    {
        return colors[0].length;
    }

    private void init(int numRows, int numCols)
    {
        lastKeyPressed = -1;
        lastLocationClicked = null;
        lineColor = null;

        colors = new Color[numRows][numCols];
        imageFileNames = new String[numRows][numCols];
        Color black = new Color(0, 0, 0);
        for (int row = 0; row < numRows; row++)
        {
            for (int col = 0; col < numCols; col++)
                colors[row][col] = black;
        }

        frame = new JFrame("GridDisplay");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(this);

        cellSize = Math.min(MAX_SIZE / getNumRows(), MAX_SIZE / getNumCols());
        setPreferredSize(new Dimension(cellSize * numCols, cellSize * numRows));
        addMouseListener(this);
        frame.getContentPane().add(this);

        frame.pack();
        frame.setVisible(true);
    }

    private void showImage(BufferedImage image)
    {
        for (int row = 0; row < getNumRows(); row++)
        {
            for (int col = 0; col < getNumCols(); col++)
            {
                int x = col * image.getWidth() / getNumCols();
                int y = row * image.getHeight() / getNumRows();
                int c = image.getRGB(x, y);
                int red = (c & 0x00ff0000) >> 16;
                int green = (c & 0x0000ff00) >> 8;
                int blue = c & 0x000000ff;
                colors[row][col] = new Color(red, green, blue);
            }
        }
        repaint();
    }

    public void keyPressed(KeyEvent e)
    {
        lastKeyPressed = e.getKeyCode();
    }

    public void keyReleased(KeyEvent e)
    {
        //ignored
    }

    public void keyTyped(KeyEvent e)
    {
        //ignored
    }

    public void mousePressed(MouseEvent e)
    {
        int row = e.getY() / cellSize;
        if (row < 0 || row >= getNumRows())
            return;
        int col = e.getX() / cellSize;
        if (col < 0 || col >= getNumCols())
            return;
        lastLocationClicked = new Location(row, col);
    }

    public void mouseReleased(MouseEvent e)
    {
        //ignore
    }

    public void mouseClicked(MouseEvent e)
    {
        //ignore
    }

    public void mouseEntered(MouseEvent e)
    {
        //ignore
    }

    public void mouseExited(MouseEvent e)
    {
        //ignore
    }

    private static java.awt.Color toJavaColor(Color color)
    {
        return new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue());
    }

    public void paintComponent(Graphics g)
    {
        for (int row = 0; row < getNumRows(); row++)
        {
            for (int col = 0; col < getNumCols(); col++)
            {
                Location loc = new Location(row, col);

                Color color = colors[loc.getRow()][loc.getCol()];
                g.setColor(toJavaColor(color));
                int x = col * cellSize;
                int y = row * cellSize;
                g.fillRect(x, y, cellSize, cellSize);

                String imageFileName = imageFileNames[loc.getRow()][loc.getCol()];
                if (imageFileName != null)
                {
//                    URL url = getClass().getResource(imageFileName);
//                    if (url == null)
//                        System.out.println("File not found:  " + imageFileName);
//                    else
//                    {
//                        Image image = new ImageIcon(url).getImage();
                	 	Image image = new ImageIcon(imageFileName).getImage();
                        int width = image.getWidth(null);
                        int height = image.getHeight(null);
                        int max;
                        if (width > height)
                        {
                            int drawHeight = cellSize * height / width;
                            g.drawImage(image, x, y + (cellSize - drawHeight) / 2, cellSize, drawHeight, null);
                        }
                        else
                        {
                            int drawWidth = cellSize * width / height;
                            g.drawImage(image, x + (cellSize - drawWidth) / 2, y, drawWidth, cellSize, null);
                        }
//                    }
                }

                if (lineColor != null)
                {
                    g.setColor(toJavaColor(lineColor));
                    g.drawRect(x, y, cellSize, cellSize);
                }
            }
        }
    }

    public void setTitle(String title)
    {
        frame.setTitle(title);
    }

    public boolean isValid(Location loc)
    {
        int row = loc.getRow();
        int col = loc.getCol();
        return 0 <= row && row < getNumRows() && 0 <= col && col < getNumCols();
    }

    public void setColor(Location loc, Color color)
    {
        if (!isValid(loc))
            throw new RuntimeException("cannot set color of invalid location " + loc + " to color " + color);
        colors[loc.getRow()][loc.getCol()] = color;
        repaint();
    }

    public Color getColor(Location loc)
    {
        if (!isValid(loc))
            throw new RuntimeException("cannot get color from invalid location " + loc);
        return colors[loc.getRow()][loc.getCol()];
    }

    public void setImage(Location loc, String imageFileName)
    {
        if (!isValid(loc))
            throw new RuntimeException("cannot set image for invalid location " + loc + " to \"" + imageFileName + "\"");
        imageFileNames[loc.getRow()][loc.getCol()] = imageFileName;
        repaint();
    }

    public String getImage(Location loc)
    {
        if (!isValid(loc))
            throw new RuntimeException("cannot get image for invalid location " + loc);
        return imageFileNames[loc.getRow()][loc.getCol()];
    }

    public static void pause(double seconds)
    {
        try
        {
            Thread.sleep((int)(1000 * seconds));
        }
        catch(Exception e)
        {
            //ignore
        }
    }

    //returns -1 if no key pressed since last call.
    //otherwise returns the code for the last key pressed.
    public int checkLastKeyPressed()
    {
        int key = lastKeyPressed;
        lastKeyPressed = -1;
        return key;
    }

    //returns null if no location clicked since last call.
    public Location checkLastLocationClicked()
    {
        Location loc = lastLocationClicked;
        lastLocationClicked = null;
        return loc;
    }

    public void load(String imageFileName)
    {
        showImage(loadImage(imageFileName));
        setTitle(imageFileName);
    }

    public void save(String imageFileName)
    {
        try
        {
            BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            paintComponent(bi.getGraphics());
            int index = imageFileName.lastIndexOf('.');
            if (index == -1)
                throw new RuntimeException("invalid image file name:  " + imageFileName);
            ImageIO.write(bi, imageFileName.substring(index + 1), new File(imageFileName));
            setTitle(imageFileName);
        }
        catch(IOException e)
        {
            throw new RuntimeException("unable to save image to file:  " + imageFileName);
        }
    }

    public void setLineColor(Color color)
    {
        lineColor = color;
        repaint();
    }

    public void showMessageDialog(String message)
    {
        JOptionPane.showMessageDialog(this, message);
    }

    public String showInputDialog(String message)
    {
        return JOptionPane.showInputDialog(this, message);
    }

    public String showInputDialog(String message, String[] choices)
    {
        return (String)JOptionPane.showInputDialog(this, message, null, JOptionPane.PLAIN_MESSAGE, null, choices, null);
    }

    //returns number of seconds that have elapsed since January 1, 1970
    public static int getCurrentTime()
    {
        return (int)(System.currentTimeMillis() / 1000);
    }
}
