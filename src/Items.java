
public class Items {
	String name;
	String itemBesch;
	int angr;
	int def;
	int specAngr;
	int specDef;
	int init;
	int krit;
	
	// auf true wenn Item im besitz ist
	boolean besitz = false;
	
	
	public Items(String itemName, int angriff, int specAngriff, int defense, int specDefense, int initiative, int kritWert, String itemBeschreibung){
	this.name = itemName;
	this.specAngr = specAngriff;
	this.itemBesch = itemBeschreibung;
	this.angr = angriff;
	this.def = defense;
	this.specDef = specDefense;
	this.init = initiative;
	this.krit = kritWert;
	}
	
	public boolean getBesitzStatus(){
		return besitz;
	}
	
	public void getItem(){
		besitz = true;
	}
	
	public void removeItem(){
		besitz = false;
	}
	
	public String getItemName(){
		return name;
	}
	
	public String getItemBeschreibung(){
		return itemBesch;
	}
	
	public int getItemStats(String n){
		
		if(n.equalsIgnoreCase("angr")){
			return angr;
		}
		
		if(n.equalsIgnoreCase("def")){
			return def;
		}
		
		if(n.equalsIgnoreCase("specDef")){
			return specDef;
		}
		
		if(n.equalsIgnoreCase("specAngr")){
			return specAngr;
		}
		
		if(n.equalsIgnoreCase("init")){
			return init;
		}
		
		if(n.equalsIgnoreCase("krit")){
			return krit;
		}
		
		return 0;
	}
}
