package personnages;

import java.util.Random;

public class GrandMere extends Humain {
	
	private enum TypeHumain {
		COMMERCANT("Commercant"),
		RONIN("Ronin"),
		YAKUZA("Yakuza"),
		HABITANT("Habitant"),
		GRANDMERE("Grand-mère"),
		SAMOURAI("Samourai");

		protected String nom;

		TypeHumain(String nom) {
			this.nom = nom;
		}
	}
	
	TypeHumain[] types = TypeHumain.values();

	protected Humain[] memoire = new Humain[5];
	Random rand = new Random();
	
	public GrandMere(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
		boisson = "tisane";
	}
	
	public String humainHasard() {
		int random = rand.nextInt(this.nbConnaissance);
		return types[random].nom;
	}
	
	public void ragoter() {
		String classeHumain;
		
		for( int i = 0; i<this.nbConnaissance; i++ ) {		
			if( this.memoire[i] instanceof Traitre) {
				parler(this.memoire[i].getNom() + " est un sale traitre! Abattez-le immédiatement!");
			}
			else {
				classeHumain = humainHasard();
				parler("Je crois que " + this.memoire[i].getNom() + " est un " + classeHumain);	
			}
		}
	}
	
	protected void memoriser(Humain humain)
	{
		if( nbConnaissance < 5 ) {
			this.memoire[this.nbConnaissance] = humain;
			this.nbConnaissance++;
		}
		else {
			parler("Oh ma tete! Je ne peux plus retenir le nom d'une personne supplémentaire!");
		}
	}
}
