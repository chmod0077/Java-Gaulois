package personnages;

public class Yakuza extends Humain {
	String clan;
	int reputation;
	
	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
		this.reputation = 0;
	}
	
	@Override
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + super.getNom() + 
				", j'aime boire du " + super.getBoisson() +
				" et je fais parti du clan des " + this.clan);
	}
	
	public void extorquer(Commercant victime) {
		int argent = victime.getArgent();
		
		parler("Tiens, tiens, ne serait-ce pas un faible voyageur qui passe par là?");
		
		super.gagnerArgent(victime.seFaireExtorquer());
		parler("Hihihiii! J'ai piqué les $" + argent + " de " + victime.getNom() + ", ce qui me fait $" + super.getArgent() + " dans mon inventaire! :3");
		
		this.reputation++;
	}
	
	public int perdre() {
		int argent = super.getArgent();
		
		super.perdreArgent(argent);
		this.reputation--;
		parler("J'ai perdu :(");
		
		return argent;
	}
	
	public int gagner(int gain) {
		super.gagnerArgent(gain);
		this.reputation++;
		parler("J'ai gagné!!! Yipeeeeeee :)");
		
		return gain;
	}
}
