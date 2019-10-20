
public class Enemy {
	
	String name = "defaultEnemy";
	String enemyText="defaultEnemyText";
	int lp =10;
	int lpMax = lp;
	int actionPoints = 10;
	int level = 1;
	int exp = 100;
	boolean besiegt = false;	
	int angr =5;
	int def= 1;
	int specAngr =1;
	int fireDef=1;
	int iceDef = 10;
	int thunderDef = 10;
	int specDef =10;
	int init =1;
	String trenner = "################################################################################################";
	boolean isABoss = false;
	public Enemy(){
		
	}

	public Enemy(String name,String enemyText,int lebenspunkte, int ap, int lv, int exp, int attack, int defense, int sAngr, int sDef, int initiative) {		
	this.name = name;
	this.enemyText = enemyText;
	lp = lebenspunkte;
	actionPoints = ap;
	level = lv;
	this.exp = exp;
	angr = attack;
	def = defense;
	specAngr = sAngr;
	specDef = sDef;
	init = initiative;
	}
	
	public Enemy(String name,String enemyText,int lebenspunkte, int ap, int lv, int exp, int attack, int defense, int sAngr, int sDef, int initiative, int fd, int id, int td) {		
	this.name = name;
	this.enemyText = enemyText;
	lp = lebenspunkte;
	actionPoints = ap;
	level = lv;
	this.exp = exp;
	angr = attack;
	def = defense;
	specAngr = sAngr;
	specDef = sDef;
	init = initiative;
	fireDef = fd;
	iceDef = id;
	thunderDef = td;
	}
	
	public Enemy(String name,String enemyText,int lebenspunkte, int ap, int lv, int exp, int attack, int defense, int sAngr, int sDef, int initiative, boolean b, int fd, int id, int td) {		
	this.name = name;
	this.enemyText = enemyText;
	lp = lebenspunkte;
	actionPoints = ap;
	level = lv;
	this.exp = exp;
	angr = attack;
	def = defense;
	specAngr = sAngr;
	specDef = sDef;
	init = initiative;
	isABoss = b;
	fireDef = fd;
	iceDef = id;
	thunderDef = td;
	}
	
	public int getEnemyEXP(){
		return exp;
	}
	public boolean isBoss(){
		return isABoss;
	}
	
	
	public void getEnemySpecs(){
			System.out.println(trenner);
			System.out.println("Name "+ "\t\t\t" +name  + "\n" +
			"Lebenspunkte "+ "\t\t" +lp + "\n"+
			"Level "+ "\t\t\t" +level + "\n"+
			"Angriff "+ "\t\t" +angr + "\n"+
			"Abwehr "+ "\t\t\t" +def + "\n"+
			"Spezial Angriff "+ "\t" +specAngr + "\n"+
			"Spezial Verteidigung "+ "\t" +specDef + "\n"+
			"Initiative " + "\t\t" +init
			);
	}
	
	
	public void getBossSpecs(){
		System.out.println(trenner);
		System.out.println("Name "+ "\t\t\t" +name  + "\n" +
		"Lebenspunkte "+ "\t\t" +"???" + "\n"+
		"Level "+ "\t\t\t" +level + "\n"+
		"Angriff "+ "\t\t" +"???" + "\n"+
		"Abwehr "+ "\t\t\t" +"???" + "\n"+
		"Spezial Angriff "+ "\t" +"???" + "\n"+
		"Spezial Verteidigung "+ "\t" +"???" + "\n"+
		"Initiative " + "\t\t" +"???"
		);
}
	
	
	
	public void getSchaden(int i){
		lp = lp - i;
	}
	public String getName(){
		return name;
	}
	
	public String getEnemyText(){
		return enemyText;
	}
	public int getFightingWert(String s){
		if(s.equals("lp")){
			return lp;
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
		
		if(s.equals("fireDef")){
			return fireDef;
		}
		if(s.equals("thunderDef")){
			return thunderDef;
		}
		if(s.equals("iceDef")){
			return iceDef;
		}
		
		
		return 0;
	}
	public void setLifePoints(int i){
		lp = lp + i;
	}
	
	public void respawnEnemy(){
		lp = lpMax;
		besiegt = false;
	}	
	public void changeElement(int fd, int id, int td){
		fireDef = fd;
		iceDef = id;
		thunderDef = td;
	}
	
	public void setBesiegt(){
		besiegt = true;
	}
	
	public boolean getStatus(){
		return besiegt;
	}
	
	public boolean getBossStatus(){
		return isABoss;
	}
	
	public void SysOutLifePoints(){
		if(lp>0){
		System.out.println("Lebenspunkte (Gegner): "+lp);
		}else if(lp<0){
			System.out.println("Lebenspunkte (Gegner): 0");
		}
	}
}
