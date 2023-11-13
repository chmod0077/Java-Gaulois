package personnages;

public class Samourai extends Humain {
	String seigneur;

	public Samourai(String seigneur, String nom, String boisson, int argent) {
		super(nom, boisson, argent);
		this.seigneur = seigneur;
	}
	
	@Override
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + super.getNom() + 
				", j'aime boire du " + super.getBoisson() +
				" et je suis fier de servir le seigneur " + this.seigneur);
	}
	
	public void boire(String boisson) {
		parler(
				"Mmm, un bon verre de " + boisson +
				"! GLOUPS !");
	}
}
