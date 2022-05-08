package itemsPack;

import java.io.IOException;

import javax.imageio.ImageIO;

public class HealthUpgrade extends ItemMain {

	public HealthUpgrade(){
		name = "HPUpgrade";
	

		try { img = ImageIO.read(getClass().getResourceAsStream("/Items/MAXhealthUpgrade.png"));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
}
}
