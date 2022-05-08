package Characters;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import MainPackage.Pannel;

public class AngelScript extends NPCs {
	//public int AngelHP = 25;
	public AngelScript(Pannel pan)
	{
		super(pan);
		direction = "AngelRight";
		speed = 3;
		playerRectangle = new Rectangle(100, 68, 100, 70 ); //(x, y, width, height)
		//EnemyHP = 12;
		AngelImage();
	}

	public void AngelImage()
	{
		try {
			//AngelWalk Right
			AngelW1 = ImageIO.read(getClass().getResourceAsStream("/AngelFolder/A1R.png"));
			AngelW2 = ImageIO.read(getClass().getResourceAsStream("/AngelFolder/A2R.png"));
			AngelW3 = ImageIO.read(getClass().getResourceAsStream("/AngelFolder/A2R.png"));
			//Alien Walk Left
			AngelW1L = ImageIO.read(getClass().getResourceAsStream("/AngelFolder/A1L.png"));
			AngelW2L = ImageIO.read(getClass().getResourceAsStream("/AngelFolder/A2L.png"));
			AngelW3L = ImageIO.read(getClass().getResourceAsStream("/AngelFolder/A3L.png"));
			//Alien Hit Right
			AngelHit1 = ImageIO.read(getClass().getResourceAsStream("/AngelFolder/Hit1R.png"));
			AngelHit2 = ImageIO.read(getClass().getResourceAsStream("/AngelFolder/Hit2R.png"));
			//Alien Hit Left
			AngelHit1L = ImageIO.read(getClass().getResourceAsStream("/AngelFolder/Hit1L.png"));
			AngelHit2L = ImageIO.read(getClass().getResourceAsStream("/AngelFolder/Hit2L.png"));
			//Alien Dead
			AngelDeadR = ImageIO.read(getClass().getResourceAsStream("/AngelFolder/AngelDR.png"));
			AngelDeadL = ImageIO.read(getClass().getResourceAsStream("/AngelFolder/AngelDL.png"));
	
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//Action===============================================================================================================
	
	public void Action()
	{
		Timer ++;
		if(Timer == 120) {
			Random rndRandom =new Random();

			int i = rndRandom.nextInt(50)+1;
			if(i<=27)
			{
				direction = "AngelRight";
			}
			if(i>=23)
			{
				direction = "AngelLeft";
			}
			Timer = 0;
		}
		
	
	//	Test========================
		if(CollisionOn == true && direction == "AngelRight")
		{
			if(pan.playerScript.GotHit == true)
			{
				direction = "Angel Hit Right";
			}
			else{direction = "AngelLeft"; pan.playerScript.GotHit = false;}

			return;
		}
		if(CollisionOn == true && direction == "AngelLeft")
		{
			if(pan.playerScript.GotHit == true)
			{
				direction = "Angel Hit Left";
			}
			else{direction = "AngelRight"; pan.playerScript.GotHit = false;}
			return;
		}

		
		
	}
	
	
}
