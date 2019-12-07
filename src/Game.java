import java.util.Scanner;


public class Game {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("[!]Warnung: Dieses Spiel ist gespickt mit schlechten Referenzen, Reminiszenzen und Rechtschreibfehlern.\n\n\n");		
		System.out.println("Wie heiﬂt du werter Spieler?");
		Menu m = new Menu();					
		m.menuStartLocation();
		
		while(Navigation.bossCounter >0){
			m.bewegen();
			m.getMlocation();
		}
		
		
		
		
		
	
		//hier gehts weiter nachdem alle 4 bosse besiegt wurden!
		Stats spieler = new Stats();
		spieler = m.getStats();
		Enemy bowser = new Enemy("Bowser", "Bowser der finale Boss erscheint!", 600, 400, 20, 1, 160, 50, 120, 40, 1000,"bowser");
		Fight vsBowser = new Fight(bowser, spieler);
		Navigation bossCastle = new Navigation("Schloss des Schreckens", "Nach all deinen Abenteuern hast du es endlich geschafft das Boese zu besiegen\n Aber es ist noch nicht ganz geschafft, der Finale Dungeon wartet!", " ", 100, vsBowser);
		bossCastle.startNavi();
		if(bowser.besiegt == true){
		System.out.println("Du hast die Welt gerettet und unterwegs noch die Prinzessin gerettet, genug fuer einen Tag arbeit!\n Fuer alle Zeiten soll " + spieler.name+ " als groﬂer Held in die Geschichte eingehen!" + "\n ENDE?!");
		}else{
			System.out.println("Da du vor deinem maechtigen Gegner fluechtest uebernimmt Bowser die Kontrolle ueber das Land \n Es ist zwar nicht optimal, aber was soll man machen? Hilft ja nichts... \n Du ziehst dich in dein Heimatdorf zurueck und hoffst das die Krise ohne dein zutun zuende geht! \n ENDE!!");
		}
		System.out.println("\n\n\n Credits:\n Programmiert by Manuel Langer\n Kreative Berater:\n Stefan Kolb \n Tim Sigl \n Timo Eichmueller");
		scan.close();
	}

}
