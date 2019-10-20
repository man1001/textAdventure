import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Menu {
	

	String prompt;
	String m1 ="Durchsuchen";
	String m2 = "Bewegen";
	String m3 = "K�mpfen";
	Stats spieler;
	Locations l = new Locations();
	Karte karte = new Karte();
	Scanner scan = new Scanner(System.in);
	int x=3;
	int y=3;
	int z=0;
	
	public Stats getStats(){
		return l.getSpieler();
	}
	
	public Menu(){
		l.setName(scan.nextLine());
		System.out.println("Du bist der Bewohner des abgelegenen Dorfes Praxx, in welchem es die Tradition \n gibt einen J�ngling zu seinem 18 Geburtstag in die Welt hinaus zu schicken um das B�se zu bek�mpfen! \n Durch diese abstruse Tradition herscht im Dorf nun ein massiver Mangel an Erwachsenen \n aber Tradition ist nun mal Tradition... \n Da heute dein 18. Geburtstag ist wirst ist nun deine Zeit f�r das gro�e Abenteuer gekommen! \n");
	}
	
	public void menuStartLocation(){
		l.startLocation(x, y);
	}
	
	public void getMlocation(){
		l.getLocationName(x, y);
	}


	public void getMenu(){
		System.out.println(prompt  + " \n Was m�chtest du tun? \n" + m1 + "\n" + m2 + "\n" + m3 + "\n" );
	}
	
	public void bewegen(){
		System.out.println("In welche Richtung m�chtest du gehen? [Norden/S�den/Westen/Osten] [stats][MP-Trank][HP-Trank][map]\t[hilfe]");
		String s = scan.nextLine();
		s = s.trim();
		
		//durchsuchen
				if(s.equalsIgnoreCase("Durchsuchen")){
					l.getLocationBeschreibung(x, y);
				}
				
				//Karte
				if(s.contains("map") || s.contains("karte") || s.contains("Karte")){
					String [] schalter  = s.split("-",0);
					
					for(int asdf = 1; asdf< schalter.length; asdf++){
						
						if(schalter[asdf].contains("h")){
							System.out.println("map -b : Zeigt Standort der 4 Boss-Gegner an.");
							System.out.println("map -h : Zeigt diese Hilfe-Seite an");
							System.out.println("map -d : Zeigt Standort von St�dten und D�rfern an\n");
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
			System.out.println("\n\n\n Credits:\n Programmiert by Manuel Langer\n Kreative Berater:\n Stefan Kolb \n Tim Sigl \n Timo Eichm�ller");
		}
		//help
		if(s.equalsIgnoreCase("help")|| s.equalsIgnoreCase("hilfe")){
		System.out.println("Navigation: Gib die entsprechende Himmelsrichtung ein in welche du gehen m�chtest.");
		System.out.println("MP-Trank: F�llt deine Aktionspunkte f�r Magie-Angriffe wieder auf den maximalen wert auf. Verbraucht MP-Tr�nke.");
		System.out.println("HP-Trank: F�llt deine Lebenspunkte wider komplett auf. Verbraucht HP-Tr�nke.");
		System.out.println("Karte: Zeigt eine Karte mit deinem aktuellen Standort an.");
		System.out.println("stats: Zeigt dein aktuelles Level, Statuswerte und Anzahl verbliebener Tr�nke an.\n\n\n");
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
				System.out.println("Du hast keine Heiltr�nke mehr!");
			}
		
		}
		
		//Magieregeneration
		if(s.equalsIgnoreCase("MP-Trank") || s.equalsIgnoreCase("m")){
			
			if(l.getSpieler().getTraenke()>0){
				l.getSpieler().restoreAP();
			}else{
				System.out.println("Du hast keine magischen Tr�nke mehr!");
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
		//S�den
		if(s.equalsIgnoreCase("s") || s.equalsIgnoreCase("S�den")){
		 	  if(y>=0 && y<=6) { 
		 		y--;
		 		System.out.println("Du wanderst nach S�den...\n");	
		 		
		 		try {
					TimeUnit.MILLISECONDS.sleep(250);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
		 		
		 		if(y < 0 ){
			 		System.out.println("Du kommst in der Feuer-W�ste an, die Sonne brennt vom Himmel und dir d�rstet es nach Wasser Du kehrst zwangsweise um! \n");	
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
		 		System.out.println("Du kommst an ein un�berwindliches Gebirge, du hast keine andere Wahl als umzukehren!\n Du gehst in die Richtun!");
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
				 		System.out.println("Du kommst an einem un�berwindlichen Gebirge an! \n Dir bleibt nichts anderes als umzukehren!");	
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
			System.out.println("�h,Osten? Haben sie nicht gesagt Wosten?");
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
			 		System.out.println("Du kommst an einem st�rmischen Meer an, da du nicht schwimmen kannst entscheidest du dich umzukehren!");	
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