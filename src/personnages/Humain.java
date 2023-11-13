package personnages;

public class Humain {
	private String nom;
	private String boisson;
	private int argent;
	protected int nbConnaissance;
	protected Humain[] memoire = new Humain[30];
	
	public Humain(String nom, String boisson, int argent) {
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
		this.nbConnaissance = 0;
	}

	public String getNom() {
		return nom;
	}
	
	public int getArgent() {
		return argent;
	}
	
	protected void parler(String texte) {
		System.out.println("(" + this.nom + ") - " + texte);
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + this.nom + 
				" et j'aime boire du " + this.boisson);
	}
	
	public void boire() {
		parler(
				"Mmm, un bon verre de " + this.boisson +
				"! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		if( this.argent >= prix) {
			parler("J'ai $" + this.argent + " en poche! (Soit " + (this.argent *  254286) +
					" dollars venezuelien). Je vais pouvoir m'offrir un(e) " + bien +
					" à $" + prix + " en poche! (Soit " + this.argent *  254286 + " dollars venezueliens)");
			perdreArgent(prix);
		}
		else {
			parler("Je n'ai plus que $" + this.argent +
					" en poche. Je ne peux meme pas m'offrir un(e) " + bien + " à $" + prix);
		}
	}
	
	protected void gagnerArgent(int gain) {
		this.argent += gain;
	}
	
	protected void perdreArgent(int gain) {
		this.argent -= gain;
	}
	
	public void faireConnaissanceAvec(Humain humain)
	{
		direBonjour();
		humain.repondre(this);
		memoriser(humain);
	}
	
	private void memoriser(Humain humain)
	{
		this.memoire[this.nbConnaissance % 30] = humain;
		this.nbConnaissance++;
	}
	
	private void repondre(Humain humain)
	{
		direBonjour();
		memoriser(humain);
	}
	
	public void listerConnaissance()
	{
		parler("Je connais beaucoup de monde dont:");
		for( int i=0; i<nbConnaissance; i++ )
		{
			System.out.println(memoire[i].getNom());
		}
	}
}
