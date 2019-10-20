import java.util.Random;
import java.util.Scanner;


public class Navigation {
	
	String locationName;
	String locationText;
	String locationDurchsuchen;
	static int bossCounter = 4;
	int w;
	Fight fight;
	Scanner scan = new Scanner(System.in);
	Random random = new Random();
	String bossText;
	boolean bossFight = false;
	boolean bossPoint = true;
	
	public Navigation(String locationName, String locationText, String locationDurchsuchen, int encounterW, Fight fight){
		this.locationName = locationName;
		this.locationText = locationText;
		this.locationDurchsuchen = locationDurchsuchen;
		w = encounterW;
		this.fight = fight;

	}
	
	public void durchsuchen(){
		System.out.println(locationDurchsuchen);
	}
	
	public Navigation(String locationName, String locationText, String locationDurchsuchen, int encounterW, Fight fight,String bossBattleText){
		this.locationName = locationName;
		this.locationText = locationText;
		this.locationDurchsuchen = locationDurchsuchen;
		w = encounterW;
		this.fight = fight;
		bossText = bossBattleText;
		bossFight = true;
	}
	
	
	public Navigation() {
		
	}


	public void encounter(){
		if(random.nextInt(100)<w){
		 	fight.fight();
		}
	}
	
	public String getLocationName(){
		return locationName;
	}
	
	public void startNavi(){
		
		if(bossFight == false){
				System.out.println(locationName+"\n"+ locationText + "\n");
		if(bossPoint == true){
		encounter();
		}

		}
		if(bossFight == true){
			System.out.println(locationName+"\n"+ locationText + "\n");
			if(bossPoint == true){
			System.out.println(bossText);
			encounter();
			if(fight.getBesiegt()== true){
				bossVictory();	
				bossPoint = false;
				bossFight = false;
			}
			}

			System.out.println("Es verbleiben: "+ bossCounter() + " Boss(e)!");
		}

	}
	
	public void bossVictory(){
		if(fight.besiegt=true){
		bossCounter--;
		}
	}
	public int bossCounter(){
		return bossCounter;
	}
	
}
	
	

