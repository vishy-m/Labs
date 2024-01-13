/**
 * TestGUI by Kris McCoy & Dagar Ahmed   v2.172
 * Run customized tests of various classes/method and custom build your GUI

 * This version adds:
 * Remove ambiguity of Rectangle.

 * TO CREATE A HEADER IN THE GUI
 *     void header(String name)
 *   
 *     Example:
 *     header("Histogram");

 * TO CREATE A MESSAGE/NOTE IN THE GUI
 *     void message(String information)
 *     void message(String information, boolean correct)
 *   
 *     Example:
 *     message("This portion of the assignment is optional and for extra credit only."); //default grey color
 *     message("I'm requesting that this method have a green background.", true) //green color
 *     message("I'm requesting that this method have a red background.", false) //red color
 *     

 * TO CREATE A BUTTON FOR LOADING SOURCE CODE / DATA FILES
 *     void srcButton(String sourceFileNamesCommaDelimited)
 *     void srcButton(String[] sourceFileNames)
 *     
 *     Example:
 *     srcButton("PracticeProblems, Data.txt");  //If file has no extension, .java is assumed
 *     srcButton(new String[]{"Car.java", "Truck.java", "DataFile.in"}

 * TO TEST A CONSTRUCTOR AND RECEIVE THE INSTANTIATED OBJECT:
 *     Object makeObject(String className, Object[] args)
 *     Object makeObject(String className, Object[] args, String inputScript)
 *
 *     Parameters:
 *     className - Name of the constructor you are calling
 *     args - arguments you are passing to the constructor.  null can be used if calling a default 
 *            (no parameter) constructor
 *     inputScript - data that will be fed through System.in in the event that the constructor
 *         requests user input
 *      
 *     Returns:
 *     the object constructed from the call
 *      
 *     Example usage:
 *     //Using this...                                              // is similar to using this... 
 *     Object o = makeObject("Person", new Object[]{"Fred", 27});   // Object o = new Person("Fred", 27);
 *     Object o = makeObject("Person", null, "Fred\n27");           // Object o = new Person(); (provides user input)          

 * TO TEST A METHOD  (The testMethod method is very overloaded.  You have several options.)
 *     Object testMethod(Object o,     String mName, Object[] args)
 *     Object testMethod(String cName, String mName, Object[] args)
 *     Object testMethod(Object o,     String mName, Object[] args, String expOut)
 *     Object testMethod(String cName, String mName, Object[] args, String expOut)
 *     Object testMethod(Object o,     String mName, Object[] args, String expOut, double allowableError)
 *     Object testMethod(String cName, String mName, Object[] args, String expOut, double allowableError)
 *     Object testMethod(Object o,     String mName, Object[] args, String expOut, String inputScript)
 *     Object testMethod(String cName, String mName, Object[] args, String expOut, String inputScript)
 *     Object testMethod(Object o,     String mName, Object[] args, String expOut, double allowableError, String inputScript)
 *     Object testMethod(String cName, String mName, Object[] args, String expOut, double allowableError, String inputScript)
 *   
 *     Parameters:
 *     o - the object invoking the method you want to test (for non-static methods)
 *     cName - name of the class invoking the method you want to test (for static methods)
 *     mName - name of the method being invoked
 *     args - arguments being passing to the method.  null can be used if the method being testing
 *            does not require any parameters.
 *     expOut - the expected output or return value from running the method
 *            If an expOut is provided the GUI will compare this against the actual output/return
 *            value from the test and make a comparison.  Leave this off or pass null if you don't want
 *            to make a red light/green light comparison against the actual output.)
 *            Wildcards can be used in the expected output to allow for tokens that aren't expected to match.
 *            Wildcards:    %int%          -  actual output may contain any int value at this location of this token
 *                          %int34_45%     - actual output may contain any int value between 34 and 45 inclusive
 *                          %double%       -  actual output may contain any double value at this location of this token
 *                          %double0_4.5%  - actual output may contain any double value between 0.0 and 4.5 inclusive
 *                          %word%         -  actual output may contain any single token at this location of this token
 *                          %line%         -  actual output may contain any number of any tokens from this location to the end of the line.
 *     allowableError - the plus/minus error allowable when conparing floating-point values.
 *            If the expOut contains a value of 10.0 and the allowableError is .2, then the actual
 *            output must fall between 9.8 and 10.2. To handle minor errors caused by rounding of floating-point values,
 *            the recommended allowable error is .0001.
 *     inputScript - data that will be fed through System.in in the event that the method
 *         requests user input
 *   
 *     Returns:
 *     the return value of the method being invoked (as Object)
 *     or null when testing void methods or the student code fails to run/throws exception
 *   
 *     Example usage:
 *     //Using this...                                               // is similar to using this... 
 *     testMethod(myHistogram, "encounter", new Object[]{7});        // myHistogram.encounter(7);
 *     testMethod("Practice", "printXs", new Object[]{4}, "xxxx")    // Practice.printXs(4); 
 *     int s = testMethod(myCar, "getSpeed", null, "55");            // int s = myCar.getSpeed();

 * TO GET A CLASS OBJECT FROM ITS NAME       
 *     Class getClassFromName(String className)
 *     
 *     Example usage:
 *     Class c = getClassFromName("Truck");  
 *     
 *     Note: Why would you want to do this?  This will allow you to collect various information about
 *     how students coded the class, useful for checking how well students understand class design and
 *     inheritance.  You can verify that the Truck class extends the Vehicle class. You can find out 
 *     how many declared fields the student included (vs how many fields were inherited.) Also, this is
 *     your only way to get a version of the Class object that uses the same ClassLoader as the TestGUI
 *     (in the event that you need to try to cast Object o as a student-coded Truck.)  For more info,
 *     read about the Class class here:  https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html 

 * TO GET AN ENUM VALUE (AS OBJECT) FROM NAME
 *      Object getEnumFromName(String enumClassName, String valueName);

 * TO SET HOW MANY SECONDS SHOULD BE WAITED BEFORE AN INDIVIDUAL TEST TIMES OUT
 *     setTimeOutSec(int seconds);  //how many seconds to wait before giving up.  (Default 2)

 * TO RUN A METHOD IN A SEPARATE THREAD
 *     boolean runAsThread(Object o, String mName, Object[] args)
 *     
 *     Parameters:
 *     o - the object invoking the method you want to test (for non-static methods)
 *     cName - name of the class invoking the method you want to test (for static methods)
 *     mName - name of the method being invoked
 *     args - arguments being passing to the method.  null can be used if the method being testing
 *            does not require any parameters.
 *      
 *     Returns: true if thread successfully started, false otherwise
 *     
 *     This is a good way to call runners for StdDraw animations/games.  No information is collected
 *     or displayed on the GUI interface.  Warning: Thread never times out.  Could cause problems if
 *     student writes an infinite loop.
 * 
 * 
 */

import java.awt.*;
import java.awt.Point;
import java.awt.event.*;
import java.io.*;
import java.lang.invoke.*;
import java.lang.reflect.*;
import java.nio.*;
import java.nio.file.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.swing.filechooser.*;
import javax.tools.*;

@SuppressWarnings({"unchecked", "deprecation"}) 
public class TestGUI 
{
    //ADJUSTABLES.  EDIT AS YOU SEE FIT
    private static final int WIDTH = 940; 
    private static final int HEIGHT = 800; 
    private static final int SOURCE_CODE_FRAME_WIDTH = 940;
    private static final int SOURCE_CODE_FRAME_HEIGHT = 800;
    private static final Font HEADER_FONT = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private static final Font REGULAR_FONT = new Font(Font.MONOSPACED, Font.PLAIN, 16);  
    private static final Font MESSAGE_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 16);  
    private static final Font PATH_FONT = new Font(Font.MONOSPACED, Font.PLAIN, 16);
    private static final Color HEADER_BG_COLOR = new Color(200,200,255); 
    private static final Color MESSAGE_BG_COLOR = new Color(200,200,200); 
    public static final Color RED = new Color(250, 180, 180);      //Output did NOT match expected
    public static final Color YELLOW = new Color(250, 250, 180);      //Output had spacing issues only
    public static final Color GREEN = new Color(160, 225, 200);    //Output DID match expected
    private static final int SCROLL_SPEED = 40;
    private static final String NOFILES_ALERT = "WARNING: The current source directory does not contain any helpful source files.  Choose new source path.";

    //BUT DON'T MESS WITH THESE.
    public static final double V_NUM = 2.172;
    private static String windowName;
    private static Class testClass;
    private static ArrayList<TestData> testResults = new ArrayList<TestGUI.TestData>();
    private static int countGreen, countYellow, countRed;
    private ArrayList<JPanel> subFrameList;     
    private static final PrintStream originalSystemOut = System.out;
    private static final InputStream originalSystemIn = System.in;
    private static InputStream hijackedSystemIn;

    private JFrame mainFrame;
    private JScrollPane scrPane;
    private JTextArea srcLabel, greenLabel, yellowLabel, redLabel;
    private JPanel buttonPanel, statPanel;
    private JButton loadButton, nextSourceButton, retestButton;
    private ArrayList<JButton> srcButtonList = new ArrayList<JButton>();

    private static final String mistakeStartFlag = (char)16+"!!", mistakeStopFlag = "!!"+(char)17;

    private static File srcPath;
    private static File originalSrcPath;
    private static JFileChooser chooser;
    private static URL classUrl;
    private static URLClassLoader classLoader;
    private static boolean timeOutThrown = false;

    /**
     * Used on initial build to collect window name and class name containing test cases
     * Default source path is the directory containing this TestGUI.class
     */
    public TestGUI(){    
        try {                        
            String callingClassName = Thread.currentThread().getStackTrace()[2].getClassName();
            this.windowName = callingClassName;
            this.testClass = Class.forName(callingClassName);
        } catch (Exception e) {}     
        letsDoSomeGUI();
    }

    public void letsDoSomeGUI() {
        SwingUtilities.invokeLater(
            new Runnable() 
            {
                @Override
                public void run() {
                    buildWindow();
                }

            }); 
    }

    public void buildWindow() {
        mainFrame = new JFrame("Current Test Sequence: " + windowName);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(WIDTH, HEIGHT);

        BorderLayout buttonLayout = new BorderLayout();
        buttonLayout.setHgap(5);
        buttonPanel = new JPanel(buttonLayout);       
        buttonPanel.setBorder(new EmptyBorder(5,5,5,5));

        loadButton = new JButton("Choose Source");
        loadButton.setToolTipText( "Select a new source folder." );
        nextSourceButton = new JButton(">");
        nextSourceButton.setToolTipText( "Advance to next source folder in directory tree." );
        initializeFileChooser();
        retestButton = new JButton("Retest");
        retestButton.setToolTipText( "Recompile source folder and run tests again." );
        retestButton.setEnabled(false);

        setSrcLabel(srcPath);
        setGreenLabel(countGreen=0);
        setYellowLabel(countYellow=0);
        setRedLabel(countRed=0);

        loadButton.addActionListener( 
            new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e) { 
                    if (loadPath()) { compileAndTest(); }
                } 
            }
        );

        nextSourceButton.addActionListener( 
            new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e) { 
                    nextSourceFolder(); 
                } 
            }
        );

        retestButton.addActionListener(
            new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e) { 
                    compileAndTest();  
                } 
            }
        );

        BorderLayout statLayout = new BorderLayout();        
        statPanel = new JPanel(statLayout);        
        statPanel.add(greenLabel, BorderLayout.WEST);
        statPanel.add(yellowLabel, BorderLayout.CENTER);
        statPanel.add(redLabel, BorderLayout.EAST);

        BorderLayout eastButtonLayout = new BorderLayout();
        JPanel eastButtonPanel = new JPanel(eastButtonLayout);
        eastButtonPanel.add(nextSourceButton, BorderLayout.WEST);
        eastButtonPanel.add(retestButton, BorderLayout.CENTER);
        eastButtonPanel.add(statPanel, BorderLayout.EAST);

        buttonPanel.add(srcLabel, BorderLayout.CENTER);    
        buttonPanel.add(loadButton, BorderLayout.WEST);
        buttonPanel.add(eastButtonPanel, BorderLayout.EAST);  
        mainFrame.add(buttonPanel, BorderLayout.NORTH);          
        compileAndTest(); //run a test from current directory
    }

    @SuppressWarnings("unchecked")
    private void compileAndTest() {
        if (scrPane != null) { 
            mainFrame.remove(scrPane); 
        }
        retestButton.setEnabled(false);
        loadButton.setEnabled(false);
        nextSourceButton.setEnabled(false);
        buttonPanel.remove(srcLabel);                        
        setSrcLabel("Loading... Please wait.");
        countGreen = countYellow = countRed = 0;
        refreshStatPanel();
        buttonPanel.add(srcLabel, BorderLayout.CENTER);
        mainFrame.repaint();
        mainFrame.setVisible(true);    

        SwingUtilities.invokeLater(
            new Runnable() 
            {
                @Override
                public void run() {
                    try {
                        testResults = new ArrayList<TestGUI.TestData>(); 
                        compileAllSrcFiles();  
                    } catch(Exception e) { System.out.println("Unable to compile source files."); }
                    try {
                        EchoingByteArrayInputStream.hijackSystemIn();
                        testClass.getMethod("runTests").invoke(testClass);  
                        EchoingByteArrayInputStream.restoreSystemIn();

                    } catch(Exception e) { 

                        System.out.println("Error with runTests.  Bad test cases?\nException: "+e); 
                    }
                    try {
                        showResults();
                        buttonPanel.remove(srcLabel);                        
                        setSrcLabel(srcPath);
                        buttonPanel.add(srcLabel, BorderLayout.CENTER);
                        refreshStatPanel();
                        if (!timeOutThrown) {
                            retestButton.setEnabled(true);
                            loadButton.setEnabled(true);
                            nextSourceButton.setEnabled(true);
                        }
                        mainFrame.setVisible(true);
                    } catch(Exception e) { System.out.println("Unable to build GUI."); }
                }
            }
        );
    }

    private void nextSourceFolder(){
        //Advance the current source file directory to the next directory in the directory tree
        if (srcPath == null) 
            return;
        chooser = new JFileChooser(".");
        chooser.setCurrentDirectory(srcPath);

        File previous = chooser.getCurrentDirectory();

        if (! srcPath.getName().equals(originalSrcPath.getName())) chooser.changeToParentDirectory();
        chooser.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES);

        File fDir = chooser.getCurrentDirectory();
        FileSystemView fsv = chooser.getFileSystemView();        
        File[] fileArray = fsv.getFiles(fDir, true);

        for (int i = 0; i < fileArray.length; i++) {
            File f = fileArray[i];
            if (f.isDirectory() && f.getPath().equals(previous.getPath())) {
                for (int j = i + 1; j < fileArray.length; j++) {
                    File next = fileArray[j];
                    if (next.isDirectory()) {
                        srcPath = next;
                        compileAndTest();
                        return;
                    }
                }
            }
        }
    }

    private void initializeFileChooser(){
        // Let the user pick from a filtered list of files
        chooser = new JFileChooser(".");
        Action details = chooser.getActionMap().get("viewTypeDetails");
        //details.actionPerformed(null);
        if (srcPath == null) {
            srcPath = originalSrcPath = new File(System.getProperty("user.dir"));
        }

        chooser.setCurrentDirectory(srcPath);
        if (! srcPath.getName().equals(originalSrcPath.getName())) chooser.changeToParentDirectory();
        chooser.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setFileFilter(
            new javax.swing.filechooser.FileFilter() 
            {
                String description = "Java files";
                @Override
                public boolean accept(File f) {
                    if (f.isDirectory()) 
                        return true;
                    if (f.getName().endsWith(".java"))
                        return true;
                    return false;
                }

                @Override
                public String getDescription() { 
                    return this.description; }
            }
        );
    }

    private boolean loadPath() {
        int returnVal = chooser.showOpenDialog(mainFrame);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File newFile = chooser.getSelectedFile();
            srcPath = (newFile.isDirectory()) ? newFile : newFile.getParentFile();
        } else {
            return false;
        }
        return true;
    }

    public void compileAllSrcFiles() {
        TestData.setClassLoader();
        File[] arrayOfFiles = srcPath.listFiles(
                new java.io.FileFilter() 
                {
                    @Override
                    public boolean accept(File f) {
                        String fn = f.getName();
                        String exclude1 = testClass.getName()+".java";                        
                        String exclude2 = "TestGUI.java";

                        if (f.getName().endsWith(".java")) {
                            if (f.getName().equals(exclude1) || f.getName().equals(exclude2)) 
                                return false;
                            return true;
                        }
                        return false;
                    }
                }
            );
        if (arrayOfFiles.length==0) {
            TestData.messageAlert(NOFILES_ALERT);
            return;
        }

        //Before we compile this list of .java files, let's delete old .class files
        for (File jFile : arrayOfFiles)
        {
            String jFilename = jFile.getPath();
            String cFilename = jFilename.substring(0, jFilename.indexOf(".java")) + ".class";
            File toDelete = new File(cFilename);
            toDelete.delete();
        }

        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        String[] baseArgs = new String[]{                
                "-Xlint:none",
                "-d",
                srcPath.getAbsolutePath(),
                "-g",
                "-sourcepath",
                srcPath.getAbsolutePath()
            };

        ArrayList<String> arguments = new ArrayList<String>(Arrays.asList(baseArgs));

        ArrayList<String> fileNames = new ArrayList<String>();
        for (File f : arrayOfFiles) arguments.add(f.getPath());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        javaCompiler.run(null, null, baos, arguments.toArray(new String[arguments.size()]));

        //Data in the baos means there was a compile error.  Try one file at a time.
        if (baos.size() > 0) {
            baos.reset();
            System.out.println("Trying to compile all project files at once caused an error.");
            System.out.println("Please wait while I compile one file at a time.");

            arguments = new ArrayList<String>(Arrays.asList(baseArgs));
            for (File f : arrayOfFiles) {
                arguments.add(f.getPath());
                javaCompiler.run(null, null, baos, arguments.toArray(new String[arguments.size()]));
                arguments.remove(arguments.size()-1);
            }
            if (baos.size() > 0) System.out.println("\n\nCompiler Errors:\n" + baos);
        }

    }

    public void showResults() {   
        subFrameList = new ArrayList<JPanel>();

        for(TestData td : testResults){
            if(td.getHeader() != null)
                makeHeaderFrame(td);
            if(td.getMessage() != null)
                makeMessageFrame(td);
            if(td.getSrcFiles() != null)
                makeSrcButtonFrame(td);
            if ( td.getExpectedOut() != null || td.getActualOut() != null )
                makeFourSubFrames(td);            
            else if(td.getMethodCall() != null)
                makeTwoSubFrames(td);           
        }

        //put all subFrames into a scrollable box
        ScrollablePanel subFrameBox = new ScrollablePanel();
        subFrameBox.setLayout(new BoxLayout(subFrameBox, BoxLayout.Y_AXIS));
        for(JPanel subFrame : subFrameList)
            subFrameBox.add(subFrame);

        //Put that scrollable box into the scroll pane
        if (scrPane != null) { mainFrame.remove(scrPane); }
        scrPane = new JScrollPane(subFrameBox);
        scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // add to the scroll pane to the main frame and view it
        mainFrame.add(scrPane, BorderLayout.CENTER);

        //mainFrame.setVisible(true); 
        SwingUtilities.invokeLater(
            new Runnable() 
            {
                @Override
                public void run() {
                    scrPane.getViewport().setViewPosition( new Point(0, 0) );
                }
            }
        );
    }    

    public void setSrcLabel(File s){ 
        String p = s.getPath();
        if (p.length()>45) p = "..."+p.substring(p.length()-45);                 
        setSrcLabel("SRC>>"+p);                
    }

    public void setSrcLabel(String s){ 
        srcLabel = new JTextArea(s);
        srcLabel.setFont(PATH_FONT);
        srcLabel.setBackground(Color.WHITE);
        srcLabel.setLineWrap(true);
        srcLabel.setWrapStyleWord(false);
        srcLabel.setEditable(false);
        if (srcPath != null) srcLabel.setToolTipText(srcPath.getPath());
    }

    public void setGreenLabel(int num) {
        greenLabel = new JTextArea(" "+num+" ");
        greenLabel.setFont(PATH_FONT);
        greenLabel.setBackground(GREEN);
        greenLabel.setLineWrap(false);
        greenLabel.setWrapStyleWord(false);
        greenLabel.setEditable(false);
        greenLabel.setToolTipText("Tests identified as matching.");
    }

    public void setYellowLabel(int num) {
        yellowLabel = new JTextArea(" "+num+" ");
        yellowLabel.setFont(PATH_FONT);
        yellowLabel.setBackground(YELLOW);
        yellowLabel.setLineWrap(false);
        yellowLabel.setWrapStyleWord(false);
        yellowLabel.setEditable(false);
        yellowLabel.setToolTipText("Tests identified as spacing issues.");
    }

    public void setRedLabel(int num) {
        redLabel = new JTextArea(" "+num+" ");
        redLabel.setFont(PATH_FONT);
        redLabel.setBackground(RED);
        redLabel.setLineWrap(false);
        redLabel.setWrapStyleWord(false);
        redLabel.setEditable(false);
        redLabel.setToolTipText("Tests identified as NOT matching.");
    }

    public void refreshStatPanel() {    
        statPanel.remove(greenLabel);                        
        statPanel.remove(yellowLabel);                        
        statPanel.remove(redLabel);  
        setGreenLabel(countGreen);
        setYellowLabel(countYellow);
        setRedLabel(countRed);                              
        statPanel.add(greenLabel, BorderLayout.WEST);
        statPanel.add(yellowLabel, BorderLayout.CENTER);
        statPanel.add(redLabel, BorderLayout.EAST);
    }

    public void makeHeaderFrame(TestData td){
        JPanel jp = new JPanel();
        subFrameList.add(jp);
        JTextArea textArea = new JTextArea("\n"+td.getHeader()+"\n");
        textArea.setFont(HEADER_FONT);
        textArea.setBackground(HEADER_BG_COLOR);        
        textArea.setColumns(td.getHeader().length());
        textArea.setLineWrap(false);
        textArea.setEditable(false);
        jp.setBackground(HEADER_BG_COLOR);
        jp.setBorder(BorderFactory.createLineBorder(new Color(0)));
        jp.add(textArea,BorderLayout.CENTER);        
    }

    public void makeMessageFrame(TestData td){
        JPanel jp = new JPanel(new BorderLayout());        
        subFrameList.add(jp); 

        JPanel jpInner = new JPanel(new BorderLayout());
        jpInner.setBorder(new EmptyBorder(5,15,5,5));
        jpInner.setBackground(td.getResultColor());

        JTextArea textArea = new JTextArea(td.getMessage());
        textArea.setFont(MESSAGE_FONT);
        textArea.setBackground(td.getResultColor());
        if (td.getResultColor() == GREEN) countGreen++;
        else if (td.getResultColor() == YELLOW) countYellow++;
        else if (td.getResultColor() == RED) countRed++;        
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        jp.setBackground(td.getResultColor());
        jp.setBorder(BorderFactory.createLineBorder(new Color(0)));
        jpInner.add(textArea,BorderLayout.CENTER);
        jp.add(jpInner,BorderLayout.CENTER);
    }

    public void makeSrcButtonFrame(TestData td){
        JPanel jp = new JPanel(new BorderLayout());        
        subFrameList.add(jp); 

        JPanel jpInner = new JPanel(new FlowLayout(FlowLayout.LEADING));
        jpInner.setBorder(new EmptyBorder(0,15,0,5));
        jpInner.setBackground(Color.WHITE);
        JTextArea lbl = new JTextArea("Source Files: ");
        lbl.setBackground(Color.WHITE);
        jpInner.add(lbl);

        String[] fileName = td.getSrcFiles();
        int oldSize = srcButtonList.size();        
        for(int i = 0; i < fileName.length; i++) {   
            //Make button

            //See if file exists.  Disable button if file is missing.
            File temp = null;
            try { 
                temp = new File(srcPath + "/" + fileName[i]);
                if (! temp.exists()) {
                    temp = new File(srcPath + "/" + fileName[i] + ".java");
                }
                if (! temp.exists()) temp = null;
            } 
            catch (Exception e) { }            

            JButton newButton;
            if (temp != null) {
                newButton = new JButton(temp.getName());
            } else {
                newButton = new JButton(fileName[i]);
                newButton.setEnabled(false);
            }
            srcButtonList.add(newButton);              
        }

        for(int i = oldSize; i < srcButtonList.size(); i++){
            final int index = i;
            srcButtonList.get(index).addActionListener( 
                new ActionListener() 
                { 
                    public void actionPerformed(ActionEvent e) { 
                        SourceCodeFrame srcFrame = new SourceCodeFrame(srcPath + "/" + srcButtonList.get(index).getLabel());
                    } 
                }
            );
            jpInner.add(srcButtonList.get(index));
        }

        JScrollPane srcScrollable = new JScrollPane(jpInner,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        WheelScrolling.install(srcScrollable);
        srcScrollable.setBorder(BorderFactory.createEmptyBorder());

        jp.add(srcScrollable,BorderLayout.CENTER);
        jp.setBorder(BorderFactory.createLineBorder(new Color(0)));
    }

    public JPanel getMethodCallPanel(TestData td) {
        JPanel jp = new JPanel(new BorderLayout());   
        jp.setBackground(Color.WHITE);
        jp.setBorder(BorderFactory.createTitledBorder("Invoking"));

        JPanel jpInner = new JPanel(new BorderLayout());
        jpInner.setBorder(new EmptyBorder(5,5,5,5));
        jpInner.setBackground(Color.WHITE);

        JTextArea textArea = new JTextArea(td.getMethodCall());        
        textArea.setFont(REGULAR_FONT);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        jpInner.add(textArea,BorderLayout.CENTER);
        jp.add(jpInner,BorderLayout.CENTER);
        return jp;
    }

    public JPanel getResultPanel(TestData td) {
        JPanel jp = new JPanel(new BorderLayout());
        jp.setBackground(Color.WHITE);
        jp.setBorder(BorderFactory.createTitledBorder("Result"));

        JPanel jpInner = new JPanel(new BorderLayout());
        jpInner.setBorder(new EmptyBorder(5,5,5,5));
        jpInner.setBackground(Color.WHITE);

        JTextArea textArea = new JTextArea(td.getResult());        
        textArea.setFont(REGULAR_FONT);        
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        if (td.getResultColor() != null) {
            if (td.getResultColor() == GREEN) countGreen++;
            else if (td.getResultColor() == YELLOW) countYellow++;
            else if (td.getResultColor() == RED) countRed++;
            textArea.setBackground(td.getResultColor());
            textArea.setFont(textArea.getFont().deriveFont(Font.BOLD));
        }
        jpInner.add(textArea,BorderLayout.CENTER);
        jp.add(jpInner,BorderLayout.CENTER);
        return jp;
    }

    public JPanel getExpOutPanel(TestData td) {
        JPanel jp = new JPanel(new BorderLayout());;    
        jp.setBackground(Color.WHITE);
        jp.setBorder(BorderFactory.createTitledBorder("Expected Output/Return Value"));

        JPanel jpInner = new JPanel(new BorderLayout());
        jpInner.setBorder(new EmptyBorder(5,5,5,5));
        jpInner.setBackground(Color.WHITE);

        StyledDocument document = new DefaultStyledDocument();
        SimpleAttributeSet attributes = new SimpleAttributeSet();
        StyleConstants.setFontFamily(attributes, "Monospace");
        attributes.addAttribute(StyleConstants.FontConstants.Family, Font.MONOSPACED);
        attributes.addAttribute(StyleConstants.FontConstants.Size, 16);
        try {
            if (td.getExpectedOut() != null)
                document.insertString(0, td.getExpectedOut() + "\n", attributes);            
        } catch (BadLocationException badLocationException) {
            System.out.println("Unable to build expected output document.");
        }

        /*  I CAN'T FIGURE OUT HOW TO SET THIS
        textArea.setLineWrap(true);
         */
        JTextPane textPane = new JTextPane(document);
        textPane.setEditable(false);
        jpInner.add(textPane,BorderLayout.CENTER);
        jp.add(jpInner,BorderLayout.CENTER);
        return jp;
    }

    public JPanel getActOutPanel(TestData td) {
        JPanel jp = new JPanel(new BorderLayout());
        jp.setBackground(Color.WHITE);
        jp.setBorder(BorderFactory.createTitledBorder("Actual Output/Return Value"));

        JPanel jpInner = new JPanel(new BorderLayout());
        jpInner.setBorder(new EmptyBorder(5,5,5,5));
        jpInner.setBackground(Color.WHITE);

        StyledDocument document = new DefaultStyledDocument();
        SimpleAttributeSet attributesNormal = new SimpleAttributeSet();
        StyleConstants.setFontFamily(attributesNormal, "Monospace");
        attributesNormal.addAttribute(StyleConstants.FontConstants.Family, Font.MONOSPACED);
        attributesNormal.addAttribute(StyleConstants.FontConstants.Size, 16);
        SimpleAttributeSet attributesMistake = (SimpleAttributeSet)(attributesNormal.clone());
        attributesMistake.addAttribute(StyleConstants.CharacterConstants.Bold, Boolean.TRUE);
        attributesMistake.addAttribute(StyleConstants.ColorConstants.Foreground, new Color(200, 0, 0));

        String textToInsert = td.getActualOut();
        if (textToInsert != null)
            try {
                int startLocation = textToInsert.indexOf(mistakeStartFlag);
                int stopLocation = textToInsert.indexOf(mistakeStopFlag);
                while (startLocation != -1 && stopLocation != -1) {
                    String good = textToInsert.substring(0, startLocation);
                    String mistake = textToInsert.substring(startLocation+mistakeStartFlag.length(), stopLocation);
                    textToInsert = textToInsert.substring(stopLocation+mistakeStopFlag.length())  ;                 
                    document.insertString(document.getLength(), good, attributesNormal);
                    document.insertString(document.getLength(), mistake, attributesMistake);                
                    startLocation = textToInsert.indexOf(mistakeStartFlag);
                    stopLocation = textToInsert.indexOf(mistakeStopFlag);
                }
                //insert remaining text            
                document.insertString(document.getLength(), textToInsert + "\n", attributesNormal);
            } catch (BadLocationException badLocationException) {
                System.out.println("Unable to parse actual output for style document.");
            }

        JTextPane textPane = new JTextPane(document);
        textPane.setEditable(false);
        jpInner.add(textPane,BorderLayout.CENTER);
        jp.add(jpInner,BorderLayout.CENTER);
        return jp;
    }

    public void makeFourSubFrames(TestData td){
        GridLayout myGL = new GridLayout(1,2);
        myGL.setHgap(8);
        EmptyBorder padding = new EmptyBorder(5,10,5,10);

        JPanel jpOuter = new JPanel();        
        jpOuter.setLayout(new BoxLayout(jpOuter, BoxLayout.Y_AXIS));
        JPanel jpTop = new JPanel(myGL);        
        JPanel jpBottom = new JPanel(myGL);  

        jpTop.setBackground(Color.WHITE);
        jpBottom.setBackground(Color.WHITE);
        jpTop.setBorder(padding);        
        jpBottom.setBorder(padding);

        //4 panels
        JPanel topLeft = new JPanel(new BorderLayout());
        topLeft.add(getMethodCallPanel(td), BorderLayout.NORTH);
        topLeft.setBackground(Color.WHITE);

        JPanel topRight = new JPanel(new BorderLayout());
        topRight.setBackground(Color.WHITE);
        topRight.add(getResultPanel(td), BorderLayout.NORTH);

        JScrollPane bottomLeftScrollable = new JScrollPane(getExpOutPanel(td),
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        WheelScrolling.install(bottomLeftScrollable);
        bottomLeftScrollable.setBorder(BorderFactory.createEmptyBorder());

        JScrollPane bottomRightScrollable = new JScrollPane(getActOutPanel(td),
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        WheelScrolling.install(bottomRightScrollable);
        bottomRightScrollable.setBorder(BorderFactory.createEmptyBorder());

        jpTop.add(topLeft);
        jpTop.add(topRight);              
        jpBottom.add(bottomLeftScrollable);  
        jpBottom.add(bottomRightScrollable);

        jpOuter.add(jpTop);
        jpOuter.add(jpBottom);
        jpOuter.setBackground(Color.WHITE);
        jpOuter.setBorder(BorderFactory.createLineBorder(new Color(0))); 
        subFrameList.add(jpOuter);
    }

    public void makeTwoSubFrames(TestData td){
        GridLayout myGL = new GridLayout(1,2);
        myGL.setHgap(8);
        EmptyBorder padding = new EmptyBorder(5,10,5,10);

        JPanel jpOuter = new JPanel();        
        jpOuter.setLayout(new BoxLayout(jpOuter, BoxLayout.Y_AXIS));
        JPanel jpTop = new JPanel(myGL);     

        jpTop.setBackground(Color.WHITE);
        jpTop.setBorder(padding);   

        //2 panels
        JPanel topLeft = new JPanel(new BorderLayout());
        topLeft.add(getMethodCallPanel(td), BorderLayout.NORTH);
        topLeft.setBackground(Color.WHITE);

        JPanel topRight = new JPanel(new BorderLayout());
        topRight.setBackground(Color.WHITE);
        topRight.add(getResultPanel(td), BorderLayout.NORTH);

        jpTop.add(topLeft);
        jpTop.add(topRight);          

        jpOuter.add(jpTop);
        jpOuter.setBackground(Color.WHITE);
        jpOuter.setBorder(BorderFactory.createLineBorder(new Color(0))); 
        subFrameList.add(jpOuter);
    }

    /**
     * ScrollablePanel is basically a JPanel that will properly resize when it contains a JScrollPane
     */
    private static class ScrollablePanel extends JPanel implements Scrollable {        
        public Dimension getPreferredScrollableViewportSize() { 
            return super.getPreferredSize(); }

        public int getScrollableUnitIncrement(java.awt.Rectangle visibleRect, int orientation, int direction) { 
            return SCROLL_SPEED; }

        public int getScrollableBlockIncrement(java.awt.Rectangle visibleRect, int orientation, int direction) { 
            return SCROLL_SPEED; }

        public boolean getScrollableTracksViewportWidth() { 
            return true; }

        public boolean getScrollableTracksViewportHeight() { 
            return false; }
    } //end Inner Class ScrollablePanel

    /**
     * A TestData object performs requested tests and stores the information collected during the test.  
     * All these TestData objects are loaded into a list of TestResults 
     * which is used to build the GUI's results scroll pane.
     */
    static class TestData {
        public static final double VERSION_NUM = V_NUM;
        private static ByteArrayOutputStream baos = new ByteArrayOutputStream();  
        private static long timeOutSec = 2;
        private String methodCall, result;
        private String expectedOut, actualOut;   
        private Color resultColor;
        private String header, message;        
        private String[] srcFiles;        

        public TestData() {  } 

        public TestData(String s, boolean isHeader) {
            if (isHeader)  this.header = s;
            else  this.message = s;
        }

        public TestData(String methodCall, String result, String expectedOut, String actualOut) {
            this(methodCall, result, expectedOut, actualOut, new Color(255, 255, 255));
        }

        public TestData(String methodCall, String result, String expectedOut, String actualOut, Color resultColor) {
            //header and message remain null
            this.methodCall = methodCall;
            this.result = result;
            this.expectedOut = expectedOut;
            this.actualOut = actualOut;
            this.resultColor = resultColor;
        }       

        public TestData(String[] srcFiles){
            this.srcFiles = srcFiles;
        }

        public static void setTimeOutSec(int sec) { timeOutSec = (long) sec; }

        public void setColor(int r, int g, int b, int a) { resultColor = new Color(r, g, b, a); }

        public void setColor(int r, int g, int b) { resultColor = new Color(r, g, b); }

        public String getHeader() { 
            return header; }

        public String getMessage() { 
            return message; }

        public String getMethodCall() { 
            return methodCall; }

        public String getResult() { 
            return result; }

        public String getExpectedOut() { 
            return expectedOut; }

        public String getActualOut() { 
            return actualOut; }

        public Color getResultColor() { 
            return resultColor; }

        public String[] getSrcFiles(){
            return srcFiles;
        }

        public String setHeader(String header) { 
            this.header = header;
            return header;
        }

        public String setMessage(String message) { 
            resultColor = MESSAGE_BG_COLOR;
            return this.message = message; 
        }

        public void setResultColorForMessage(boolean correct) { 
            if (correct) resultColor = GREEN;
            else resultColor = RED;
        }

        public String setMethodCall(String methodCall) { 
            return this.methodCall = methodCall; }

        public String setResult(String result) { 
            return this.result = result; }

        public String setResult(String result, Color resultColor) { 
            this.resultColor = resultColor;
            return this.result = result;
        }

        public String setExpectedOut(String expectedOut) { 
            this.expectedOut = expectedOut;
            return expectedOut;
        }

        public String setActualOut(String actualOut) { 
            return this.actualOut = actualOut; }

        public static void header(String name) { 
            testResults.add(new TestGUI.TestData(name, true)); 
        }

        public static void srcButton(String srcFileName) { 
            String[] fileNames = srcFileName.split(",");
            for (int i = 0; i < fileNames.length; i++) fileNames[i] = fileNames[i].trim();
            testResults.add(new TestGUI.TestData(fileNames)); 
        }

        public static void srcButton(String[] srcFileNames) { 
            testResults.add(new TestGUI.TestData(srcFileNames)); 
        }

        private static void messageAlert(String m) {
            TestGUI.TestData newEntry = new TestGUI.TestData(m, false); //set message
            newEntry.setResultColorForMessage(false);  //red 
            testResults.add(0, newEntry);
        }

        public static void message(String m) {
            testResults.add(new TestGUI.TestData(m, false));
        }       

        public static void message(String m, boolean correct) {
            TestGUI.TestData newEntry = new TestGUI.TestData(m, false); //set message
            newEntry.setResultColorForMessage(correct);
            testResults.add(newEntry);
        }  

        /** 
         * This method returns a Class object for the given class name (as String) as seen by the 
         * URLClassLoader for this student.  
         * 
         * Class.forName unexpectly crashes when attempting to load the Car.class if the file
         * has been improperly named car.class (case is wrong).  The URLClassLoader does not
         * notice the problem until it is too late, causing an exception to not be thrown currectly.
         * 
         * Crazy solution: break encapsulation to run the protected findClass of the URLClassLoader
         * to manually attempt a "find and load."  This will properly throw an InvocationTargetException
         * if the class could not be loaded.  However, attempting to load the same class twice also
         * causes an InvocationTargetException.  Therefore, when this exception is thrown, the detail
         * message of the target exception must be analyzed to determine the cause.  Bad class name
         * or class is already loaded?
         */
        public static Class getClassFromName(String cName) {
            try {
                Method m = URLClassLoader.class.getDeclaredMethod("findClass", new Class[] { String.class });
                m.setAccessible(true);                
                m.invoke(classLoader, cName);  //throws ITE if the class is missing, has wrong case, or is already loaded.
                return Class.forName(cName, true, classLoader);                
            }
            catch (InvocationTargetException e) {                
                String message = e.getTargetException().getMessage();
                if (message.contains("duplicate")) { //this class was already loaded 
                    try { return  Class.forName(cName, true, classLoader); } 
                    catch (Exception e2) { return null; }
                }
                return null; 
            }
            catch (Exception e) { return null; }
        }

        public static <T extends Enum<T>> T getEnumFromName(String eName, String valName) {
            try {
                Class<T> e = getClassFromName(eName);
                return Enum.valueOf(e, valName);
            } catch (Exception e) { return null; }
        }

        public static Object makeObject(String cName, Object[] args, String userInputScript) {
            //makeObject instantiates & return an object of class cName with supplied arguments
            baos = new ByteArrayOutputStream(); 
            System.setOut(new PrintStream(baos));
            TestGUI.TestData td = new TestGUI.TestData();
            testResults.add(td);
            if (args == null) args = new Object[0];
            String methodCall = "constructor: " + cName + "(" + getParam(args) + ")";
            if (userInputScript != null) methodCall += "\n**Input provided by user input script";
            td.setMethodCall(methodCall); 
            Object retObject = null;                                  

            ExecutorService es = null;
            FutureTask<?>  theTask = null;

            try {            
                ArrayList<Class[]> argOptions = getWideningOptions(args);
                //Class<?> c = Class.forName(cName, true, classLoader);
                Class<?> c = getClassFromName(cName);
                if (c == null) throw new ClassNotFoundException();

                Constructor[] availableConstructors = c.getConstructors();
                Constructor conSearch = null; 
                outerLoop:
                for (Class[] argCombo : argOptions) {
                    for (Constructor conOption : availableConstructors) {
                        //See if this conOption is a good fit
                        //It's parameters must match with this argCombo
                        if (conOption.getParameterCount() != argCombo.length) 
                            continue;
                        Class[] paramCombo = conOption.getParameterTypes();
                        boolean goodFit = true;
                        for (int i = 0; i < paramCombo.length; i++) {                       
                            if (! (paramCombo[i].isAssignableFrom(argCombo[i])))                            
                                goodFit = false;
                        }
                        if (goodFit) {
                            conSearch = conOption;
                            break outerLoop; //will break for loop as soon as a proper method signature is found
                        }
                    }
                }
                if (conSearch == null) throw new NoSuchMethodException();
                Constructor con = conSearch;                              

                final Object[] argList = args;
                theTask = new FutureTask<Object>(
                    new Callable<Object>() 
                    {
                        public Object call() {
                            Object retObject = null;
                            if (userInputScript != null) 
                                EchoingByteArrayInputStream.injectScript(userInputScript);
                            try {                                    
                                retObject = con.newInstance(argList);
                            } catch (Exception e) { retObject = e; }                                
                            return retObject;
                        }
                    });

                es = Executors.newSingleThreadExecutor();
                es.execute(theTask);
                retObject = theTask.get(timeOutSec, TimeUnit.SECONDS);
                es.shutdownNow();
                if (retObject instanceof Exception) {
                    Exception e = (Exception)retObject;
                    retObject = null;
                    throw (Exception)(e.getCause()); 
                }
                if (retObject != null) td.setResult("Completed.");  
                else td.setResult("Unsuccessful. null object.  Must explicitly declare class as public.", TestGUI.RED);  

                if (baos.size() > 0) td.setActualOut(baos.toString());                   

            } catch (ClassNotFoundException e) {
                td.setResult("Error: Class not found. Ensure that source file exists and will compile.", TestGUI.RED); 
                if (baos.size()>0) td.setActualOut(baos.toString());  
            } catch (NoSuchMethodException e) {
                td.setResult("Error: Could not call constructor", TestGUI.RED); 
                if (baos.size()>0) td.setActualOut(baos.toString()); 
            } catch (TimeoutException e) {             
                td.setResult("Error: Constructor timed out (Inefficient solution? Infinite loop?)", TestGUI.RED); 
                if (theTask != null) theTask.cancel(true);
                if (es != null) es.shutdownNow();
                //Now let's be more aggressive                
                try{
                    final Field threadField = theTask.getClass().getDeclaredField("runner");
                    threadField.setAccessible(true);                    
                    Thread t = (Thread)threadField.get(theTask);
                    t.stop();
                }catch(Exception e2){
                    System.out.print("Problem occured while forcibly stopping FutureTask thread");
                }
                if (baos.size() > 1000) {
                    byte[] truncBA = baos.toByteArray();
                    String trunc = new String(truncBA, 0, 1000);
                    td.setActualOut(trunc+"...\n[truncated]");
                }
                else
                if (baos.size()>0) td.setActualOut(baos.toString());               
            } catch (NoSuchElementException e) {
                td.setResult("Error: More data was requested than the script provided.", TestGUI.RED); 
                if (baos.size() > 1000) {
                    byte[] truncBA = baos.toByteArray();
                    String trunc = new String(truncBA, 0, 1000);
                    td.setActualOut(trunc+"...\n[truncated]");
                }
                else
                if (baos.size()>0) td.setActualOut(baos.toString());  
            } catch (Exception e) {
                td.setResult("Error: Crashed while running\n"+e, TestGUI.RED);  
                if (baos.size() > 1000) {
                    byte[] truncBA = baos.toByteArray();
                    String trunc = new String(truncBA, 0, 100);
                    td.setActualOut(trunc+"...\n[truncated]");
                }
                else
                if (baos.size()>0) td.setActualOut(baos.toString());                  
            }

            System.setOut(originalSystemOut); //Ensure that System.out is restored.
            return retObject;                   
        }

        public static boolean runAsThread(Object o, String name, Object[] args) {
            String methodCall = "";
            if (args == null) args = new Object[0];
            if (o == null) methodCall += "null.";
            else if (o instanceof Class) methodCall += ((Class)o).getName()+".";
            else methodCall += o.getClass().getName().toLowerCase()+"Object.";
            methodCall += name + "(" + getParam(args) + ")";

            try { 
                ArrayList<Class[]> argOptions = getWideningOptions(args);

                //Is o an actual object or is it a Class?
                Class c = null;                
                if (o instanceof Class) //If o is a Class, cast it as such.
                    c = (Class)o;
                else {  //o is an object.  We need to know what class it belogs to.
                    if (o != null)
                        c = o.getClass();
                    else {  //o isn't even a thing
                        throw new Exception("No object/class found.");
                    }
                }

                Method[] availableMethods = c.getMethods();
                Method methodSearch = null;  
                outerLoop:
                for (Class[] argCombo : argOptions) {
                    for (Method methodOption : availableMethods) {
                        //See if this methodOption is a good fit
                        //Must have same name and it's parameters must match with this argCombo
                        if (!methodOption.getName().equals(name) || methodOption.getParameterCount() != argCombo.length) 
                            continue;
                        Class[] paramCombo = methodOption.getParameterTypes();
                        boolean goodFit = true;
                        for (int i = 0; i < paramCombo.length; i++) {                       
                            if (! (paramCombo[i].isAssignableFrom(argCombo[i])))                            
                                goodFit = false;
                        }
                        if (goodFit) {
                            methodSearch = methodOption;
                            break outerLoop; //will break for loop as soon as a proper method signature is found
                        }
                    }
                }
                if (methodSearch == null) throw new NoSuchMethodException();
                Method m = methodSearch;
                final Object[] ARG_LIST = args;
                final String METHOD_CALL = methodCall;

                Runnable task = new Runnable() 
                    {
                        public void run() {                            
                            try {
                                m.invoke(o, ARG_LIST);
                            } catch (Exception e) { 
                                System.out.println("Crashed while running: " + METHOD_CALL); 
                            }
                        }
                    };
                Thread t = new Thread(task);
                t.start();
                return true;
            } catch (Exception e) { 
                return false; 
            }            
        }       

        public static Object makeObject(String cName, Object[] args) {
            return makeObject(cName, args, null);  //no input script requested
        }

        public static Object testMethod(Object o, String name, Object[] args, String expOut, double allowableError, String userInputScript) {                
            baos = new ByteArrayOutputStream(); 
            System.setOut(new PrintStream(baos));

            TestGUI.TestData td = new TestGUI.TestData();
            testResults.add(td);
            String methodCall = "";
            if (args == null) args = new Object[0];
            if (o == null) methodCall += "null.";
            else if (o instanceof Class) methodCall += ((Class)o).getName()+".";
            else methodCall += o.getClass().getName().toLowerCase()+"Object.";
            methodCall += name + "(" + getParam(args) + ")";
            if (userInputScript != null) methodCall += "\n**Input provided by user input script";
            td.setMethodCall(methodCall);
            td.setExpectedOut(expOut);
            Object retObject = null;

            ExecutorService es = null;
            FutureTask<?>  theTask = null;

            try { 
                ArrayList<Class[]> argOptions = getWideningOptions(args);

                //Is o an actual object or is it a Class?
                Class c = null;                
                if (o instanceof Class) //If o is a Class, cast it as such.
                    c = (Class)o;
                else {  //o is an object.  We need to know what class it belogs to.
                    if (o != null)
                        c = o.getClass();
                    else {  //o isn't even a thing
                        throw new Exception("No object/class found.");
                    }
                }

                Method[] availableMethods = c.getMethods();
                Method methodSearch = null;  
                outerLoop:
                for (Class[] argCombo : argOptions) {
                    for (Method methodOption : availableMethods) {
                        //See if this methodOption is a good fit
                        //Must have same name and it's parameters must match with this argCombo
                        if (!methodOption.getName().equals(name) || methodOption.getParameterCount() != argCombo.length) 
                            continue;
                        Class[] paramCombo = methodOption.getParameterTypes();
                        boolean goodFit = true;
                        for (int i = 0; i < paramCombo.length; i++) {                       
                            if (! (paramCombo[i].isAssignableFrom(argCombo[i])))                            
                                goodFit = false;
                        }
                        if (goodFit) {
                            methodSearch = methodOption;
                            break outerLoop; //will break for loop as soon as a proper method signature is found
                        }
                    }
                }
                if (methodSearch == null) throw new NoSuchMethodException();
                Method m = methodSearch;
                final Object[] argList = args;
                theTask = new FutureTask<Object>(
                    new Callable<Object>() 
                    {
                        public Object call() {
                            Object retObject = null;
                            if (userInputScript != null) 
                                EchoingByteArrayInputStream.injectScript(userInputScript);
                            try {
                                retObject = m.invoke(o, argList);
                            } catch (Exception e) { 
                                retObject = e; 
                            }
                            return retObject;
                        }
                    });
                es = Executors.newSingleThreadExecutor();
                es.execute(theTask);
                retObject = theTask.get(timeOutSec, TimeUnit.SECONDS);

                //We got our return object. Politely request the test task to shut down.
                theTask.cancel(true);
                es.shutdownNow();
                if (retObject instanceof Exception) {
                    Exception e = (Exception)retObject;
                    retObject = null;
                    throw (Exception)(e.getCause()); 
                }

                String actOut = null;
                if (retObject != null) { 
                    if (retObject.getClass().isArray()) actOut = baos.toString() + arrayAsString(retObject);
                    else actOut = baos.toString() + retObject;
                } else {  //no return object?  Must have been a void method.  Check baos for printed output.
                    if (baos.size() > 0) actOut = baos.toString();                    
                }      

                actOut = fixSlashR(actOut);
                td.setActualOut(actOut);  //will be replaced later with marked up output if needed.
                if (expOut != null) {
                    verifyAndMarkUpOutput(td, expOut, actOut, allowableError);
                } else {
                    td.setResult("Completed.");
                }

            } catch (NoSuchMethodException e) {            
                td.setResult("Error: Could not find method. Similar signature not found or method not public.", TestGUI.RED); 
            } catch (TimeoutException e) {
                td.setResult("Error: Method timed out (Inefficient code? Infinite loop?)", TestGUI.RED); 
                //This is how we used to politely ask for shutdown.
                if (theTask != null) theTask.cancel(true);
                if (es != null) es.shutdownNow();
                //Now let's be more aggressive                
                try{
                    final Field threadField = theTask.getClass().getDeclaredField("runner");
                    threadField.setAccessible(true);                    
                    Thread t = (Thread)threadField.get(theTask);
                    t.stop();
                }catch(Exception e2){
                    System.out.print("Problem occured while forcibly stopping FutureTask thread");
                }
                if (baos.size() > 1000) {
                    byte[] truncBA = baos.toByteArray();
                    String trunc = new String(truncBA, 0, 1000);
                    td.setActualOut(trunc+"...\n[truncated]");
                }
                else
                if (baos.size()>0) td.setActualOut(baos.toString());           
            } catch (NoSuchElementException e) {
                td.setResult("Error: More data was requested than the script provided.", TestGUI.RED); 
                if (baos.size() > 1000) {
                    byte[] truncBA = baos.toByteArray();
                    String trunc = new String(truncBA, 0, 1000);
                    td.setActualOut(trunc+"...\n[truncated]");
                }
                else
                if (baos.size()>0) td.setActualOut(baos.toString());  
            } catch (Exception e) {
                if (e.getMessage() != null && e.getMessage().equals("No object/class found.")) {
                    td.setResult("Error: No object/class exists to run method.", TestGUI.RED); 
                } else {
                    td.setResult("Error: Crashed while running\n"+e, TestGUI.RED); 
                    if (baos.size() > 1000) {
                        byte[] truncBA = baos.toByteArray();
                        String trunc = new String(truncBA, 0, 1000);
                        td.setActualOut(trunc+"...\n[truncated]");
                    }
                    else
                    if (baos.size()>0) td.setActualOut(baos.toString());  
                }
            }

            System.setOut(originalSystemOut); //Ensure that System.out is restored.
            return retObject;             
        }  

        public static Object testMethod(String cName, String name, Object[] args, String expOut, double allowableError, String userInputScript) {              
            //USE STRING FOR CLASS NAME WHEN WANTING TO TEST A STATIC METHOD
            //testMethod (String of class name containing static method, method name, array of method parameters, expected output)      
            //testMethod will print the data returned by calling the method.        
            try {                
                //Class<?> c = Class.forName(cName, true, classLoader);
                Class<?> c = getClassFromName(cName);
                if (c == null) throw new ClassNotFoundException();
                return testMethod(c, name, args, expOut, allowableError, userInputScript);
            } catch (LinkageError e) {
                testResults.add(new TestGUI.TestData(cName+"."+name+"()", 
                        "Error: Class not found. Ensure that source file exists, is named correctly, and will compile.", null, null, TestGUI.RED)); 
            } catch (ClassNotFoundException e) {
                testResults.add(new TestGUI.TestData(cName+"."+name+"()", 
                        "Error: Class not found. Ensure that source file exists, is named correctly, and will compile.", null, null, TestGUI.RED)); 
            } catch (Exception e) {
                testResults.add(new TestGUI.TestData(cName+"."+name+"()", 
                        "Error: No object/class exists to run the method.", null, null, TestGUI.RED));               
            }  
            return null;  //in the event that we had exception
        }        

        public static Object testMethod(Object o, String name, Object[] args, String expOut, double allowableError) {
            return testMethod(o, name, args, expOut, allowableError, null);
        }

        public static Object testMethod(String cName, String name, Object[] args, String expOut, double allowableError) {              
            return testMethod(cName, name, args, expOut, allowableError, null);
        }

        public static Object testMethod(Object o, String name, Object[] args, String expOut, String userInputScript) {
            return testMethod(o, name, args, expOut, 0.0, userInputScript);
        }

        public static Object testMethod(String cName, String name, Object[] args, String expOut, String userInputScript) {              
            return testMethod(cName, name, args, expOut, 0.0, userInputScript);
        }

        public static Object testMethod(Object o, String name, Object[] args, String expOut) {
            return testMethod(o, name, args, expOut, 0.0, null);
        }

        public static Object testMethod(String cName, String name, Object[] args, String expOut) {              
            return testMethod(cName, name, args, expOut, 0.0, null);
        }

        public static Object testMethod(Object o, String name, Object[] args) {
            return testMethod(o, name, args, null, 0.0, null);
        }

        public static Object testMethod(String cName, String name, Object[] args) {              
            return testMethod(cName, name, args, null, 0.0, null);
        }

        private static void verifyAndMarkUpOutput(TestData td, String expOut, String actOut, double allowableError) {
            if (expOut == null) 
                return;
            if (expOut.equals("") && (actOut == null || actOut.equals(""))) {
                td.setResult("Perfect", TestGUI.GREEN);
                return;
            }
            if (actOut == null) {  //we have an expected output, but no actual output
                td.setResult("NO MATCH", TestGUI.RED);
                return;
            }

            //We have an expected output and an actual output.  Let's try to match them up.    
            String expOutUnaltered = expOut, actOutUnaltered = actOut;
            boolean perfect = true;
            String markup = "";                     
            int start = 0;  //start location of difference.
            Scanner expectedFull = new Scanner(expOut);
            Scanner actualFull = new Scanner(actOut);
            Scanner eo = new Scanner("");
            Scanner ao = new Scanner("");
            String eLine = "";
            String aLine = "";
            boolean hasWildcard = false;

            while (perfect && (expectedFull.hasNext() || eo.hasNext()) && (actualFull.hasNext() || ao.hasNext())) {  //no mistake found and still data to scan                
                if (! eo.hasNext()) {
                    eLine = "";
                    while (eLine.equals("")) eLine = expectedFull.nextLine();                
                    eo = new Scanner(eLine);
                }
                if (! ao.hasNext()) {
                    aLine = "";
                    while (aLine.equals("")) {
                        aLine = actualFull.nextLine();                
                        if (aLine.equals("")) start++;
                    }
                    ao = new Scanner(aLine);                
                }

                while (perfect && eo.hasNext() && ao.hasNext()) {  //no mistake found and still data to scan
                    String eWord = eo.next();
                    String aWord = ao.next();

                    if (! eWord.equals(aWord))  {
                        //tokens did not match!                          
                        //See if it is a wildcard with appropriate value
                        if (eWord.contains("%int%")) {
                            hasWildcard = true;
                            int wcStart = eWord.indexOf("%int%");
                            int wcEnd = eWord.lastIndexOf("%");
                            try {
                                String eBefore = eWord.substring(0, wcStart);
                                String eWC = eWord.substring(wcStart, wcEnd+1);
                                String eAfter = eWord.substring(wcEnd+1);
                                String aBefore = aWord.substring(0, wcStart);
                                String aAfter = aWord.substring(aWord.length()-eAfter.length());
                                String aWC = aWord.substring(wcStart, aWord.length()-eAfter.length());
                                if ( eBefore.equals(aBefore) && eAfter.equals(eAfter) ) {
                                    Integer.parseInt(aWC);
                                    continue; //if it parsed, this is acceptable.  Continue to next token.
                                }                                
                            } catch (Exception e) { } //This didn't word so tokens don't match
                        }
                        else if (eWord.contains("%double%")) {
                            hasWildcard = true;
                            int wcStart = eWord.indexOf("%double%");
                            int wcEnd = eWord.lastIndexOf("%");
                            try {
                                String eBefore = eWord.substring(0, wcStart);
                                String eWC = eWord.substring(wcStart, wcEnd+1);
                                String eAfter = eWord.substring(wcEnd+1);
                                String aBefore = aWord.substring(0, wcStart);
                                String aAfter = aWord.substring(aWord.length()-eAfter.length());
                                String aWC = aWord.substring(wcStart, aWord.length()-eAfter.length());
                                if ( eBefore.equals(aBefore) && eAfter.equals(eAfter) ) {
                                    Double.parseDouble(aWC);
                                    continue; //if it parsed, this is acceptable.  Continue to next token.
                                }                                
                            } catch (Exception e) { } //This didn't word so tokens don't match
                        }
                        else if (eWord.contains("%word%")) {  
                            hasWildcard = true;
                            int wcStart = eWord.indexOf("%word%");
                            int wcEnd = eWord.lastIndexOf("%");
                            try {
                                String eBefore = eWord.substring(0, wcStart);
                                String eWC = eWord.substring(wcStart, wcEnd+1);
                                String eAfter = eWord.substring(wcEnd+1);
                                String aBefore = aWord.substring(0, wcStart);
                                String aAfter = aWord.substring(aWord.length()-eAfter.length());
                                String aWC = aWord.substring(wcStart, aWord.length()-eAfter.length());
                                if ( eBefore.equals(aBefore) && eAfter.equals(eAfter) ) {
                                    continue; //good
                                }                                
                            } catch (Exception e) { } //This didn't word so tokens don't match
                        }
                        else if (eWord.equals("%line%")) {                            
                            //empty the actual out line scanner so it is forced to move to the next line
                            hasWildcard = true;
                            ao = new Scanner("");
                            continue; //skip this token
                        } else if (eWord.contains("%int")) {
                            //ranged int 
                            hasWildcard = true;
                            int wcStart = eWord.indexOf("%int");
                            int wcEnd = eWord.lastIndexOf("%");
                            try {
                                String eBefore = eWord.substring(0, wcStart);
                                String eWC = eWord.substring(wcStart, wcEnd+1);
                                String eAfter = eWord.substring(wcEnd+1);
                                String aBefore = aWord.substring(0, wcStart);
                                String aAfter = aWord.substring(aWord.length()-eAfter.length());
                                String aWC = aWord.substring(wcStart, aWord.length()-eAfter.length());                                                                                                               
                                if ( eBefore.equals(aBefore) && eAfter.equals(eAfter) ) {
                                    String[] bounds = eWC.substring(4, eWC.length()-1).split("_");
                                    int lower = Integer.parseInt(bounds[0]);
                                    int upper = Integer.parseInt(bounds[1]);
                                    int actual = Integer.parseInt(aWC);
                                    if (actual >= lower && actual <= upper)
                                        continue; //if it parsed and it is within range, this is acceptable.  Continue to next token.
                                }
                            } catch (Exception e) { } //This didn't word so tokens don't match

                        } else if (eWord.contains("%double")) {
                            //ranged double 
                            hasWildcard = true;
                            int wcStart = eWord.indexOf("%double");
                            int wcEnd = eWord.lastIndexOf("%");
                            try {
                                String eBefore = eWord.substring(0, wcStart);
                                String eWC = eWord.substring(wcStart, wcEnd+1);
                                String eAfter = eWord.substring(wcEnd+1);
                                String aBefore = aWord.substring(0, wcStart);
                                String aAfter = aWord.substring(aWord.length()-eAfter.length());
                                String aWC = aWord.substring(wcStart, aWord.length()-eAfter.length());                                                                                                               

                                if ( eBefore.equals(aBefore) && eAfter.equals(eAfter) ) {
                                    String[] bounds = eWC.substring(7, eWC.length()-1).split("_");
                                    double lower = Double.parseDouble(bounds[0]);
                                    double upper = Double.parseDouble(bounds[1]);
                                    double actual = Double.parseDouble(aWC);
                                    if (actual >= lower && actual <= upper)
                                        continue; //if it parsed and it is within range, this is acceptable.  Continue to next token.
                                }
                            } catch (Exception e) { } //This didn't word so tokens don't match
                        } 

                        //See if entire token is floating-point value that is within the allowable error
                        if (aWord.contains(".") && eWord.contains("."))
                            try {                            
                                double aDouble = Double.parseDouble(aWord);
                                double eDouble = Double.parseDouble(eWord);
                                if (aDouble <= eDouble + allowableError && aDouble >= eDouble - allowableError) {
                                    continue; //acceptable (within allowable error)
                                }                            
                            } catch (Exception e) { } //1 or more tokens are not doubles 

                        try {
                            perfect = false;
                            final Field f = ao.getClass().getDeclaredField("position");
                            f.setAccessible(true);
                            start += (Integer)f.get(ao) - aWord.length();
                        } catch (Exception e) { System.out.print("Problem accessing position within Scanner"); }
                    }
                }
                if (perfect && !ao.hasNext()) start += aLine.length() + 1; //push forward to next line
            }

            if (!perfect) {  // we found a spot that doesn't match.
                String before, remaining, mistake, after;
                before = actOut.substring(0, start);
                remaining = actOut.substring(start);

                //Find end of the word that we want to flag
                int space = remaining.indexOf(" ");
                int slashn = remaining.indexOf("\n");
                if (space == -1) space = remaining.length();
                if (slashn == -1) slashn = remaining.length();                                
                int end = Math.min(space, slashn);

                mistake = remaining.substring(0, end);
                after = remaining.substring(end);
                markup = before + mistakeStartFlag + mistake + mistakeStopFlag + after;                 
            }            
            if (perfect && (eo.hasNext()||expectedFull.hasNext())) {  //no mistake was found, but actual out ran out of data
                perfect = false;
                markup = actOut + "\n" + mistakeStartFlag + "Remaining output is missing." + mistakeStopFlag;                
            }
            if (perfect && (ao.hasNext()||actualFull.hasNext())) {  //no mistake was found, but actual out has extra data
                perfect = false;
                if (ao.hasNext())                
                    try {
                        perfect = false;
                        final Field f = ao.getClass().getDeclaredField("position");
                        f.setAccessible(true);
                        start += (Integer)f.get(ao);
                    } catch (Exception e) { System.out.print("Problem accessing position within Scanner"); }
                markup = actOut.substring(0, start) + mistakeStartFlag + actOut.substring(start) + mistakeStopFlag;                
            }
            if (perfect) {  //tokens matched, but is there a spacing issue?
                if (trimSpacing(expOut).equals(trimSpacing(actOut)))
                    td.setResult("Perfect", TestGUI.GREEN);
                else {
                    if (hasWildcard)
                        td.setResult("All tokens match! Spacing not verified due to wildcards.", TestGUI.YELLOW);
                    else
                        td.setResult("All tokens match! Difference in spacing or precision.", TestGUI.YELLOW);
                }                
            } else {
                td.setResult("NO MATCH", TestGUI.RED);
                td.setActualOut(markup);
            }
        }

        public static String fixSlashR(String s) {
            if (s != null)
                while (s.indexOf("\r\n") > -1)
                    s = s.replace("\r\n", "\n");
            return s;
        }

        private static String trimSpacing(String s) {            
            //student output may differ from expected output by spacing, so let's clean it up.
            if (s == null || s.length() == 0) 
                return s;
            while (s.indexOf("\r\n") > -1)
                s = s.replace("\r\n", "\n");
            while (s.indexOf("\n\n") > -1)
                s = s.replace("\n\n", "\n");                
            while (s.indexOf(" \n") > -1)
                s = s.replace(" \n", "\n");            
            boolean changed;
            do {
                changed = false;            
                if (s.substring(s.length()-1).equals("\n")) {            
                    s=s.substring(0, s.length()-1);
                    changed = true;
                }
                while (s.length()>0 && s.charAt(s.length()-1)==' ') {
                    s=s.substring(0, s.length()-1);
                    changed = true;
                }
            } while (changed && s.length()>0);
            return s;
        }

        private static ArrayList<Class[]> getWideningOptions(Object args[]) {
            //Given an array of arguments (as Objects) determine all possible widening options
            //For example, if the arguments passed were (Float, Long) we would first consider wrappers then
            //the primitive forms, but using the order of windening upcasts we would eventuall consider
            //something like (double, float) as a viable consideration (since float can be unwrapped to a 
            //primitive and upcase to a double and Long can be unwrapped to a primitive and upcast as a float).

            //The complete returned list for (Float, Long) would be:
            //Float     Long
            //float     Long
            //double    Long
            //Float     long
            //float     long
            //double    long
            //Float     float
            //float     float
            //double    float
            //Float     double
            //float     double
            //double    double       

            ArrayList<Class[]> options = new ArrayList<Class[]>();
            ArrayList<Class[]> paths = new ArrayList<Class[]>();

            int argCount = args.length; 
            Class[] originalClassArray = new Class[argCount];
            for (int i = 0; i < argCount; i++) {
                originalClassArray[i] = args[i].getClass();
            }

            int totalCombos = 1;
            for (Class start : originalClassArray) {    
                Class[] path = upcastPath(start);
                totalCombos *= path.length;
                paths.add(path);
            }

            for (int i = 0; i < totalCombos; i++)
                options.add(new Class[argCount]);

            int prevBreakFreq = totalCombos;
            for (int a = argCount-1; a >= 0; a--) {    
                int pathLength = paths.get(a).length;
                int breakFreq = prevBreakFreq/pathLength;
                for (int i = 0; i < totalCombos; i++){  
                    if (a == 1 && i == 6) 
                        pathLength = pathLength;
                    (options.get(i))[a]=(paths.get(a))[i/breakFreq%pathLength];
                }          
                prevBreakFreq = breakFreq;            
            }
            return options;
        }

        private static Class[] getSuperclassPath(Class current) {
            String starting = current.getName();
            java.util.List<Class> list = new ArrayList<Class>(); 
            list.add(current);
            while (current != Object.class) {
                current = current.getSuperclass();
                list.add(current);
            } 

            Class[] cPath = new Class[list.size()];
            for (int i = 0; i < list.size(); i++)
                cPath[i] = list.get(i);

            String path = "" + list;        
            return cPath;
        }

        private static Class[] upcastPath(Class original) {
            if (original == Byte.class) 
                return new Class[] {original, byte.class, short.class, int.class, long.class, float.class, double.class, Number.class, Object.class};
            if (original == Short.class) 
                return new Class[] {original, short.class, int.class, long.class, float.class, double.class, Number.class, Object.class};
            if (original == Character.class) 
                return new Class[] {original, char.class, int.class, long.class, float.class, double.class, Number.class, Object.class};
            if (original == Integer.class) 
                return new Class[] {original, int.class, long.class, float.class, double.class, Number.class, Object.class};
            if (original == Long.class) 
                return new Class[] {original, long.class, float.class, double.class, Number.class, Object.class};
            if (original == Float.class) 
                return new Class[] {original, float.class, double.class, Number.class, Object.class};
            if (original == Double.class) 
                return new Class[] {original, double.class, Number.class, Object.class};                                    
            if (original == Boolean.class) 
                return new Class[] {original, boolean.class, Object.class};                                    
            return getSuperclassPath(original);
        }

        private static String arrayAsString(Object o) {
            //Object is an array.  Since we don't want a string representation with just reference addresses
            //we must determining what kind of data is in the array, cast and convert to String
            if (o == null) 
                return "null";
            if (! o.getClass().isArray()) 
                return "";
            if (o instanceof byte[])     
                return Arrays.toString((byte[])o);
            if (o instanceof short[])    
                return Arrays.toString((short[])o);
            if (o instanceof int[])      
                return Arrays.toString((int[])o);
            if (o instanceof long[])     
                return Arrays.toString((long[])o);
            if (o instanceof float[])    
                return Arrays.toString((float[])o);
            if (o instanceof double[])   
                return Arrays.toString((double[])o);
            if (o instanceof boolean[])  
                return Arrays.toString((boolean[])o);
            if (o instanceof char[])     
                return Arrays.toString((char[])o);      
            String ret = "[";
            for (Object part : (Object[])o) {
                if (ret.length() > 1) ret += ", ";
                ret += getObjectAsString(part);
            }
            return ret + "]";
        }

        private static String getObjectAsString(Object o) {
            if (o == null) 
                return "null";
            if (o instanceof String) 
                return "\"" + o + "\"";
            if (o instanceof Character) 
                return "\'" + o + "\'";
            if (o instanceof Boolean) 
                return ""+o;
            if (o.getClass().isArray()) 
                return arrayAsString(o);
            if (o instanceof Number) 
                return ""+o;            
            String className = o.getClass().getName();
            if (className.lastIndexOf(".") > -1) className = className.substring(className.lastIndexOf(".")+1);
            return className.toLowerCase()+"Object" ;          
        }

        private static String getParam(Object[] params) {
            //returns a string representation of the array of objects
            String ret = "";
            for (Object o : params) {
                if (ret.length() > 0) ret += ", ";
                if (o == null) ret += null;
                else ret += getObjectAsString(o);
            }
            return ret;         
        }     

        private static void setClassLoader() {
            try {
                classUrl = srcPath.toURI().toURL();
                classLoader = URLClassLoader.newInstance(new URL[]{classUrl});
            } catch (Exception e) { };
        }
    }//end inner class TestData

/**
 * EchoingByteArrayInputStream
 * When a student is collecting data from System.In, SysIn will be hijacked to read data from 
 * this  "script" instead.  Since we are faking "user-typed input" this stream echoes the 
 * "user input" to System.out as it is collected by the Scanner so that it looks like it was typed
 * into each prompt by a real human.
 * 
 * 
 * @author Dagar Ahmed & Kris McCoy
 */
static class EchoingByteArrayInputStream extends ByteArrayInputStream {  
    public static void hijackSystemIn() {      
        ArrayList<EchoingByteArrayInputStream> streams = new ArrayList<EchoingByteArrayInputStream>();
        hijackedSystemIn = new SequenceInputStream(Collections.enumeration(streams));
        System.setIn(hijackedSystemIn); 
    }

    public static void injectScript(String script) {
        ArrayList<EchoingByteArrayInputStream> streams = new ArrayList<EchoingByteArrayInputStream>();
        Scanner chopper = new Scanner(script);
        while (chopper.hasNextLine()) {
            streams.add(new EchoingByteArrayInputStream((chopper.nextLine()+'\n').getBytes()));            
        }

        //Inject our collection of streams into the currently hijacked System In
        try{           
            final Field f = hijackedSystemIn.getClass().getDeclaredField("e");
            f.setAccessible(true);
            f.set(hijackedSystemIn, Collections.enumeration(streams));

            final Field field = hijackedSystemIn.getClass().getDeclaredField("in");
            field.setAccessible(true);
            field.set(hijackedSystemIn, (InputStream)Collections.enumeration(streams).nextElement());
        }catch(Exception e){
            System.out.print("Unable to inject input script into System In" + e);
        }
    }

    public static void restoreSystemIn() {
        System.setIn(TestGUI.originalSystemIn);
    }

    public EchoingByteArrayInputStream(byte[] b) { super(b); }

    @Override
    public int read(byte[] b, int off, int len) {
        int data = super.read(b, off, len);
        for (int i = 0; i < data; i++) {
            System.out.print((char)b[i]);
            if (b[i] == 10) // '\n'
                return i+1;
        }
        return data;            
    }

    @Override
    public int read(byte[] b) throws IOException {
        int data = super.read(b);
        for (int i = 0; i < data; i++) {
            System.out.print((char)b[i]);
            if (b[i] == 10) // '\n'
                return i+1;
        }
        return data;
    }
} //end inner class EchoingByteArrayInputStream

public static final class WheelScrolling {
    /**
     * Passes mouse wheel events to the parent component if parent component is scrollable.
     */
    public static void install(JScrollPane pane) {
        pane.addMouseWheelListener(new Listener(pane));
    }

    private static class Listener implements MouseWheelListener {
        private final JScrollPane pane;
        private boolean inHandler; // To avoid StackOverflowError in nested calls

        Listener(JScrollPane pane) {
            this.pane = pane;
            pane.setWheelScrollingEnabled(false);
        }

        public void mouseWheelMoved(MouseWheelEvent e) {
            if (!inHandler) {
                inHandler = true;
                try {
                    handleMoved(e);
                } finally {
                    inHandler = false;
                }
            }
        }

        private void handleMoved(MouseWheelEvent e) {
            JScrollPane curr = currentPane(e);
            JScrollPane parent = getTopmostParentPane(e);

            if (curr == null || parent == null) {
                dispatchDefault(pane, e);
            } else {
                dispatchDefault(parent, (MouseWheelEvent)
                    SwingUtilities.convertMouseEvent(pane, e, curr));
            }
        }

        private static void dispatchDefault(JScrollPane comp, MouseWheelEvent e) {
            if (comp.isWheelScrollingEnabled()) {
                comp.dispatchEvent(e);
            } else {
                comp.setWheelScrollingEnabled(true);
                comp.dispatchEvent(e);
                comp.setWheelScrollingEnabled(false);
            }
        }

        private JScrollPane currentPane(MouseWheelEvent e) {
            Current current = current(pane);
            if (current == null) {
                return null;
            }

            long validUntil = current.validUntil;
            current.validUntil = e.getWhen() + 1000;

            if (e.getWhen() < validUntil) {
                return current.pane;
            }

            for (Component comp = pane; comp != null; comp = comp.getParent()) {
                if (comp instanceof JScrollPane) {
                    JScrollPane otherPane = (JScrollPane) comp;
                    if (canScrollFurther(otherPane, e)) {
                        current.pane = otherPane;
                        return current.pane;
                    }
                }
            }

            current.pane = null;
            return null;
        }

        private JScrollPane getTopmostParentPane(MouseWheelEvent e) {
            Current current = current(pane);
            if (current == null) {
                return null;
            }

            boolean parentSet = false;
            for (Component comp = pane; comp != null; comp = comp.getParent()) {
                if (comp instanceof JScrollPane) {
                    JScrollPane otherPane = (JScrollPane) comp;
                    parentSet = true;
                    current.pane = otherPane;
                }
            }

            if (parentSet)
                return current.pane;

            current.pane = null;
            return null;
        }        

        private static boolean canScrollFurther(JScrollPane pane, MouseWheelEvent e) {

            // See BasicScrollPaneUI
            JScrollBar bar = pane.getVerticalScrollBar();
            if (bar == null || !bar.isVisible() || e.isShiftDown()) {
                bar = pane.getHorizontalScrollBar();
                if (bar == null || !bar.isVisible()) {
                    return false;
                }
            }

            if (e.getWheelRotation() < 0) {
                return bar.getValue() != 0;
            } else {
                int limit = bar.getMaximum() - bar.getVisibleAmount();
                return bar.getValue() != limit;
            }
        }

        private static Current current(Component component) {
            if (component.getParent() == null) {
                return null;
            }

            Component top = component;
            while (top.getParent() != null) {
                top = top.getParent();
            }

            for (MouseWheelListener listener : top.getMouseWheelListeners()) {
                if (listener instanceof Current) {
                    return (Current) listener;
                }
            }

            Current current = new Current();
            top.addMouseWheelListener(current);
            return current;
        }
    }//end inner inner class (WheelScrolling/Listener)

    /**
     * The "currently active scroll pane" needs to remembered once
     * per top-level window.
     * <p>
     * Since a Component does not provide a storage for arbitrary data,
     * this data is stored in a no-op listener.
     */
    private static class Current implements MouseWheelListener {
        private JScrollPane pane;
        private long validUntil;

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            // Do nothing.
        }
    }//end inner inner class (WheelScrolling/Current)
} //end inner class WheelScrolling

/**
 * SourceCodeFrame
 * 
 * Makes a seperate frame when "srcButton" is clicked.
 * Shows all the source code for that .java file
 * you can either include the .java or not its up to the user
 * If src file in a diffrent folder we use the srcSource variable to get the path
 * 
 * @author Dagar Ahmed & Kris McCoy
 */
public class SourceCodeFrame {
    private JFrame frame;

    public SourceCodeFrame(String fileName){makeSourceCodeFrame(fileName);}

    public void makeSourceCodeFrame(String fileName) {
        frame = new JFrame("Source code: " + fileName);
        JFileChooser fc = new JFileChooser();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTextArea textArea = new JTextArea(10, 10);
        textArea.setFont(REGULAR_FONT);
        textArea.setLineWrap(false);
        textArea.setEditable(false);

        File file = new File(fileName);
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(
                        new FileInputStream(file)));
            textArea.read(input, "READING FILE :-)");
        } catch (Exception e) {
            e.printStackTrace();
        }

        textArea.setEditable(false);
        frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.pack();
        frame.setSize(SOURCE_CODE_FRAME_WIDTH, SOURCE_CODE_FRAME_HEIGHT);
        frame.setVisible(true);
    }
}//end inner inner class (SourceCodeFrame)

}