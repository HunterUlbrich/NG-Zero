package MainPackage;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartScreen extends JFrame{
	JFrame frame;
	Container cotainer;
	JPanel titlePanel;
	UI ui;
	ImageIcon appicon = new ImageIcon(getClass().getClassLoader().getResource("ng0AppIcon.png"));
	public static void main(String[] args) {

		new StartScreen();
		
		
	}

	public StartScreen()
	{
		frame = new JFrame(); //create frame
	//	frame.setSize(900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allow exit
		frame.getContentPane().setBackground(Color.black); //set default color
		frame.setTitle("NEO GEMINI ZERO"); //add title to window
		frame.setIconImage(appicon.getImage()); //change application image from java duke
		Pannel panel =new Pannel();
		frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		panel.SetObjs();
		panel.StartThread();
	
		frame.setResizable(false);
		
	}
	

	
}
