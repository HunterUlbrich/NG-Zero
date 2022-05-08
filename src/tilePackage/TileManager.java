package tilePackage;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import MainPackage.Pannel;

public class TileManager {

	Pannel pan;
	int TileAmount = 80;
	public TileScript[] tile;
	public int maptile[] [];
	public TileManager(Pannel pan)
	{
		this.pan = pan;
		tile = new TileScript[TileAmount];
		maptile = new int [pan.MapLimitCol][pan.MapLimitRow];
		GetTiles();
		loadmap();
	}
	void GetTiles()
	{
		try {
			
			tile[0] = new TileScript();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/GrayBig2.png"));

			tile[1] = new TileScript();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/GrayBig.png"));
			//Collision Test==========================================================================
			tile[2] = new TileScript();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Brick1.png"));
			tile[2].collision = true;
			
			tile[3] = new TileScript();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/colTest2.png"));
			tile[3].collision = true;
			
			tile[4] = new TileScript();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/RailLine.png"));
			tile[4].collision = true;
			
			tile[5] = new TileScript();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/RailLineSpeed.png"));
			tile[5].collision = true;
			
			tile[6] = new TileScript();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Rocks.png"));
			//tile[5].collision = true;
			
			tile[7] = new TileScript();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/RocksBrace1.png"));
			//tile[5].collision = true;
			
			tile[8] = new TileScript();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/RocksBrace2.png"));
			//tile[5].collision = true;
			
			tile[9] = new TileScript();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/RocksBraceTOP.png"));
			
			tile[10] = new TileScript();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/latter.png"));
			//tile[5].collision = true;
			
			tile[11] = new TileScript();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/MineCart1.png"));
			//tile[5].collision = true;
			
			tile[12] = new TileScript();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/MineCart2.png"));
			//tile[5].collision = true;
			
			tile[13] = new TileScript();
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Wall1.png"));
			tile[13].collision = true;
			
			tile[14] = new TileScript();
			tile[14].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Wall2.png"));
			tile[14].collision = true;
			
			tile[15] = new TileScript();
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Wall3.png"));
			tile[15].collision = true;
			
			tile[16] = new TileScript();
			tile[16].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/walls.png"));
			//tile[5].collision = true;
			
			tile[17] = new TileScript();
			tile[17].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/walls2.png"));
			tile[17].collision = true;
			
			tile[18] = new TileScript();
			tile[18].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/walls3.png"));
			tile[18].collision = true;
			
			tile[19] = new TileScript();
			tile[19].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/floor1.png"));
			tile[19].collision = true;
			
			tile[20] = new TileScript();
			tile[20].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Flsg.png"));
			//tile[20].collision = true;
			
			tile[21] = new TileScript();
			tile[21].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/blackDoor.png"));
			//tile[19].collision = true;
			
			tile[22] = new TileScript();
			tile[22].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/whiteDoor.png"));
			//tile[19].collision = true;
			
			tile[23] = new TileScript();
			tile[23].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/lentins.png"));
			//tile[19].collision = true;
			
			tile[24] = new TileScript();
			tile[24].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Dirt.png"));
			//tile[19].collision = true;
			
			tile[25] = new TileScript();
			tile[25].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Beams.png"));
			//tile[19].collision = true;
			
			tile[26] = new TileScript();
			tile[26].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Flagbottom.png"));
			//tile[19].collision = true;
			
			tile[27] = new TileScript();
			tile[27].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/FlagMiddle.png"));
			//tile[19].collision = true;
			
			tile[28] = new TileScript();
			tile[28].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/FlagTop.png"));
			//tile[19].collision = true;
			
			tile[29] = new TileScript();
			tile[29].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/box (1).png"));
			//tile[19].collision = true;
			
			tile[30] = new TileScript();
			tile[30].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/box (4).png"));
			//tile[19].collision = true;
			
			tile[31] = new TileScript();
			tile[31].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/box (3).png"));
			//tile[19].collision = true;
			
			tile[32] = new TileScript();
			tile[32].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/box (2).png"));
			//tile[19].collision = true;
			
			tile[33] = new TileScript();
			tile[33].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/pillar1.png"));
			//tile[19].collision = true;
			
			tile[34] = new TileScript();
			tile[34].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Temple1.png"));
			tile[34].collision = true;
			
			tile[35] = new TileScript();
			tile[35].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Temple2.png"));
			//tile[34].collision = true;
			
			tile[36] = new TileScript();
			tile[36].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/FlagDark.png"));
			//tile[34].collision = true;
			
			tile[37] = new TileScript();
			tile[37].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/construction.png"));
			//tile[34].collision = true;
			
			tile[38] = new TileScript();
			tile[38].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/StatueLightTOP.png"));
			//tile[34].collision = true;
			
			tile[39] = new TileScript();
			tile[39].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/StatueLightBOTTOM.png"));
			//tile[34].collision = true;
			
			tile[40] = new TileScript();
			tile[40].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/StatueDarkTOP.png"));
			//tile[34].collision = true;
			
			tile[41] = new TileScript();
			tile[41].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/StatueDarkBOTTOM.png"));
			//tile[34].collision = true;
			
			tile[42] = new TileScript();
			tile[42].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/latterDark.png"));
			//tile[34].collision = true;
			
			tile[43] = new TileScript();
			tile[43].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/pillarTemple.png"));
			//tile[34].collision = true;
			
			tile[44] = new TileScript();
			tile[44].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/pillarTemple2.png"));
			//tile[34].collision = true;
			
			tile[45] = new TileScript();
			tile[45].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/sky.png"));
			//tile[34].collision = true;
			
			tile[46] = new TileScript();
			tile[46].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/grass1.png"));
			//tile[34].collision = true;
			
			tile[47] = new TileScript();
			tile[47].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/view.png"));
			//tile[34].collision = true;
			
			//planets
			tile[48] = new TileScript();
			tile[48].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Planet (1).png"));
			//tile[34].collision = true;
			
			tile[49] = new TileScript();
			tile[49].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Planet (2).png"));
			//tile[34].collision = true;
			
			tile[50] = new TileScript();
			tile[50].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Planet (3).png"));
			//tile[34].collision = true;
			
			tile[51] = new TileScript();
			tile[51].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Planet (4).png"));
			//tile[34].collision = true;
			
			tile[52] = new TileScript();
			tile[52].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Planet (5).png"));
			//tile[34].collision = true;
			
			tile[53] = new TileScript();
			tile[53].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Planet (6).png"));
			//tile[34].collision = true;
			
			tile[54] = new TileScript();
			tile[54].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Planet (7).png"));
			//tile[34].collision = true;
			
			tile[55] = new TileScript();
			tile[55].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Planet (8).png"));
			//tile[34].collision = true;
			
			tile[56] = new TileScript();
			tile[56].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Planet (9).png"));
			//tile[34].collision = true;
		}catch (IOException e) {

				e.printStackTrace();
		}
		
	}
	public void loadmap()
	{
		try {InputStream inStream = getClass().getResourceAsStream("/MapPacks/FinalMap.txt"); //change map
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inStream));
		int col = 0;
		int row = 0;
		while (col < pan.MapLimitCol && row < pan.MapLimitRow)
		{
			String lineString = bufferedReader.readLine();
			while (col < pan.MapLimitCol)
			{
				String numbers[] = lineString.split(" ");
				int num = Integer.parseInt(numbers[col]);
				maptile[col][row] = num;
				col++;
			}
			if(col == pan.MapLimitCol)
			{
				col = 0;
				row++;
			}
		}
		bufferedReader.close();
		}
		catch(Exception e)
		{}
	}
	public void draw(Graphics2D g2)
	{
		int column = 0;
		int row  = 0;
		
		while (column < pan.MapLimitCol && row < pan.MapLimitRow)
		{
			int tilenum = maptile[column][row];
			
			int worldx = column * pan.tilesize;
			int worldy = row * pan.tilesize;
			int screenx = worldx - pan.playerScript.worldX  + pan.playerScript.screenx;
			int screeny = worldy - pan.playerScript.worldY + pan.playerScript.screeny;
			
			if(worldx + pan.PlayerTileSize > pan.playerScript.worldX - pan.playerScript.screenx &&
			   worldx - pan.PlayerTileSize < pan.playerScript.worldX + pan.playerScript.screenx &&
			  worldy + pan.PlayerTileSize > pan.playerScript.worldY - pan.playerScript.screeny &&
			   worldy - pan.PlayerTileSize < pan.playerScript.worldY + pan.playerScript.screeny)
			{g2.drawImage(tile[tilenum].image, screenx, screeny, pan.tilesize, pan.tilesize, null);}
			
			
			column++;
			
			
			if(column == pan.MapLimitCol)
			{
				column = 0;
				
				row++;
				
			}
		}
		
	}
}
