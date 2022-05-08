package MainPackage;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import Characters.NPCs;
import Characters.PlayerScript;

public class CollisionCheckScript {


	Pannel pan;
	public int DamageTimer = 0;
	public CollisionCheckScript(Pannel pan)
	{
		this.pan = pan;
	}
	
	public void tileCheck(NPCs npc)
	{
		int PlayerLeftX = (npc.worldX +npc.playerRectangle.x);
		int PlayerRightX = (npc.worldX+ npc.playerRectangle.x + npc.playerRectangle.width);
		int PlayerUpY = npc.worldY + npc.playerRectangle.y;
		int PlayerDownY = npc.worldY + npc.playerRectangle.y + npc.playerRectangle.height;
		
		int PlayerPositionCol = PlayerLeftX/pan.PlayerTileSize;
		int PlayerRightCol = PlayerRightX/pan.PlayerTileSize;
		int PlayerTopRow = PlayerUpY/pan.PlayerTileSize;
		int PlayerBottomRow = PlayerDownY/pan.PlayerTileSize;
		
		int tileNum1, tileNum2;
		
		switch(npc.direction)
		{
		case "up":
			PlayerTopRow = (PlayerUpY - npc.speed)/pan.PlayerTileSize;
			tileNum1 = pan.tileManager.maptile[PlayerPositionCol][PlayerTopRow];
			tileNum2 = pan.tileManager.maptile[PlayerRightCol][PlayerTopRow];
			if(pan.tileManager.tile[tileNum1].collision == true || pan.tileManager.tile[tileNum2].collision == true)
			{
				npc.CollisionOn = true;
			}
			break;
		case "down":
			PlayerBottomRow = (PlayerDownY + npc.speed)/(pan.PlayerTileSize);
			tileNum1 = pan.tileManager.maptile[PlayerPositionCol][PlayerBottomRow];
			tileNum2 = pan.tileManager.maptile[PlayerRightCol][PlayerBottomRow];
			if(pan.tileManager.tile[tileNum1].collision == true || pan.tileManager.tile[tileNum2].collision == true)
			{
				npc.CollisionOn = true;
			}
			break;
		case "left":
			PlayerPositionCol = (PlayerLeftX - npc.speed)/pan.PlayerTileSize;
			tileNum1 = pan.tileManager.maptile[PlayerPositionCol][PlayerTopRow];
			tileNum2 = pan.tileManager.maptile[PlayerPositionCol][PlayerBottomRow];
			if(pan.tileManager.tile[tileNum1].collision == true || pan.tileManager.tile[tileNum2].collision == true)
			{
				npc.CollisionOn = true;
			}
			break;
		case "right":
			PlayerRightCol = (PlayerRightX + npc.speed)/pan.PlayerTileSize;
			tileNum1 = pan.tileManager.maptile[PlayerRightCol][PlayerTopRow];
			tileNum2 = pan.tileManager.maptile[PlayerRightCol][PlayerBottomRow];
			if(pan.tileManager.tile[tileNum1].collision == true || pan.tileManager.tile[tileNum2].collision == true)
			{
				npc.CollisionOn = true;
			}
			break;
		case "AngelLeft":
			PlayerPositionCol = (PlayerLeftX - npc.speed)/pan.PlayerTileSize;
			tileNum1 = pan.tileManager.maptile[PlayerPositionCol][PlayerTopRow];
			tileNum2 = pan.tileManager.maptile[PlayerPositionCol][PlayerBottomRow];
			if(pan.tileManager.tile[tileNum1].collision == true || pan.tileManager.tile[tileNum2].collision == true)
			{
				npc.CollisionOn = true;
			}
			break;
		case "AngelRight":
			PlayerRightCol = (PlayerRightX + npc.speed)/pan.PlayerTileSize;
			tileNum1 = pan.tileManager.maptile[PlayerRightCol][PlayerTopRow];
			tileNum2 = pan.tileManager.maptile[PlayerRightCol][PlayerBottomRow];
			if(pan.tileManager.tile[tileNum1].collision == true || pan.tileManager.tile[tileNum2].collision == true)
			{
				npc.CollisionOn = true;
			}
			break;
		
		
		}
		
		
	}

	public int CheckObject(NPCs npc, boolean player)
	{
		int index = 999;
		
		for(int i =0; i < pan.itemMain.length; i++)
		{
			if(pan.itemMain[i] != null)
			{
				npc.playerRectangle.x = npc.worldX + npc.playerRectangle.x;
				npc.playerRectangle.y = npc.worldY + npc.playerRectangle.y;
				
				pan.itemMain[i].SolidArea.x = pan.itemMain[i].worldx + pan.itemMain[i].SolidArea.x;
				pan.itemMain[i].SolidArea.y = pan.itemMain[i].worldy + pan.itemMain[i].SolidArea.y;
				
				switch(npc.direction)
				{
				case "up":
					npc.playerRectangle.y -= npc.speed;
					if(npc.playerRectangle.intersects(pan.itemMain[i].SolidArea))
					{
						System.out.println("mksjdskjdskjsdksjdksdj");
						if(player == true)
						{
							index = i;
						}
					}
					break;
				case "down":
					npc.playerRectangle.y += npc.speed;
					if(npc.playerRectangle.intersects(pan.itemMain[i].SolidArea))
					{
						System.out.println("ererererererere");
						if(player == true)
						{
							index = i;
						}
					}
					break;
				case "left":
					npc.playerRectangle.y -= npc.speed;
					if(npc.playerRectangle.intersects(pan.itemMain[i].SolidArea))
					{
						System.out.println("iiiuiuuiuiuiu");
						if(player == true)
						{
							index = i;
						}
					}
					break;
				case "right":
					npc.playerRectangle.y += npc.speed;
					if(npc.playerRectangle.intersects(pan.itemMain[i].SolidArea))
					{
						System.out.println("nnvbvvbvbvvbvbvbvb");
						if(player == true)
						{
							index = i;
						}
					}
					break;
				}
				npc.playerRectangle.x = npc.SolidAreaDefaultX;
				npc.playerRectangle.y = npc.SolidAreaDefaultY;
				pan.itemMain[i].SolidArea.x = pan.itemMain[i].DefaultX;
				pan.itemMain[i].SolidArea.y = pan.itemMain[i].DefaultY;
			}
			
		}
		return index;
	}
	//NPC Collision
	public int CheckNPCCollision(NPCs npc, NPCs[] target)
	{
		int index = 999;
		
		for(int i =0; i < target.length; i++)
		{
			if(target[i] != null)
			{
				npc.playerRectangle.x = npc.worldX + npc.playerRectangle.x;
				npc.playerRectangle.y = npc.worldY + npc.playerRectangle.y;
				
				target[i].playerRectangle.x =target[i].worldX + target[i].playerRectangle.x;
				target[i].playerRectangle.y = target[i].worldY + target[i].playerRectangle.y;
				switch(npc.direction)
				{
				case "left":
					npc.playerRectangle.x -= npc.speed;
					if(npc.playerRectangle.intersects(pan.npc[i].playerRectangle))
					{
						npc.CollisionOn = true;
						index = 1;
						//System.out.println("ppppppppp");
//						pan.playerScript.GotHit = true;
//						pan.playerScript.PlayerHealth = pan.playerScript.PlayerHealth -1;
					}
					break;
				case "right":
					npc.playerRectangle.x += npc.speed;
					if(npc.playerRectangle.intersects(pan.npc[i].playerRectangle))
					{
						npc.CollisionOn = true;
						index = 1;
						//System.out.println("oooooooooooooo");
//						pan.playerScript.GotHit = true;
//						pan.playerScript.PlayerHealth = pan.playerScript.PlayerHealth -1;
					}
					break;
				case "AngelLeft":
					npc.playerRectangle.x -= npc.speed;
					if(npc.playerRectangle.intersects(pan.npc[i].playerRectangle))
					{
						npc.CollisionOn = true;
						index = 1;
						//System.out.println("ppppppppp");
//						pan.playerScript.GotHit = true;
//						pan.playerScript.PlayerHealth = pan.playerScript.PlayerHealth -1;
					}
					break;
				case "AngelRight":
					npc.playerRectangle.x += npc.speed;
					if(npc.playerRectangle.intersects(pan.npc[i].playerRectangle))
					{
						npc.CollisionOn = true;
						index = 1;
						//System.out.println("oooooooooooooo");
//						pan.playerScript.GotHit = true;
//						pan.playerScript.PlayerHealth = pan.playerScript.PlayerHealth -1;
					}
					break;
				}
				npc.playerRectangle.x = npc.SolidAreaDefaultX;
				npc.playerRectangle.y = npc.SolidAreaDefaultY;
				target[i].playerRectangle.x = target[i].SolidAreaDefaultX;
				target[i].playerRectangle.y = target[i].SolidAreaDefaultY;
			}
			
		}
		return index;
	}
	
	public void CheckPlayer(NPCs npc)
	{
		npc.playerRectangle.x = npc.worldX + npc.playerRectangle.x;
		npc.playerRectangle.y = npc.worldY + npc.playerRectangle.y;
		
		pan.playerScript.playerRectangle.x =pan.playerScript.worldX + pan.playerScript.playerRectangle.x;
		pan.playerScript.playerRectangle.y = pan.playerScript.worldY + pan.playerScript.playerRectangle.y;
		switch(npc.direction)
		{
		case "left":
			npc.playerRectangle.x -= npc.speed;
			if(npc.playerRectangle.intersects(pan.playerScript.playerRectangle))
			{
				npc.CollisionOn = true;
				//For Damage
				pan.playerScript.GotHit = true;
				if(pan.playerScript.wpn.Active == false) {
				npc.direction = "Alien Hit Left";
				pan.playerScript.PlayerHealth = pan.playerScript.PlayerHealth -20;
				pan.playerScript.playerHealthString = String.valueOf(pan.playerScript.PlayerHealth);}
				else if(pan.playerScript.wpn.Active == true)
				{
					npc.direction = "left";
					pan.playerScript.PlayerHealth = pan.playerScript.PlayerHealth -0;
					pan.playerScript.playerHealthString = String.valueOf(pan.playerScript.PlayerHealth);
				}
				
				//System.out.println("ppppppppp");
				
			}
			else {pan.playerScript.GotHit = false; npc.direction = "left";}
			break;
		case "right":
			npc.playerRectangle.x += npc.speed;
			if(npc.playerRectangle.intersects(pan.playerScript.playerRectangle))
			{
				npc.CollisionOn = true;
				//For Damage
				pan.playerScript.GotHit = true;
				//System.out.println("oooooooooooooo");
				if(pan.playerScript.wpn.Active == false) {
					npc.direction = "Alien Hit Right";
					pan.playerScript.PlayerHealth = pan.playerScript.PlayerHealth -20;
					pan.playerScript.playerHealthString = String.valueOf(pan.playerScript.PlayerHealth);}
					else if(pan.playerScript.wpn.Active == true)
					{
						npc.direction = "right";
						pan.playerScript.PlayerHealth = pan.playerScript.PlayerHealth -0;
						pan.playerScript.playerHealthString = String.valueOf(pan.playerScript.PlayerHealth);
					}
			}
			else {pan.playerScript.GotHit = false; npc.direction = "right";}
			break;
		case "AngelLeft":
			npc.playerRectangle.x -= npc.speed;
			if(npc.playerRectangle.intersects(pan.playerScript.playerRectangle))
			{
				npc.CollisionOn = true;
				//For Damage
				pan.playerScript.GotHit = true;
				if(pan.playerScript.wpn.Active == false) {
				npc.direction = "Angel Hit Left";
				pan.playerScript.PlayerHealth = pan.playerScript.PlayerHealth -35;
				pan.playerScript.playerHealthString = String.valueOf(pan.playerScript.PlayerHealth);}
				else if(pan.playerScript.wpn.Active == true)
				{
					npc.direction = "AngelLeft";
					pan.playerScript.PlayerHealth = pan.playerScript.PlayerHealth -0;
					pan.playerScript.playerHealthString = String.valueOf(pan.playerScript.PlayerHealth);
				}
				
				//System.out.println("ppppppppp");
				
			}
			else {pan.playerScript.GotHit = false; npc.direction = "AngelLeft";}
			break;
		case "AngelRight":
			npc.playerRectangle.x += npc.speed;
			if(npc.playerRectangle.intersects(pan.playerScript.playerRectangle))
			{
				npc.CollisionOn = true;
				//For Damage
				pan.playerScript.GotHit = true;
				//System.out.println("oooooooooooooo");
				if(pan.playerScript.wpn.Active == false) {
					npc.direction = "Angel Hit Right";
					pan.playerScript.PlayerHealth = pan.playerScript.PlayerHealth -35;
					pan.playerScript.playerHealthString = String.valueOf(pan.playerScript.PlayerHealth);}
					else if(pan.playerScript.wpn.Active == true)
					{
						npc.direction = "AngelRight";
						pan.playerScript.PlayerHealth = pan.playerScript.PlayerHealth -0;
						pan.playerScript.playerHealthString = String.valueOf(pan.playerScript.PlayerHealth);
					}
			}
			else {pan.playerScript.GotHit = false; npc.direction = "AngelRight";}
			break;
		}
		npc.playerRectangle.x = npc.SolidAreaDefaultX;
		npc.playerRectangle.y = npc.SolidAreaDefaultY;
		pan.playerScript.playerRectangle.x = pan.playerScript.SolidAreaDefaultX;
		pan.playerScript.playerRectangle.y = pan.playerScript.SolidAreaDefaultY;	
	}
}

