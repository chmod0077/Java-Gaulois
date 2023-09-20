package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.effetPotion = 1;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
	+ romain.getNom());
		romain.recevoirCoup((force / 3) * this.effetPotion);
	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + this.effetPotion + " fois décuplée.");
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		
		Romain lanius = new Romain("Lanius", 8);
		
		asterix.prendreParole();
		asterix.parler("bonjour");
		asterix.boirePotion(5);
		asterix.frapper(lanius);
		//TODO créer un main permettant de tester la classe Gaulois
	}
}