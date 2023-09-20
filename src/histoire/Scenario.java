package histoire;

import personnages.*;

public class Scenario {
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		Gaulois obelix = new Gaulois("Obelix", 10);
		Gaulois asterix = new Gaulois("Asterix", 8);
		Romain lanius = new Romain("Legate Lanius", 20);
		
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste!");
		panoramix.booster(asterix);
		
		asterix.parler("Bone jaw");
		lanius.parler("And who are you to come before me... you bear the insignia of the Bear, yet you do not wear it as a soldier of the West wears it");
		asterix.frapper(lanius);
		asterix.frapper(lanius);
	}
}
