package Characters;

import java.awt.Rectangle;
import java.io.IOException;
import java.security.PublicKey;
import java.util.Random;

import javax.imageio.ImageIO;

import MainPackage.Pannel;

public class AlienScript extends NPCs {
	
	public AlienScript(Pannel pan)
	{
		super(pan);
		direction = "right";
		speed = 3;
		playerRectangle = new Rectangle(100, 68, 100, 70 ); //(x, y, width, height)
		AlienImage();
	}
	public void AlienImage()
	{
		try {
			//Alien Walk
			AlienW1 = ImageIO.read(getClass().getResourceAsStream("/AlienFolder/AlienWalk1.png"));
			AlienW2 = ImageIO.read(getClass().getResourceAsStream("/AlienFolder/AlienWalk2.png"));
			AlienW3 = ImageIO.read(getClass().getResourceAsStream("/AlienFolder/AlienWalk3.png"));
			//Alien Walk Back
			AlienW1Back = ImageIO.read(getClass().getResourceAsStream("/AlienFolder/AlienWalk1Back.png"));
			AlienW2Back = ImageIO.read(getClass().getResourceAsStream("/AlienFolder/AlienWalk2Back.png"));
			AlienW3Back = ImageIO.read(getClass().getResourceAsStream("/AlienFolder/AlienWalk3Back.png"));
			//Alien Hit
			AlienHit1 = ImageIO.read(getClass().getResourceAsStream("/AlienFolder/AlienWalkHit1.png"));
			AlienHit2 = ImageIO.read(getClass().getResourceAsStream("/AlienFolder/AlienWalkHit2.png"));
			AlienHit3 = ImageIO.read(getClass().getResourceAsStream("/AlienFolder/AlienWalkHit3.png"));
			//Alien Hit Back
			AlienHit1B = ImageIO.read(getClass().getResourceAsStream("/AlienFolder/AlienWalkHitBack1.png"));
			AlienHit2B = ImageIO.read(getClass().getResourceAsStream("/AlienFolder/AlienWalkHitBack2.png"));
			AlienHit3B = ImageIO.read(getClass().getResourceAsStream("/AlienFolder/AlienWalkHitBack3.png"));
			//AlienDead
			AlienDeadR = ImageIO.read(getClass().getResourceAsStream("/AlienFolder/alienDeadR.png"));
			AlienDeadL = ImageIO.read(getClass().getResourceAsStream("/AlienFolder/alienDeadL.png"));
	
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public void Action()
	{
		Timer ++;
		if(Timer == 120) {
			Random rndRandom =new Random();

			int i = rndRandom.nextInt(50)+1;
			if(i<=27)
			{
				direction = "right";
			}
			if(i>=23)
			{
				direction = "left";
			}
			Timer = 0;
		}
		
	
	//	Test========================
		if(CollisionOn == true && direction == "right" && pan.playerScript.GotHit == false)
		{
			direction = "left";
			return;
		}
		if(CollisionOn == true && direction == "left" && pan.playerScript.GotHit == false)
		{
			direction = "right";
		}
		if(CollisionOn == true && pan.playerScript.wpn.Active == false && direction == "right" && IsHitting == true)
		{
			direction = "Alien Hit Right";
			return;
		}
		if(CollisionOn == true && pan.playerScript.wpn.Active == false && direction == "left" && IsHitting == true)
		{
			direction = "Alien Hit Left";
			return;
		}
		if(EnemHP <= 0)
		{
			speed = 0;
			direction ="Alien Dead Right";
		}
		
	}
	

}
