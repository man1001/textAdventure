import java.nio.file.WatchEvent.Kind;
import java.util.Random;
import java.util.concurrent.TimeUnit;

 public class Stats {
	String name;
	static int potion=3;
	static int traenke = 3;
	int lpMax = 250;
	int lp = lpMax;
	int actionPoints =50;
	int apMax = actionPoints;
	int level = 1;
	int exp = 0;
	
	int angr =25;
	int def =15;
	int specAngr= 35;
	int specDef=25;
	int init=15;
	int krit =12;
	int KritMax = 100;
	String trenner = "##########################################Level-UP##########################################";
	String trenner2 ="############################################################################################";
	
	
	Random random = new Random();
	ItemList spielerItems = new ItemList();
	boolean itemInsert = false;
	int usedItem;
	
	public Stats(){
		name = "defaultHero";
	}
	
	public Stats(String n){
		this.name = n;
	}
	
	public void setEXP(int erfahrung){
		exp = exp + erfahrung;
	}
	
	public void lvUP(){
		int nextLvUp = (int) (100 * Math.pow(2, ((double)level-2)));
		
			while(exp > nextLvUp){
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
			System.out.println(trenner);	
			level++;
			System.out.println("your exp: " + exp);
			nextLvUp = (int) (100 * Math.pow(2, ((double)level-2)));
			if((nextLvUp-exp)<0){
				System.out.println("benötigte exp für nächsten LevelUP: 0");
			}else{
			System.out.println("benötigte exp für nächsten LevelUP: " + (nextLvUp-exp));
			}
			
			System.out.println("New Level: " + level);
			int lpR = random.nextInt(30);
			int apR = random.nextInt(30);
			int aR = random.nextInt(15);
			int dR = random.nextInt(15);
			int saR = random.nextInt(15);
			int sdR = random.nextInt(15);
			int iR = random.nextInt(25);
			int kritR = random.nextInt(5);
			lpMax = lpMax +10 + lpR;
			apMax = apMax +10 +apR;
			angr = angr+ aR;
			def = def+ dR;
			specAngr= specAngr+ saR;
			specDef= specDef+ sdR;
			init = init + iR;
			krit = krit + kritR;
			System.out.println(
					"Lebenspunkte "+ "\t\t" +lpMax + "\t /+"+ (lpR +10) + "\n"+
					"Aktionspunkte "+ "\t\t" +apMax + "\t /+"+ (apR +10) + "\n"+
					"Level "+ "\t\t\t" +level + "\t /+1" +"\n"+
					"Angriff "+ "\t\t" +angr + "\t /+"+ aR +"\n"+
					"Abwehr "+ "\t\t\t" +def + "\t /+"+ dR +"\n"+
					"Magie "+ "\t\t\t" +specAngr + "\t /+"+ saR +"\n"+
					"Magieresistenz "+ "\t\t" +specDef + "\t /+"+ sdR +"\n"+
					"Initiative " + "\t\t" +init + "\t /+" + iR + "\n"+
					"Glück \t\t\t" +krit + "\t /+" + kritR
					);	

			}
	}
	
	public void getSpielerSpecs(){
		if(itemInsert == false){
			System.out.println(trenner2);
			System.out.println(
					"Statuswerte " + name + ":\n"+		
			"Level "+ "\t\t\t" +level + "\n"+		
			"Lebenspunkte "+ "\t\t"+lp+ " / "+lpMax + "\n"+
			"Aktionspunkte "+ "\t\t" + actionPoints +" / "+ apMax+ "\n"+
			"Angriff "+ "\t\t" +angr + "\n"+
			"Abwehr "+ "\t\t\t" +def + "\n"+
			"Spezial Angriff "+ "\t" +specAngr + "\n"+
			"Spezial Verteidigung "+ "\t" +specDef + "\n"+
			"Initiative " + "\t\t" + init + "\n"+
			"Glück " + "\t\t\t" +krit + "\n\n\n"+
			"Heiltränke \t\t"+potion+
			"\nMagische Tränke \t"+ traenke+"\n"
			);
		
		}else{
			System.out.println(trenner2);
			
			System.out.println(
					"Statuswerte " + name + ":\n"+		
			"Level "+ "\t\t\t" +level + "\n"+		
			"Lebenspunkte "+ "\t\t"+lp+ " / "+lpMax + "\n"+
			"Aktionspunkte "+ "\t\t" + actionPoints +" / "+ apMax+ "\n"+
			"Angriff "+ "\t\t" +angr + " (+"+spielerItems.getItemListStats(usedItem, "angr")+")"+"\n"+
			"Abwehr "+ "\t\t\t" +def + " (+"+spielerItems.getItemListStats(usedItem, "def")+")"+ "\n"+
			"Spezial Angriff "+ "\t" +specAngr + " (+"+spielerItems.getItemListStats(usedItem, "specAngr")+")"+ "\n"+
			"Spezial Verteidigung "+ "\t" +specDef + " (+"+spielerItems.getItemListStats(usedItem, "specDef")+")"+ "\n"+
			"Initiative " + "\t\t" + init + " (+"+spielerItems.getItemListStats(usedItem, "init")+")"+ "\n"+
			"Glück " + "\t\t\t" +krit + " (+"+spielerItems.getItemListStats(usedItem, "krit")+")"+ "\n\n\n"+
			"Heiltränke \t\t"+potion+
			"\nMagische Tränke \t"+ traenke+"\n"
			);
		}
	}
	
	public int getFightingWert(String s){
		if(s.equals("lp")){
			return lp;
		}
		if(s.equals("lpMax")){
			return lpMax;
		}
		
		if(s.equals("ap")){
			return actionPoints;
		}
		if(s.equals("atk")){
			return angr;
		}
		if(s.equals("def")){
			return def;
		}
		if(s.equals("specAngr")){
			return specAngr;
		}
		if(s.equals("specDef")){
			return specDef;
		}
		if(s.equals("init")){
			return init;
		}
		if(s.equals("krit")){
			return krit;
		}
		if(s.equals("apMax")){
			return apMax;
		}
		if(s.equals("kritMax")){
			return KritMax;
		}
		
		return 0;
	}
	
	public void setLifePoints(int i){
		lp = lp + i;
	}
	
	public void SysOutLifePoints(){
		System.out.println("Lebenspunkte (Spieler): "+lp);
	}
	public int getSpielerEXP(){
		return exp;
	}
	public String getName(){
		return name;
	}
	
	public void restoreLifePoints(){
		lp=lpMax;
	}
	
	public void restoreAP(){
		actionPoints = apMax;
		traenke--;
		System.out.println("Deine AP wurden wiederhergestellt!\nDu hast jetzt "+ getFightingWert("ap")+" AP\nDu hast noch "+traenke+" Magische Tränk(e)\n");
	}
	
	public void setName(String n){
		name = n;
	}
	public void heal(){
		restoreLifePoints();
		potion--;
		System.out.println("Deine Lebenspunkte wurden wiederhergestellt!\nDu hast jetzt "+ getFightingWert("lp")+" Lebenspunkte\nDu hast noch "+potion+" Heiltränk(e)\n");
	}
	
	public void heal(int i){
		if(lp+i<lpMax){
			lp=lp+i;
			System.out.println("Du regenerierst "+ i +" Lebenspunkte!\n"+ "Du hast jetzt "+lp+ " Lebenspunkte");
		}
		else if(lp+i>=lpMax){
				lp=lpMax;
				System.out.println("Du bist vollständig geheilt!\n Du hast jetzt "+ lp+ " Lebenspunkte");
		}
	}
	public int getPotion(){
		return potion;
	}
	
	public int getTraenke(){
		return traenke;
	}
	
	public void reduceAP(int i){
		actionPoints= actionPoints-i;
		System.out.println("Du hast noch " + getFightingWert("ap")+" von "+ getFightingWert("apMax")+ " AP\n");

	}
	public void lootTrank(){
		traenke++;
	}
	public void lootPotion(){
		potion++;
	}
	
//angr def specDef specAngr init krit
	
	public void buffStatsWithItem(Items item){
		if(itemInsert == false){
			angr = angr+ item.getItemStats("angr");
			specAngr = specAngr+ item.getItemStats("specAngr");
			def = def+ item.getItemStats("def");
			specDef = specDef+ item.getItemStats("specDef");
			init = init+ item.getItemStats("init");
			krit = krit+ item.getItemStats("krit");
			System.out.println("Du verwendest jetzt: "+ item.getItemName()+"\n");
			itemInsert = true;
		}else{
			System.out.println("Item bereits in Verwendung!\n");			
		}
	}
	public void nerfStatsWithItem(Items item){
		angr = angr- item.getItemStats("angr");
		specAngr = specAngr- item.getItemStats("specAngr");
		def = def- item.getItemStats("def");
		specDef = specDef- item.getItemStats("specDef");
		init = init- item.getItemStats("init");
		krit = krit- item.getItemStats("krit");

		itemInsert = false;
	}
	
	public void setUsedItem(int i){
		usedItem = i;
	}
	

 }
