package MainPackage;

import Characters.AlienScript;
import Characters.AngelScript;
import Characters.Terminal;
import itemsPack.AmmoItem;
import itemsPack.HealthItem;
import itemsPack.HealthUpgrade;
import itemsPack.StarCrystalItem;
import itemsPack.TeleportClss;

public class ItemPlacer {

	Pannel pan;
	
	public ItemPlacer(Pannel pan)
	{
		this.pan = pan;
	}
	
	public void placeObjs()
	{
		pan.itemMain[0] = new HealthItem();
		pan.itemMain[0].worldx = 21 * pan.tilesize;
		pan.itemMain[0].worldy = 12 * pan.tilesize;
		
		pan.itemMain[1] = new StarCrystalItem();
		pan.itemMain[1].worldx = 3 * pan.tilesize;
		pan.itemMain[1].worldy = 12 * pan.tilesize;
		
		pan.itemMain[2] = new StarCrystalItem();
		pan.itemMain[2].worldx = 15 * pan.tilesize;
		pan.itemMain[2].worldy = 12 * pan.tilesize;
		
		pan.itemMain[3] = new TeleportClss();
		pan.itemMain[3].worldx = 2 * pan.tilesize;
		pan.itemMain[3].worldy = 12 * pan.tilesize;
		
		pan.itemMain[4] = new TeleportClss();
		pan.itemMain[4].worldx = 10 * pan.tilesize;
		pan.itemMain[4].worldy = 17 * pan.tilesize;
		
		pan.itemMain[5] = new TeleportClss();
		pan.itemMain[5].worldx = 2 * pan.tilesize;
		pan.itemMain[5].worldy = 17 * pan.tilesize;
		
		pan.itemMain[6] = new TeleportClss();
		pan.itemMain[6].worldx = 27 * pan.tilesize;
		pan.itemMain[6].worldy = 18 * pan.tilesize;
		
		pan.itemMain[7] = new TeleportClss();
		pan.itemMain[7].worldx = 19 * pan.tilesize;
		pan.itemMain[7].worldy = 18 * pan.tilesize;
		
		pan.itemMain[8] = new TeleportClss();
		pan.itemMain[8].worldx = 23 * pan.tilesize;
		pan.itemMain[8].worldy = 12 * pan.tilesize;
		
		pan.itemMain[9] = new TeleportClss();
		pan.itemMain[9].worldx = 14 * pan.tilesize;
		pan.itemMain[9].worldy = 18 * pan.tilesize;
		
		pan.itemMain[10] = new TeleportClss();
		pan.itemMain[10].worldx = 47 * pan.tilesize;
		pan.itemMain[10].worldy = 18 * pan.tilesize;
		
		pan.itemMain[11] = new TeleportClss();
		pan.itemMain[11].worldx = 32 * pan.tilesize;
		pan.itemMain[11].worldy = 18 * pan.tilesize;
		
		pan.itemMain[12] = new TeleportClss();
		pan.itemMain[12].worldx = 44 * pan.tilesize;
		pan.itemMain[12].worldy = 12 * pan.tilesize;
		
		pan.itemMain[13] = new TeleportClss();
		pan.itemMain[13].worldx = 36 * pan.tilesize;
		pan.itemMain[13].worldy = 12 * pan.tilesize;
		
		pan.itemMain[14] = new TeleportClss();
		pan.itemMain[14].worldx = 43 * pan.tilesize;
		pan.itemMain[14].worldy = 26 * pan.tilesize;
		
		pan.itemMain[15] = new TeleportClss();
		pan.itemMain[15].worldx = 34 * pan.tilesize;
		pan.itemMain[15].worldy = 26 * pan.tilesize;
		
		pan.itemMain[16] = new TeleportClss();
		pan.itemMain[16].worldx = 34 * pan.tilesize;
		pan.itemMain[16].worldy = 24 * pan.tilesize;
		
		pan.itemMain[17] = new TeleportClss();
		pan.itemMain[17].worldx = 32 * pan.tilesize;
		pan.itemMain[17].worldy = 24 * pan.tilesize;
		
		pan.itemMain[18] = new TeleportClss();
		pan.itemMain[18].worldx = 29 * pan.tilesize;
		pan.itemMain[18].worldy = 26 * pan.tilesize;
		
		pan.itemMain[19] = new TeleportClss();
		pan.itemMain[19].worldx = 15 * pan.tilesize;
		pan.itemMain[19].worldy = 26 * pan.tilesize;
		
		pan.itemMain[20] = new TeleportClss();
		pan.itemMain[20].worldx = 15 * pan.tilesize;
		pan.itemMain[20].worldy = 23 * pan.tilesize;
		
		pan.itemMain[21] = new TeleportClss();
		pan.itemMain[21].worldx = 14 * pan.tilesize;
		pan.itemMain[21].worldy = 23 * pan.tilesize;
		
		pan.itemMain[22] = new TeleportClss();
		pan.itemMain[22].worldx = 10 * pan.tilesize;
		pan.itemMain[22].worldy = 26 * pan.tilesize;
		
		pan.itemMain[23] = new TeleportClss();
		pan.itemMain[23].worldx = 6 * pan.tilesize;
		pan.itemMain[23].worldy = 26 * pan.tilesize;
		
		pan.itemMain[24] = new TeleportClss();
		pan.itemMain[24].worldx = 52 * pan.tilesize;
		pan.itemMain[24].worldy = 27 * pan.tilesize;
		
		pan.itemMain[25] = new TeleportClss();
		pan.itemMain[25].worldx = 60 * pan.tilesize;
		pan.itemMain[25].worldy = 27 * pan.tilesize;
		
		pan.itemMain[26] = new TeleportClss();
		pan.itemMain[26].worldx = 60 * pan.tilesize;
		pan.itemMain[26].worldy = 23 * pan.tilesize;
		
		pan.itemMain[27] = new TeleportClss();
		pan.itemMain[27].worldx = 67 * pan.tilesize;
		pan.itemMain[27].worldy = 27 * pan.tilesize;
		
		pan.itemMain[28] = new TeleportClss();
		pan.itemMain[28].worldx = 67 * pan.tilesize;
		pan.itemMain[28].worldy = 18 * pan.tilesize;
		
		pan.itemMain[29] = new TeleportClss();
		pan.itemMain[29].worldx = 62 * pan.tilesize;
		pan.itemMain[29].worldy = 18 * pan.tilesize;
		
		pan.itemMain[30] = new TeleportClss();
		pan.itemMain[30].worldx = 62 * pan.tilesize;
		pan.itemMain[30].worldy = 13 * pan.tilesize;
		
		pan.itemMain[31] = new TeleportClss();
		pan.itemMain[31].worldx = 72 * pan.tilesize;
		pan.itemMain[31].worldy = 18 * pan.tilesize;
		
		pan.itemMain[32] = new TeleportClss();
		pan.itemMain[32].worldx = 55 * pan.tilesize;
		pan.itemMain[32].worldy = 18 * pan.tilesize;

		pan.itemMain[33] = new TeleportClss();
		pan.itemMain[33].worldx = 75 * pan.tilesize;
		pan.itemMain[33].worldy = 18 * pan.tilesize;
		
		pan.itemMain[34] = new TeleportClss();
		pan.itemMain[34].worldx = 89 * pan.tilesize;
		pan.itemMain[34].worldy = 12 * pan.tilesize;
		
		pan.itemMain[35] = new TeleportClss();
		pan.itemMain[35].worldx = 83 * pan.tilesize;
		pan.itemMain[35].worldy = 12 * pan.tilesize;
		
		pan.itemMain[36] = new TeleportClss();
		pan.itemMain[36].worldx = 97 * pan.tilesize;
		pan.itemMain[36].worldy = 17 * pan.tilesize;
		
		pan.itemMain[37] = new TeleportClss();
		pan.itemMain[37].worldx = 85 * pan.tilesize;
		pan.itemMain[37].worldy = 17 * pan.tilesize;
		
		pan.itemMain[38] = new TeleportClss();
		pan.itemMain[38].worldx = 96 * pan.tilesize;
		pan.itemMain[38].worldy = 27 * pan.tilesize;
		
		pan.itemMain[39] = new TeleportClss();
		pan.itemMain[39].worldx = 85 * pan.tilesize;
		pan.itemMain[39].worldy = 27 * pan.tilesize;
		
		pan.itemMain[40] = new TeleportClss();
		pan.itemMain[40].worldx = 97 * pan.tilesize;
		pan.itemMain[40].worldy = 40 * pan.tilesize;
		
		pan.itemMain[41] = new TeleportClss();
		pan.itemMain[41].worldx = 53 * pan.tilesize;
		pan.itemMain[41].worldy = 40 * pan.tilesize;
		
		pan.itemMain[42] = new TeleportClss();
		pan.itemMain[42].worldx = 40 * pan.tilesize;
		pan.itemMain[42].worldy = 41 * pan.tilesize;
		
		pan.itemMain[43] = new TeleportClss();
		pan.itemMain[43].worldx = 17 * pan.tilesize;
		pan.itemMain[43].worldy = 41 * pan.tilesize;
		
		pan.itemMain[44] = new TeleportClss();
		pan.itemMain[44].worldx = 10 * pan.tilesize;
		pan.itemMain[44].worldy = 36 * pan.tilesize;
		
		pan.itemMain[45] = new TeleportClss();
		pan.itemMain[45].worldx = 6 * pan.tilesize;
		pan.itemMain[45].worldy = 36 * pan.tilesize;
		
		pan.itemMain[46] = new TeleportClss();
		pan.itemMain[46].worldx = 6 * pan.tilesize;
		pan.itemMain[46].worldy = 41 * pan.tilesize;
		
		pan.itemMain[47] = new TeleportClss();
		pan.itemMain[47].worldx = 2 * pan.tilesize;
		pan.itemMain[47].worldy = 41 * pan.tilesize;
		
		pan.itemMain[48] = new TeleportClss();
		pan.itemMain[48].worldx = 2 * pan.tilesize;
		pan.itemMain[48].worldy = 47 * pan.tilesize;
		
		pan.itemMain[49] = new TeleportClss();
		pan.itemMain[49].worldx = 9 * pan.tilesize;
		pan.itemMain[49].worldy = 47 * pan.tilesize;
		
		pan.itemMain[50] = new TeleportClss();
		pan.itemMain[50].worldx = 9 * pan.tilesize;
		pan.itemMain[50].worldy = 52 * pan.tilesize;
		
		pan.itemMain[51] = new TeleportClss();
		pan.itemMain[51].worldx = 37 * pan.tilesize;
		pan.itemMain[51].worldy = 47 * pan.tilesize;
		
		pan.itemMain[52] = new TeleportClss();
		pan.itemMain[52].worldx = 37 * pan.tilesize;
		pan.itemMain[52].worldy = 54 * pan.tilesize;
		
		pan.itemMain[53] = new TeleportClss();
		pan.itemMain[53].worldx = 21 * pan.tilesize;
		pan.itemMain[53].worldy = 54 * pan.tilesize;
		
		pan.itemMain[54] = new TeleportClss();
		pan.itemMain[54].worldx = 12 * pan.tilesize;
		pan.itemMain[54].worldy = 56 * pan.tilesize;
		
		pan.itemMain[55] = new TeleportClss();
		pan.itemMain[55].worldx = 43 * pan.tilesize;
		pan.itemMain[55].worldy = 47 * pan.tilesize;
		
		pan.itemMain[56] = new TeleportClss();
		pan.itemMain[56].worldx = 95 * pan.tilesize;
		pan.itemMain[56].worldy = 56 * pan.tilesize;
		
		pan.itemMain[57] = new TeleportClss();
		pan.itemMain[57].worldx = 51 * pan.tilesize;
		pan.itemMain[57].worldy = 56 * pan.tilesize;
		
		pan.itemMain[58] = new TeleportClss();
		pan.itemMain[58].worldx = 96 * pan.tilesize;
		pan.itemMain[58].worldy = 50 * pan.tilesize;
		
		pan.itemMain[59] = new TeleportClss();
		pan.itemMain[59].worldx = 96 * pan.tilesize;
		pan.itemMain[59].worldy = 53 * pan.tilesize;
		
		pan.itemMain[60] = new TeleportClss();
		pan.itemMain[60].worldx = 96 * pan.tilesize;
		pan.itemMain[60].worldy = 46 * pan.tilesize;
		
		pan.itemMain[61] = new TeleportClss();
		pan.itemMain[61].worldx = 50 * pan.tilesize;
		pan.itemMain[61].worldy = 46 * pan.tilesize;
		
		pan.itemMain[62] = new TeleportClss();
		pan.itemMain[62].worldx = 96 * pan.tilesize;
		pan.itemMain[62].worldy = 45 * pan.tilesize;
		
		pan.itemMain[63] = new TeleportClss();
		pan.itemMain[63].worldx = 53 * pan.tilesize;
		pan.itemMain[63].worldy = 50 * pan.tilesize;
		
		pan.itemMain[64] = new TeleportClss();
		pan.itemMain[64].worldx = 53 * pan.tilesize;
		pan.itemMain[64].worldy = 46 * pan.tilesize;
		
		pan.itemMain[65] = new TeleportClss();
		pan.itemMain[65].worldx = 93 * pan.tilesize;
		pan.itemMain[65].worldy = 45 * pan.tilesize; //
		
		pan.itemMain[66] = new TeleportClss();
		pan.itemMain[66].worldx = 93 * pan.tilesize;
		pan.itemMain[66].worldy = 47 * pan.tilesize; //
		
		pan.itemMain[67] = new TeleportClss();
		pan.itemMain[67].worldx = 85 * pan.tilesize;
		pan.itemMain[67].worldy = 47 * pan.tilesize; //
		//000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
		
		pan.itemMain[68] = new StarCrystalItem();
		pan.itemMain[68].worldx = 6 * pan.tilesize;
		pan.itemMain[68].worldy = 17 * pan.tilesize;
		
		pan.itemMain[69] = new AmmoItem();
		pan.itemMain[69].worldx = 37 * pan.tilesize;
		pan.itemMain[69].worldy = 26 * pan.tilesize;
		
		pan.itemMain[70] = new StarCrystalItem();
		pan.itemMain[70].worldx = 19 * pan.tilesize;
		pan.itemMain[70].worldy = 26 * pan.tilesize;
		
		pan.itemMain[71] = new HealthUpgrade();
		pan.itemMain[71].worldx = 75 * pan.tilesize;
		pan.itemMain[71].worldy = 27 * pan.tilesize;
		
		pan.itemMain[72] = new HealthItem();
		pan.itemMain[72].worldx = 76 * pan.tilesize;
		pan.itemMain[72].worldy = 27 * pan.tilesize;
		
		pan.itemMain[73] = new AmmoItem();
		pan.itemMain[73].worldx = 57 * pan.tilesize;
		pan.itemMain[73].worldy = 18 * pan.tilesize;
		
		pan.itemMain[74] = new StarCrystalItem();
		pan.itemMain[74].worldx = 95 * pan.tilesize;
		pan.itemMain[74].worldy = 12 * pan.tilesize;
		
		pan.itemMain[75] = new StarCrystalItem();
		pan.itemMain[75].worldx = 57 * pan.tilesize;
		pan.itemMain[75].worldy = 40 * pan.tilesize;
		
		pan.itemMain[76] = new StarCrystalItem();
		pan.itemMain[76].worldx = 8 * pan.tilesize;
		pan.itemMain[76].worldy = 36 * pan.tilesize;
		
		pan.itemMain[77] = new StarCrystalItem();
		pan.itemMain[77].worldx = 4 * pan.tilesize;
		pan.itemMain[77].worldy = 41 * pan.tilesize;
		
		pan.itemMain[78] = new HealthItem();
		pan.itemMain[78].worldx = 3 * pan.tilesize;
		pan.itemMain[78].worldy = 41 * pan.tilesize;
		
		pan.itemMain[79] = new AmmoItem();
		pan.itemMain[79].worldx = 2 * pan.tilesize;
		pan.itemMain[79].worldy = 41 * pan.tilesize;
		
		pan.itemMain[80] = new StarCrystalItem();
		pan.itemMain[80].worldx = 6 * pan.tilesize;
		pan.itemMain[80].worldy = 52 * pan.tilesize;
		
		pan.itemMain[81] = new AmmoItem();
		pan.itemMain[81].worldx = 11 * pan.tilesize;
		pan.itemMain[81].worldy = 56 * pan.tilesize;
		
		pan.itemMain[82] = new AmmoItem();
		pan.itemMain[82].worldx = 10 * pan.tilesize;
		pan.itemMain[82].worldy = 56 * pan.tilesize;
		
		pan.itemMain[83] = new TeleportClss();
		pan.itemMain[83].worldx = 16 * pan.tilesize;
		pan.itemMain[83].worldy = 4 * pan.tilesize; //
	}
	
	
	public void PlaceNPC()
	{
		pan.npc[0] = new AlienScript(pan);
		pan.npc[0].worldX = 16 * pan.tilesize;
		pan.npc[0].worldY = 18 * pan.tilesize;
		
		pan.npc[1] = new AlienScript(pan);
		pan.npc[1].worldX = 40 * pan.tilesize;
		pan.npc[1].worldY = 18 * pan.tilesize;
		
		pan.npc[2] = new AlienScript(pan);
		pan.npc[2].worldX = 19 * pan.tilesize;
		pan.npc[2].worldY = 26 * pan.tilesize;
		
		pan.npc[3] = new AlienScript(pan);
		pan.npc[3].worldX = 18 * pan.tilesize;
		pan.npc[3].worldY = 26 * pan.tilesize;
		
		pan.npc[4] = new AlienScript(pan);
		pan.npc[4].worldX = 91 * pan.tilesize;
		pan.npc[4].worldY = 17 * pan.tilesize;
		
		pan.npc[5] = new AlienScript(pan);
		pan.npc[5].worldX = 90 * pan.tilesize;
		pan.npc[5].worldY = 17 * pan.tilesize;
		
		pan.npc[6] = new AlienScript(pan);
		pan.npc[6].worldX = 90 * pan.tilesize;
		pan.npc[6].worldY = 17 * pan.tilesize;
		
		pan.npc[7] = new AlienScript(pan);
		pan.npc[7].worldX = 90 * pan.tilesize;
		pan.npc[7].worldY = 27 * pan.tilesize;
		
		pan.npc[8] = new AlienScript(pan);
		pan.npc[8].worldX = 55 * pan.tilesize;
		pan.npc[8].worldY = 27 * pan.tilesize;
		
		pan.npc[9] = new AlienScript(pan);
		pan.npc[9].worldX = 59 * pan.tilesize;
		pan.npc[9].worldY = 27 * pan.tilesize;
		
		pan.npc[10] = new AlienScript(pan);
		pan.npc[10].worldX = 60 * pan.tilesize;
		pan.npc[10].worldY = 27 * pan.tilesize;
		
		pan.npc[11] = new AlienScript(pan);
		pan.npc[11].worldX = 24 * pan.tilesize;
		pan.npc[11].worldY = 41 * pan.tilesize;
		
		pan.npc[12] = new AlienScript(pan);
		pan.npc[12].worldX = 25 * pan.tilesize;
		pan.npc[12].worldY = 41 * pan.tilesize;
		
		pan.npc[13] = new AlienScript(pan);
		pan.npc[13].worldX = 39 * pan.tilesize;
		pan.npc[13].worldY = 41 * pan.tilesize;
		
		pan.npc[14] = new AlienScript(pan);
		pan.npc[14].worldX = 36 * pan.tilesize;
		pan.npc[14].worldY = 41 * pan.tilesize;
		
		pan.npc[15] = new AlienScript(pan);
		pan.npc[15].worldX = 30 * pan.tilesize;
		pan.npc[15].worldY = 41 * pan.tilesize;
		
		pan.npc[16] = new AlienScript(pan);
		pan.npc[16].worldX = 69 * pan.tilesize;
		pan.npc[16].worldY = 18 * pan.tilesize;
		
		pan.npc[17] = new AngelScript(pan);
		pan.npc[17].worldX = 24 * pan.tilesize;
		pan.npc[17].worldY = 47 * pan.tilesize;
		
		pan.npc[18] = new AngelScript(pan);
		pan.npc[18].worldX = 25 * pan.tilesize;
		pan.npc[18].worldY = 47 * pan.tilesize;
		
		pan.npc[19] = new AngelScript(pan);
		pan.npc[19].worldX = 31 * pan.tilesize;
		pan.npc[19].worldY = 47 * pan.tilesize;
		
		pan.npc[20] = new AngelScript(pan);
		pan.npc[20].worldX = 7 * pan.tilesize;
		pan.npc[20].worldY = 47 * pan.tilesize;
		
		pan.npc[21] = new AngelScript(pan);
		pan.npc[21].worldX = 10 * pan.tilesize;
		pan.npc[21].worldY = 47 * pan.tilesize;
		
		pan.npc[22] = new AngelScript(pan);
		pan.npc[22].worldX = 14 * pan.tilesize;
		pan.npc[22].worldY = 47 * pan.tilesize;
		
		pan.npc[23] = new AngelScript(pan);
		pan.npc[23].worldX = 25 * pan.tilesize;
		pan.npc[23].worldY = 54 * pan.tilesize;
		
		pan.npc[24] = new AngelScript(pan);
		pan.npc[24].worldX = 68 * pan.tilesize;
		pan.npc[24].worldY = 56 * pan.tilesize;
		
		pan.npc[25] = new AngelScript(pan);
		pan.npc[25].worldX = 70 * pan.tilesize;
		pan.npc[25].worldY = 56 * pan.tilesize;
		
		pan.npc[26] = new AngelScript(pan);
		pan.npc[26].worldX = 75 * pan.tilesize;
		pan.npc[26].worldY = 56 * pan.tilesize;
		
		pan.npc[27] = new AngelScript(pan);
		pan.npc[27].worldX = 58 * pan.tilesize;
		pan.npc[27].worldY = 56 * pan.tilesize;
		
		pan.npc[28] = new AngelScript(pan);
		pan.npc[28].worldX = 60 * pan.tilesize;
		pan.npc[28].worldY = 56 * pan.tilesize;
		
		pan.npc[29] = new AngelScript(pan);
		pan.npc[29].worldX = 68 * pan.tilesize;
		pan.npc[29].worldY = 50 * pan.tilesize;
		
		pan.npc[29] = new AngelScript(pan);
		pan.npc[29].worldX = 68 * pan.tilesize;
		pan.npc[29].worldY = 50 * pan.tilesize;
		
		pan.npc[30] = new AngelScript(pan);
		pan.npc[30].worldX = 70 * pan.tilesize;
		pan.npc[30].worldY = 50 * pan.tilesize;
		
		pan.npc[31] = new AngelScript(pan);
		pan.npc[31].worldX = 66 * pan.tilesize;
		pan.npc[31].worldY = 50 * pan.tilesize;
		
		pan.npc[32] = new AngelScript(pan);
		pan.npc[32].worldX = 69 * pan.tilesize;
		pan.npc[32].worldY = 50 * pan.tilesize;
//		pan.npc[2] = new AngelScript(pan);
//		pan.npc[2].worldX = 8 * pan.tilesize;
//		pan.npc[2].worldY = 19 * pan.tilesize;

	}
	
}
