import java.util.EmptyStackException;
import java.util.concurrent.TimeUnit;


public class Locations {
	Stats spieler= new Stats();
	Navigation n [][] = new Navigation[7][7];
	int [] bossMapping = new int[4];

	
	Enemy noFight = new Enemy("noEnemy", " ", 0, 0, 0, 0, 0, 0, 0, 0, 0);
	Fight vsNobody = new Fight(noFight, spieler);
	
	//Enemy Spickzettel = new Enemy(1name, 2enemyText, 3lebenspunkte, 4ap, 5lv, 6exp, 7 attack, 8 defense, 9 sAngr, 10 sDef, 11 initiative)
	
	Enemy dragon = new Enemy("Drache","Du wirst von einem feuerspeienden Drachen angegriffen!", 350, 200, 100, 300, 120, 20, 30, 20, 200, true,1000,120,70);
	Fight vsDragon = new Fight(dragon, spieler);
	
	Enemy gargoyle = new Enemy("Gargoyles","Du wirst von Gargoyles angegriffen!", 500, 100, 10, 150, 40, 30, 1, 1, 100,120,160,40);
	Fight vsGargoyle = new Fight(gargoyle, spieler);
	
	Enemy gremlyn = new Enemy("Gremlyn", "Du wirst von Gremlyns angegriffen", 30, 50, 2, 8, 10, 5, 1, 1, 40);
	Fight vsGremlyn = new Fight(gremlyn, spieler);
	
	Enemy riesenKrabbe = new Enemy("Menschenfressende Riesenkrabbe", "Du wirst von einer schrecklichen, menschenfressenden Riesenkrabbe angegriffen", 200, 300, 12, 100, 17, 200, 1, 6, 1,130,30,120);
	Fight vsRiesenKrabbe = new Fight(riesenKrabbe, spieler);
	
	Enemy lich = new Enemy("Übermächtiger Lich", "Vor dir erscheint der Lich!", 500, 300, 10, 300, 160, 10, 1, 1000, 250, true,100,100,100);
	Fight vsLich = new Fight(lich, spieler);
	
	Enemy zombie = new Enemy("Gruppe Untoter", "Eine Gruppe Untoter Zombies  erscheint", 150, 120, 4, 130, 50, 120, 20, 50, 5,10,1000,120);
	Fight vsZombie = new Fight(zombie, spieler);
	
	Enemy erdWurm = new Enemy("Erdwurm", "Eine unheilvolle Kreatur schießt aus dem Boden und schnappt mit ihren messerscharfen Beißwerkzeugen nach dir!",  100, 30, 5, 50, 20, 40, 1, 50, 77,90,50,200);
	Fight vsErdwurm = new Fight(erdWurm, spieler);
	
	Enemy riesenSpinne = new Enemy("Riesenspinne", "Du verfängst dich in einem klebrigen Spinnennetz und über dir erscheint\n eine unglaublich hässliche riesige Spinne!\n Du kannst dich befreien und machst dich kampfbereit!", 100, 20, 11, 155, 35, 40, 10, 5, 155,35,140,90);
	Fight vsSpinne = new Fight(riesenSpinne, spieler);
	
	Enemy vogelscheuche = new Enemy("Lebendig gewordene Vogelscheuche", "Als du über das Feld läufst wirst du plötzlich von einer Vogelscheuche angegriffen welche bis jetzt bewegungslos da stand!", 20, 10, 2, 30, 10, 5, 4, 7, 3,1,100,1000);
	Fight vsVogelscheuche = new Fight(vogelscheuche, spieler);
	
	Enemy traktor = new Enemy("Verrosteter teuflischer Traktor", " \n Als du dich umschaust hörst du hinter dem Hauptgebäude einen lauten Knall! \n Ein altes stählernes Ungetüm fährt auf dich zu! Sein verrostetes Getriebe heult auf...! \n Der unheimliche Traktor greift dich an!", 50, 50, 4, 50, 12, 10, 4, 70, 1,50,10,130);
	Fight vsTraktor = new Fight(traktor, spieler);
	
	Enemy trolle = new Enemy("Trolle", "Die Trolle greifen dich an!", 30, 5, 3, 15, 5, 4, 4, 7, 7,20,1000,80);
	Fight vsTrolle = new Fight(trolle, spieler);
	
	Enemy eiskreatur = new Enemy("Eiskreatur", "Eine Kreatur aus Eis und Schnee erscheint! \n Mit ihren gefrorenen Krallen schlägt sie auf dich ein!", 150, 10, 10, 85, 75, 35, 50, 40, 25,0,10000,120);
	Fight vsEisKreatur = new Fight(eiskreatur, spieler);
	
	Enemy krake = new Enemy("Sumpf-Krake", "Aus der braunen Brühe erhebt sich ein gigantisches Tentakelmonster und greift nach dir mit hunderten von Fangarmen!", 50, 30, 20, 100, 85, 35, 60, 20, 40,130,30,120);
	Fight vsKrake = new Fight(krake, spieler);
	
	Enemy piranha = new Enemy("Piranha-Schwarm", "Du rutschst aus und fällst ins Wasser! \n Ein Schwarm Piranhas naht heran und greift dich an...", 45, 30, 5, 60, 30, 10, 1, 7, 5,100,80,0);
	Fight vsPiranha = new Fight(piranha, spieler);
	
	Enemy bauer = new Enemy("Kartoffelbauer", "Als du das Feld überquerst stürmt ein wütend fluchender Bauer auf dich zu! \n Er schwingt seine Mistgabel", 5, 5, 2, 30, 5, 6, 3, 100, 2,10000,10000,10000);
	Fight vsBauer = new Fight(bauer, spieler);
	
	Enemy bandit = new Enemy("Banditen", "Ein Rudel räudiger Räuber greift dich an!", 30, 25, 3, 75, 25, 14, 1, 10, 17);
	Fight vsBanditen = new Fight(bandit, spieler);
	
	Enemy wolf = new Enemy("Wolf", "Ein schrecklicher schwarzer Wolf greift dich an!", 40, 10, 5, 55, 12, 16, 1, 50, 16,10,130,50);
	Fight vsWolf = new Fight(wolf, spieler);
	
	Enemy priester = new Enemy("Gottloser Priester", "Aus einer dunklen Ecke springt dich ein besessener Priester an... \n Er beschwört eine unheilige Kreatur welche dich mit Grauen erfüllt!", 189, 54, 12, 99, 65, 15, 25, 123, 75,100,100,100);
	Fight vsPriester = new Fight(priester, spieler);
	
	Enemy hexe = new Enemy("Sumpf-Hexe", "Eine garstige Hexe erscheint. \n Ihre Augen funkeln dich böse an und sie macht sich bereit dich zu verfluchen!", 45, 15, 6, 85, 1, 12, 45, 70, 15,40,150,150);
	Fight vsHexe = new Fight(hexe, spieler);
	
	Enemy räuber = new Enemy("Räuber", "Ein Räuber erscheint! \n Du fragst dich was er möchte! \n Dann wird dir klar das ein Räuber unter umständen nichts gutes im Sinn hat...", 30, 25, 3, 75, 25, 14, 1, 10, 17,10,10,10);
	Fight vsBandit = new Fight(räuber, spieler);
	
	Enemy holzfäller = new Enemy("Geistig umnachteter Holzfäller", "Ein verwirrt wirkender Holzfäller nähert sich dir. \n Als du mit ihm reden möchtest schwingt er seine rasiermesserscharfe Axt nach dir. \n Obwohl du ein recht friedfertiger Mensch bist, ist dir das doch recht unangenehm...", 15, 65, 10, 100, 75, 5, 1, 10, 10,100,100,20);
	Fight vsHolzfäller = new Fight(holzfäller, spieler);
	
	Enemy magier = new Enemy("Magischer Magier", "Der Magier der hier im Turm lebt erscheint mit einem lauten Knall. \n Als er bemerkt das du wach bist versucht er dich mit seiner Magie zu betäuben... \n Als ihn das nicht gelingt greift er dich mit Energiestrahlen an...", 65, 10, 18, 60, 80, 12, 120, 200, 99,120,100,130);
	Fight vsMagier = new Fight(magier, spieler);
	
	Enemy schwarzerRitter = new Enemy("Der Schwarze Ritter", " \n Als du sie betrittst greift dich augenblicklich ein Ritter in schwarzer Rüstung an... \n Die Rüstung ist ziemlich cool und du fragst dich ob du sie nach dem Kampf an dich nehmen kannst", 200, 10, 20, 500, 100, 100, 1, 25, 1,120,95,60);
	Fight vsSchwarzerRitter = new Fight(schwarzerRitter, spieler);
	
	Enemy darkShadow = new Enemy("Dunkler Schatten", " \n Du kommst an einem Grab vorbei welches deinen Namen trägt... \n Erschrocken taumelst du zurück \n Halb wahnsinnig vor Angst bemerkst du nicht wie sich hinter dir ein dunkler Schatten formiert und dich angreift.........! ", 100, 25, 10, 150, 55, 25, 75, 15, 1000,30,160,40);
	Fight vsDarkShadow = new Fight(darkShadow, spieler);
	
	Enemy verdammter = new Enemy("Verstoßener Untoter", "Dieser Untoter hat gleichermaßen Verlangen nach dem Fleisch der Lebenden \n so wie Wut auf die Gesellschaft die ihn verstoßen hat..", 25, 45, 2, 95, 15, 20, 5, 5, 10,20,150,160);
	Fight vsVerdammter = new Fight(verdammter, spieler);
	
	Enemy bankräuber = new Enemy("Bankräuber", "Als du fröhlich deines Weges gehst bemerkst du wie die hiesige Bank überfallen wird... \n In einem Anflug von Größenwahn stellst du dich dem Gesindel entgegen. \n\n Endlich macht sich deine Erfahrung als hauptberuflicher Held bezahlt...", 50, 70, 3, 45, 15, 7, 1, 1, 8);
	Fight vsBankräuber = new Fight(bankräuber, spieler);
	
	Enemy zwerg = new Enemy("Riesiger Zwerg", "Ein gewaltiger Zwerg greift dich an als du kurz wegschaust...", 50, 10, 7, 98, 25, 30, 40, 45, 50,35,90,90);
	Fight vsZwerg = new Fight(zwerg, spieler);
	
	Enemy samurai = new Enemy("Psychopatischer Samurai", "Ein Samurai erscheint \n Dieser verrückte Samurai hat es auf dein Schwert abgesehen... \n ", 90, 50, 12, 180, 90, 10, 0, 15, 100,110,110,30);
	Fight vsSamurai = new Fight(samurai, spieler);
	
	Enemy lordNatas = new Enemy("Lord Natas","\n Lord Natas erscheint! \n Er ist der gefallene Engel... \n Und beliebt bei den Frauen... ", 666, 66, 66, 666, 150, 40, 67, 76, 666, true,666,333,65);
	Fight vsLordNatas = new Fight(lordNatas, spieler);
	
	Enemy komischeFrau = new Enemy("Besessene Frau", "In einem Anflug von Wahnsinn greift dich die liebeskranke Frau an", 10, 10, 2, 10, 5, 5, 5, 5, 1);
	Fight vsFrau = new Fight(komischeFrau, spieler);
	
	Enemy balrog = new Enemy("Balrog von Morgoth", "Als du durch die Minen streifst kommt ein Grollen näher\n und vor dir baut sich eine riesige brennende Gestalt auf...\n Ein Zauberer tritt zwischen dich und das Ungetüm, dieser stürzt aber ungeschickt in den Abgrund bevor er etwas sagen kann... ", 300, 100, 200, 1000, 75, 50, 100, 1, 100,10000,60,160);
	Fight vsBalrog = new Fight(balrog, spieler);
	
	Enemy voidWarrior = new Enemy("Krieger der Leere", "Die Erscheinung vor dir formiert sich zu einer Gestalt welche nichts menschliches an sich hat...", 100, 10, 10, 250, 45, 20, 10, 1, 25,200,200,200);
	Fight vsLeerenKrieger = new Fight(voidWarrior, spieler);
	
	Enemy statue = new Enemy("Steinstatuen Wächter", "Als du das Schwert loslässt und dich nach etwas umsiehst mit dem du es aus dem Stein hebeln kannst\n wirst du von von zwei dich umgebenden Stein-Statuen angegriffen\n ", 300, 10, 15, 350, 95, 200, 1, 1, 0,130,75,120);
	Fight vsStatue = new Fight(statue, spieler);
	
	Enemy letzterStadtbewohner = new Enemy("Überfürsorglicher Hausmeister", "...ist sie aber nicht! \n Der Hausmeister der Stadt rastet aus als er bemerkt das du mit dreckigen Schuhen seine saubere Stadt betreten hast.", 170, 100, 18, 400, 77, 89, 1, 21, 10,170,45,180);
	Fight vsBewohner = new Fight(letzterStadtbewohner, spieler);
	
	Enemy dracula = new Enemy("Dracula", "Der Fürst der Finsternis der Meister des Bösen sitzt vor dir\n Nachdem er einen kurzen Monolog über die hybris der Menschlichkeit gehalten hat beschließt er dich anzugreifen...", 360, 10, 40, 500, 140, 43, 160, 47, 1000, true,105,105,105);
	Fight vsDracula = new Fight(dracula, spieler);
	
	public Locations(){		
		n [0][0]= new Navigation("Dungeon des Todes", "Du befindest dich im Dungeon des Todes, dich beschleicht ein ungutes Gefühl!","Du findest nichts", 100, vsDragon, "Du betritts den Dungeon und vor dir erscheint eine der vier mächtigsten Kreaturen dieser Welt!");	
		n [0][1]= new Navigation("Süd-Östlicher Palast", "Du siehst einen großen Palast und betrittst ihn...", "Du findest nichts", 100, vsGargoyle);
		n [0][2]= new Navigation("Kränklicher Wald", "Du betrittst den kränklichen Wald \n Abgestorbene Bäume stehen um dich herum \n, Du kommst zu deiner großen Verwunderung ohne einen Kampf weiter!", "Du findest nichts!", 0, vsGargoyle);
		n [0][3]= new Navigation("einsamer Sandstrand", "Du kommst an einem einsamen Strand an", "Du findest eine Muschel",  10, vsRiesenKrabbe);
		n [0][4]= new Navigation("Östliche Hafenstadt", "Du betrittst die östlich gelegene Hafenstadt, du erfahrst von der Legende das eine mächtige Kreatur im Süden lebt! ",  "Du findest nichts!", 0, vsNobody);
		n [0][5]= new Navigation("Verlassener Strand", "Nach einer beschwerlichen Reise kommst du an einem verlassenen Strand an",  "Du findest nichts", 25, vsRiesenKrabbe);
		n [0][6]= new Navigation("Das Schloss der Untoten", "Schon aus der ferne siehst du wie sich ein riesiges Schloss auf einem hohen Berg erhebt!", "Nichts obviously", 100, vsLich, "Du betritts das Schloss und vor dir erscheint eine der vier mächtigsten Kreaturen dieser Welt!");
		n [1][0]= new Navigation("Schlucht des Todes", "Du bist in der Schlucht des Todes", "Du findest nichts", 100, vsGremlyn);
		n [1][1]= new Navigation("Friedhof der Untoten", "Es zieht ein dichter Nebel auf...", "Du findest Knochen!", 100, vsZombie);
		n [1][2]= new Navigation("Kränklicher Wald", "Du bist im kränklichen Wald \n Abgestorbene Bäume stehen um dich herum", "Du findest nichts!", 20, vsGargoyle);
		n [1][3]= new Navigation("Sehr zerklüftete Einöde", "Eine weite Ebene erstreckt sich vor dir!", "wie immer nichts!", 40, vsErdwurm);
		n [1][4]= new Navigation("Zerklüftete Einöde", "Du erklimmst einen Hügel und vor dir erstreckt sich eine weite Ebene welche sehr zerklüftet ist!", "wie immer nichts!", 50, vsErdwurm);
		n [1][5]= new Navigation("Finsterer Wald", "Du betrittst einen dunklen Wald!", "nothing" , 75, vsSpinne);
		n [1][6]= new Navigation("Finsterer, dunkler Wald", "Du bist im Wald!", "nothing" , 45, vsSpinne);
		n [2][0]= new Navigation("Kränklicher Wald", "Du bist im kränklichen Wald \n Abgestorbene Bäume stehen um dich herum \n Du fühlst dich beobachtet!", "Du findest nichts!", 80, vsZombie);
		n [2][1]= new Navigation("Kränklicher kranker Wald", "Du bist im kränklichen Wald \n Abgestorbene Bäume stehen um dich herum \n Dunkle Nebelschwaden ziehen auf!", "Du findest nichts!", 25, vsZombie);
		n [2][2]= new Navigation("Kränklicher kranker Wald", "Du bist im kränklichen Wald \n Abgestorbene Bäume stehen um dich herum \n Dunkle Nebelschwaden ziehen auf!", "Du findest nichts!", 25, vsBanditen);
		n [2][3]= new Navigation("Östliches Weizenfeld", "Vor dir erstreckt sich ein Weizenfeld. Die Ähren neigen sich im Wind! Da du nicht weit von deinem Heimatdorf entfernt bist fühlst du dich relativ sicher!", "nichts", 100, vsVogelscheuche);
		n [2][4]= new Navigation("Verlassene Farm", "Du kommst an einer alten verfallenen Farm an...", "Nichts!", 100, vsTraktor);
		n [2][5]= new Navigation("Tiefe Höhle", "Ein Unwetter zieht auf um Schutz vor dem Gewitter zu suchen flüchtest du in eine dunkle Höhle! \n Als du dich zum Schlafen legst bricht unter dir der Boden ein... \n Du bist einer Horde Hölen-Trollen in die Falle gegangen... \n Glücklicherweise hast du dein Schwert zur Hand...",  "nichts", 50, vsTrolle);
		n [2][6]= new Navigation("eisiger Wald", "Ein Schneesturm zieht auf! \n Der Wald in dem du umherirrst wird zur eisigen Falle für dich!", "Du findest nichts!", 95, vsEisKreatur);
		n [3][0]= new Navigation("Tümpel der Vergessenen", "Du kommst an einem morastigen Tümpel an",  "Du findest absolut gar nichts!", 75, vsKrake);
		n [3][1]= new Navigation("Kristallklarer See", "Du kommst an einem See mit sehr klaren Wasser an!", "Wie immer findest du nichts!", 50, vsPiranha);
		n [3][2]= new Navigation("südliches Kürbisfeld", "Du läufst über ein Kürbisfeld...\n Du kannst aus der ferne dein Heimatdorf sehen!", "Was denkst du denn?", 30, vsBauer,2);
		n [3][3]= new Navigation("Das Dorf Praxx", "Du befindest dich in deinem Heimatdorf, die Vögel singen, die Leute treiben Handel... \n Hier ist die Welt noch in Ordnung!", "nichts", 0, vsNobody,10);
		n [3][4]= new Navigation("Nördlicher Feldweg", "Du kommst an einem Feldweg vorbei, du erinnerst dich das östlich von hier ein alter Bauernhof steht!", " ", 45, vsBanditen,1);
		n [3][5]= new Navigation("Nord-Wald", "Du betrittst den nördlichen Wald! \n Du findest einen alten Pfad der dich durch den Wald führt!", " ", 60, vsWolf);
		n [3][6]= new Navigation("Kirchen-Ruine", "Du betritts eine verfallene alte Ruine einer Kirche! \n Es sieht so aus als ob vor kurzem jemand hier gewesen ist! \n Du siehst dich vorsichtig um...", "Der Klassiker!", 85, vsPriester);
		n [4][0]= new Navigation("Hexenhaus", "Als du in den morastigen Sumpf trittst siehst du ein kleines unförmiges Haus.\n Die Wände aus Holz sind vermodert und allgemein wirkt es nicht so als ob man hier schön Urlaub machen könnte...", "Du findest Gegenstände die für dich absolut nutzlos sind", 79, vsHexe);
		n [4][1]= new Navigation("Vertrocknetes Flussbett", "Du triffst auf einen Wanderer welcher dir von einem mächtigen Wesen in einer Kathedrale westlich von hier berichtet! \n Als du dich kurz umschaust ist der Reisende verschwunden...", "You know...", 0, vsNobody);
		n [4][2]= new Navigation("Verborgener Hain", "Du findest eine kleines Wäldchen mit einer Quelle.", "Ist eine magische Quelle nicht genug?", 0, vsNobody);
		n [4][3]= new Navigation("westliches Feld", "Du wanderst den Feldweg entlang, dein Heimatdorf ist nicht weit weg von hier...", "Nichts da!", 65, vsBandit);
		n [4][4]= new Navigation("Uralter Baum", "Du kommst an einem riesigen alten Baum an. \n Du ruhst dich kurz aus...", "Der Baum ist dir wohl nicht gut genug?!", 85, vsHolzfäller);
		n [4][5]= new Navigation("idyllische Weide", "Du kommst an einer friedvollen Kuh-Weide an... \n Der Bauer der hier lebt erzählt dir das es im Norden einen speziellen Ort gibt \n Er warnt dich das es gefährlich sein könnte...", " ", 0, vsNobody);
		n [4][6]= new Navigation("Turm des Magiers", "Als du einen Turm erblickst spürst du eine eisigen Schauer der dich durchdringt... \n Du fällst in Ohnmacht! \n \n Als du wieder erwachst bist du in einem dunklen Raum. \n Du bemerkst das du im obersten Stockwerk des Turmes gefangen bist.", "Als ob du zeit hättest dich umzuschauen...", 100, vsMagier);
		n [5][0]= new Navigation("Stadt: New Altmeria (Osten)", "Die alte und ehrwürdige Stadt Altmeria liegt vor dir! \n Hier herscht eine merkwürdige Stimmung! \n Die Menschen die hier leben meiden dich und wirken so als ob sie dich los werden wollen würden. \n Du sprichst mit einem reisenden Händler der dir berichtet das unheilige Dinge in der Kathedrale im Westen vor sich gehen... \n ", "Du findest eine Kathedrale im Westen, gehe dort hin!!!",  0, vsNobody);
		n [5][1]= new Navigation("Stadt: New Altmeria (Norden)", "Du wanderst durch die durch die Gassen von New Altmeria und kommst an der Zitadelle der Stadt an...", "Rüstung", 100, vsSchwarzerRitter);
		n [5][2]= new Navigation("Altmeria Friedhof", "Du bewegst dich auf einen großen Friedhof zu... \n In der Ferne kannst du die Stadt Altmeria leuchten sehen...", "Hier gibt es nur Gräber...", 100, vsDarkShadow);
		n [5][3]= new Navigation("Ebene der Verdammten", "Stehst irgenwo auf einer weiten Ebene...", "nothing", 25, vsVerdammter);
		n [5][4]= new Navigation("Dorf Knaaax", "Du kommst in das Dorf Knaaax... \n Hier leben die Menschen noch nach den alten Traditionen und den alten Göttern...", "Gold du findest sehr viel Gold... Glückwunsch", 100, vsBankräuber);
		n [5][5]= new Navigation("Einsamer Berg Erebor", "In der großen Ebene davor findet eine erbitterte Schlacht statt... \n Wegen deiner friedfertigen Natur entschließt du dich das gewaltsame Treiben zu meiden....", "Schlacht", 10, vsZwerg);
		n [5][6]= new Navigation("Nördliche Steppen von Lycia", "Ein weite Steppe \n", "nichts", 100, vsSamurai);
		n [6][0]= new Navigation("Kathedrale von New Altmeria", "Du betrittst die Kathedrale um ein stilles Gebet zu sprechen... \n", " ", 100, vsLordNatas, "Da bemerkst du wie sich ein Portal öffnet und der Leibhaftige heraussteigt \n Deine Stimmung verschlechtert sich rapide...");
		n [6][1]= new Navigation("Stadt: New Altmeria (Norden)", "Als du durch die Stadt wanderst begegnest du einer Frau \n welche von ihrem Liebhaber schwärmt und nebenbei erwähnt das sich dieser in der Kathedrale aufhält...", "Amulet der Macht!", 10, vsFrau);
		n [6][2]= new Navigation("Verlassene Miene", "Du stürzt durch ein Loch im Boden und bist kurz bewusstlos\n Du siehst dich um und merkst das du in einer alten Miene gelandet bist...", "Erz viel viel Erz...", 85, vsBalrog);
		n [6][3]= new Navigation("The Void", "Als du das Gebiet betritts zerbricht um dich herum die Realität\n Unfähig das sich vor dir absielende Schauspiel zu begreifen bist du dem Wahnsinn nahe\n Du verlierst 1 Punkt Mentale Belastbarkeit", "nichts", 50, vsLeerenKrieger);
		n [6][4]= new Navigation("Heiliger Hein", "Auf einer Lichtung findest du ein Schwert welches in einem Stein steckt... Der versuch es herauszuziehen scheitert kläglich...", "MasterSchwert", 99, vsStatue);
		n [6][5]= new Navigation("Verlassene Stadt", "Die Stadt wirkt verlassen... \n", " ", 50, vsBewohner);
		n [6][6]= new Navigation("Das Schloss Castlevania", "Das Teufelsschloss erhebt sich vor dir\n unsagbare Schrecken erwarten dich wohl im inneren\n Trotzdem hälst du es für eine gute Idee das Schloss zu betreten...", "Peitsche", 100, vsDracula, "Nachdem du dich durch das komplette Schloss gekämpft hast kommst du endlich im letzten Raum,\n im obersten Stockwerk an...");
	
		
		
	}
	
	public void getLocationName(int i, int j){
		System.out.println(n[i][j].getLocationName());
	}
	
	
	
	public Navigation getLocation(int i,int j){
		return n[i][j];
	}
	
	public void startLocation(int i, int j){
 		
 		try {
			TimeUnit.MILLISECONDS.sleep(250);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
 		
		n[i][j].startNavi();
	}
	

		
	public void setLocation(int i, int j){		
	}
	
	public void getLocationBeschreibung(int i, int j){
		n[i][j].durchsuchen();
	}

	public int getBossStatus(int i){
		if(dracula.getStatus()==false){
			bossMapping[0]=1;
		}else{
			bossMapping[0]=0;
		}
		
		if(dragon.getStatus()==false){
			bossMapping[1]=1;
		}else{
			bossMapping[1]=0;
		}
		
		if(lich.getStatus()==false){
			bossMapping[2]=1;
		}else{
			bossMapping[2]=0;
		}
		if(lordNatas.getStatus()==false){
			bossMapping[3]=1;
		}else{
			bossMapping[3]=0;
		}
		
		return bossMapping[i];
	}
	
	public Stats getSpieler(){
		return spieler;
	}
	
	public void setName(String n){
		spieler.setName(n);
	}
	
	public void getStats(){
	spieler.getSpielerSpecs();
	}
	

	public int getItemNr(int x, int y){
		return n[x][y].getItemNr();
	}
}
