import java.util.OptionalInt;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Menu {
	

	String prompt;
	String m1 ="Durchsuchen";
	String m2 = "Bewegen";
	String m3 = "Kämpfen";
	Stats spieler;
	Locations l = new Locations();
	Karte karte = new Karte();
	Scanner scan = new Scanner(System.in);
	int x=3;
	int y=3;
	int z=0;
	
	int verwItem = -1;
	
	public Stats getStats(){
		return l.getSpieler();
	}
	
	public Menu(){
		l.setName(scan.nextLine());
		System.out.println("Du bist der Bewohner des abgelegenen Dorfes Praxx, in welchem es die Tradition \n gibt einen Jüngling zu seinem 18 Geburtstag in die Welt hinaus zu schicken um das Böse zu bekämpfen! \n Durch diese abstruse Tradition herscht im Dorf nun ein massiver Mangel an Erwachsenen \n aber Tradition ist nun mal Tradition... \n Da heute dein 18. Geburtstag ist wirst ist nun deine Zeit für das große Abenteuer gekommen! \n");
	}
	
	public void menuStartLocation(){
		l.startLocation(x, y);

	}
	
	public void getMlocation(){
		l.getLocationName(x, y);
	}


	public void getMenu(){
		System.out.println(prompt  + " \n Was möchtest du tun? \n" + m1 + "\n" + m2 + "\n" + m3 + "\n" );
	}
	
	public void bewegen(){
		System.out.println("In welche Richtung möchtest du gehen? [Norden/Süden/Westen/Osten]\t[menu]");
		String s = scan.nextLine();
		s = s.trim();
		
		
		//menu anzeigen
		if(s.equalsIgnoreCase("menu")){
			System.out.println("stats\t[Zeigt aktuelles Level und Statuswerte an]");
			System.out.println("mp-trank\t[Stellt Magie komplett wieder her]");
			System.out.println("hp-trank\t[Stellt Lebenspunkte komplett wieder her]");
			System.out.println("map\t[Zeigt Karte mit der aktuellen Position]\nmap -b\t[Zeigt Standort der verbleibenden Boss-Gegner an]");
			System.out.println("suchen\t[Durchsucht die Umgebung nach Items]");
			System.out.println("item\t[Zeigt Liste der gefundenen Items]\nitem -a (Item Nummer)\t[Rüstet das gewünschte Item aus]\nitem -b\t[Zeigt Item-Beschreibung an]");
			System.out.println("hilfe\t[Zeigt ein recht unnützes Hilfe-Menü an]\n\n");
			
		}
		
		
		//item anzeigen aendern und ausrüsten
		
		if(s.contains("item")){
			String [] option = s.split(" ", 0);
			
			for(int i = 0; i< option.length; i++){
				    
					if (option[i].equalsIgnoreCase("-h")){
						System.out.println("Zeigt alle erhaltenen Items an\n item -(option) -(itemNr)\n item -h : hilfe\n item -a (itemNr) : Item ausruesten\n item -b (itemNr) : Itembeschreibung anzeigen");				
					}
					
					if(option[i].equalsIgnoreCase("-b")){
						if(option.length == 3){
							// Test ob Item im besitz ist							
							if(l.getSpieler().spielerItems.getItemBesitz(Integer.parseInt(option[i+1]))==true){
								System.out.println("\n");
								System.out.println(l.getSpieler().spielerItems.getItemListeName(Integer.parseInt(option[i+1])));
								System.out.println(l.getSpieler().spielerItems.getItemListBeschreibung(Integer.parseInt(option[i+1])));
								l.getSpieler().spielerItems.getItemStats(Integer.parseInt(option[i+1]));
								System.out.println("\n");
								}else{
								System.out.println("Du besitzt dieses Item nicht!");
								}
												
						}else{
						System.out.println("[!]Falsche Eingabe");		
						}
					}
						
					
					
					if(option[i].equalsIgnoreCase("-a")){
						if(option.length == 3){
							// Test ob Item im besitz ist
							
							if(l.getSpieler().spielerItems.getItemBesitz(Integer.parseInt(option[i+1]))==true){
								if(verwItem == -1){
									l.getSpieler().buffStatsWithItem(l.getSpieler().spielerItems.getItem(Integer.parseInt(option[i+1])));	
									verwItem = Integer.parseInt(option[i+1]);
								}
								else if(verwItem == Integer.parseInt(option[i+1])){
									System.out.println("Du verwendest dieses Item bereits!");
								}else{
									l.getSpieler().nerfStatsWithItem(l.getSpieler().spielerItems.getItem(verwItem));	

									l.getSpieler().buffStatsWithItem(l.getSpieler().spielerItems.getItem(Integer.parseInt(option[i+1])));	
									System.out.println("Du hast "+l.getSpieler().spielerItems.getItemListeName(verwItem)+ " gegen "+ l.getSpieler().spielerItems.getItemListeName(Integer.parseInt(option[i+1]))+" ausgetauscht!");
									verwItem = Integer.parseInt(option[i+1]);
								}
								
								
							}else{
								System.out.println("Du besitzt dieses Item nicht!");
							}
							
						}else{
						System.out.println("[!]Falsche Eingabe");	
						}
						
					}
					
			}
			//Ausgabe aller Items
			if(s.equalsIgnoreCase("item")){			
				l.getSpieler().spielerItems.getItemListeImBesitz();
				System.out.println("\n");
			}
			
		}
		//durchsuchen
				if(s.equalsIgnoreCase("Durchsuchen") || s.equalsIgnoreCase("suchen")){
					l.getLocationBeschreibung(x, y);
					
					int i=l.getItemNr(x, y);
					if(i>=0){
					System.out.println("Du findest "+ l.getSpieler().spielerItems.getItemListeName(i)+"!");
					l.getSpieler().spielerItems.ItemListErhalteItem(i);
					}
				}
				
				//Karte
				if(s.contains("map") || s.contains("karte") || s.contains("Karte")){
					String [] schalter  = s.split("-",0);
					
					for(int asdf = 1; asdf< schalter.length; asdf++){
						
						if(schalter[asdf].contains("h")){
							System.out.println("map -b : Zeigt Standort der 4 Boss-Gegner an.");
							System.out.println("map -h : Zeigt diese Hilfe-Seite an");
							System.out.println("map -d : Zeigt Standort von Städten und Dörfern an\n");
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
			System.out.println("\n\n\n Credits:\n Programmiert by Manuel Langer\n Kreative Berater:\n Stefan Kolb \n Tim Sigl \n Timo Eichmüller");
		}
		//help
		if(s.equalsIgnoreCase("help")|| s.equalsIgnoreCase("hilfe")){
		System.out.println("Navigation: Gib die entsprechende Himmelsrichtung ein in welche du gehen möchtest.");
		System.out.println("MP-Trank: Füllt deine Aktionspunkte für Magie-Angriffe wieder auf den maximalen wert auf. Verbraucht MP-Tränke.");
		System.out.println("HP-Trank: Füllt deine Lebenspunkte wider komplett auf. Verbraucht HP-Tränke.");
		System.out.println("Karte: Zeigt eine Karte mit deinem aktuellen Standort an.");
		System.out.println("stats: Zeigt dein aktuelles Level, Statuswerte und Anzahl verbliebener Tränke an.\n\n\n");
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
				System.out.println("Du hast keine Heiltränke mehr!");
			}
		
		}
		
		//Magieregeneration
		if(s.equalsIgnoreCase("MP-Trank") || s.equalsIgnoreCase("m")){
			
			if(l.getSpieler().getTraenke()>0){
				l.getSpieler().restoreAP();
			}else{
				System.out.println("Du hast keine magischen Tränke mehr!");
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
		//Süden
		if(s.equalsIgnoreCase("s") || s.equalsIgnoreCase("Süden")){
		 	  if(y>=0 && y<=6) { 
		 		y--;
		 		System.out.println("Du wanderst nach Süden...\n");	
		 		
		 		try {
					TimeUnit.MILLISECONDS.sleep(250);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
		 		
		 		if(y < 0 ){
			 		System.out.println("Du kommst in der Feuer-Wüste an, die Sonne brennt vom Himmel und dir dürstet es nach Wasser Du kehrst zwangsweise um! \n");	
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
		 		System.out.println("Du kommst an ein unüberwindliches Gebirge, du hast keine andere Wahl als umzukehren!\n Du gehst in die Richtun!");
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
				 		System.out.println("Du kommst an einem unüberwindlichen Gebirge an! \n Dir bleibt nichts anderes als umzukehren!");	
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
			System.out.println("Öh,Osten? Haben sie nicht gesagt Wosten?");
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
			 		System.out.println("Du kommst an einem stürmischen Meer an, da du nicht schwimmen kannst entscheidest du dich umzukehren!");	
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
