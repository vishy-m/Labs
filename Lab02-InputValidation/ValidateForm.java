import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

/**
 * A class that validates user input, used as part of an input form
 */
public class ValidateForm
{
    public ValidateForm() {
        //default constructor.
        //This class has no instance variables to initialize
    }
    
    public boolean isAllAlpha(String str)
    {
        int count = 0;
        
        for (int i = 0; i < str.length(); i++)
        {
            if (Character.isLetter(str.charAt(i)))
            {
                count++;
            }
        }
        if (count == str.length())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean isNumeric(String str)
    {
        int count = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (Character.isDigit(str.charAt(i)))
            {
                count++;
            }
        }
        if (count == str.length())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /** validate the user's entered name */
    public String checkName(String name) {
        //TODO
        if (isAllAlpha(name) != true)
        {
            return "Invalid name!\n";
        }
        else
        {
            if (name.length() <= 1)
            {
                return "Invalid name!\n";
            }
            else
            {
                return "";
            }
        }
    }

    /** validate the user's entered email */
    public String checkEmail(String email) {
        //TODO
        if (email.indexOf("@") == -1)
            return "Invalid email!\n";
        else if (email.indexOf("@") < 1)
            return "Invalid email!\n";
        else
        {
            if (email.indexOf(".") == -1 || email.indexOf(".") < email.indexOf("@"))
                return "Invalid email!\n";
            else if (email.indexOf(".") + 2 > email.length() - 1)
                return "Invalid email!\n";
            else
                return "";
        }
    }

    /** validate the user's enter password */
    public String checkPW(String pw) {
        //TODO
        boolean leastUpperCase = false;
        boolean leastLowerCase = false;
        boolean leastNumber = false;
        if (pw.length() < 4)
            return "Invalid password!\n";
        for (int i = 0; i < pw.length(); i++)
        {
            if (Character.isUpperCase(pw.charAt(i)))
                leastUpperCase = true;
            if (Character.isLowerCase(pw.charAt(i)))
                leastLowerCase = true;
            if (Character.isDigit(pw.charAt(i)))
                leastNumber = true;
        }
        if (leastUpperCase == true && leastLowerCase == true && leastNumber == true)
            return "";
        else
            return "Invalid password!\n";
    }

    /** validate the user's entered zipcode */
    public String checkZip(String zip) {
        //TODO
        if (zip.length() < 3 || zip.length() > 5)
            return "Invalid zip!\n";
        else
        {
            if (isNumeric(zip) == false)
                return "Invalid zip!\n";
            else
                return "";
        }
    }

    /** validate the user's entered birth year */
    public String checkBirth(String date) {
        //TODO
        int year = 0;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (isNumeric(date) == false)
            return "Invalid birth year!\n";
        try {
            year = Integer.parseInt(date);
        }
        catch (NumberFormatException ex)
        {
            
        }
        if (year >= currentYear || currentYear - 11 <= year)
          return "Invalid birth year!\n";
        else if (currentYear - 100 > year)
          return "Invalid birth year!\n";
        else
          return "";
        
    }

    /** validate the user's entered phone number */
    public String checkPhone(String phone) 
    {
        //TODO
        String numS = "";
        
        Scanner chopper = new Scanner(phone);
        chopper.useDelimiter("-");
        
        //if (isNumeric(phone) == false || phone.length() != 12)
            //return "Invalid phone number!\n";
        //else
            //return "";
        while (chopper.hasNext())
        {
            numS += chopper.next();
        }
        if (isNumeric(numS) == false || numS.length() != 10)
            return "Invalid phone number!\n";
        else
            return "";
    }

    /** main method for testing / setting up the GUI */
    public static void main(String[] args)
    {
        /*
         * you can add other method calls here for testing
         */
        ValidateForm form = new ValidateForm();
        System.out.println(form.isAllAlpha("Hello world"));
        System.out.println(form.isNumeric("123443"));
        System.out.println(Calendar.getInstance().get(Calendar.YEAR));

        //set up the GUI, you don't need to understand this code
        EventQueue.invokeLater(new Runnable() {
                public void run() {
                    //the frame is the GUI, it uses a ValidateForm object
                    TextComponentFrame frame = new TextComponentFrame(new ValidateForm());
                    frame.setVisible(true);
                }
            });
    }
}





/**
 * A frame (GUI) with simple text components to simulate a web form
 */
class TextComponentFrame extends JFrame 
{
    static final int DEFAULT_WIDTH  = 300;
    static final int DEFAULT_HEIGHT = 400;

    ValidateForm validater;

    public TextComponentFrame(ValidateForm v)
    {
        validater = v;

        initGUI();

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null); //center on screen
    }

    /** initialize the GUI components, e.g. buttons and text fields */
    private void initGUI()
    {
        setTitle("Subscription Form");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        final JTextField username = new JTextField();
        final JTextField emailField = new JTextField();
        final JTextField zipCode    = new JTextField();
        final JTextField birthDate  = new JTextField();

        MaskFormatter mfor = null;
        try {
            mfor = new MaskFormatter("***-***-****"); //for the phone number field
        }
        catch (ParseException e) {}

        final JFormattedTextField phoneNumber   = new JFormattedTextField(mfor);
        final JPasswordField      passwordField = new JPasswordField();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(6, 6)); //dimensions of layout
        northPanel.add(new JLabel("Username :  ", SwingConstants.RIGHT));
        northPanel.add(username);
        northPanel.add(new JLabel("Password :  ", SwingConstants.RIGHT));
        northPanel.add(passwordField);
        northPanel.add(new JLabel("Email : ", SwingConstants.RIGHT));
        northPanel.add(emailField);
        northPanel.add(new JLabel("Zip Code (US) : ", SwingConstants.RIGHT));
        northPanel.add(zipCode);
        northPanel.add(new JLabel("Year of Birth: ", SwingConstants.RIGHT));
        northPanel.add(birthDate);
        northPanel.add(new JLabel("Phone Number: ", SwingConstants.RIGHT));
        northPanel.add(phoneNumber);

        add(northPanel, BorderLayout.NORTH);

        final JTextArea textArea = new JTextArea(8, 40);
        JScrollPane scrollPane   = new JScrollPane(textArea);

        add(scrollPane, BorderLayout.CENTER);

        // add button to listen for events, append text into the text area

        JPanel  southPanel   = new JPanel();
        JButton submitButton = new JButton("Submit");
        southPanel.add(submitButton);
        submitButton.addActionListener(new ActionListener() //make anonymous action listener
            {
                /** this method is called in response to an event, in this case the "Submit" button pressed */
                public void actionPerformed(ActionEvent event)
                {
                    String uname = username.getText() ;
                    String email    = emailField.getText();
                    String zip      = zipCode.getText();
                    String birth    = birthDate.getText();
                    String phone    = phoneNumber.getText(); 
                    String password = new String(passwordField.getPassword());

                    String result = ""; 

                    result += validater.checkName(uname);
                    result += validater.checkPW(password);
                    result += validater.checkEmail(email);
                    result += validater.checkZip(zip);
                    result += validater.checkBirth(birth);
                    result += validater.checkPhone(phone);

                    if (result.length() == 0)
                        result = "Input accepted!";

                    textArea.setText(result);
                }
            });

        add(southPanel, BorderLayout.SOUTH);
    }
}