
public class ItemList {

	Items il [] = new Items[11];
	
	public ItemList(){
		il[0] = new Items("Master Schwert", 50, 50, 15, 25, 50, 20, "Ein Uraltes und echt ziemlich cooles Schwert!\n In der alten Welt wurde es zur Bekaempfung des boesen verwendet.");
		il[1] = new Items("Zerbrochenes Schwert", 4, 0, 1, 1, 1, 0, "Ein wirklich absolut nutzloses Schwert, welches eigentlich nur Ballast ist...");
		il[2] = new Items("Lanze", 10, 0, 10, 2, 10, 2, "Eine einfache Lanze...");
		il[3] = new Items("Stahl Schwert", 12, 5, 10, 4, 12, 10, "Ein aus Stahl gefertigtes Schwert, perfekt fuer neue Abenteurer!");
		il[4] = new Items("Silber Schwert", 20, 0, 14, 15, 16, 11, "Ein extrem scharfes und gut ausbalanciertes Schwert...");
		il[5] = new Items("Krieger-Schwert", 22, 10, 22, 22, 22, 22, "Dieses Schwert ist so gut das du dich fuehlst als ob du zweimal angreifen koenntest!\n Kannst du aber nicht wirklich...");
		il[6] = new Items("Einfaches Schild", 0, 0, 5, 5, 2, 3, "Ein aus Holz geschnitztes Schild,\n wirkt ziemlich zerbrechlich!");
		il[7] = new Items("Stahl Schild", 5, 3, 10, 9, 9, 4, "Ein Schild mit hohem Verteidigungs-Wert.");
		il[8] = new Items("Stahl Ruestung", 5, 6, 18, 15, 3, 2, "Eine einfache Stahl Ruestung, schwierig sich darin zu bewegen...");
		il[9] = new Items("Schwarz-Stahl Ruestung", 6, 8, 20, 22, 4, 7, "Eine aus mysterioesen schwarzen Material gefertigte Ruestung, \n der normalen Stahl-Ruestung in allen Punkten ueberlegen");
		il[10] = new Items("EVA 01", 100, 100, 50, 150, 30, 30, "Ein gigantischer Mecha-Roboter, welcher urspruenglich zum bekaempfen von Engeln erschaffen wurde\n#GetInTheFu*ingRobotShinji");
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
	
	public void getItemListeImBesitz(){
		for(int i = 0; i< il.length; i++){
			if(il[i].getBesitzStatus()==true){
				System.out.println(il[i].getItemName()+" Item Nr:"+i);
			}
		}
		
	}
	
	public void getItemStats(int i){
		System.out.println("\nAngriff:\t\t"+il[i].getItemStats("angr"));
		System.out.println("Abwehr:\t\t\t"+il[i].getItemStats("def"));
		System.out.println("Spezialangriff:\t\t"+il[i].getItemStats("specAngr"));
		System.out.println("Spezialabwehr:\t\t"+il[i].getItemStats("specDef"));
		System.out.println("Initiative:\t\t"+il[i].getItemStats("init"));
		System.out.println("Kritische Treffer:\t"+il[i].getItemStats("krit"));
	}
	
}
