package itemsPack;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import MainPackage.Pannel;

public class ItemMain {

	public BufferedImage img;
	public String name;
	public boolean collision = false;
	public int worldx, worldy;
	public Rectangle SolidArea = new Rectangle(56, 68, 22, 70 ); //(x, y, width, height)
	public int DefaultX = 0;
	public int DefaultY = 0;
	
	public void draw(Graphics2D g2, Pannel pan)
	{
		int screenx = worldx - pan.playerScript.worldX + pan.playerScript.screenx;
		int screeny = worldy - pan.playerScript.worldY + pan.playerScript.screeny;
		
		if(worldx + pan.PlayerTileSize > pan.playerScript.worldX - pan.playerScript.screenx &&
		   worldx - pan.PlayerTileSize < pan.playerScript.worldX + pan.playerScript.screenx &&
		  worldy + pan.PlayerTileSize > pan.playerScript.worldY - pan.playerScript.screeny &&
		   worldy - pan.PlayerTileSize < pan.playerScript.worldY + pan.playerScript.screeny)
		{g2.drawImage(img, screenx, screeny, pan.tilesize, pan.tilesize, null);
	
		}
	}
}
