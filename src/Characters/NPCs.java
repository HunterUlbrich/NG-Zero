package Characters;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Desktop.Action;
import java.awt.image.BufferedImage;
import java.security.PublicKey;

import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import MainPackage.Pannel;
import MainPackage.PlayerMove;
public class NPCs {
public int worldX, worldY;
public int speed = 4;

public BufferedImage FazeF, FazeB, IDLEB1, IDLEB2, IDLEF1, IDLEF2, ShootB, ShootF, ShootR, ShootL, WalkUp1, WalkUp2, WalkUp3, WalkDown1, WalkDown2, WalkDown3, WalkLeft1, WalkLeft2, WalkLeft3, WalkRight1, WalkRight2, WalkRight3;
public BufferedImage AlienW1, AlienW2, AlienW3, AlienW1Back, AlienW2Back, AlienW3Back, AlienHit1, AlienHit2, AlienHit3, AlienHit1B, AlienHit2B, AlienHit3B, AlienDeadR, AlienDeadL; 
public BufferedImage AngelW1, AngelW2, AngelW3, AngelW1L, AngelW2L, AngelW3L, AngelHit1, AngelHit2, AngelHit3, AngelHit1L, AngelHit2L, AngelHit3L, AngelDeadR, AngelDeadL;
public BufferedImage Terminal1, Terminal2;
public String direction;
public int ImagePlace = 0;
public int SpriteIndex = 1;
public Rectangle playerRectangle;
public int SolidAreaDefaultX, SolidAreaDefaultY;
public boolean CollisionOn = false;
Pannel pan;
public int Timer = 0;
public boolean PlayerHit;
public boolean IsHitting;
public int EnemHP = 9;
public NPCs(Pannel pan)
{
	this.pan = pan;
}
public void Action()
{
	
}
public void speak()
{
	
}
public void Update()
{
	if(pan.playerScript.GotHit == true)
	{
		IsHitting = true;
	}
	else {IsHitting = false;}
	Action();
	
	CollisionOn = false;
	pan.ColCheckScript.tileCheck(this);
	pan.ColCheckScript.CheckObject(this, false);
	pan.ColCheckScript.CheckPlayer(this);
	if(CollisionOn == false)
	{
		switch (direction){
		case "right": worldX+=speed; break;
		case "left": worldX -= speed; break;
		//Angel
		case "AngelRight": worldX+=speed; break;
		case "AngelLeft": worldX -= speed; break;
		}
	}
	ImagePlace ++;
	if(ImagePlace > 8)
	{
	if(SpriteIndex == 1)
		{
			SpriteIndex = 2;
		}
	else if(SpriteIndex == 2)
	{
		SpriteIndex = 3;
	}
	else if(SpriteIndex == 3)
	{
		SpriteIndex = 4;
	}
	else if(SpriteIndex == 4)
	{
		SpriteIndex = 1;
	}
	ImagePlace = 0;
	}
}



public void draw(Graphics2D g2)
{
	//Alien
	BufferedImage image = null;
	int screenx = worldX - pan.playerScript.worldX + pan.playerScript.screenx;
	int screeny = worldY - pan.playerScript.worldY + pan.playerScript.screeny;
	
	if(worldX + pan.PlayerTileSize > pan.playerScript.worldX - pan.playerScript.screenx &&
			worldX - pan.PlayerTileSize < pan.playerScript.worldX + pan.playerScript.screenx &&
			worldY + pan.PlayerTileSize > pan.playerScript.worldY - pan.playerScript.screeny &&
			worldY - pan.PlayerTileSize < pan.playerScript.worldY + pan.playerScript.screeny)
		
	
		switch(direction)
		{
		case "right":
			if(SpriteIndex == 1)
			{
				image = AlienW1;
			}
			if(SpriteIndex == 2)
			{
				image = AlienW2;
			}
			if(SpriteIndex == 3)
			{
				image = AlienW3;
			}
			if(SpriteIndex == 4)
			{
				image = AlienW2;
			}
			break;
		case "left":
			if(SpriteIndex == 1)
			{
				image = AlienW1Back;
			}
			if(SpriteIndex == 2)
			{
				image = AlienW2Back;
			}
			if(SpriteIndex == 3)
			{
				image = AlienW3Back;
			}
			if(SpriteIndex == 4)
			{
				image = AlienW2Back;
			}
			break;
		case "Alien Hit Right":
			if(SpriteIndex == 1)
			{
				image = AlienHit1;
			}
			if(SpriteIndex == 2)
			{
				image = AlienHit2;
			}
			if(SpriteIndex == 3)
			{
				image = AlienHit3;
			}
			if(SpriteIndex == 4)
			{
				image = AlienHit2;
			}
			break;
		case "Alien Hit Left":
			if(SpriteIndex == 1)
			{
				image = AlienHit1B;
			}
			if(SpriteIndex == 2)
			{
				image = AlienHit2B;
			}
			if(SpriteIndex == 3)
			{
				image = AlienHit3B;
			}
			if(SpriteIndex == 4)
			{
				image = AlienHit2B;
			}
			break;
		case "Alien Dead Right":
			if(SpriteIndex == 1)
			{
				image = AlienDeadR;
			}
			if(SpriteIndex == 2)
			{
				image = AlienDeadR;
			}
			if(SpriteIndex == 3)
			{
				image = AlienDeadR;
			}
			if(SpriteIndex == 4)
			{
				image = AlienDeadR;
			}
			
			break;
		case "Alien Dead Left":
			if(SpriteIndex == 1)
			{
				image = AlienDeadL;
			}
			if(SpriteIndex == 2)
			{
				image = AlienDeadL;
			}
			if(SpriteIndex == 3)
			{
				image = AlienDeadL;
			}
			if(SpriteIndex == 4)
			{
				image = AlienDeadL;
			}
			break;
			//Alien
			//Angel==========================================================
			
		case "AngelRight": 
		{
			image = AngelW1;
		}
		if(SpriteIndex == 2)
		{
			image = AngelW2;
		}
		if(SpriteIndex == 3)
		{
			image = AngelW3;
		}
		if(SpriteIndex == 4)
		{
			image = AngelW2;
		}
			break;
		case "AngelLeft":
		{
			image = AngelW1L;
		}
		if(SpriteIndex == 2)
		{
			image = AngelW2L;
		}
		if(SpriteIndex == 3)
		{
			image = AngelW3L;
		}
		if(SpriteIndex == 4)
		{
			image = AngelW2L;
		}
			break;
		case "Angel Hit Right":
			if(SpriteIndex == 1)
			{
				image = AngelHit1;
			}
			if(SpriteIndex == 2)
			{
				image = AngelHit2;
			}
			if(SpriteIndex == 3)
			{
				image = AngelHit1;
			}
			if(SpriteIndex == 4)
			{
				image = AngelHit2;
			}
			break;
		case "Angel Hit Left":
			if(SpriteIndex == 1)
			{
				image = AngelHit1L;
			}
			if(SpriteIndex == 2)
			{
				image = AngelHit2L;
			}
			if(SpriteIndex == 3)
			{
				image = AngelHit1L;
			}
			if(SpriteIndex == 4)
			{
				image = AngelHit2L;
			}
			break;
		case "AngelDeadRight":
			if(SpriteIndex == 1)
			{
				image = AngelDeadR;
			}
			if(SpriteIndex == 2)
			{
				image = AngelDeadR;
			}
			if(SpriteIndex == 3)
			{
				image = AngelDeadR;
			}
			if(SpriteIndex == 4)
			{
				image = AngelDeadR;
			}
			break;
		case "AngelDeadLeft":
			if(SpriteIndex == 1)
			{
				image = AngelDeadL;
			}
			if(SpriteIndex == 2)
			{
				image = AngelDeadL;
			}
			if(SpriteIndex == 3)
			{
				image = AngelDeadL;
			}
			if(SpriteIndex == 4)
			{
				image = AngelDeadL;
			}
			break;
			
			//Terminal
		case "TermDir":
		{
			if(SpriteIndex == 1)
			{
				image = Terminal1;
			}
			if(SpriteIndex == 2)
			{
				image = Terminal2;
			}
			if(SpriteIndex == 3)
			{
				image = Terminal1;
			}
			if(SpriteIndex == 4)
			{
				image = Terminal2;
			}
		}
		}
	
		
		
	{
		
		g2.drawImage(image, screenx, screeny, pan.tilesize, pan.tilesize, null);
		
	}
}
}
