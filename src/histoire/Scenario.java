package histoire;

import personnages.*;
import java.util.Scanner;

public class Scenario {
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		Gaulois obelix = new Gaulois("Obelix", 10);
		Gaulois asterix = new Gaulois("Asterix", 8);
		Romain lanius = new Romain("Legate Lanius", 200);
		
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste!");
		panoramix.booster(asterix);
		
		Scanner options = new Scanner(System.in);
		Gaulois courier = new Gaulois("Courier 6", 20);	
		lanius.parler("And who are you to come before me... you bear the insignia of the Bear, yet you do not wear it as a soldier of the West wears it");
		
		System.out.println("1) If you think you've got any chance of taking Hoover Dam, you're wrong.");
		System.out.println("2) Maybe you're willing to listen to reason. ");
		String choix = options.nextLine();
		
		switch ( choix ) {
			case "1":
				courier.parler("If you think you've got any chance of taking Hoover Dam, you're wrong.");
				lanius.parler("Enough words, then. Let our strength settle this.");
				courier.frapper(lanius);
				courier.frapper(lanius);
				break;
			default:
				courier.parler("Maybe you're willing to listen to reason.");
				courier.parler("If you return East and exact vengeance, it buys the West time - and thins the Legion ranks. ");
				
				lanius.parler("Until the day when our armies meet again, envoy of Vegas - I shall wait for you on the battlefield. ");
				break;
		}
		
		
	}
}
