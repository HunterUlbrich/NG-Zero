package Characters;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.PublicKey;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;
import MainPackage.Pannel;
import MainPackage.PlayerMove;
import MainPackage.weapon;

public class PlayerScript extends NPCs {

//Pannel pan;
public PlayerMove playmov;
public weapon wpn;
public final int screenx;
public final int screeny;
public int MaxPlayerHealth = 100;
public int PlayerHealth = 90;
public String playerHealthString;
public boolean CanUse;
public boolean CanEnter;
public int TeleportID = 0;
public boolean GotHit;
public int TimeDamage = 0;
//public int BulletAmmount = 12;


public PlayerScript(Pannel pan, PlayerMove playmov, weapon wpn)
{	
	super(pan);
	//this.pan = pan;
	this.playmov = playmov;
	this.wpn = wpn;
	screenx = pan.scrrenwdith/2 - (pan.PlayerTileSize/2);
	screeny = pan.screehheight/2 - (pan.PlayerTileSize/2);
	
	playerRectangle = new Rectangle(56, 68, 22, 70 ); //(x, y, width, height)
	//playerRectangle = new Rectangle(0, 0, 0, 0 );
	setValues();
	getPlayerImage();
	PlayerDamage();
	SolidAreaDefaultX = playerRectangle.x;
	SolidAreaDefaultY = playerRectangle.y;
	
}
public void PlayerDamage()
{
	if(GotHit == true)
	{
		TimeDamage++;
		if(TimeDamage > 1)
		{
			PlayerHealth = PlayerHealth -3;
			playerHealthString = String.valueOf(PlayerHealth);
		}
		TimeDamage = 0;
	}
}

public void setValues()
{
	worldX = pan.tilesize * 5; //change Player staring location on the map X=5 Y=12
	worldY = pan.tilesize * 12;
	//speed = 4;
	direction = "down";
	playerHealthString = String.valueOf(PlayerHealth);
}

public void getPlayerImage()
{
	try {
		 WalkUp1 = ImageIO.read(getClass().getResourceAsStream("/playerAnims/WalkBack1.png"));
		 WalkUp2 = ImageIO.read(getClass().getResourceAsStream("/playerAnims/WalkBack2.png"));
		 WalkUp3= ImageIO.read(getClass().getResourceAsStream("/playerAnims/WalkBack3.png"));
		 
		 WalkDown1 = ImageIO.read(getClass().getResourceAsStream("/playerAnims/WalkFront1.png"));
		 WalkDown2 = ImageIO.read(getClass().getResourceAsStream("/playerAnims/WalkFront2.png"));
		 WalkDown3 = ImageIO.read(getClass().getResourceAsStream("/playerAnims/WalkFront3.png"));
		
		 WalkLeft1 = ImageIO.read(getClass().getResourceAsStream("/playerAnims/WalkLeft1.png"));
		 WalkLeft2 = ImageIO.read(getClass().getResourceAsStream("/playerAnims/WalkLeft2.png"));
		 WalkLeft3 = ImageIO.read(getClass().getResourceAsStream("/playerAnims/WalkLeft3.png"));
		 
		 WalkRight1 = ImageIO.read(getClass().getResourceAsStream("/playerAnims/WalkRight1.png"));
		 WalkRight2 = ImageIO.read(getClass().getResourceAsStream("/playerAnims/WalkRight2.png"));
		 WalkRight3 = ImageIO.read(getClass().getResourceAsStream("/playerAnims/WalkRight3.png"));
		 
		 IDLEB1 = ImageIO.read(getClass().getResourceAsStream("/playerAnims/IdleBack1.png"));
		 IDLEB2 = ImageIO.read(getClass().getResourceAsStream("/playerAnims/IdleBack2.png"));
		 IDLEF1 = ImageIO.read(getClass().getResourceAsStream("/playerAnims/IdleFront1.png"));
		 IDLEF2 = ImageIO.read(getClass().getResourceAsStream("/playerAnims/IdleFront2.png"));
		 
		 ShootL = ImageIO.read(getClass().getResourceAsStream("/playerAnims/shootLeft.png"));
		 ShootR = ImageIO.read(getClass().getResourceAsStream("/playerAnims/shootRight.png"));
		 
		 FazeF = ImageIO.read(getClass().getResourceAsStream("/playerAnims/FazeLightFront.png"));
	}catch(IOException e)
	{
		e.printStackTrace();
	}
}
//shooting====================================================================

//shooting=====================================================================
public void update()
{
	if(PlayerHealth <= 0)
	{
		pan.gameState = pan.GameOverState;
	}
	//======================
	if(playmov.pressedshoot == true && wpn.Active == false)
	{
		
		wpn.shoot();
		playmov.pressedshoot = false;
		direction = "left";
		//worldY -= 17;
		System.out.println(wpn.Active + "" + playmov.pressedshoot);
	}
	
	if(playmov.pressedshoot == true && wpn.Active == true)
	{
		playmov.pressedshoot = false;
		wpn.StopShoot();
		direction = "right";
		//worldY += 17;
		//wpn.Active = false;
		System.out.println("stopped");
		
	}
	
	if(wpn.Active == true)
	{
		playerRectangle = new Rectangle(0, 0, 0, 0); //change for attack state
	}
	else if(wpn.Active == false)
	{
		playerRectangle = new Rectangle(56, 68, 22, 70);
	}


	if(playmov.pressedUp == true || playmov.pressedDown == true || playmov.pressedright == true || playmov.pressedleft == true)
	{
		
	
	if(playmov.pressedUp == true) 
	{
		direction = "up";
		//worldY -= speed;
	
	}

	if(playmov.pressedDown == true)
	{
		direction = "down";
		//worldY += speed;
	}

	if(playmov.pressedright == true)
	{
		direction = "right";
		//worldX += speed;
	}

	if(playmov.pressedleft == true)
	{
		direction = "left";
		//worldX -= speed;
	}
	if(playmov.pressedleft == true && playmov.pressedright == true)
	{
		direction = "both";
	}
	if(playmov.pressedUp == true && playmov.pressedDown == true)
	{
		direction = "both2";
	}

	
	//collision check
	CollisionOn = false;
	pan.ColCheckScript.tileCheck(this);
	
	
	
	//Object collision check
	int ItemIndex = pan.ColCheckScript.CheckObject(this, true);
	ObtainObject(ItemIndex);

	//NPC Collision
	int NPCIndex = pan.ColCheckScript.CheckNPCCollision(this, pan.npc);
	CollideWithNPC(NPCIndex);
	
	if(CollisionOn == false)
	{
	
		switch(direction)
		{
		case "up":
			worldY -= speed;
			worldY += speed; //Remove or comment to allow up button
			break;
		case "down":
			worldY += speed;
			worldY -= speed; //Remove or comment to allow down button
			break;
		case "left":
			worldX -= speed;
			if(wpn.Active == true && wpn.BulletAmount > 0)
			{
				worldX -= speed *2;
			}
			break;
		case "right":
			worldX += speed;
			if(wpn.Active == true && wpn.BulletAmount > 0)
			{
				worldX += speed *2;
			}
			break;
		case "both":
			worldX += speed;
			worldX -= speed;
			break;
		case "both2":
			worldY += speed;
			worldY -= speed;
			break;
		case "ShotLeft":
			worldX -= speed;
			break;
		case "ShotRight":
			
			break;
		}
	}
	//========================================
	
	
	
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
	if(playmov.pressedUp == true && playmov.pressedDown == true)
	{
		SpriteIndex = 2;
	}
	if(playmov.pressedright == true && playmov.pressedleft == true)
	{
		SpriteIndex = 2;
	}
		
	}
	
	
	
	
	}
	//Obtained Objects Script=======================================================
	
public void ObtainObject(int index)
{
	if(index != 999)
	{
		String itemTypeString = pan.itemMain[index].name;
		
		switch(itemTypeString)
		{
		case "Health":
			if(PlayerHealth >= MaxPlayerHealth)
			{
				
				return;
			}
			if(PlayerHealth <= MaxPlayerHealth)
			{
				PlayerHealth = PlayerHealth + 20;
				pan.itemMain[index] = null;
				if(PlayerHealth >= MaxPlayerHealth)
				{
					PlayerHealth = MaxPlayerHealth;
				}
				playerHealthString = String.valueOf(PlayerHealth);
			}
			
			break;
		case "StarCrystalItem":
			CanUse = true;
			System.out.println(CanUse);
			if(wpn.Active == true)
			{
				worldY += 17;
				wpn.Active = false;
				
			}
			if(CanUse ==true)
			if(index == 1) {					
			pan.inferface.dialStrings = "Memory Aquired: Name:Sol, Species:Human-Cintin Hybrid, Imperial ID: VWER-89";
			pan.inferface.dialStrings2 = "Objectives: CODE M9K Mop-up Operation";
			pan.gameState = pan.DialougeState;
			pan.itemMain[index] = null;
			}
			if(index == 2) {
				pan.inferface.dialStrings = "The native's rebellion cost to many resources, requesting additional forces. ";
				pan.inferface.dialStrings2 = "REC: Request granted Kimeran Purge Troopers en route";
				pan.gameState = pan.DialougeState;
				pan.itemMain[index] = null;
				}
			if(index == 68) {
				pan.inferface.dialStrings = "Unit Analyzed: Modified Mk2 Replica Unit, Eqipt: P12 Arm Connon: Destroyed, Armour: null";
				pan.inferface.dialStrings2 = "Suggest: Utilize FL Cloaking and return to surface immediately";
				pan.gameState = pan.DialougeState;
				pan.itemMain[index] = null;
				}
			if(index == 70) {
				pan.inferface.dialStrings = "The usage of Kimeran Purge Troopers is a waste, any other human unit would do.";
				pan.inferface.dialStrings2 = "This misappropriation of resources will be the death of us. ";
				pan.gameState = pan.DialougeState;
				pan.itemMain[index] = null;
				}
			
			if(index == 74) {
				pan.inferface.dialStrings = "The Purge Troopers are working to well, they are getting extremely close to the temple.";
				pan.inferface.dialStrings2 = "We can take care of the survivors, withdraw the humans to the surface";
				pan.gameState = pan.DialougeState;
				pan.itemMain[index] = null;
				}
			
			if(index == 75) {
				pan.inferface.dialStrings = "We told those savages not to go inside";
				pan.inferface.dialStrings2 = " ";
				pan.gameState = pan.DialougeState;
				pan.itemMain[index] = null;
				}
			
			if(index == 76) {
				pan.inferface.dialStrings = "Ancient Watcher temple found, Aklin Empire Protocol T-6Q7 Initialized:";
				pan.inferface.dialStrings2 = "Recover any technology and destroy what remains.";
				pan.gameState = pan.DialougeState;
				pan.itemMain[index] = null;
				}
			if(index == 77) {
				pan.inferface.dialStrings = "Species: Angels, Orgins: Unknown, Status: 320 Erradication Order ";
				pan.inferface.dialStrings2 = "Warning, species reproduce through the collection of biomass evac immediately!";
				pan.gameState = pan.DialougeState;
				pan.itemMain[index] = null;
				}
			if(index == 80) {
				pan.inferface.dialStrings = "They were put here to deter us and others like us, but what the ancients failed to";
				pan.inferface.dialStrings2 = "realize is that they are resisting the Aklin Empire, the ultimate power in the universe";
				pan.gameState = pan.DialougeState;
				pan.itemMain[index] = null;
				}
			else if(CanUse == false)
			{
				pan.inferface.dialStrings = "INFOMATION-NULL";
				return;
			}
			break;
		case "WeaponUpgradeItem":
			break;
		case "AmmoPack":
			wpn.BulletAmount = wpn.BulletAmount + 10;
			wpn.bulletAmountString = String.valueOf(wpn.BulletAmount);
			break;
		case "HPUpgrade":
			MaxPlayerHealth = MaxPlayerHealth + 20;
			break;
		case "TeleportItem":
			CanEnter = true;
			if(index == 3 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 4 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 5 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 6 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 7 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 8 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 9 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 10 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 11 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 12 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 13 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 14 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 15 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 16 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 17 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 18 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 19 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 20 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 21 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 22 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 23 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 24 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 25 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 26 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 27 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 28 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 29 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 30 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 29 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 30 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 31 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 32 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 33 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 34 && CanEnter == true)
			{
				TeleportID = index;		
			return;	
			}
			if(index == 35 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 36 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 37 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 38 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 39 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 40 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 41 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 42 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 43 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 44 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 45 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 46 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 47 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 48 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 49 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 50 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 51 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 52 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 53 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 54 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 55 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 56 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 57 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 58 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 59 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 60 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 61 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 62 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 63 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 64 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 65 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 66 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 67 && CanEnter == true)
			{
				TeleportID = index;		
			return;
			}
			if(index == 83 && CanEnter == true)
			{
				pan.gameState = 5;		
			return;
			}
			else {
				CanEnter = false;
				TeleportID = 0;
			}
			break;
			
		}
		
		pan.itemMain[index] = null;
	}
}
//for NPCs============================================================
public void CollideWithNPC(int NPCIndex)
{
	if(NPCIndex != 999)
	{
		playerHealthString = String.valueOf(PlayerHealth);
		GotHit = true;
		
	}
	else {GotHit = false;}

		
	
		
	}




public void draw(Graphics2D g2d)
{
	//g2d.setColor(Color.white);
	//g2d.fillRect(x, y, pan.PlayerTileSize, pan.PlayerTileSize);
	
	//g2d.fillRect(screenx + playerRectangle.x, screeny + playerRectangle.y, playerRectangle.width, playerRectangle.height); // Draw collision rectangle
	//g2d.drawString(playerHealthString, screenx + (playerRectangle.x - 44), screeny + playerRectangle.y); //test UI
	
	
	BufferedImage image = null;
	switch(direction)
	{
	case "up":
		if(SpriteIndex == 1)
		{
			//image = WalkUp1; 
			image = WalkUp2;
		}
		if(SpriteIndex == 2)
		{
			image = WalkUp2;
		}
		if(SpriteIndex == 3)
		{
			//image = WalkUp3;
			image = WalkUp2;
		}
		if(SpriteIndex == 4)
		{
			image = WalkUp2;
		}
		if(playmov.pressedUp == false && SpriteIndex == 1)
		{
			image = IDLEB1;
		}
		if(playmov.pressedUp == false && SpriteIndex == 2)
		{
			image = IDLEB2;
		}
		if(playmov.pressedUp == false && SpriteIndex == 3)
		{
			image = IDLEB1;
		}
		if(playmov.pressedUp == false && SpriteIndex == 4)
		{
			image = IDLEB2;
		}
		if(wpn.Active == true && wpn.BulletAmount > 0)
		{
			image = FazeF;
		}
		
		break;
	case "down":
		if(SpriteIndex == 1)
		{
			//image = WalkDown1;
			image = WalkDown2;
		}
		if(SpriteIndex == 2)
		{
			image = WalkDown2;
		}
		if(SpriteIndex == 3)
		{
			//image = WalkDown3;
			image = WalkDown2;
		}
		if(SpriteIndex == 4)
		{
			image = WalkDown2;
		}
		if(playmov.pressedDown == false && SpriteIndex == 1)
		{
			image = IDLEF1;
		}
		if(playmov.pressedDown == false && SpriteIndex == 2)
		{
			image = IDLEF2;
		}
		if(playmov.pressedDown == false && SpriteIndex == 3)
		{
			image = IDLEF2;
		}
		if(playmov.pressedDown == false && SpriteIndex == 4)
		{
			image = IDLEF1;
		}
		if(wpn.Active == true && wpn.BulletAmount > 0)
		{
			image = FazeF;
		}
		
		break;
	case "right":
		if(SpriteIndex == 1)
		{
			image = WalkRight1;
		}
		if(SpriteIndex == 2)
		{
			image = WalkRight2;
		}
		if(SpriteIndex == 3)
		{
			image = WalkRight3;
		}
		if(SpriteIndex == 4)
		{
			image = WalkRight2;
		}
		if(playmov.pressedright == false && SpriteIndex == 1 || playmov.pressedright == false && SpriteIndex == 2 || playmov.pressedright == false && SpriteIndex == 3 || playmov.pressedright == false && SpriteIndex == 4 )
		{
			image = WalkRight2;
		}
		if(wpn.Active == true && wpn.BulletAmount > 0)
		{
			image = FazeF;
		}
		break;
	case "left":
		if(SpriteIndex == 1)
		{
			image = WalkLeft1;
		}
		if(SpriteIndex == 2)
		{
			image = WalkLeft2;
		}
		if(SpriteIndex == 3)
		{
			image = WalkLeft3;
		}
		if(SpriteIndex == 4)
		{
			image = WalkLeft2;
		}
		if(playmov.pressedleft == false && SpriteIndex == 1 || playmov.pressedleft == false && SpriteIndex == 2 || playmov.pressedleft == false && SpriteIndex == 3 || playmov.pressedleft == false && SpriteIndex == 4 )
		{
			image = WalkLeft2;
		}
		if(wpn.Active == true && wpn.BulletAmount > 0)
		{
			image = FazeF;
		}
		
		break;
	case "both":
		image = WalkRight2;
		if(wpn.Active == true && wpn.BulletAmount > 0)
		{
			image = FazeF;
		}
		break;
	case "both2":
		image = IDLEF1;
		if(wpn.Active == true && wpn.BulletAmount > 0)
		{
			image = FazeF;
		}
		break;
	case "ShotLeft":
	
		break;
		
	case "ShotRight":
	
		break;
	}
	
	g2d.drawImage(image, screenx, screeny, pan.PlayerTileSize, pan.PlayerTileSize, null);
	
	
	wpn.paint(g2d);
	
}
}
