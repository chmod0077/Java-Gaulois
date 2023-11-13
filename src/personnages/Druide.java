package personnages;

import java.util.Random;

public class Druide extends Gaulois {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		super(nom, effetPotionMax);
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		this.forcePotion = 1;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à " + effetPotionMax + ".");
	}
	
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void preparerPotion() {
		Random random = new Random();
		forcePotion = random.nextInt(this.effetPotionMax - this.effetPotionMin) + this.effetPotionMin;
		
		if (forcePotion > 7) {
			super.parler("J'ai préparé une super potion de force " + forcePotion);
		} else {
			super.parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + forcePotion);
		}
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() == "Obelix") {
			super.parler("Non, Obélix !... Tu n'auras pas de potion magique !");
		} else {
			gaulois.boirePotion(this.forcePotion);
		}
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion();
	}
}
