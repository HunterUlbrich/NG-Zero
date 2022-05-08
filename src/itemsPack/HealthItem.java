package itemsPack;

import java.io.IOException;

import javax.imageio.ImageIO;

public class HealthItem extends ItemMain{

	public HealthItem(){
		name = "Health";
	

		try { img = ImageIO.read(getClass().getResourceAsStream("/Items/HPpack.png"));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
}
}
