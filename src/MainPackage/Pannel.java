package MainPackage;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import Characters.NPCs;
import Characters.PlayerScript;
import itemsPack.ItemMain;
import tilePackage.TileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.security.PublicKey;
import java.sql.Time;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.JPanel;

public class Pannel extends JPanel implements Runnable{

	final int tileset = 140;
	final int scale = 1;
	
	public final int tilesize = tileset * scale;
	//PlayerTiler
	final int PlayerTile = 140;
	public final int PlayerTileSize = PlayerTile * scale;
	//--------------------------------------------------
	public final int screencol = 12;
	public final int screenrow = 7;
	public  final int scrrenwdith = tilesize * screencol;
	 public final int screehheight = tilesize * screenrow;
	public PlayerMove playmov = new PlayerMove(this); 
	public weapon wpn = new weapon(this, playmov);
	Thread gameThread;
	
	public final int MapLimitCol = 100;// <side ways>
	public final int MapLimitRow = 59; // down     //Change when final map is created.
	public final int worldWidth = tilesize * MapLimitCol;
	public final int worldHeight = tilesize * MapLimitRow;
	int FPS = 35;
	public PlayerScript playerScript = new PlayerScript(this, playmov, wpn);
	TileManager tileManager = new TileManager(this);
	public CollisionCheckScript ColCheckScript = new CollisionCheckScript(this);
	public ItemPlacer IT = new ItemPlacer(this);
	public ItemMain itemMain[] = new ItemMain[87];
	public NPCs npc[] = new NPCs[35];
	public UI inferface = new UI(this);

	//pause 
	public int gameState;
	public final int playState = 1;
	public final int pausedState = 0;
	public final int DialougeState = 2;
	public final int TitleState = 3;
	public final int GameOverState = 4;
	public final int CompleteState = 5;
	
	//InfoUI

	
	
	
	public Pannel()
	{
		this.setPreferredSize(new Dimension(scrrenwdith, screehheight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.setVisible(true);
		this.addKeyListener(playmov);
		this.setFocusable(true);
		
	}

	public void SetObjs()
	{
		IT.placeObjs();
		IT.PlaceNPC();
		gameState = playState;
		
	}
	
	
	
	public void StartThread()
	{
		gameThread = new Thread(this);
		gameThread.start();
	}
	public void run() {
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lasttime = System.nanoTime();
		long currentime;
		while(gameThread != null)
		{
			currentime = System.nanoTime();
			delta += (currentime - lasttime)/drawInterval;
			lasttime = currentime;
			
			if(delta >= 1)
			{
			//Camera position
			update();
			//Draw screen
			repaint();
			delta--;
			}
		}	
		
	}
	public void update()
	{
		if(playmov.pressedEnter == false)
		{
		gameState = TitleState;
		} //needs work}
		if(playmov.pressedEnter == true)
		{
			if(gameState == 1)
			{
				gameState = playState;
			}
			if(gameState == 0)
			{
				gameState = pausedState;
			}
			if(gameState == 2)
			{
				gameState = DialougeState;
			}
			if(gameState == 4)
			{
				gameState = GameOverState;
			}
			
			if(gameState == 5)
			{
				gameState = CompleteState;
			}
		}
		if(gameState == playState) {
		playerScript.update();
		
		for(int i = 0; i < npc.length; i++)
		{
			if(npc[i] != null)
			{
				npc[i].Update();
			}
		}
		}
		if(gameState == pausedState)
		{
			
			
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		//tiles
		tileManager.draw(g2d);
		
		//Objects
		for(int i = 0; i < itemMain.length; i++)
		{
			if(itemMain[i] != null )
			{
				itemMain[i].draw(g2d, this);
			}
		}
		//NPCs
		for(int i = 0; i < npc.length; i++)
		{
			if(npc[i] != null )
			{
				npc[i].draw(g2d);
			}
		}
		
		
		
		
		playerScript.draw(g2d);
		
		inferface.draw(g2d);
		//wpn.paint(g2d);
		g2d.dispose();
		
	}
	
}
