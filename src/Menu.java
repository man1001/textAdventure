import java.util.OptionalInt;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Menu {
	

	String prompt;
	String m1 ="Durchsuchen";
	String m2 = "Bewegen";
	String m3 = "Kaempfen";
	Stats spieler;
	Locations l = new Locations();
	Karte karte = new Karte();
	Scanner scan = new Scanner(System.in);
	int x=3;
	int y=3;
	int z=0;
	
	int verwItem = -1;
	boolean itemFound = false;
	
	Image image = new Image();
	
	public Stats getStats(){
		return l.getSpieler();
	}
	
	public Menu(){
		l.setName(scan.nextLine());
		System.out.println("Du bist der Bewohner des abgelegenen Dorfes Praxx, in welchem es die Tradition \n gibt einen Juengling zu seinem 18 Geburtstag in die Welt hinaus zu schicken um das Boese zu bekaempfen! \n Durch diese abstruse Tradition herscht im Dorf nun ein massiver Mangel an Erwachsenen \n aber Tradition ist nun mal Tradition... \n Da heute dein 18. Geburtstag ist wirst ist nun deine Zeit fuer das groﬂe Abenteuer gekommen! \n");
	}
	
	public void menuStartLocation(){
		l.startLocation(x, y);

	}
	
	public void getMlocation(){
		l.getLocationName(x, y);
	}
	
	public int getVerwItem(){
		return verwItem;
	}


	public void getMenu(){
		System.out.println(prompt  + " \n Was moechtest du tun? \n" + m1 + "\n" + m2 + "\n" + m3 + "\n" );
	}
	
	public void bewegen(){
		System.out.println("In welche Richtung moechtest du gehen? [Norden/Sueden/Westen/Osten]\t[menu]");
		String s = scan.nextLine();
		s = s.trim();
		
		//Test Bilderanzeige...
		if(s.contains("bilder")){
			String [] imag = s.split(" ",0);
			for(int i=0; i<imag.length;i++){
				if(imag[i].equals("bowser")){
					System.out.println(image.bowser);
				}
				if(imag[i].equals("lich")){
					System.out.println(image.lich);
				}
				if(imag[i].equals("dragon")){
					System.out.println(image.dragon);
				}
				if(imag[i].equals("natas")){
					System.out.println(image.natas);
				}
				if(imag[i].equals("dracula")){
					System.out.println(image.dracula);
				}
				if(imag[i].equals("void")){
					System.out.println(image.voidWarrior);
				}
			}
		}
		
		//menu anzeigen
		if(s.equalsIgnoreCase("menu")){
			System.out.println("stats\t\t[Zeigt aktuelles Level und Statuswerte an]");
			System.out.println("mp-trank\t[Stellt Magie komplett wieder her]");
			System.out.println("hp-trank\t[Stellt Lebenspunkte komplett wieder her]");
			System.out.println("map\t\t[Zeigt Karte mit der aktuellen Position]\nmap -b\t\t[Zeigt Standort der verbleibenden Boss-Gegner an]");
			System.out.println("suchen\t\t[Durchsucht die Umgebung nach Items]");
			System.out.println("item\t\t[Zeigt Liste der gefundenen Items]\nitem -a (Item Nummer)\t[Ruestet das gewuenschte Item aus, Itemnummer angeben]\nitem -b (Item Nummer)\t[Zeigt Item-Beschreibung an, Itemnummer angeben]");
			System.out.println("credits\t\t[Zeigt die Personen an welche an der Erschaffung dieser Videospiel-Perle beteiligt waren!]");
			System.out.println("hilfe\t\t[Zeigt ein recht unnuetzes Hilfe-Menue an]\n\n");
			
		}
		
		
		//item anzeigen aendern und ausruesten
		
		if(s.contains("item")){
			String [] option = s.split(" ", 0);
			
			for(int i = 0; i< option.length; i++){
				    
					if (option[i].equalsIgnoreCase("-h")){
						System.out.println("Zeigt alle erhaltenen Items an\n item -(option) -(itemNr)\n item -h : hilfe\n item -a (itemNr) : Item ausruesten\n item -b (itemNr) : Itembeschreibung anzeigen");				
					}
					
					if(option[i].equalsIgnoreCase("-b")){
						if(option.length == 3){
							// Test ob Item im besitz ist
							try {
								if(l.getSpieler().spielerItems.getItemBesitz(Integer.parseInt(option[i+1]))==true){
									System.out.println("\n");
									System.out.println(l.getSpieler().spielerItems.getItemListeName(Integer.parseInt(option[i+1])));
									System.out.println(l.getSpieler().spielerItems.getItemListBeschreibung(Integer.parseInt(option[i+1])));
									l.getSpieler().spielerItems.getItemStats(Integer.parseInt(option[i+1]));
									System.out.println("\n");
									}else{
									System.out.println("Du besitzt dieses Item nicht!\n");
									}
								}
								catch(Exception e) {
								  System.out.println("[!] Absolut fehlerhafte Eingabe\n");
								}
							
							
												
						}else{
						System.out.println("[!]Falsche Eingabe\n");		
						}
					}
						
					
					
					if(option[i].equalsIgnoreCase("-a")){
						if(option.length == 3){
							// Test ob Item im besitz ist
							try {
								
								if(l.getSpieler().spielerItems.getItemBesitz(Integer.parseInt(option[i+1]))==true){
									if(verwItem == -1){
										l.getSpieler().buffStatsWithItem(l.getSpieler().spielerItems.getItem(Integer.parseInt(option[i+1])));	
										verwItem = Integer.parseInt(option[i+1]);
										l.getSpieler().setUsedItem(verwItem);
									}
									else if(verwItem == Integer.parseInt(option[i+1])){
										System.out.println("Du verwendest dieses Item bereits!\n");
									}else{
										l.getSpieler().nerfStatsWithItem(l.getSpieler().spielerItems.getItem(verwItem));	

										l.getSpieler().buffStatsWithItem(l.getSpieler().spielerItems.getItem(Integer.parseInt(option[i+1])));	
										System.out.println("Du hast "+l.getSpieler().spielerItems.getItemListeName(verwItem)+ " gegen "+ l.getSpieler().spielerItems.getItemListeName(Integer.parseInt(option[i+1]))+" ausgetauscht!\n");
										verwItem = Integer.parseInt(option[i+1]);
										l.getSpieler().setUsedItem(verwItem);
									}
									
									
								}else{
									System.out.println("Du besitzt dieses Item nicht!\n");
								}								}
								catch(Exception e) {
								  System.out.println("[!]OMG Das haette echt nicht passieren sollen...\n");
								}

							
						}else{
						System.out.println("[!]Falsche Eingabe");	
						}
						
					}
					
			}
			//Ausgabe aller Items
			if(s.equalsIgnoreCase("item")){
				if(itemFound==true){
				l.getSpieler().spielerItems.getItemListeImBesitz();
				System.out.println("\n");	
				}else{
					System.out.println("Du hast noch keine Items!\n");
				}
				
			}
			
		}
		//durchsuchen
				if(s.equalsIgnoreCase("Durchsuchen") || s.equalsIgnoreCase("suchen") || s.equalsIgnoreCase("suche")){
					l.getLocationBeschreibung(x, y);
					
					int i=l.getItemNr(x, y);
					if(i>=0){
					System.out.println("Du findest "+ l.getSpieler().spielerItems.getItemListeName(i)+"!\n");
					l.getSpieler().spielerItems.ItemListErhalteItem(i);
					itemFound = true;
					
					}
				}
				
				//Karte
				if(s.contains("map") || s.contains("karte") || s.contains("Karte")){
					String [] schalter  = s.split("-",0);
					
					for(int asdf = 1; asdf< schalter.length; asdf++){
						
						if(schalter[asdf].contains("h")){
							System.out.println("map -b : Zeigt Standort der 4 Boss-Gegner an.");
							System.out.println("map -h : Zeigt diese Hilfe-Seite an");
							System.out.println("map -d : Zeigt Standort von Staedten und Doerfern an\n");
						}
						if(schalter[asdf].contains("b")){
							karte.showBossMap(l.getBossStatus(0),l.getBossStatus(1),l.getBossStatus(2),l.getBossStatus(3));
						}
						if(schalter[asdf].contains("d")){
							System.out.println("Funktion noch nicht fertig, steht aber auf dem Plan...\n");
						}
						if(schalter[asdf].contains("s")){
							System.out.println(l.getBossStatus(0)+" "+ l.getBossStatus(1)+ " " +l.getBossStatus(2)+ " "+ l.getBossStatus(3));
						}
							
					}					
					if(s.equalsIgnoreCase("map") || s.equalsIgnoreCase("karte")){
						karte.showMap(x,y);
					}
				}
		//credits
		if(s.equalsIgnoreCase("credits")){
			System.out.println("\n\n\n Credits:\n Programmiert by Manuel Langer\n Kreative Berater:\n Stefan Kolb \n Tim Sigl \n Timo Eichmueller");
		}
		//help
		if(s.equalsIgnoreCase("help")|| s.equalsIgnoreCase("hilfe")){
		System.out.println("Navigation: Gib die entsprechende Himmelsrichtung ein in welche du gehen moechtest.");
		System.out.println("MP-Trank: Fuellt deine Aktionspunkte fuer Magie-Angriffe wieder auf den maximalen wert auf. Verbraucht MP-Traenke.");
		System.out.println("HP-Trank: Fuellt deine Lebenspunkte wider komplett auf. Verbraucht HP-Traenke.");
		System.out.println("Karte: Zeigt eine Karte mit deinem aktuellen Standort an.");
		System.out.println("stats: Zeigt dein aktuelles Level, Statuswerte und Anzahl verbliebener Traenke an.\n\n\n");
		}
		
		//exit
		if(s.equalsIgnoreCase("exit")){
		System.exit(0);
		}

		
		//Heilung
		if(s.equalsIgnoreCase("HP-Trank") || s.equalsIgnoreCase("h")){
			
			if(l.getSpieler().getPotion()>0){
				l.getSpieler().heal();
			}else{
				System.out.println("Du hast keine Heiltraenke mehr!");
			}
		
		}
		
		//Magieregeneration
		if(s.equalsIgnoreCase("MP-Trank") || s.equalsIgnoreCase("m")){
			
			if(l.getSpieler().getTraenke()>0){
				l.getSpieler().restoreAP();
			}else{
				System.out.println("Du hast keine magischen Traenke mehr!");
			}
		
		}
		//Stats
		if(s.equalsIgnoreCase("Stats")){
			l.getStats();
		}
	
		//Norden
		if(s.equalsIgnoreCase("n") || s.equalsIgnoreCase("Norden")){
		 	  if(y>=0 && y<=6) { 
		 		y++;
		 		System.out.println("Du wanderst nach Norden...\n");
		 		
		 		try {
					TimeUnit.MILLISECONDS.sleep(250);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
		 		
		 		if(y > 6 ){
			 		System.out.println("Du betritts ein unerforschtes Gebiet, als ein dichter Nebel aufzieht bekommst du es mit der Angst zutun und du kehrst um! \n");	
			 		y--;
			 		
			 		try {
						TimeUnit.MILLISECONDS.sleep(250);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
			 		
			 		l.startLocation(x, y);
			 	
			 	}else{
			 		
		 		l.startLocation(x, y);}
		 	}
		}  
		//Sueden
		if(s.equalsIgnoreCase("s") || s.equalsIgnoreCase("Sueden")){
		 	  if(y>=0 && y<=6) { 
		 		y--;
		 		System.out.println("Du wanderst nach Sueden...\n");	
		 		
		 		try {
					TimeUnit.MILLISECONDS.sleep(250);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
		 		
		 		if(y < 0 ){
			 		System.out.println("Du kommst in der Feuer-Wueste an, die Sonne brennt vom Himmel und dir duerstet es nach Wasser Du kehrst zwangsweise um! \n");	
			 		y++;
			 		
			 		try {
						TimeUnit.MILLISECONDS.sleep(250);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
			 		
			 		l.startLocation(x, y);
			 	
			 	}else{
			 		
		 		l.startLocation(x, y);}
		 	}
			
		 	
		 	/* if(y>6){
		 		System.out.println("Du kommst an ein unueberwindliches Gebirge, du hast keine andere Wahl als umzukehren!\n Du gehst in die Richtun!");
		 		y--;
		 		l.startLocation(x, y);
		 	
		 	} */

		 
	}
		//Westen
		if(s.equalsIgnoreCase("w") || s.equalsIgnoreCase("Westen")){
			 	  if(y>=0 && y<=6) { 
			 		x++;
			 		System.out.println("Du wanderst nach Westen...\n");
			 		
			 		try {
						TimeUnit.MILLISECONDS.sleep(250);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
			 		
			 		if(x > 6 ){
				 		System.out.println("Du kommst an einem unueberwindlichen Gebirge an! \n Dir bleibt nichts anderes als umzukehren!");	
				 		x--;
				 		
				 		try {
							TimeUnit.MILLISECONDS.sleep(250);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
				 		
				 		l.startLocation(x, y);
				 	
				 	}else{
				 		
			 		l.startLocation(x, y);}
			 	}
		}
		//Wosten
		if(s.equalsIgnoreCase("wosten")){
			System.out.println("oeh,Osten? Haben sie nicht gesagt Wosten?");
			l.spieler.setEXP(10000);
			l.spieler.lvUP();
		}
		
		//Osten
		if(s.equalsIgnoreCase("o") || s.equalsIgnoreCase("Osten")){
		 	  if(y>=0 && y<=6) { 
		 		x--;
		 		System.out.println("Du wanderst nach Osten...\n");
		 		
		 		try {
					TimeUnit.MILLISECONDS.sleep(250);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
		 		
		 		if(x < 0 ){
			 		System.out.println("Du kommst an einem stuermischen Meer an, da du nicht schwimmen kannst entscheidest du dich umzukehren!");	
			 		x++;
			 		
			 		try {
						TimeUnit.MILLISECONDS.sleep(250);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
			 		
			 		l.startLocation(x, y);
			 	
			 	}else{
			 		
		 		l.startLocation(x, y);}
		 	}		


		}
	
	}
}
