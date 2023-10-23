package personnages;


public class Romain {
	private String nom;
	private int force;
	
	private Equipement[] equipements;
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		if( force <= 0 ) throw new IllegalArgumentException("Force invalide: " + force);
		
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
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
	
	/*
	 * public void recevoirCoup(int forceCoup) { assert( this.force > 0 );
	 * 
	 * int forceDebut = this.force; this.force -= forceCoup; if (this.force > 0) {
	 * parler("Aïe"); } else { parler("J'abandonne..."); }
	 * 
	 * assert( forceDebut > this.force ); }
	 */
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		
		force -= forceCoup;
		//if (force > 0) {
		//	parler("Aïe");
		//} else {
		//	equipementEjecte = ejecterEquipement();
		//	parler("J'abandonne...");
		//}
		if( force == 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		
		int resistanceEquipement = 0;
		
		if ( nbEquipement != 0 ) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
		
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} 
				else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
		
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		
		//TODO
		int nbEquipementEjecte = 0;
		
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				equipements[i] = null;
			}
			nbEquipementEjecte++;
		}
		
		return equipementEjecte;
	}
	
	public void sEquiper(Equipement equ) {
		switch( this.nbEquipement ) {
			case 3: break;
			case 2: 
				System.out.println("Le soldat " + this.nom + " est déjà bien protégé !");
				break;
			default:
				if( equ == this.equipements[0]) {
					System.out.println("Le soldat " + this.nom + " possède déjà un " + equ);
				}
				else {
					this.equipements[this.nbEquipement] = equ;
					this.nbEquipement++;
					
					System.out.println("Le soldat " + this.nom + " s'équipe avec un " + equ);
				}
				break;
		}
	}
	
	public int getForce() {
		return force;
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
