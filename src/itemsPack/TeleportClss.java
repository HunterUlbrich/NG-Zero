package itemsPack;

import java.io.IOException;

import javax.imageio.ImageIO;

public class TeleportClss extends ItemMain {

	public TeleportClss()
	{
		name = "TeleportItem";
		

		try { img = ImageIO.read(getClass().getResourceAsStream("/Items/TstTeleport.png"));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
}
