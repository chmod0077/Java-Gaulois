package histoire;

import java.util.Iterator;

import personnages.*;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private int nbVillageoisMaximum;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageoisMaximum = nbVillageoisMaximum;
		this.villageois = new Gaulois[this.nbVillageoisMaximum];
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		this.villageois[this.nbVillageois] = gaulois;
		this.nbVillageois++;
	}
	
	public void afficherVillageois() {
		System.out.println("Le village de " + this.nom + " dirigé par " + this.chef.getNom() + " a pour résidents:");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println(villageois[i].getNom());
		}
	}
	
	public Gaulois trouverHabitant(int numeroVillageois) {
		return this.villageois[numeroVillageois];
	}
	
	public Village(String nom) {
		this.nom = nom;
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public static void main(String[] args) {
		Village village = new Village("Nipton", 30);
		/* Gaulois gaulois = village.trouverHabitant(30); */
		/* On obtient ça parce que le village[30] correspond au 31ème element du tableau village, depassant sa taille définie */
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
		
		/* Gaulois gaulois = village.trouverHabitant(1); */
		/* System.out.println(gaulois); */
		/* le 2ème element du tableau village n'est pas définie donc sa valeur est nulle */
		
		Gaulois Obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(Obelix);
		village.afficherVillageois();
	}
}
