package MainPackage;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.border.TitledBorder;

import Characters.NPCs;
import Characters.PlayerScript;

public class UI {

	Pannel pan;
	weapon wpn;
    Font font4game;
    Font Font2;
	PlayerScript playerScript;
	NPCs npCs;
	Graphics2D graphics;
	public String dialStrings;
	public String dialStrings2;
	public BufferedImage titleImage, GameOverImage;
	
	
	public UI(Pannel pan)
	{
		this.pan = pan;
		font4game = new Font("Courier New", Font.PLAIN, 30);
	    Font2 = new Font("Verdana", Font.PLAIN, 22);
	    
	    //for titleImage
	    try { titleImage = ImageIO.read(getClass().getResourceAsStream("/MapPacks/NGZERO.png"));
	    	GameOverImage = ImageIO.read(getClass().getResourceAsStream("/MapPacks/gameOverScreen.png"));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2d)
	{
		
		g2d.setFont(font4game);
		g2d.setColor(Color.white);
		g2d.drawString("Unit Integrity: " + pan.playerScript.playerHealthString, 30, 50);
		g2d.drawString("Faze Light: " + pan.wpn.bulletAmountString, 30, 100);//text, X , Y    
		
		this.graphics = g2d;
		
		
		if(pan.gameState == pan.playState)
		{
			
		}
		if(pan.gameState == pan.pausedState)
		{
			 Paused();
		}
		
		if(pan.gameState == pan.DialougeState)
		{
			DrawDiaWindow();
		}
		if(pan.gameState == pan.TitleState)
		{
			TitleScreen();
		}
		if(pan.gameState == pan.GameOverState)
		{
			GOScreen();
		}
		if(pan.gameState == pan.CompleteState)
		{
			EndScreen();
		}
		
	}
	public void Paused()
	{
		
		String pausedTextString = "//System.STOPPED";
		
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, 4000, 8000);
		graphics.setFont(Font2);
		graphics.setColor(Color.white);
		graphics.drawString(pausedTextString, 30, pan.screehheight/2);
	}
	
	public void DrawDiaWindow()
	{
		int x = 5000, y = 4000, width = 5000, height =10000;
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, 4000, 8000);
		graphics.setColor(Color.red);
		graphics.setStroke(new BasicStroke(10));
		graphics.drawRect(x +5, y+5, width-10, height-10);
		graphics.drawString(dialStrings, x = 10, y = 400);
		graphics.drawString(dialStrings2, x = 10, y = 450);
	
	}
	public void TitleScreen()
	{
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, 4000, 8000);
		graphics.drawImage(titleImage, null, 547, 380);
		graphics.setColor(Color.white);
		graphics.drawString("<press 'Enter' to start>", 632, 592);
	}
	
	public void GOScreen()
	{
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, 4000, 8000);
		graphics.drawImage(GameOverImage, null, 547, 380);
		graphics.setColor(Color.darkGray);
		graphics.drawString("<press 'Enter' to quit>", 632, 592);
	}
	
	public void EndScreen()
	{
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, 4000, 8000);
		graphics.setColor(Color.white);
		graphics.drawString("Replica Purge Trooper unit, Sol, recovered at 56:00 at <redacted>",10, 400);
		graphics.drawString("Purge Trooper is to be interrogated and sent home until further notice. ",10, 500);
		graphics.drawString("Type-55 Nuclear Mine autorized for use on watcher temple, evacuation of personell started.",10, 450);
		graphics.drawString("<press 'Enter' to quit>", 632, 860);
		graphics.drawString("Thanks for playing, full version will be released in the future - Hunter Ulbrich", 10, 800);
	}
}
