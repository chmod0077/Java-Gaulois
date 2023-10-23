package personnages;

import village.*;

public class Gaulois {
	private String nom;
	private int effetPotion;
	
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
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
	
	/*
	 * private String prendreParole() { return "Le gaulois " + nom + " : "; }
	 */
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	/*
	 * public void frapper(Romain romain) { System.out.println(nom +
	 * " envoie un grand coup dans la mâchoire de " + romain.getNom());
	 * romain.recevoirCoup((force / 3) * this.effetPotion); }
	 */
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		
		Equipement[] coups = romain.recevoirCoup((force / 3) * effetPotion);
		
		for (int i = 0; coups != null && i < coups.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = coups[i];
		}
	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + this.effetPotion + " fois décuplée.");
	}
	
	public void faireUneDonation(Musee musee) {
		if( trophees.length > 0 ) {
			parler("Je donne au musee tous mes trophees :");
			for (int i = 0; i < nbTrophees; i++) {
				musee.donnerTrophees(this, trophees[i]);
				System.out.println("- " + trophees[i]);
			}
		}
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
		
		Musee nipton = new Musee();
		asterix.faireUneDonation(nipton);
	}
}