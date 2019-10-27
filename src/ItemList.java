
public class ItemList {

	Items il [] = new Items[11];
	
	public ItemList(){
		il[0] = new Items("Master Schwert", 50, 50, 15, 25, 50, 20, "Ein Uraltes und echt ziemlich cooles Schwert!\n In der alten Welt wurde es zur Bekämpfung des bösen verwendet.");
		il[1] = new Items("Zerbrochenes Schwert", 4, 0, 1, 1, 1, 0, "Ein wirklich absolut nutzloses Schwert, welches eigentlich nur Ballast ist...");
		il[2] = new Items("Lanze", 10, 0, 10, 2, 10, 2, "Eine einfache Lanze...");
		il[3] = new Items("Stahl Schwert", 12, 5, 10, 4, 12, 10, "Ein aus Stahl gefertigtes Schwert, perfekt für neue Abenteurer!");
		il[4] = new Items("Silber Schwert", 20, 0, 14, 15, 16, 11, "Ein extrem scharfes und gut ausbalanciertes Schwert...");
		il[5] = new Items("Krieger-Schwert", 22, 10, 22, 22, 22, 22, "Dieses Schwert ist so gut das du dich fühlst als ob du zweimal angreifen könntest!\n Kannst du aber nicht wirklich...");
		il[6] = new Items("Einfaches Schild", 0, 0, 5, 5, 2, 3, "Ein aus Holz geschnitztes Schild,\n wirkt ziemlich zerbrechlich!");
		il[7] = new Items("Stahl Schild", 5, 3, 10, 9, 9, 4, "Ein Schild mit hohem Verteidigungs-Wert.");
		il[8] = new Items("Stahl Rüstung", 5, 6, 18, 15, 3, 2, "Eine einfache Stahl Rüstung, schwierig sich darin zu bewegen...");
		il[9] = new Items("Schwarz-Stahl Rüstung", 6, 8, 20, 22, 4, 7, "Eine aus mysteriösen schwarzen Material gefertigte Rüstung, \n der normalen Stahl-Rüstung in allen Punkten überlegen");
		il[10] = new Items("EVA 01", 100, 100, 50, 150, 30, 30, "Ein gigantischer Mecha-Roboter, welcher ursprünglich zum bekämpfen von Engeln verwendet wurde\n #GetInTheFu*ingRobotShinji");
	}
	
	
	public void ItemListErhalteItem(int i){
		il[i].getItem();
	}
	
	public String getItemListeName(int i){
		return il[i].getItemName();
	}
	
	public boolean getItemBesitz(int itemNr){
		if(itemNr < il.length) {
		return il[itemNr].getBesitzStatus();	
		}
		return false;
	}
	
	public int getItemListStats(int itemNr, String stat){
		return il[itemNr].getItemStats(stat);
	}
	
	public String getItemListBeschreibung(int itemNr){
		return il[itemNr].getItemBeschreibung();
	}
	
	public Items getItem(int i){
		return il[i];
	}
	
}
