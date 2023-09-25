package personnages;


public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		assert(force > 0);
		
		this.nom = nom;
		this.force = force;	
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert( this.force > 0 );
		
		int forceDebut = this.force;
		this.force -= forceCoup;
		if (this.force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		
		assert( forceDebut > this.force );
	}
	
	public static void main(String[] args) {
		Romain vulpes = new Romain("Vulpes", 10);
		
		vulpes.prendreParole();
		vulpes.parler("Don't worry, I won't have you lashed out on a cross like the rest of these degenerates");
		vulpes.recevoirCoup(5);
	}
}
