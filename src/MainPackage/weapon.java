package MainPackage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.security.PublicKey;
import java.util.Timer;
import java.util.TimerTask;

import Characters.NPCs;
import Characters.PlayerScript;

public class weapon extends BulletMain   {
	Pannel pan;
	PlayerMove pMove;
	PlayerScript pScript;
	int x, y, xDirection;
	int bx, by;
	boolean readytofire, shot = false;
	public int BulletAmount = 100;
	public String bulletAmountString;
	public boolean Active;
	Timer t = new Timer(true);
	Rectangle bulletCollider;
	int TimeAmmount = 750;
	
	public weapon(Pannel pan, PlayerMove pMove)
	{
		this.pan = pan;
		this.pMove = pMove;
		bulletCollider = new Rectangle(12, 24, 120, 120);
		
	}
	
	public void Values()
	{
		BulPosX =  pan.scrrenwdith/2 - (pan.PlayerTileSize/2); //default shooting point
		BulPosY =  pan.scrrenwdith/2 - (pan.PlayerTileSize/2);
		Active = false;
		bulletAmountString = String.valueOf(BulletAmount);
		System.out.println("its running");
	
	}
	
	public void paint(Graphics2D g2d)
	{
		if(Active == true && BulletAmount > 0) {
		//g2d.setPaint(Color.orange);
		//g2d.drawRect(bulletCollider.x, + bulletCollider.y, bulletCollider.height, bulletCollider.width);
		//g2d.rotate(Math.toRadians(90));
		g2d.setPaint(Color.white);
		g2d.drawRect(bulletCollider.x + 767, + bulletCollider.y + 410, bulletCollider.height, bulletCollider.width);
		
		}
		else {
			return;
		}
		
	}
	
	public void shoot()
	{
		Active = true;
		resume();
		if(Active == true && BulletAmount > 0) {
		t.schedule(new TimerTask() {
		    @Override
		    public void run() {
		    	BulletAmount--;
		    	bulletAmountString = String.valueOf(BulletAmount);

		       System.out.println(BulletAmount + " " + TimeAmmount);
		       
		       
		       if(BulletAmount <= 0)
				{
					BulletAmount = 0;
					StopShoot();
				}
		       
		       if(Active == false)
		       {
		    	   		pause();
		       }
		    }
		}, 0, TimeAmmount);}
		
	} 
	
	public void pause()
	{
		System.out.println("Paused");
		t.cancel();
	}
	public void resume()
	{
		this.t = new Timer();
		t.purge();
	}
	public void StopShoot()
	{
		Active = false;
		
	}
	

}
	
	
	
	


