package personnages;


public class Romain {
	private String nom;
	private int force;
	
	private Equipement[] equipement;
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		assert(force > 0);
		
		this.nom = nom;
		this.force = force;
		this.equipement = new Equipement[2];
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
	
	public void sEquiper(Equipement equ) {
		switch( this.nbEquipement ) {
			case 3: break;
			case 2: 
				System.out.println("Le soldat " + this.nom + " est déjà bien protégé !");
				break;
			default:
				if( equ == this.equipement[0]) {
					System.out.println("Le soldat " + this.nom + " possède déjà un " + equ);
				}
				else {
					this.equipement[this.nbEquipement] = equ;
					this.nbEquipement++;
					
					System.out.println("Le soldat " + this.nom + " s'équipe avec un " + equ);
				}
				break;
		}
	}
	
	public static void main(String[] args) {
		Romain vulpes = new Romain("Vulpes", 10);
		
		vulpes.prendreParole();
		vulpes.parler("Don't worry, I won't have you lashed out on a cross like the rest of these degenerates");
		vulpes.recevoirCoup(5);
		
		System.out.println(Equipement.BOUCLIER);
		System.out.println(Equipement.CASQUE);
		
		vulpes.sEquiper(Equipement.CASQUE);
		vulpes.sEquiper(Equipement.CASQUE);
		vulpes.sEquiper(Equipement.BOUCLIER);
		vulpes.sEquiper(Equipement.BOUCLIER);
	}
}
