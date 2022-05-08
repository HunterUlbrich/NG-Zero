package Characters;

import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import MainPackage.Pannel;

public class Terminal extends NPCs {

	
	public Terminal(Pannel pan)
	{
		super(pan);
		direction = "TermDir";
		speed = 0;
		playerRectangle = new Rectangle(0, 4, 50, 70 );
		TerminalImage();
	}
	public void TerminalImage()
	{
		try {
			//Alien Walk
			Terminal1 = ImageIO.read(getClass().getResourceAsStream("/LoreSystem/PC1.png"));
			Terminal2 = ImageIO.read(getClass().getResourceAsStream("/LoreSystem/PC2.png"));
			
	
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
