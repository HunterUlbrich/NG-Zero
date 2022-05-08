package itemsPack;

import java.io.IOException;

import javax.imageio.ImageIO;

public class AmmoItem extends ItemMain {

	
	public AmmoItem(){
		name = "AmmoPack";
	

		try { img = ImageIO.read(getClass().getResourceAsStream("/Items/AmmoPack.png"));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
}
	
	
	
}
