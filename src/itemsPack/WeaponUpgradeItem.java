package itemsPack;

import java.io.IOException;

import javax.imageio.ImageIO;

public class WeaponUpgradeItem extends ItemMain{

	public WeaponUpgradeItem(){
		name = "WeaponUpgradeItem";
	

		try { img = ImageIO.read(getClass().getResourceAsStream("/Items/HPpack.png"));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
}
}