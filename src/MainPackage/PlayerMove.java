package MainPackage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.Printable;

import javax.security.auth.login.CredentialNotFoundException;

import Characters.NPCs;
import Characters.PlayerScript;

public class PlayerMove implements KeyListener {

	Pannel pan;
	
	public boolean pressedUp, pressedDown, pressedright, pressedleft, pressedshoot, pressedEnter, usedDoor;
	
	public PlayerMove(Pannel pan)
	{
		this.pan = pan; 
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W)
		{
			pressedUp = true;
		}
		if(code == KeyEvent.VK_A)
		{
			pressedleft = true;
		}
		if(code == KeyEvent.VK_S)
		{
			pressedDown = true;
		}
		if(code == KeyEvent.VK_D)
		{
			pressedright = true;
		}
		if(pan.playerScript.wpn.BulletAmount > 0 && code == KeyEvent.VK_SHIFT)
		{
			pressedshoot = true;
			
		}else {pressedshoot = false;}
		
		if(code == KeyEvent.VK_ESCAPE)
		{
			pan.wpn.Active = false;
			if(pan.gameState == pan.playState)
			{
				pan.gameState = pan.pausedState;
			}
			else if(pan.gameState == pan.pausedState)
			{
				pan.gameState = pan.playState;
			}
			
			
		}
		if(code == KeyEvent.VK_ENTER && pan.gameState == pan.TitleState)
		{
			pressedEnter = true;
			System.out.println("ddddddddd");
			pan.gameState = pan.playState;
			
		}
		if(code == KeyEvent.VK_ENTER && pan.gameState == pan.GameOverState)
		{
			System.exit(0);
		}
		if(code == KeyEvent.VK_ENTER && pan.gameState == pan.CompleteState)
		{
			System.exit(0);
		}
		//4 moving player around the map==========================================================================================================
		if(pan.playerScript.CanEnter == true)
		{
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 3)
			{
				pan.playerScript.worldX = 10 *pan.tilesize;
				pan.playerScript.worldY = 17 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 4)
			{
				pan.playerScript.worldX = 3 *pan.tilesize;
				pan.playerScript.worldY = 12 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 5)
			{
				pan.playerScript.worldX = 27 *pan.tilesize;
				pan.playerScript.worldY = 18 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 6)
			{
				pan.playerScript.worldX = 2 *pan.tilesize;
				pan.playerScript.worldY = 17 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 7)
			{
				pan.playerScript.worldX = 23 *pan.tilesize;
				pan.playerScript.worldY = 12 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 8)
			{
				pan.playerScript.worldX = 18 *pan.tilesize;
				pan.playerScript.worldY = 18 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 9)
			{
				pan.playerScript.worldX = 47 *pan.tilesize;
				pan.playerScript.worldY = 18 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 10)
			{
				pan.playerScript.worldX = 14 *pan.tilesize;
				pan.playerScript.worldY = 18 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 11)
			{
				pan.playerScript.worldX = 44 *pan.tilesize;
				pan.playerScript.worldY = 12 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 12)
			{
				pan.playerScript.worldX = 32 *pan.tilesize;
				pan.playerScript.worldY = 18 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 13)
			{
				pan.playerScript.worldX = 43 *pan.tilesize;
				pan.playerScript.worldY = 26 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 14)
			{
				pan.playerScript.worldX = 36 *pan.tilesize;
				pan.playerScript.worldY = 12 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 15)
			{
				pan.playerScript.worldX = 34 *pan.tilesize;
				pan.playerScript.worldY = 24 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 16)
			{
				pan.playerScript.worldX = 33 *pan.tilesize;
				pan.playerScript.worldY = 26 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 17)
			{
				pan.playerScript.worldX = 29 *pan.tilesize;
				pan.playerScript.worldY = 26 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 18)
			{
				pan.playerScript.worldX = 32 *pan.tilesize;
				pan.playerScript.worldY = 24 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 19)
			{
				pan.playerScript.worldX = 15 *pan.tilesize;
				pan.playerScript.worldY = 23 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 20)
			{
				pan.playerScript.worldX = 15 *pan.tilesize;
				pan.playerScript.worldY = 26 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 21)
			{
				pan.playerScript.worldX = 10 *pan.tilesize;
				pan.playerScript.worldY = 26 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 22)
			{
				pan.playerScript.worldX = 14 *pan.tilesize;
				pan.playerScript.worldY = 23 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 23)
			{
				pan.playerScript.worldX = 52 *pan.tilesize;
				pan.playerScript.worldY = 27 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 24)
			{
				pan.playerScript.worldX = 6 *pan.tilesize;
				pan.playerScript.worldY = 26 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 25)
			{
				pan.playerScript.worldX = 60 *pan.tilesize;
				pan.playerScript.worldY = 23 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 26)
			{
				pan.playerScript.worldX = 60 *pan.tilesize;
				pan.playerScript.worldY = 27 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 27)
			{
				pan.playerScript.worldX = 67 *pan.tilesize;
				pan.playerScript.worldY = 18 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 28)
			{
				pan.playerScript.worldX = 67 *pan.tilesize;
				pan.playerScript.worldY = 27 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 29)
			{
				pan.playerScript.worldX = 62 *pan.tilesize;
				pan.playerScript.worldY = 13 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 30)
			{
				pan.playerScript.worldX = 61 *pan.tilesize;
				pan.playerScript.worldY = 18 *pan.tilesize;//
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 31)
			{
				pan.playerScript.worldX = 55 *pan.tilesize;
				pan.playerScript.worldY = 18 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 32)
			{
				pan.playerScript.worldX = 72 *pan.tilesize;
				pan.playerScript.worldY = 18 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 33)
			{
				pan.playerScript.worldX = 89 *pan.tilesize;
				pan.playerScript.worldY = 12 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 34)
			{
				pan.playerScript.worldX = 75 *pan.tilesize;
				pan.playerScript.worldY = 18 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 35)
			{
				pan.playerScript.worldX = 97 *pan.tilesize;
				pan.playerScript.worldY = 17 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 36)
			{
				pan.playerScript.worldX = 83 *pan.tilesize;
				pan.playerScript.worldY = 12 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 37)
			{
				pan.playerScript.worldX = 96 *pan.tilesize;
				pan.playerScript.worldY = 27 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 38)
			{
				pan.playerScript.worldX = 85 *pan.tilesize;
				pan.playerScript.worldY = 17 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 39)
			{
				pan.playerScript.worldX = 97 *pan.tilesize;
				pan.playerScript.worldY = 40 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 40)
			{
				pan.playerScript.worldX = 85 *pan.tilesize;
				pan.playerScript.worldY = 27 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 41)
			{
				pan.playerScript.worldX = 40 *pan.tilesize;
				pan.playerScript.worldY = 41 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 42)
			{
				pan.playerScript.worldX = 53 *pan.tilesize;
				pan.playerScript.worldY = 40 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 43)
			{
				pan.playerScript.worldX = 10 *pan.tilesize;
				pan.playerScript.worldY = 36 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 44)
			{
				pan.playerScript.worldX = 17 *pan.tilesize;
				pan.playerScript.worldY = 41 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 45)
			{
				pan.playerScript.worldX = 6 *pan.tilesize;
				pan.playerScript.worldY = 41 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 46)
			{
				pan.playerScript.worldX = 6 *pan.tilesize;
				pan.playerScript.worldY = 36 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 47)
			{
				pan.playerScript.worldX = 2 *pan.tilesize;
				pan.playerScript.worldY = 47 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 48)
			{
				pan.playerScript.worldX = 2 *pan.tilesize;
				pan.playerScript.worldY = 41 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 49)
			{
				pan.playerScript.worldX = 9 *pan.tilesize;
				pan.playerScript.worldY = 52 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 50)
			{
				pan.playerScript.worldX = 9 *pan.tilesize;
				pan.playerScript.worldY = 47 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 51)
			{
				pan.playerScript.worldX = 37 *pan.tilesize;
				pan.playerScript.worldY = 54 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 52)
			{
				pan.playerScript.worldX = 37 *pan.tilesize;
				pan.playerScript.worldY = 47 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 53)
			{
				pan.playerScript.worldX = 12 *pan.tilesize;
				pan.playerScript.worldY = 56 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 54)
			{
				pan.playerScript.worldX = 21 *pan.tilesize;
				pan.playerScript.worldY = 54 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 55)
			{
				pan.playerScript.worldX = 95 *pan.tilesize;
				pan.playerScript.worldY = 56 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 56)
			{
				pan.playerScript.worldX = 43 *pan.tilesize;
				pan.playerScript.worldY = 47 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 57)
			{
				pan.playerScript.worldX = 96 *pan.tilesize;
				pan.playerScript.worldY = 50 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 58)
			{
				pan.playerScript.worldX = 51 *pan.tilesize;
				pan.playerScript.worldY = 56 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 59)
			{
				pan.playerScript.worldX = 96 *pan.tilesize;
				pan.playerScript.worldY = 46 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 60)
			{
				pan.playerScript.worldX = 96 *pan.tilesize;
				pan.playerScript.worldY = 53 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 61)
			{
				pan.playerScript.worldX = 96 *pan.tilesize;
				pan.playerScript.worldY = 45 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 62)
			{
				pan.playerScript.worldX = 50 *pan.tilesize;
				pan.playerScript.worldY = 46 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 63)
			{
				pan.playerScript.worldX = 53 *pan.tilesize;
				pan.playerScript.worldY = 46 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 64)
			{
				pan.playerScript.worldX = 53 *pan.tilesize;
				pan.playerScript.worldY = 50 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 65)
			{
				pan.playerScript.worldX = 93 *pan.tilesize;
				pan.playerScript.worldY = 47 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 66)
			{
				pan.playerScript.worldX = 93 *pan.tilesize;
				pan.playerScript.worldY = 45 *pan.tilesize;
			}
			if(code == KeyEvent.VK_ENTER && pan.playerScript.TeleportID == 67)
			{
				pan.playerScript.worldX = 97 *pan.tilesize;
				pan.playerScript.worldY = 4 *pan.tilesize;
			}
			else {
				pan.playerScript.TeleportID = 0;
				pan.playerScript.CanEnter = false;
			}
			
			
		}
		//============================================================================================================================================
		
		
		if(code == KeyEvent.VK_ENTER && pan.playerScript.CanUse == true)
		{
			
		
			pan.wpn.Active = false;
			if(pan.gameState == pan.playState)
			{
				pan.gameState = pan.DialougeState;
			}
			else if(pan.gameState == pan.DialougeState)
			{
				
				pan.gameState = pan.playState;
				pan.playerScript.CanUse = false;
				
			}
		}
	  }
	

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W)
		{
			pressedUp = false;
		}
		if(code == KeyEvent.VK_A)
		{
			pressedleft = false;
		}
		if(code == KeyEvent.VK_S)
		{
			pressedDown = false;
		}
		if(code == KeyEvent.VK_D)
		{
			pressedright = false;
		}
		
	}
	
	

}
