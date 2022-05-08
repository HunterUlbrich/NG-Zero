package itemsPack;

import java.io.IOException;

import javax.imageio.ImageIO;

public class StarCrystalItem extends ItemMain {

	
	
	public StarCrystalItem(){
		name = "StarCrystalItem";
	

		try { img = ImageIO.read(getClass().getResourceAsStream("/Items/cintin.png"));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
}
}