import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
    this is the Controller component
 */

public class Life extends JFrame implements ActionListener
{
   private static final long serialVersionUID = 1L;
   private LifeView view;
   private LifeModel model;
   private JButton runButton, pauseButton, resumeButton, resetButton, randomizeColorButton;
   private String file;

	/** construct a randomized starting grid */
   public Life()
   {
      this(null);
      file = null;
   }
	
	/** construct a grid using the info in text file */
   public Life(String fileName) 
   {
      super("Conway's Life");
      
      file = fileName;
      
   	// build the buttons
      JPanel controlPanel = 
         	new JPanel(new FlowLayout(FlowLayout.CENTER));
      runButton = new JButton("Run");
      runButton.addActionListener(this);
      runButton.setEnabled(true);
      controlPanel.add(runButton);
      pauseButton = new JButton("Pause");
      pauseButton.addActionListener(this);
      pauseButton.setEnabled(false);
      controlPanel.add(pauseButton);
      resumeButton = new JButton("Resume");
      resumeButton.addActionListener(this);
      resumeButton.setEnabled(false);
      controlPanel.add(resumeButton);
      resetButton = new JButton("resetButton");
      resetButton.addActionListener(this);
      resetButton.setEnabled(false);
      controlPanel.add(resetButton);
      randomizeColorButton = new JButton("randomizeColorButton");
      randomizeColorButton.addActionListener(this);
      randomizeColorButton.setEnabled(false);
      controlPanel.add(randomizeColorButton);
   
   	// build the view
      view = new LifeView();
      view.setBackground(Color.white);
   
   	// put buttons, view together
      Container c = getContentPane();
      c.add(controlPanel, BorderLayout.NORTH);
      c.add(view, BorderLayout.CENTER);
   
   	// build the model
      model = new LifeModel(view, fileName);
   }

   public void actionPerformed(ActionEvent e)
   {
      JButton b = (JButton)e.getSource();
      if ( b == runButton )
      {
         model.run();
         runButton.setEnabled(false);
         pauseButton.setEnabled(true);
         resumeButton.setEnabled(false);
         
         resetButton.setEnabled(false);
         randomizeColorButton.setEnabled(true);
      }
      else if ( b == pauseButton )
      {
         model.pause();
         runButton.setEnabled(false);
         pauseButton.setEnabled(false);
         resumeButton.setEnabled(true);
         
         resetButton.setEnabled(true);
         randomizeColorButton.setEnabled(true);
      }
      else if ( b == resumeButton )
      {
         model.resume();
         runButton.setEnabled(false);
         pauseButton.setEnabled(true);
         resumeButton.setEnabled(false);
         
         resetButton.setEnabled(false);
         randomizeColorButton.setEnabled(true);
      }
      else if ( b == resetButton )
      {
         model = new LifeModel(view, file);
         
         runButton.setEnabled(true);
         pauseButton.setEnabled(false);
         resumeButton.setEnabled(false);
         
         resetButton.setEnabled(false);
         randomizeColorButton.setEnabled(true);
         
      }
      else if ( b == randomizeColorButton )
      {
         view.randomColorTick();
         
         runButton.setEnabled(false);
         pauseButton.setEnabled(true);
         resumeButton.setEnabled(false);
         
         resetButton.setEnabled(false);
         randomizeColorButton.setEnabled(true);
         
      }
   }
	
   public static void main(String[] args) 
   {
      Life conway = new Life("glgun13.lif"); //parameterize to start w/ a particular file
   	
      conway.addWindowListener(
         new WindowAdapter()
         {
            public void windowClosing(WindowEvent e)
            {
               System.exit(0);
            }
         });
      conway.setSize(570, 640);
   	//conway.show(); //deprecated, added call below
      conway.setVisible(true);
   }

}