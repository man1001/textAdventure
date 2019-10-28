import java.lang.ProcessBuilder.Redirect;
import java.net.ResponseCache;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Fight {
	Enemy e = new Enemy();
	Stats s;
	int damage;
	Scanner scan = new Scanner(System.in);
	boolean abbruchFight = false;
	boolean besiegt = false;
	boolean fokussiert = false;
	Random random = new Random();
	
	public Fight(Enemy e, Stats spieler){
		this.e = e;
		this.s = spieler;
	}
	
	public void fight(){
		if(besiegt == false){
			System.out.println(e.getEnemyText());
		
		while(e.getFightingWert("lp")>0 && s.getFightingWert("lp")>0 && abbruchFight == false){
	 		
	 		try {
				TimeUnit.MILLISECONDS.sleep(250);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
	 		if(abbruchFight == true){
	 			break;
	 		}
	 		
			if(e.getFightingWert("init") > s.getFightingWert("init")){
				
				if(e.getFightingWert("lp")>0 && s.getFightingWert("lp")>0){
				enemyAttack();
				}
				
				if(e.getFightingWert("lp")>0 && s.getFightingWert("lp")>0){
					spielerAttack();
					}
				
			}else{
				
				if(e.getFightingWert("lp")>0 && s.getFightingWert("lp")>0){
					spielerAttack();
					}
					
				if(e.getFightingWert("lp")>0 && s.getFightingWert("lp")>0){
					enemyAttack();
					}
				
			}

	
		}
		
		if(e.getFightingWert("lp")<=0){
	 		
	 		try {
				TimeUnit.MILLISECONDS.sleep(250);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
	 		
			System.out.println("\n**********************************\n*\t Du hast gewonnen!\t *\n*\t\t\t\t *\n**********************************\n");
			s.setEXP(e.getEnemyEXP());
			System.out.println("Du erhälts " + e.getEnemyEXP() + " exp!" + "-----> du hast jetzt "+ s.getSpielerEXP()+ " exp!");	
			s.restoreLifePoints();
			e.setBesiegt();
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			s.lvUP();
			int lootRate=random.nextInt(100);
			int lootRatePotion= random.nextInt(100);
			if(lootRate<=20){
				System.out.println("Du findest einen magischen Trank");
				s.lootTrank();
			}
			if(lootRatePotion<=10){
				System.out.println("Du findest einen Heiltrank");
				s.lootPotion();
			}
			
			besiegt = true;
		}else if(s.getFightingWert("lp")<=0){
	 		
	 		try {
				TimeUnit.MILLISECONDS.sleep(250);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
	 		
			System.out.println("\n\n\nGame Over!!! \n\n"+ s.getName()+ " stay determined!");
			System.exit(0);
			
		} else if(abbruchFight == true){
			System.out.println("Du bist entkommen! \n");
			abbruchFight = false;
			besiegt = false;
		}
	}
}	
	public void getEnemyAndSData(){
		e.getEnemySpecs();
		s.getSpielerSpecs();
	}
	
	public boolean getBesiegt(){
		return besiegt;
	}
	
	public void setBesiegt(){
		besiegt = true;
	}
	
	public boolean getFightBoss(){
		return e.isBoss();
	}
	
	public void enemyAttack(){
		int pOrM = random.nextInt(100);
		if(e.getFightingWert("specAngr")>e.getFightingWert("atk") && pOrM <= 70){
			damage = e.getFightingWert("specAngr") - s.getFightingWert("specDef");
			if(damage <=1){
				damage = 1;				
			}
			System.out.println("Dein Gegner greift dich mit Magie an! \n Du bekommst " + damage + " Schaden!");
			s.setLifePoints(-damage);
			s.SysOutLifePoints();
		}else{
		damage =  e.getFightingWert("atk") -  s.getFightingWert("def");		
		if(damage <=1){
			damage = 1;
		}
		System.out.println("Dein Gegner greift an! \n Du bekommst " + damage + " Schaden!");
		s.setLifePoints(-damage);
		s.SysOutLifePoints();
		}
	}
	
	public void spielerAttack(){
		String input;
		int kritWert = random.nextInt(100);
		System.out.println("Was möchtest du tun? [Angriff/Magie/Scan/Flucht] [HP-Trank = Heiltrank verwenden / MP-Trank = magischen Trank verwende]");
		 input = scan.next();
		 
		 if(input.equalsIgnoreCase("adminKill")){
				System.out.println("Nein Tim, das funktioniert nicht mehr!");
				} 
		 
		 if(input.equalsIgnoreCase("scan")){
				if(e.getBossStatus()==true){
					e.getBossSpecs();
				}
				if(e.getBossStatus()==false){
					e.getEnemySpecs();
				}
				
		} 
		 
		 if(input.equalsIgnoreCase("ak")){
				e.setLifePoints(-(e.getFightingWert("lp")));
				} 
		
		if(input.equalsIgnoreCase("angriff") || input.equalsIgnoreCase("a")){
			if(fokussiert==true){
				kritWert=s.getFightingWert("krit");
			}
			if(kritWert <= s.getFightingWert("krit")){
				damage = (s.getFightingWert("atk")*3)-e.getFightingWert("def");
				System.out.println("Du fügst deinem Gegner einen kritschen Treffer zu!");
				fokussiert=false;
			}else{
			damage =  s.getFightingWert("atk") -  e.getFightingWert("def");	
			}
			
			if(damage <=1){
			damage = 1;
			}
			
			System.out.println("Du fügst "+ e.getName()+" " +  damage + " Schaden zu!\n");
			e.setLifePoints(-damage);
			e.SysOutLifePoints();					
		}
		
		if(input.equalsIgnoreCase("magie") || input.equalsIgnoreCase("m")){
			if(fokussiert==true){
				kritWert=s.getFightingWert("krit");
			}
			if(s.getFightingWert("ap")>0){
				System.out.println("Welchen Zauber möchtest du verwenden? (Anfangsbuchstabe genuegt!)\n [regenerate = Stellt 50 Lebenspunkte wieder her (Kosten 4 AP)]\n[Inferno = Fügt dem Gegener Feuerschaden zu (Kosten 5 AP)]\n[Blizzard = Fügt dem Gegener Frostschaden zu (Kosten 5 AP)]\n[Donnerschock = Fügt dem Gegener Blitzschaden zu (Kosten 5 AP)]\n[power = Garantiert einen kritischen Treffer in der nächsten Runde (Kosten = 20 AP)");
				String spell = scan.next();
				if( spell.equalsIgnoreCase("regenerate") || spell.equalsIgnoreCase("r")){
					if(s.getFightingWert("ap")>=4){
						s.heal(s.getFightingWert("lp")/20);
						s.reduceAP(4);
					}else{
						System.out.println("Du hast nicht genug AP");
					}
					
				}
				//Feuerball
				if(spell.equalsIgnoreCase("Inferno") || spell.equalsIgnoreCase("i")){
					if(s.getFightingWert("ap")>=5){
						s.reduceAP(5);
					if(kritWert <= s.getFightingWert("krit")){
						damage = (s.getFightingWert("specAngr")*3)-e.getFightingWert("fireDef");
						System.out.println("Du fügst deinem Gegner einen kritschen feurigen magischen Treffer zu!\n");
						fokussiert=false;
					}else{
						damage =  s.getFightingWert("specAngr") - ( e.getFightingWert("fireDef") + random.nextInt(10));
					}
					if(damage <=1){
						damage = 1;
					}
					System.out.println("Du fügst "+ e.getName()+" " +  damage + " Feuer-Magie-Schaden zu!");
					e.setLifePoints(-damage);
					e.SysOutLifePoints();				
					}else{
						System.out.println("Du hast keine AP mehr!\n\n");
					}
				}
				//Eismagie
				if(spell.equalsIgnoreCase("Blizzard") || spell.equalsIgnoreCase("b")){
					if(s.getFightingWert("ap")>=5){
						s.reduceAP(5);
					if(kritWert <= s.getFightingWert("krit")){
						damage = (s.getFightingWert("specAngr")*3)-e.getFightingWert("iceDef");
						System.out.println("Du fügst deinem Gegner einen kritschen frostigen magischen Treffer zu!\n");
						fokussiert=false;
					}else{
						damage =  s.getFightingWert("specAngr") -  (e.getFightingWert("iceDef") + random.nextInt(10));
					}
					if(damage <=1){
						damage = 1;
					}
					System.out.println("Du fügst "+ e.getName()+" " +  damage + " Eis-Magie-Schaden zu!");
					e.setLifePoints(-damage);
					e.SysOutLifePoints();				
					}else{
						System.out.println("Du hast keine AP mehr!\n\n");
					}
				}
				//Donnerschock
				if(spell.equalsIgnoreCase("Donnerschock") || spell.equalsIgnoreCase("d")){
					if(s.getFightingWert("ap")>=5){
						s.reduceAP(5);
					if(kritWert <= s.getFightingWert("krit")){
						damage = (s.getFightingWert("specAngr")*3)-e.getFightingWert("thunderDef");
						System.out.println("Du fügst deinem Gegner einen kritschen elekrischen magischen Treffer zu!\n");
						fokussiert=false;
					}else{
						damage =  s.getFightingWert("specAngr") -  (e.getFightingWert("thunderDef") + random.nextInt(10));
					}
					if(damage <=1){
						damage = 1;
					}
					System.out.println("Du fügst "+ e.getName()+" " +  damage + " Blitz-Magie-Schaden zu!");
					e.setLifePoints(-damage);
					e.SysOutLifePoints();				
					}else{
						System.out.println("Du hast keine AP mehr!\n\n");
					}
				
				}
				//Energie-Fokus
				if(spell.equalsIgnoreCase("power") || spell.equalsIgnoreCase("p")){
					if(s.getFightingWert("ap")>=20){
						s.reduceAP(20);
						if(kritWert <= 90){
							fokussiert=true;
							System.out.println("Du fokussierst dich für den nächsten Angriff!\n");
						}

					}else{
						System.out.println("Du hast keine AP mehr!\n\n");			
					}	
			}
		
		}	else{
			System.out.println("Du hast keine AP mehr!\n\n");
		}
		}
		if(input.equalsIgnoreCase("Flucht") || input.equalsIgnoreCase("f")){ 

			int r = random.nextInt(100);
			if(r<50){
			abbruchFight = true;
			}else{
				System.out.println("Das hat wohl nicht geklappt! \n Du stolperst und musst weiterkämpfen...\n");
			}
		
		}
		
		if(input.equalsIgnoreCase("hp-trank") || input.equalsIgnoreCase("hp")){
			if(s.getPotion()>0){
				s.heal();
			}else{
				System.out.println("Du hast keine Heiltränke mehr!");
			}
		}
		
		if(input.equalsIgnoreCase("mp-trank") || input.equalsIgnoreCase("mp")){
			if(s.getTraenke()>0){
				s.restoreAP();
			}else{
				System.out.println("Du hast keine magischen Tränke mehr!");
			}
		}
	}	
}

